package com.hari.covid_19app.item

import com.hari.covid_19app.R
import com.hari.covid_19app.databinding.ItemNewsUpdatesBinding
import com.xwray.groupie.databinding.BindableItem

class ItemNews : BindableItem<ItemNewsUpdatesBinding>() {
    override fun getLayout() = R.layout.item_news_updates

    override fun bind(viewBinding: ItemNewsUpdatesBinding, position: Int) {
    }
}