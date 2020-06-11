package com.hari.covid_19app.ui.symptons

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.hari.covid_19app.R
import com.hari.covid_19app.databinding.FragmentSymptomsBinding
import com.hari.covid_19app.ui.item.CardItemDecoration
import com.hari.covid_19app.ui.item.ItemSymptomsImage
import com.xwray.groupie.Group
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.viewbinding.GroupieViewHolder
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SymptomsFragment : Fragment(R.layout.fragment_symptoms) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentSymptomsBinding.bind(view)

        val adapter = GroupAdapter<GroupieViewHolder<*>>()

        val items = mutableListOf<Group>()
        items.add(ItemSymptomsImage())

        adapter.update(items)

        binding.recyclerViewSymptoms.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewSymptoms.addItemDecoration(
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
        binding.recyclerViewSymptoms.adapter = adapter
    }
}