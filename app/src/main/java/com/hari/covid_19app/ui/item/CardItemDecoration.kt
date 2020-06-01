package com.hari.covid_19app.ui.item

import android.graphics.Rect
import android.view.View
import androidx.annotation.ColorInt
import androidx.recyclerview.widget.RecyclerView

class CardItemDecoration(
    @ColorInt val backgroundColor: Int,
    private val paddingPixelSize: Int
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position = parent.getChildAdapterPosition(view)
        val isLast = position == state.itemCount - 1

        outRect.top = paddingPixelSize
        outRect.left = paddingPixelSize
        outRect.right = paddingPixelSize

        if (isLast) {
            outRect.bottom = paddingPixelSize
        }
    }
}