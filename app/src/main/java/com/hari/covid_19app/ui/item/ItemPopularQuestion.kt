package com.hari.covid_19app.ui.item

import android.view.View
import com.hari.covid_19app.R
import com.hari.covid_19app.databinding.ItemPopularQuestionCardBinding
import com.hari.covid_19app.model.Question
import com.xwray.groupie.viewbinding.BindableItem

class ItemPopularQuestion constructor(
    val question: Question
) : BindableItem<ItemPopularQuestionCardBinding>() {
    override fun getLayout() = R.layout.item_popular_question_card

    override fun bind(viewBinding: ItemPopularQuestionCardBinding, position: Int) {
        viewBinding.question = question
        viewBinding.executePendingBindings()
    }

    override fun initializeViewBinding(view: View): ItemPopularQuestionCardBinding {
        return ItemPopularQuestionCardBinding.bind(view)
    }

}