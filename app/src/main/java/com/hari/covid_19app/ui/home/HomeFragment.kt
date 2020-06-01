package com.hari.covid_19app.ui.home

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.transition.MaterialFadeThrough
import com.hari.covid_19app.R
import com.hari.covid_19app.databinding.FragmentHomeBinding
import com.hari.covid_19app.ui.item.*
import com.xwray.groupie.Group
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.databinding.GroupieViewHolder

class HomeFragment : Fragment(R.layout.fragment_home) {
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enterTransition = MaterialFadeThrough()
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentHomeBinding.bind(view)
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        val adapter = GroupAdapter<GroupieViewHolder<*>>()

        val items = mutableListOf<Group>()
        items.add(ItemHealthStatusCard())
        items.add(ItemGlobalStatusCard())
        items.add(ItemIndiaStatusCard())

        val newsSection = Section(ItemHeader(R.string.latest_updates))
        for (i in 1..50) {
            newsSection.add(ItemNews())
        }

        items.add(newsSection)

        adapter.update(items)
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

    }


}