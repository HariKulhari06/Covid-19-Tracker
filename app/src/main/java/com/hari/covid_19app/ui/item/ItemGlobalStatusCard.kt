package com.hari.covid_19app.ui.item

import com.hari.covid_19app.R
import com.hari.covid_19app.databinding.ItemGlobalUpdateCardBinding
import com.hari.covid_19app.db.entity.GlobalState
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import com.xwray.groupie.databinding.BindableItem

class ItemGlobalStatusCard @AssistedInject constructor(
    @Assisted val globalState: GlobalState
) : BindableItem<ItemGlobalUpdateCardBinding>() {
    override fun getLayout() = R.layout.item_global_update_card

    override fun bind(viewBinding: ItemGlobalUpdateCardBinding, position: Int) {
        viewBinding.globalState = globalState
    }

    @AssistedInject.Factory
    interface Factory {
        fun create(globalState: GlobalState): ItemGlobalStatusCard
    }
}