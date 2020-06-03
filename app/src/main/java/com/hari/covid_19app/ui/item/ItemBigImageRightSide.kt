package com.hari.covid_19app.ui.item

import com.hari.covid_19app.R
import com.hari.covid_19app.databinding.ItemBigImageRightSideBinding
import com.hari.covid_19app.model.Prevention
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import com.xwray.groupie.databinding.BindableItem

class ItemBigImageRightSide @AssistedInject constructor(
    @Assisted val prevention: Prevention
) : BindableItem<ItemBigImageRightSideBinding>() {
    override fun getLayout() = R.layout.item_big_image_right_side

    override fun bind(viewBinding: ItemBigImageRightSideBinding, position: Int) {
        viewBinding.prevention = prevention
    }

    @AssistedInject.Factory
    interface Factory {
        fun create(prevention: Prevention): ItemBigImageRightSide
    }
}