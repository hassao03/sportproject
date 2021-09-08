package uk.co.bbc.bbcsportapptechchallenge.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.content_main.view.*
import uk.co.bbc.bbcsportapptechchallenge.MainActivity
import uk.co.bbc.bbcsportapptechchallenge.R
import uk.co.bbc.bbcsportapptechchallenge.presentation.SportViewModel
import uk.co.bbc.bbcsportapptechchallenge.stats.StatsEvent
import uk.co.bbc.bbcsportapptechchallenge.stats.StatsPostEvent
import uk.co.bbc.bbcsportapptechchallenge.ui.ContentLayout
import uk.co.bbc.bbcsportapptechchallenge.ui.Fetch
import kotlin.system.measureTimeMillis

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MySportFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MySportFragment : Fragment() {
    // TODO: Rename and change types of parameters
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
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MySportFragment.
         */
        // TODO: Rename and change types and number of parameters
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