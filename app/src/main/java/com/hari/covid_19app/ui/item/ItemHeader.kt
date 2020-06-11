package com.hari.covid_19app.ui.item

import android.view.View
import androidx.annotation.StringRes
import com.hari.covid_19app.R
import com.hari.covid_19app.databinding.ItemHeaderBinding
import com.xwray.groupie.viewbinding.BindableItem

class ItemHeader(@StringRes private val titleRes: Int) : BindableItem<ItemHeaderBinding>() {
    override fun getLayout() = R.layout.item_header

    override fun bind(viewBinding: ItemHeaderBinding, position: Int) {
        with(viewBinding) {
            title.setText(titleRes)
        }
    }

    override fun initializeViewBinding(view: View): ItemHeaderBinding {
        return ItemHeaderBinding.bind(view)
    }
}