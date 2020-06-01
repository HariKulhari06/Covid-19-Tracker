package com.hari.covid_19app.item

import com.hari.covid_19app.R
import com.hari.covid_19app.databinding.ItemPreventionsImageBinding
import com.xwray.groupie.databinding.BindableItem

class ItemPreventionsImage : BindableItem<ItemPreventionsImageBinding>() {
    override fun getLayout() = R.layout.item_preventions_image

    override fun bind(viewBinding: ItemPreventionsImageBinding, position: Int) {
        with(viewBinding) {
        }
    }
}