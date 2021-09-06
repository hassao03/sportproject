package uk.co.bbc.bbcsportapptechchallenge.ui

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.annotation.StyleRes
import androidx.annotation.StyleableRes
import androidx.core.widget.TextViewCompat
import com.squareup.picasso.Picasso
import uk.co.bbc.bbcsportapptechchallenge.R
import uk.co.bbc.bbcsportapptechchallenge.databinding.FragmentMySportBinding
import uk.co.bbc.bbcsportapptechchallenge.presentation.SportPresenter
import uk.co.bbc.bbcsportapptechchallenge.presentation.SportView
import uk.co.bbc.bbcsportapptechchallenge.presentation.SportViewModel
import uk.co.bbc.bbcsportapptechchallenge.util.TimeUtil

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

        setLastUpdatedTextAppearance()
        setItemTitleTextAppearance()
    }

    fun render(model: SportViewModel) {
        presenter.render(model)
    }

    private fun setItemTitleTextAppearance() {
        val attrs = context.getStyleAttrs()
        binding.itemTitle.setTextAppearance(
            attrs,
            R.styleable.sportLayout_titleTextAppearance,
            R.style.titleTextAppearance
        )
        attrs.recycle()
    }

    private fun setLastUpdatedTextAppearance() {
        val attrs = context.getStyleAttrs()
        binding.lastUpdatedTimestamp.setTextAppearance(
            attrs,
            R.styleable.sportLayout_lastUpdatedTextAppearance,
            R.style.lastUpdatedTextAppearance
        )
        attrs.recycle()
    }

    private fun TextView.setTextAppearance(attrs: TypedArray, @StyleableRes style: Int, @StyleRes default: Int) {
        TextViewCompat.setTextAppearance(this, attrs.getResourceId(style, default))
    }

    private fun Context.getStyleAttrs(): TypedArray {
        return theme.obtainStyledAttributes(
            null,
            R.styleable.sportLayout,
            R.attr.sportLayoutStyle,
            R.style.sportLayout
        )
    }

    private class ViewDelegate(val binding: FragmentMySportBinding): SportView {
        override fun setTopicTitle(topicTitle: String) {
        }

        override fun setItemTitle(itemTitle: String) {
            binding.itemTitle.text = itemTitle
        }

        override fun setItemUrl(itemUrl: String) {
        }

        override fun setLastUpdatedTimestamp(lastUpdatedTimestamp: Int) {
            binding.lastUpdatedTimestamp.text = lastUpdatedTimestamp.let { TimeUtil
                .convertTime(it) }
        }

        override fun setImageSize(medium: String) {
            Picasso.with(binding.root.context).load(medium).into(binding.itemImage)
        }

    }
}