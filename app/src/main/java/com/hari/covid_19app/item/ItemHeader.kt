package com.hari.covid_19app.item

import com.hari.covid_19app.R
import com.hari.covid_19app.databinding.ItemHeaderBinding
import com.xwray.groupie.databinding.BindableItem

class ItemHeader : BindableItem<ItemHeaderBinding>() {
    override fun getLayout() = R.layout.item_header

    override fun bind(viewBinding: ItemHeaderBinding, position: Int) {
    }
}