package com.hari.covid_19app.ui.home

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.hari.covid_19app.R
import com.hari.covid_19app.databinding.FragmentHomeBinding
import com.hari.covid_19app.ui.item.*
import com.xwray.groupie.Group
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.viewbinding.GroupieViewHolder
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private val homeViewModel: HomeViewModel by viewModels<HomeViewModel>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentHomeBinding.bind(view)
        val adapter = GroupAdapter<GroupieViewHolder<*>>()
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.addItemDecoration(
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
        binding.recyclerView.adapter = adapter

        homeViewModel.ui.observe(viewLifecycleOwner, Observer { uiModel ->
            val items = mutableListOf<Group>()
            items.add(ItemHealthStatusCard())

            uiModel.states?.let { states ->
                val newsSection =
                    Section(ItemHeader(R.string.latest_updates)).apply { setHideWhenEmpty(true) }
                states.forEach { state ->
                    if (state.stateCode == "TT") {
                        items += ItemIndiaStatusCard(state)
                    } else if (state.stateNotes.isNullOrEmpty().not()) {
                        newsSection.add(ItemNews(state))
                    }
                }
                items.add(newsSection)
            }

            adapter.update(items)
        })
    }


}