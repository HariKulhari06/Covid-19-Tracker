package com.hari.covid_19app.ui.questions

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.hari.covid_19app.R
import com.hari.covid_19app.databinding.FragmentPopularQuestionsBinding
import com.hari.covid_19app.di.Injectable
import com.hari.covid_19app.model.Question
import com.hari.covid_19app.ui.SystemViewModel
import com.hari.covid_19app.ui.item.CardItemDecoration
import com.hari.covid_19app.ui.item.ItemPopularQuestion
import com.hari.covid_19app.utils.ext.assistedActivityViewModels
import com.hari.covid_19app.utils.ext.assistedViewModels
import com.xwray.groupie.Group
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.databinding.GroupieViewHolder
import javax.inject.Inject
import javax.inject.Provider

class PopularQuestionFragment : Fragment(R.layout.fragment_popular_questions), Injectable {

    @Inject
    lateinit var popularQuestionsViewModelProvider: Provider<PopularQuestionsViewModel>
    private val popularQuestionsViewModel: PopularQuestionsViewModel by assistedViewModels {
        popularQuestionsViewModelProvider.get()
    }

    @Inject
    lateinit var systemViewModelProvider: Provider<SystemViewModel>
    private val systemViewModel: SystemViewModel by assistedActivityViewModels {
        systemViewModelProvider.get()
    }

    @Inject
    lateinit var itemPopularQuestionFactory: ItemPopularQuestion.Factory

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
                    items.add(itemPopularQuestionFactory.create(question))
                }
                adapter.update(items)
            }

        })


    }

}