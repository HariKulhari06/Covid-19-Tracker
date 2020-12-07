package com.hari.covid_19app.ui.item

import android.graphics.Color
import android.view.View
import androidx.core.content.res.ResourcesCompat
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.hari.covid_19app.R
import com.hari.covid_19app.databinding.ItemStatisticsCardBinding
import com.hari.covid_19app.db.entity.State
import com.hari.covid_19app.utils.ext.getThemeColor
import com.xwray.groupie.viewbinding.BindableItem

class ItemStatisticsCard constructor(
    private val state: State
) : BindableItem<ItemStatisticsCardBinding>() {
    override fun getLayout() = R.layout.item_statistics_card

    override fun bind(viewBinding: ItemStatisticsCardBinding, position: Int) {
        viewBinding.state = state
        with(viewBinding) {
            initChart(chart)
            setChatData(chart)
        }
    }

    private fun setChatData(chart: PieChart) {
        val entries = mutableListOf<PieEntry>()

        entries.add(
            0,
            PieEntry(state.active?.toFloat() ?: 0.0f, chart.context.getString(R.string.active))
        )
        entries.add(
            1,
            PieEntry(
                state.recovered?.toFloat() ?: 0.0f,
                chart.context.getString(R.string.recovered)
            )
        )
        entries.add(
            2,
            PieEntry(state.deaths?.toFloat() ?: 0.0f, chart.context.getString(R.string.deaths))
        )

        val colors = mutableListOf<Int>()
        colors.add(chart.context.getColor(R.color.blue))
        colors.add(chart.context.getColor(R.color.green))
        colors.add(chart.context.getColor(R.color.red))

        val dataSet = PieDataSet(entries, "Covid-19 Status")

        dataSet.colors = colors

        val pieData = PieData(dataSet)
        pieData.setValueTextSize(12f)
        pieData.setValueTextColor(Color.BLACK)
        pieData.setValueTypeface(
            ResourcesCompat.getFont(
                chart.context,
                R.font.sf_pro_display_medium
            )
        )

        chart.data = pieData
        chart.invalidate()
    }

    private fun initChart(chart: PieChart) {

        chart.setUsePercentValues(false)

        chart.animateY(1400, Easing.EaseInOutQuad)

        chart.holeRadius = 58f
        chart.transparentCircleRadius = 61f

        // enable rotation of the chart by touch
        chart.isRotationEnabled = false
        chart.isHighlightPerTapEnabled = true
        chart.setHoleColor(Color.TRANSPARENT)


        chart.rotationAngle = 0f

        chart.description.isEnabled = false

        val l = chart.legend
        l.verticalAlignment = Legend.LegendVerticalAlignment.CENTER
        l.horizontalAlignment = Legend.LegendHorizontalAlignment.RIGHT
        l.orientation = Legend.LegendOrientation.VERTICAL
        l.textSize = 12f
        l.textColor = chart.context.getThemeColor(R.attr.colorOnSurface)
        l.typeface = ResourcesCompat.getFont(chart.context, R.font.sf_pro_display_medium)
        l.setDrawInside(false)
        l.xEntrySpace = 7f
        l.yEntrySpace = 20f

    }

    override fun initializeViewBinding(view: View): ItemStatisticsCardBinding {
        return ItemStatisticsCardBinding.bind(view)
    }
}