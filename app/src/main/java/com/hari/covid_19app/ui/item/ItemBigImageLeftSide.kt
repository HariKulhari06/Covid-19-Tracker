package com.hari.covid_19app.ui.item

import android.view.View
import com.hari.covid_19app.R
import com.hari.covid_19app.databinding.ItemBigImageLeftSideBinding
import com.hari.covid_19app.model.Prevention
import com.xwray.groupie.viewbinding.BindableItem

class ItemBigImageLeftSide constructor(
    val prevention: Prevention
) : BindableItem<ItemBigImageLeftSideBinding>() {
    override fun getLayout() = R.layout.item_big_image_left_side

    override fun bind(viewBinding: ItemBigImageLeftSideBinding, position: Int) {
        viewBinding.prevention = prevention
        viewBinding.executePendingBindings()
    }

    override fun initializeViewBinding(view: View): ItemBigImageLeftSideBinding {
        return ItemBigImageLeftSideBinding.bind(view)
    }

}