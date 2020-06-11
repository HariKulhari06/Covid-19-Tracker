package com.hari.covid_19app.ui.item

import android.view.View
import com.hari.covid_19app.R
import com.hari.covid_19app.databinding.ItemPreventionsImageBinding
import com.xwray.groupie.viewbinding.BindableItem

class ItemPreventionsImage : BindableItem<ItemPreventionsImageBinding>() {
    override fun getLayout() = R.layout.item_preventions_image

    override fun bind(viewBinding: ItemPreventionsImageBinding, position: Int) {

    }

    override fun initializeViewBinding(view: View): ItemPreventionsImageBinding {
        return ItemPreventionsImageBinding.bind(view)
    }
}