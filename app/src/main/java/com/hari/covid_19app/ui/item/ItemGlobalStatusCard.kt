package com.hari.covid_19app.ui.item

import android.view.View
import com.hari.covid_19app.R
import com.hari.covid_19app.databinding.ItemGlobalUpdateCardBinding
import com.hari.covid_19app.db.entity.GlobalState
import com.xwray.groupie.viewbinding.BindableItem

class ItemGlobalStatusCard constructor(
    private val globalState: GlobalState
) : BindableItem<ItemGlobalUpdateCardBinding>() {
    override fun getLayout() = R.layout.item_global_update_card

    override fun bind(viewBinding: ItemGlobalUpdateCardBinding, position: Int) {
        viewBinding.globalState = globalState
        viewBinding.executePendingBindings()
    }

    override fun initializeViewBinding(view: View): ItemGlobalUpdateCardBinding {
        return ItemGlobalUpdateCardBinding.bind(view)
    }

}