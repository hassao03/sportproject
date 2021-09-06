package uk.co.bbc.bbcsportapptechchallenge.util

import java.text.SimpleDateFormat
import java.util.concurrent.TimeUnit

private const val SECOND_MILLIS = 1
private const val MINUTE_MILLIS = 60 * SECOND_MILLIS
private const val HOUR_MILLIS = 60 * MINUTE_MILLIS
private const val DAY_MILLIS = 24 * HOUR_MILLIS

object TimeUtil {

    fun convertTime(time: Int): String {

        val now = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis())

        val timeDiff = now - time
        val dateTime = java.util.Date(time.toLong() * 1000)
        val sdf = SimpleDateFormat("dd MMMM yyyy")
        return when {
            timeDiff < MINUTE_MILLIS -> " now"
            timeDiff < 60 * MINUTE_MILLIS -> "${timeDiff / MINUTE_MILLIS}m"
            timeDiff < 24 * HOUR_MILLIS -> "${timeDiff / HOUR_MILLIS}h"
            timeDiff > 72 * HOUR_MILLIS  && timeDiff < 120 * HOUR_MILLIS -> "${timeDiff / DAY_MILLIS}d"
            else -> sdf.format(dateTime)
        }
    }
}
