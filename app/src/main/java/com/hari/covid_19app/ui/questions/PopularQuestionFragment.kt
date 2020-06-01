package com.hari.covid_19app.ui.questions

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.hari.covid_19app.R
import com.hari.covid_19app.databinding.FragmentPopularQuestionsBinding
import com.hari.covid_19app.item.CardItemDecoration
import com.hari.covid_19app.item.ItemPopularQuestion
import com.hari.covid_19app.item.ItemSymptomsImage
import com.xwray.groupie.Group
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.databinding.GroupieViewHolder

class PopularQuestionFragment : Fragment(R.layout.fragment_popular_questions) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentPopularQuestionsBinding.bind(view)

        val adapter = GroupAdapter<GroupieViewHolder<*>>()

        val items = mutableListOf<Group>()

        for (i in 1..30){
            items.add(ItemPopularQuestion())
        }

        adapter.update(items)

        binding.recyclerViewQuestions.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewQuestions.addItemDecoration(
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
        binding.recyclerViewQuestions.adapter = adapter
    }

}