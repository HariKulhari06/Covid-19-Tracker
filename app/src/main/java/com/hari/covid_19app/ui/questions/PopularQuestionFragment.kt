package com.hari.covid_19app.ui.questions

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
import com.hari.covid_19app.databinding.FragmentPopularQuestionsBinding
import com.hari.covid_19app.model.Question
import com.hari.covid_19app.ui.SystemViewModel
import com.hari.covid_19app.ui.item.CardItemDecoration
import com.hari.covid_19app.ui.item.ItemPopularQuestion
import com.xwray.groupie.Group
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.viewbinding.GroupieViewHolder
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PopularQuestionFragment : Fragment(R.layout.fragment_popular_questions) {

    private val popularQuestionsViewModel: PopularQuestionsViewModel by viewModels<PopularQuestionsViewModel>()

    private val systemViewModel: SystemViewModel by activityViewModels<SystemViewModel>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentPopularQuestionsBinding.bind(view)

        val adapter = GroupAdapter<GroupieViewHolder<*>>()

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

        popularQuestionsViewModel.ui.observe(viewLifecycleOwner, Observer { uiModel ->

            binding.progressCircular.isVisible = uiModel.isLoading

            uiModel.appError?.let { appError ->
                systemViewModel.onError(appError)
            }

            uiModel.questions?.let { questions ->
                val items = mutableListOf<Group>()
                questions.forEach { question: Question ->
                    items.add(ItemPopularQuestion(question))
                }
                adapter.update(items)
            }

        })


    }

}