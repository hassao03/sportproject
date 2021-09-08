package uk.co.bbc.bbcsportapptechchallenge.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import uk.co.bbc.bbcsportapptechchallenge.stats.StatsEvent
import uk.co.bbc.bbcsportapptechchallenge.stats.StatsPostEvent
import uk.co.bbc.bbcsportapptechchallenge.ui.ContentLayout
import uk.co.bbc.bbcsportapptechchallenge.ui.Fetch
import kotlin.system.measureTimeMillis

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class MySportFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null
    var start: Long? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        start = System.currentTimeMillis()

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return context?.let { ContentLayout(it) }
    }

    override fun onResume() {
        super.onResume()

        val elapsedDisplayTimeMillis: Long = System.currentTimeMillis() - start!!
        StatsPostEvent.sendStats(StatsEvent.DISPLAY,elapsedDisplayTimeMillis.toString())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fetchElapsedTime = measureTimeMillis {
            Fetch.loadData(view)
        }

        StatsPostEvent.sendStats(StatsEvent.LOAD,fetchElapsedTime.toString())
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MySportFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}