package com.hari.covid_19app

import androidx.annotation.IdRes

enum class PageConfiguration(
    val id: Int,
    val hasTitle: Boolean = true,
    val isShowLogoImage: Boolean = true,
    val isTopLevel: Boolean = false
) {

    HOME(
        R.id.nav_home,
        hasTitle = false,
        isTopLevel = true
    ),
    STATISTICS(
        R.id.statisticsFragment,
        hasTitle = false
    ),
    OTHER(0);

    operator fun component1() = id
    operator fun component2() = hasTitle
    operator fun component3() = isShowLogoImage

    companion object {
        fun getConfiguration(@IdRes id: Int): PageConfiguration {
            return values()
                .firstOrNull { it.id == id } ?: OTHER
        }
    }
}
