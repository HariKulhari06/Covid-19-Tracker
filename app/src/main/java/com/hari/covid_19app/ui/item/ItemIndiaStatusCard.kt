package com.hari.covid_19app.ui.item

import androidx.navigation.findNavController
import com.hari.covid_19app.R
import com.hari.covid_19app.databinding.ItemIndiaUpdateCardBinding
import com.xwray.groupie.databinding.BindableItem

class ItemIndiaStatusCard constructor() : BindableItem<ItemIndiaUpdateCardBinding>() {
    override fun getLayout() = R.layout.item_india_update_card

    override fun bind(viewBinding: ItemIndiaUpdateCardBinding, position: Int) {
        viewBinding.cardView.setOnClickListener {
            it.findNavController().navigate(R.id.statisticsFragment)
        }
    }
}