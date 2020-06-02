package com.hari.covid_19app.utils.pref

import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import androidx.preference.PreferenceManager
import com.hari.covid_19app.R

class ThemePrefs(
    private val context: Context
) {
    fun getNightMode(): Int {
        return when (PreferenceManager.getDefaultSharedPreferences(context).getString(
            DARK_THEME_KEY,
            context.getString(R.string.pref_theme_value_light)
        )) {
            context.getString(R.string.pref_theme_value_dark) -> {
                AppCompatDelegate.MODE_NIGHT_YES
            }
            else -> {
                AppCompatDelegate.MODE_NIGHT_NO
            }
        }
    }

    fun setNightMode(value: String) {
        PreferenceManager.getDefaultSharedPreferences(context).edit()
            .putString(DARK_THEME_KEY, value).apply()
    }

    companion object {
        const val DARK_THEME_KEY = "darkTheme"
    }
}
