package com.hari.covid_19app.ui.item

import com.hari.covid_19app.R
import com.hari.covid_19app.databinding.ItemBigImageLeftSideBinding
import com.hari.covid_19app.model.Prevention
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import com.xwray.groupie.databinding.BindableItem

class ItemBigImageLeftSide @AssistedInject constructor(
    @Assisted val prevention: Prevention
) : BindableItem<ItemBigImageLeftSideBinding>() {
    override fun getLayout() = R.layout.item_big_image_left_side

    override fun bind(viewBinding: ItemBigImageLeftSideBinding, position: Int) {
        viewBinding.prevention = prevention
    }

    @AssistedInject.Factory
    interface Factory {
        fun create(prevention: Prevention): ItemBigImageLeftSide
    }
}