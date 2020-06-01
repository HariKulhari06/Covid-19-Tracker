package com.hari.covid_19app.utils.ext

import android.app.Activity
import android.content.Context
import android.content.res.Configuration
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.view.inputmethod.InputMethodManager
import androidx.annotation.AttrRes
import androidx.annotation.ColorInt
import androidx.core.content.getSystemService
import androidx.core.content.res.use
import androidx.databinding.adapters.Converters
import androidx.fragment.app.Fragment

@ColorInt
fun Context.getThemeColor(
    @AttrRes themeAttrId: Int
): Int {
    return obtainStyledAttributes(intArrayOf(themeAttrId))
        .use {
            it.getColor(0, Color.MAGENTA)
        }
}

fun Context.getThemeColorDrawable(
    @AttrRes themeAttrId: Int
): Drawable {
    return obtainStyledAttributes(intArrayOf(themeAttrId))
        .use {
            it.getColor(0, Color.MAGENTA)
        }.let {
            Converters.convertColorToDrawable(it)
        }
}

fun Context.isNightMode(): Boolean {
    return resources.configuration.uiMode and
            Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES
}

fun Activity.hideSoftInput() {
    val imm: InputMethodManager? = getSystemService()
    val currentFocus = currentFocus
    if (currentFocus != null && imm != null) {
        imm.hideSoftInputFromWindow(currentFocus.windowToken, 0)
    }
}

fun Fragment.hideSoftInput() = requireActivity().hideSoftInput()
