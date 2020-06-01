package com.hari.covid_19app.ui.statistics

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.hari.covid_19app.R
import com.hari.covid_19app.databinding.FragmentStatisticsBinding
import com.hari.covid_19app.ui.item.*
import com.xwray.groupie.Group
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.databinding.GroupieViewHolder

class StatisticsFragment : Fragment(R.layout.fragment_statistics) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentStatisticsBinding.bind(view)
        val adapter = GroupAdapter<GroupieViewHolder<*>>()

        val items = mutableListOf<Group>()

        val todayStatisticsSection = Section(ItemHeader(R.string.today_statistics))
        todayStatisticsSection.add(ItemStatisticsCard())
        items.add(todayStatisticsSection)

        val stateAndUt = Section(ItemHeader(R.string.all_state_ut_stats))
        stateAndUt.add(ItemStatusHeader())
        for (i in 1..35) {
            stateAndUt.add(ItemStateAndUtStatusCard())
        }
        items.add(stateAndUt)

        adapter.update(items)
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
    }


}