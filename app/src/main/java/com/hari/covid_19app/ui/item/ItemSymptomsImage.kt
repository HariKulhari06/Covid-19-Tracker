package com.hari.covid_19app.ui.item

import android.view.View
import com.hari.covid_19app.R
import com.hari.covid_19app.databinding.ItemSymptomsImageBinding
import com.xwray.groupie.viewbinding.BindableItem

class ItemSymptomsImage : BindableItem<ItemSymptomsImageBinding>() {
    override fun getLayout() = R.layout.item_symptoms_image

    override fun bind(viewBinding: ItemSymptomsImageBinding, position: Int) {

    }

    override fun initializeViewBinding(view: View): ItemSymptomsImageBinding {
        return ItemSymptomsImageBinding.bind(view)
    }
}