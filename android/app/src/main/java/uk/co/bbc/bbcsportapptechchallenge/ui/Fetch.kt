package uk.co.bbc.bbcsportapptechchallenge.ui

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import uk.co.bbc.bbcsportapptechchallenge.R
import uk.co.bbc.bbcsportapptechchallenge.adapter.SportAdapter
import uk.co.bbc.bbcsportapptechchallenge.mapper.getString
import uk.co.bbc.bbcsportapptechchallenge.mapper.parseJson
import java.net.MalformedURLException
import java.net.URL

object Fetch {
    private const val BASE_URL = "https://bbc.github.io/sport-app-dev-tech-challenge/data.json"

    private fun getUrl(): URL? {
        return try {
            URL(BASE_URL)
        } catch (e: MalformedURLException) {
            Log.d("Exception", e.toString())
            null
        }
    }


    fun loadData(view: View) = CoroutineScope(Dispatchers.Main).launch(Dispatchers.IO) {
        getUrl()?.getString()?.apply {
            withContext(Dispatchers.Default) {
                val list = parseJson(this@apply)
                val sortList = list?.sortedWith(compareBy { it.data.topic.title })
                withContext(Dispatchers.Main) {
                    val recyclerView: RecyclerView? = view.findViewById(R.id.recycler_view)
                    val adapter = sortList?.let {
                        SportAdapter(it, SportAdapter.OnClickListener { onClickListener ->
                        })
                    }
                    recyclerView?.adapter = adapter
                }
            }
        }
    }
}