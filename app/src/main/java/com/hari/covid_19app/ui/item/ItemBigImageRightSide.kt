package com.hari.covid_19app.ui.item

import android.view.View
import com.hari.covid_19app.R
import com.hari.covid_19app.databinding.ItemBigImageRightSideBinding
import com.hari.covid_19app.model.Prevention
import com.xwray.groupie.viewbinding.BindableItem

class ItemBigImageRightSide constructor(
    val prevention: Prevention
) : BindableItem<ItemBigImageRightSideBinding>() {
    override fun getLayout() = R.layout.item_big_image_right_side

    override fun bind(viewBinding: ItemBigImageRightSideBinding, position: Int) {
        viewBinding.prevention = prevention
        viewBinding.executePendingBindings()
    }

    override fun initializeViewBinding(view: View): ItemBigImageRightSideBinding {
        return ItemBigImageRightSideBinding.bind(view)
    }

}