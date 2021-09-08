package uk.co.bbc.bbcsportapptechchallenge.mapper

import android.util.Log
import org.json.JSONException
import org.json.JSONObject
import uk.co.bbc.bbcsportapptechchallenge.presentation.*
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.URL

internal fun SportData.toViewModel(): SportViewModel {
    return SportViewModel(
        data = data
    )
}

fun URL.getString(): String? {
    val stream = openStream()
    return try {
        val br = BufferedReader(InputStreamReader(stream))
        val result = StringBuilder()
        var line: String?
        while (br.readLine().also { line = it } != null) {
            result.append(line).appendLine()
        }
        result.toString()
    } catch (e: IOException) {
        e.toString()
    }
}

fun parseJson(data: String): List<SportViewModel>? {
    val list = mutableListOf<SportViewModel>()

    try {
        val root = JSONObject(data)
        val dataObj = root.getJSONObject("data")
        val topic = dataObj.getJSONObject("topic")
        val topicTitle = topic.getString("title")
        val topicUrl = topic.getString("url")
        val array = dataObj.getJSONArray("items")
        for (i in 0 until array.length()) {
            val obj = JSONObject(array[i].toString())
            val type = obj.getString("type")
            val title = obj.getString("title")
            val url = obj.getString("url")
            val sectionLabel = obj.getString("sectionLabel")
            val sectionUrl = obj.getString("sectionUrl")
            val isLive = obj.getBoolean("isLive")
            val lastUpdatedText = obj.getString("lastUpdatedText")
            val mediaType = obj.getString("mediaType")
            val contentType = obj.getString("contentType")
            val lastUpdatedTimestamp = obj.getInt("lastUpdatedTimestamp")
            val image = obj.getJSONObject("image")
            val small = image.getString("small")
            val medium = image.getString("small")
            val large = image.getString("medium")
            val altText = image.getString("large")
            val copyrightHolder = image.getString("large")

            list.add(
                convertToViewModel(
                    SportData(
                        Data(
                            Topic(topicTitle, topicUrl), listOf(
                                Items(
                                    type,
                                    title,
                                    url,
                                    sectionLabel,
                                    sectionUrl,
                                    isLive,
                                    lastUpdatedText,
                                    mediaType,
                                    contentType,
                                    lastUpdatedTimestamp,
                                    Image(
                                        small, medium, large, altText,
                                        copyrightHolder
                                    )
                                )
                            )
                        )
                    )
                )
            )
        }
    } catch (e: JSONException) {
        Log.d("Exception", e.toString())
    }
    return list
}

private fun convertToViewModel(dataItem: SportData): SportViewModel {
    return dataItem.toViewModel()
}