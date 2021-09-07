package uk.co.bbc.bbcsportapptechchallenge.stats

import android.net.Uri
import android.util.Log
import kotlinx.coroutines.*
import java.net.HttpURLConnection
import java.net.URL
import java.util.*

sealed class StatsEvent(val event: String) {
    object Display : StatsEvent("display")
    object LOAD : StatsEvent("load")
    object ERROR : StatsEvent("error")
}

object StatsPostEvent {

    private fun makeRequest(stringUrl: String?): HttpURLConnection {
        val url = URL(stringUrl)
        val urlConnection: HttpURLConnection = url.openConnection() as HttpURLConnection
        urlConnection.connectTimeout = 100000
        urlConnection.readTimeout = 100000
        urlConnection.instanceFollowRedirects = true
        urlConnection.connect()

        return urlConnection
    }

    fun sendStats(postEvent: StatsEvent, data: String) {

        val url = Uri.Builder().apply {
            scheme("https")
            authority("bbc.github.io")
            appendPath("sport-app-dev-tech-challenge")
            appendPath("stats")
            appendQueryParameter("event", postEvent.event)
            appendQueryParameter("data", data)
            build()
        }.toString()

        val map = HashMap<String, String>()
        map["event"] = postEvent.event
        map["data"] = data

        val mainScope = CoroutineScope(Dispatchers.Main + SupervisorJob())

        mainScope.launch {
            withContext(Dispatchers.IO) {
                val resp = makeRequest(url)
                Log.i("HTTP Response Msg", resp.responseMessage)
                Log.i("HTTP Response URL", resp.url.toString())
            }
        }
    }
}