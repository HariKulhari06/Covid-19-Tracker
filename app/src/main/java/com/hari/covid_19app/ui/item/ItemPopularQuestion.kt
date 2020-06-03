package com.hari.covid_19app.ui.item

import com.hari.covid_19app.R
import com.hari.covid_19app.databinding.ItemPopularQuestionCardBinding
import com.hari.covid_19app.model.Question
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import com.xwray.groupie.databinding.BindableItem

class ItemPopularQuestion @AssistedInject constructor(
    @Assisted val question: Question
) : BindableItem<ItemPopularQuestionCardBinding>() {
    override fun getLayout() = R.layout.item_popular_question_card

    override fun bind(viewBinding: ItemPopularQuestionCardBinding, position: Int) {
        viewBinding.question = question
    }

    @AssistedInject.Factory
    interface Factory {
        fun create(question: Question): ItemPopularQuestion
    }
}