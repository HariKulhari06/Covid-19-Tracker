package com.hari.covid_19app.item

import android.graphics.Color
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.hari.covid_19app.R
import com.hari.covid_19app.databinding.ItemStatisticsCardBinding
import com.xwray.groupie.databinding.BindableItem

class ItemStatisticsCard : BindableItem<ItemStatisticsCardBinding>() {
    override fun getLayout() = R.layout.item_statistics_card

    override fun bind(viewBinding: ItemStatisticsCardBinding, position: Int) {
        with(viewBinding) {
            initChart(chart)
            setChatData(chart)
        }

    }

    private fun setChatData(chart: PieChart) {
        val entries = mutableListOf<PieEntry>()

        entries.add(0, PieEntry(60.0f, "Active"))
        entries.add(1, PieEntry(35.0f, "Recovered"))
        entries.add(2, PieEntry(5.0f, "Death"))

        val colors = mutableListOf<Int>()
        colors.add(chart.context.resources.getColor(R.color.blue))
        colors.add(chart.context.resources.getColor(R.color.green))
        colors.add(chart.context.resources.getColor(R.color.red))

        val dataSet = PieDataSet(entries, "Covid-19 Status")

        dataSet.colors = colors

        val pieData = PieData(dataSet)

        chart.data = pieData
        chart.invalidate()
    }

    private fun initChart(chart: PieChart) {

        chart.setUsePercentValues(true)

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
        l.setDrawInside(false)
        l.xEntrySpace = 7f
        l.yEntrySpace = 20f

    }
}