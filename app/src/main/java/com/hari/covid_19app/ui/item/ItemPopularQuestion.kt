package com.hari.covid_19app.ui.item

import com.hari.covid_19app.R
import com.hari.covid_19app.databinding.ItemPopularQuestionCardBinding
import com.xwray.groupie.databinding.BindableItem

class ItemPopularQuestion : BindableItem<ItemPopularQuestionCardBinding>() {
    override fun getLayout() = R.layout.item_popular_question_card

    override fun bind(viewBinding: ItemPopularQuestionCardBinding, position: Int) {
        with(viewBinding) {
        }
    }
}