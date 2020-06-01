package com.hari.covid_19app.ui.item

import com.hari.covid_19app.R
import com.hari.covid_19app.databinding.ItemSymptomsImageBinding
import com.xwray.groupie.databinding.BindableItem

class ItemSymptomsImage : BindableItem<ItemSymptomsImageBinding>() {
    override fun getLayout() = R.layout.item_symptoms_image

    override fun bind(viewBinding: ItemSymptomsImageBinding, position: Int) {
        with(viewBinding) {
        }
    }
}