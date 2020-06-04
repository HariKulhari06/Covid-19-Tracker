package com.hari.covid_19app.ui.item

import com.hari.covid_19app.R
import com.hari.covid_19app.databinding.ItemNewsUpdatesBinding
import com.hari.covid_19app.db.entity.State
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import com.xwray.groupie.databinding.BindableItem

class ItemNews @AssistedInject constructor(
    @Assisted val state: State
) : BindableItem<ItemNewsUpdatesBinding>() {
    override fun getLayout() = R.layout.item_news_updates

    override fun bind(viewBinding: ItemNewsUpdatesBinding, position: Int) {
        viewBinding.state = state
    }

    @AssistedInject.Factory
    interface Factory {
        fun create(state: State): ItemNews
    }
}