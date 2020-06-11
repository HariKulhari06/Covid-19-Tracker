package com.hari.covid_19app.ui.item

import android.view.View
import com.hari.covid_19app.R
import com.hari.covid_19app.databinding.ItemStatusHeaderBinding
import com.xwray.groupie.viewbinding.BindableItem

class ItemStatusHeader : BindableItem<ItemStatusHeaderBinding>() {
    override fun getLayout() = R.layout.item_status_header

    override fun bind(viewBinding: ItemStatusHeaderBinding, position: Int) {

    }

    override fun initializeViewBinding(view: View): ItemStatusHeaderBinding {
        return ItemStatusHeaderBinding.bind(view)
    }

}