package com.hari.covid_19app.ui.item

import android.view.View
import com.hari.covid_19app.R
import com.hari.covid_19app.databinding.ItemNewsUpdatesBinding
import com.hari.covid_19app.db.entity.State
import com.xwray.groupie.viewbinding.BindableItem

class ItemNews constructor(
    val state: State
) : BindableItem<ItemNewsUpdatesBinding>() {
    override fun getLayout() = R.layout.item_news_updates

    override fun bind(viewBinding: ItemNewsUpdatesBinding, position: Int) {
        viewBinding.state = state
        viewBinding.executePendingBindings()
    }

    override fun initializeViewBinding(view: View): ItemNewsUpdatesBinding {
        return ItemNewsUpdatesBinding.bind(view)
    }

}