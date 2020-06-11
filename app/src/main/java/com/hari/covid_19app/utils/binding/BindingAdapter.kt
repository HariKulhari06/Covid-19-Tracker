package com.hari.covid_19app.utils.binding

import android.annotation.SuppressLint
import android.text.Html
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import coil.api.load
import coil.decode.SvgDecoder
import com.hari.covid_19app.R
import com.hari.covid_19app.db.entity.State
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*

@BindingAdapter("setCases")
fun TextView.setCases(value: String) {
    text = NumberFormat.getNumberInstance(Locale.getDefault()).format(value.toLong())
}

@BindingAdapter("setCases")
fun TextView.setCases(value: Int) {
    text = NumberFormat.getNumberInstance(Locale.getDefault()).format(value.toLong())
}

@SuppressLint("SetTextI18n")
@BindingAdapter("setDelta")
fun TextView.setDelta(value: String) {
    val formattedNumber = NumberFormat.getNumberInstance(Locale.getDefault()).format(value.toLong())
    this.text = context.getString(R.string.new_) + " $formattedNumber"
}

@SuppressLint("SetTextI18n")
@BindingAdapter("setDeltaOrGone")
fun TextView.setDeltaOrGone(value: String) {
    if (value.isEmpty()) {
        visibility = View.GONE
    } else {
        visibility = View.VISIBLE
        val formattedNumber =
            NumberFormat.getNumberInstance(Locale.getDefault()).format(value.toLong())
        text = "+$formattedNumber"
    }
}

@SuppressLint("SimpleDateFormat", "SetTextI18n")
@BindingAdapter("lastUpdatedTime")
fun TextView.setLastUpdatedTime(date: String) {
    val parser = SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
    val formatter = SimpleDateFormat("MMM dd HH:mm aa")
    val output: String = formatter.format(parser.parse(date)!!)
    text = context.getString(R.string.last_updated) + " $output"
}

@BindingAdapter("loadImage")
fun ImageView.loadImage(url: String) {
    this.load(url) {
        crossfade(true)
        decoder(SvgDecoder(context))
    }
}


@SuppressLint("SetTextI18n")
@BindingAdapter("news")
fun TextView.setNews(state: State) {
    val text = state.stateNotes + " <font color=#1366a5> - " + state.state + "</font>"
    this.text = Html.fromHtml(text, Html.FROM_HTML_MODE_LEGACY)
}