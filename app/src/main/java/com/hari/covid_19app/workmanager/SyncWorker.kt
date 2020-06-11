package com.hari.covid_19app.workmanager

import android.content.Context
import androidx.hilt.Assisted
import androidx.hilt.work.WorkerInject
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.hari.covid_19app.R
import com.hari.covid_19app.repository.CovidRepository
import com.hari.covid_19app.utils.notification.NotificationHelper
import kotlinx.coroutines.flow.collect


class SyncWorker @WorkerInject constructor(
    @Assisted private val appContext: Context,
    @Assisted workerParams: WorkerParameters,
    val covidRepository: CovidRepository
) : CoroutineWorker(appContext, workerParams) {
    override suspend fun doWork(): Result {
        if (runAttemptCount > 0) return Result.failure()


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