package com.hari.covid_19app.ui.item

import androidx.navigation.findNavController
import com.hari.covid_19app.R
import com.hari.covid_19app.databinding.ItemIndiaUpdateCardBinding
import com.hari.covid_19app.db.entity.State
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import com.xwray.groupie.databinding.BindableItem

class ItemIndiaStatusCard @AssistedInject constructor(
    @Assisted private val state: State
) : BindableItem<ItemIndiaUpdateCardBinding>() {
    override fun getLayout() = R.layout.item_india_update_card

    override fun bind(viewBinding: ItemIndiaUpdateCardBinding, position: Int) {
        viewBinding.state = state
        viewBinding.cardView.setOnClickListener {
            it.findNavController().navigate(R.id.statisticsFragment)
        }
    }


    @AssistedInject.Factory
    interface Factory {
        fun create(state: State): ItemIndiaStatusCard
    }
}