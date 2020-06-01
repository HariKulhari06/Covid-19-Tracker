package com.hari.covid_19app.item

import com.hari.covid_19app.R
import com.hari.covid_19app.databinding.ItemBigImageLeftSideBinding
import com.xwray.groupie.databinding.BindableItem

class ItemBigImageLeftSide : BindableItem<ItemBigImageLeftSideBinding>() {
    override fun getLayout() = R.layout.item_big_image_left_side

    override fun bind(viewBinding: ItemBigImageLeftSideBinding, position: Int) {
        with(viewBinding) {
        }
    }
}