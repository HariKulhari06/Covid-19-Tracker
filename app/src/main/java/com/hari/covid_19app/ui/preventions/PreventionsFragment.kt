package com.hari.covid_19app.ui.preventions

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.hari.covid_19app.R
import com.hari.covid_19app.databinding.FragmentPreventionsBinding
import com.hari.covid_19app.ui.SystemViewModel
import com.hari.covid_19app.ui.item.CardItemDecoration
import com.hari.covid_19app.ui.item.ItemBigImageLeftSide
import com.hari.covid_19app.ui.item.ItemBigImageRightSide
import com.hari.covid_19app.ui.item.ItemPreventionsImage
import com.xwray.groupie.Group
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.viewbinding.GroupieViewHolder
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PreventionsFragment : Fragment(R.layout.fragment_preventions) {

    private val preventionsViewModel: PreventionsViewModel by viewModels<PreventionsViewModel>()

    private val systemViewModel: SystemViewModel by activityViewModels<SystemViewModel>()

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
                items += ItemPreventionsImage()

                preventions.forEachIndexed { index, prevention ->
                    items += if (index % 2 == 0) {
                        ItemBigImageLeftSide(prevention)
                    } else {
                        ItemBigImageRightSide(prevention)
                    }
                }

                adapter.update(items)
            }

        })
    }

}