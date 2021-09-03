package uk.co.bbc.bbcsportapptechchallenge.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewDebug
import android.view.ViewGroup
import android.widget.FrameLayout
import uk.co.bbc.bbcsportapptechchallenge.R
import uk.co.bbc.bbcsportapptechchallenge.databinding.FragmentMySportBinding
import uk.co.bbc.bbcsportapptechchallenge.presentation.SportPresenter
import uk.co.bbc.bbcsportapptechchallenge.presentation.SportView
import uk.co.bbc.bbcsportapptechchallenge.presentation.SportViewModel

class SportLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = R.attr.sportLayoutStyle
) : FrameLayout(context, attrs, defStyle) {

    private val binding = FragmentMySportBinding.inflate(LayoutInflater.from(context), this, true)
    private val presenter = SportPresenter(ViewDelegate(binding))

    init {
        layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
    }

    fun render(model: SportViewModel) {
        presenter.render(model)
    }

    private class ViewDelegate(val binding: FragmentMySportBinding): SportView {
        override fun setTopicTitle(topicTitle: String) {
//            TODO("Not yet implemented")
        }

        override fun setItemTitle(itemTitle: String) {
//            TODO("Not yet implemented")
        }

        override fun setItemUrl(itemUrl: String) {
//            TODO("Not yet implemented")
        }

        override fun setLastUpdatedTimestamp(lastUpdatedTimestamp: Int) {
//            TODO("Not yet implemented")
        }

        override fun setImageSize(medium: String) {
//            TODO("Not yet implemented")
        }

    }
}