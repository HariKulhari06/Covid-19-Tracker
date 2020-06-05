package com.hari.covid_19app.repository.workmanager

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.hari.covid_19app.R
import com.hari.covid_19app.di.AppComponentHolder
import com.hari.covid_19app.utils.notification.NotificationHelper
import kotlinx.coroutines.flow.collect


class SyncWorker(
    private val appContext: Context,
    workerParams: WorkerParameters
) : CoroutineWorker(appContext, workerParams) {
    override suspend fun doWork(): Result {
        if (runAttemptCount > 0) return Result.failure()
        val appComponentHolder = appContext as? AppComponentHolder ?: return Result.failure()
        val covidRepository = appComponentHolder.appComponent.covidRepository()

        covidRepository.refreshDataOfIndia()
        covidRepository.getTotalCaseInIndia().collect { totalState ->
            NotificationHelper(appContext)
                .createNotification(
                    appContext.getString(R.string.latest_update),
                    "${totalState.deltaConfirmed} ${appContext.getString(R.string.notification_message)}"
                )
        }

        return Result.success()
    }
}