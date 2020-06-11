package com.hari.covid_19app.ui.statistics

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.hari.covid_19app.R
import com.hari.covid_19app.databinding.FragmentStatisticsBinding
import com.hari.covid_19app.ui.item.*
import com.xwray.groupie.Group
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.viewbinding.GroupieViewHolder
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StatisticsFragment : Fragment(R.layout.fragment_statistics) {

    private val statisticsViewModel: StatisticsViewModel by viewModels<StatisticsViewModel>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentStatisticsBinding.bind(view)
        postponeEnterTransition()
        val adapter = GroupAdapter<GroupieViewHolder<*>>()
        binding.recyclerViewStatistics.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewStatistics.addItemDecoration(
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
        binding.recyclerViewStatistics.adapter = adapter

        statisticsViewModel.states.observe(viewLifecycleOwner, Observer { states ->
            adapter.clear()
            val items = mutableListOf<Group>()
            val todayStatisticsSection = Section(ItemHeader(R.string.today_statistics))

            val stateAndUt = Section(ItemHeader(R.string.all_state_ut_stats))
            stateAndUt.add(ItemStatusHeader())

            states.forEach { state ->
                if (state.stateCode == "TT") {
                    todayStatisticsSection.add(ItemStatisticsCard(state))
                } else {
                    stateAndUt.add(ItemStateAndUtStatusCard(state))
                }

            }
            items.add(todayStatisticsSection)
            items.add(stateAndUt)

            adapter.update(items)

            startPostponedEnterTransition()
        })


    }


}