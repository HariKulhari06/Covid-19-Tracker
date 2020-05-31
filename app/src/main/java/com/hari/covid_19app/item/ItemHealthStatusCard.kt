package com.hari.covid_19app.item

import com.hari.covid_19app.R
import com.hari.covid_19app.databinding.ItemHealthStatusCardBinding
import com.xwray.groupie.databinding.BindableItem

class ItemHealthStatusCard constructor() : BindableItem<ItemHealthStatusCardBinding>() {
    override fun getLayout() = R.layout.item_health_status_card

    override fun bind(viewBinding: ItemHealthStatusCardBinding, position: Int) {
    }
}