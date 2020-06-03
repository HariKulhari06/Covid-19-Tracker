package com.hari.covid_19app.ui.preventions

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.hari.covid_19app.R
import com.hari.covid_19app.databinding.FragmentPreventionsBinding
import com.hari.covid_19app.di.Injectable
import com.hari.covid_19app.ui.SystemViewModel
import com.hari.covid_19app.ui.item.CardItemDecoration
import com.hari.covid_19app.ui.item.ItemBigImageLeftSide
import com.hari.covid_19app.ui.item.ItemBigImageRightSide
import com.hari.covid_19app.ui.item.ItemPreventionsImage
import com.hari.covid_19app.utils.ext.assistedActivityViewModels
import com.hari.covid_19app.utils.ext.assistedViewModels
import com.xwray.groupie.Group
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.databinding.GroupieViewHolder
import javax.inject.Inject
import javax.inject.Provider

class PreventionsFragment : Fragment(R.layout.fragment_preventions), Injectable {

    @Inject
    lateinit var preventionsViewModelProvider: Provider<PreventionsViewModel>
    private val preventionsViewModel: PreventionsViewModel by assistedViewModels {
        preventionsViewModelProvider.get()
    }

    @Inject
    lateinit var systemViewModelProvider: Provider<SystemViewModel>
    private val systemViewModel: SystemViewModel by assistedActivityViewModels {
        systemViewModelProvider.get()
    }

    @Inject
    lateinit var itemPreventionsImage: ItemPreventionsImage

    @Inject
    lateinit var itemBigImageLeftSideFactory: ItemBigImageLeftSide.Factory

    @Inject
    lateinit var itemBigImageRightSideFactory: ItemBigImageRightSide.Factory

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentPreventionsBinding.bind(view)
        val adapter = GroupAdapter<GroupieViewHolder<*>>()
        binding.recyclerViewPreventions.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewPreventions.addItemDecoration(
            CardItemDecoration(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.color_surface
                ),
                resources.getDimensionPixelSize(
                    R.dimen.activity_horizontal_margin
                )
            )
        )
        binding.recyclerViewPreventions.adapter = adapter

        preventionsViewModel.ui.observe(viewLifecycleOwner, Observer { uiModel ->

            binding.progressCircular.isVisible = uiModel.isLoading

            uiModel.appError?.let { appError ->
                systemViewModel.onError(appError)
            }

            uiModel.preventions?.let { preventions ->
                val items = mutableListOf<Group>()
                items += itemPreventionsImage

                preventions.forEachIndexed { index, prevention ->
                    items += if (index % 2 == 0) {
                        itemBigImageLeftSideFactory.create(prevention)
                    } else {
                        itemBigImageRightSideFactory.create(prevention)
                    }
                }

                adapter.update(items)
            }

        })
    }

}