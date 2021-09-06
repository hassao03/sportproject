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
import uk.co.bbc.bbcsportapptechchallenge.R
import uk.co.bbc.bbcsportapptechchallenge.databinding.ContentMainBinding

class ContentLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = R.attr.sportLayoutStyle
) : FrameLayout(context, attrs, defStyle) {

    private val binding = ContentMainBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        setTopicTitleTextAppearance()
    }

    private fun setTopicTitleTextAppearance() {
        val attrs = context.getStyleAttrs()
        binding.topicTitle.setTextAppearance(
            attrs,
            R.styleable.sportLayout_topicTitleTextAppearance,
            R.style.topicTitleTextAppearance
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

}