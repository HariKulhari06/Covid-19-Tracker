package com.hari.covid_19app.ui.item

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.view.View
import androidx.annotation.ColorInt
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.hari.covid_19app.R


class HeaderItemDecoration(
    @ColorInt background: Int,
    private val sidePaddingPixels: Int,
    @param:LayoutRes private val headerViewType: Int = R.layout.item_header
) : RecyclerView.ItemDecoration() {
    private val paint: Paint = Paint()
    private fun isHeader(
        child: View?,
        parent: RecyclerView
    ): Boolean {
        val viewType = parent.layoutManager!!.getItemViewType(child!!)
        return viewType == headerViewType
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        if (!isHeader(view, parent)) return
        outRect.left = sidePaddingPixels
        outRect.right = sidePaddingPixels
    }

    override fun onDraw(
        c: Canvas,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        for (i in 0 until parent.childCount) {
            val child = parent.getChildAt(i)
            if (!isHeader(child, parent)) continue
            val lm =
                parent.layoutManager
            val top = lm!!.getDecoratedTop(child) + child.translationY
            var bottom = lm.getDecoratedBottom(child) + child.translationY
            if (i == parent.childCount - 1) {
                // Draw to bottom if last item
                bottom = parent.height.toFloat().coerceAtLeast(bottom)
            }
            val right = lm.getDecoratedRight(child) + child.translationX
            val left = lm.getDecoratedLeft(child) + child.translationX
            c.drawRect(left, top, right, bottom, paint)
        }
    }

    init {
        paint.color = background
    }
}