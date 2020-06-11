package com.hari.covid_19app.ui.item

import android.view.View
import androidx.navigation.findNavController
import com.hari.covid_19app.R
import com.hari.covid_19app.databinding.ItemIndiaUpdateCardBinding
import com.hari.covid_19app.db.entity.State
import com.xwray.groupie.viewbinding.BindableItem

class ItemIndiaStatusCard constructor(
    private val state: State
) : BindableItem<ItemIndiaUpdateCardBinding>() {
    override fun getLayout() = R.layout.item_india_update_card

    override fun bind(viewBinding: ItemIndiaUpdateCardBinding, position: Int) {
        viewBinding.state = state
        viewBinding.executePendingBindings()
        viewBinding.cardView.setOnClickListener {
            it.findNavController().navigate(R.id.statisticsFragment)
        }
    }

    override fun initializeViewBinding(view: View): ItemIndiaUpdateCardBinding {
        return ItemIndiaUpdateCardBinding.bind(view)
    }

}