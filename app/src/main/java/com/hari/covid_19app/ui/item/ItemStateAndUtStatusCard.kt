package com.hari.covid_19app.ui.item

import com.hari.covid_19app.R
import com.hari.covid_19app.databinding.ItemStateUtStatusBinding
import com.hari.covid_19app.db.entity.State
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import com.xwray.groupie.databinding.BindableItem

class ItemStateAndUtStatusCard @AssistedInject constructor(
    @Assisted private val state: State
) : BindableItem<ItemStateUtStatusBinding>() {

    override fun getLayout() = R.layout.item_state_ut_status

    override fun bind(viewBinding: ItemStateUtStatusBinding, position: Int) {
        viewBinding.state = state
    }

    @AssistedInject.Factory
    interface Factory {
        fun create(state: State): ItemStateAndUtStatusCard
    }
}