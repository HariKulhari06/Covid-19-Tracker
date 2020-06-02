package com.hari.covid_19app.ui

import androidx.annotation.IdRes
import com.hari.covid_19app.R

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
    PREVENTIONS(
        R.id.nav_prevention,
        hasTitle = false,
        isTopLevel = true
    ),
    SYMPTOMS(
        R.id.nav_symptoms,
        hasTitle = false,
        isTopLevel = true
    ),
    QUESTIONS(
        R.id.nav_questions,
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
