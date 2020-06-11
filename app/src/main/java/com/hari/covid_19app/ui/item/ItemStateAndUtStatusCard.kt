package com.hari.covid_19app.ui.item

import android.view.View
import com.hari.covid_19app.R
import com.hari.covid_19app.databinding.ItemStateUtStatusBinding
import com.hari.covid_19app.db.entity.State
import com.xwray.groupie.viewbinding.BindableItem

class ItemStateAndUtStatusCard constructor(
    private val state: State
) : BindableItem<ItemStateUtStatusBinding>() {

    override fun getLayout() = R.layout.item_state_ut_status

    override fun bind(viewBinding: ItemStateUtStatusBinding, position: Int) {
        viewBinding.state = state
        viewBinding.executePendingBindings()
    }

    override fun initializeViewBinding(view: View): ItemStateUtStatusBinding {
        return ItemStateUtStatusBinding.bind(view)
    }

}