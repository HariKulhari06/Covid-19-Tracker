package com.hari.covid_19app.item

import com.hari.covid_19app.R
import com.hari.covid_19app.databinding.ItemGlobalUpdateCardBinding
import com.xwray.groupie.databinding.BindableItem

class ItemGlobalStatusCard constructor() : BindableItem<ItemGlobalUpdateCardBinding>() {
    override fun getLayout() = R.layout.item_global_update_card

    override fun bind(viewBinding: ItemGlobalUpdateCardBinding, position: Int) {
    }
}