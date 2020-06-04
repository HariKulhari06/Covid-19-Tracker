package com.hari.covid_19app.repository.workmanager

import android.content.Context
import androidx.navigation.NavDeepLinkBuilder
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.hari.covid_19app.R
import com.hari.covid_19app.di.AppComponentHolder
import com.hari.covid_19app.utils.NotificationUtil

class SyncWorker(
    private val appContext: Context,
    private val workerParams: WorkerParameters
) : CoroutineWorker(appContext, workerParams) {
    override suspend fun doWork(): Result {
        if (runAttemptCount > 0) return Result.failure()
        val appComponentHolder = appContext as? AppComponentHolder ?: return Result.failure()
        val covidRepository = appComponentHolder.appComponent.covidRepository()

        covidRepository.refreshData()

        val pendingIntent = NavDeepLinkBuilder(appContext)
            .setGraph(R.navigation.mobile_navigation)
            .setDestination(R.id.statisticsFragment)
            .createPendingIntent()

        NotificationUtil.showNotification(
            appContext,
            "Covid-19 Tracker",
            "New Case Reported, please check",
            pendingIntent,
            "channelId"
        )

        return Result.success()
    }
}