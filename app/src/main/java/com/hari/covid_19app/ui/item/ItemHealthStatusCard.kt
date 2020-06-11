package com.hari.covid_19app.ui.item

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.View
import com.hari.covid_19app.R
import com.hari.covid_19app.databinding.ItemHealthStatusCardBinding
import com.xwray.groupie.viewbinding.BindableItem


class ItemHealthStatusCard :
    BindableItem<ItemHealthStatusCardBinding>() {
    override fun getLayout() = R.layout.item_health_status_card

    override fun bind(viewBinding: ItemHealthStatusCardBinding, position: Int) {
        viewBinding.root.setOnClickListener { dialCallToHelplineNumber(viewBinding.root.context) }
    }

    private fun dialCallToHelplineNumber(context: Context) {
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:+91-11-23978046")
        context.startActivity(intent)
    }

    override fun initializeViewBinding(view: View): ItemHealthStatusCardBinding {
        return ItemHealthStatusCardBinding.bind(view)
    }
}