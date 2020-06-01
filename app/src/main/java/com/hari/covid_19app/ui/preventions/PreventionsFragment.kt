package com.hari.covid_19app.ui.preventions

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.hari.covid_19app.R
import com.hari.covid_19app.databinding.FragmentPreventionsBinding
import com.hari.covid_19app.item.CardItemDecoration
import com.hari.covid_19app.item.ItemBigImageLeftSide
import com.hari.covid_19app.item.ItemBigImageRightSide
import com.hari.covid_19app.item.ItemPreventionsImage
import com.xwray.groupie.Group
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.databinding.GroupieViewHolder

class PreventionsFragment : Fragment(R.layout.fragment_preventions) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentPreventionsBinding.bind(view)

        val adapter = GroupAdapter<GroupieViewHolder<*>>()

        val items = mutableListOf<Group>()
        items.add(ItemPreventionsImage())
        items.add(ItemBigImageRightSide())
        items.add(ItemBigImageLeftSide())
        items.add(ItemBigImageRightSide())
        items.add(ItemBigImageLeftSide())
        items.add(ItemBigImageRightSide())

        adapter.update(items)

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
    }

}