package uk.co.bbc.bbcsportapptechchallenge.ui

import android.content.Context
import android.content.Intent
import android.content.res.TypedArray
import android.net.Uri
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

class SportLayout constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = R.attr.sportLayoutStyle
) : FrameLayout(context, attrs, defStyle), Component<SportViewModel>{

    private var model: SportViewModel? = null
    private val binding = FragmentMySportBinding.inflate(LayoutInflater.from(context), this, true)
    private val viewDelegate = ViewDelegate(binding)
    private val presenter = SportPresenter(viewDelegate)

    init {
        setLastUpdatedTextAppearance()
        setItemTitleTextAppearance()
        openBrowser()
    }

    override fun render(model: SportViewModel) {
        presenter.render(model)
        this.model = model
    }

    private fun openBrowser() {
        binding.root.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(model?.data?.items?.map { it.url }?.get(0)))
            context.startActivity(browserIntent)
        }
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
        override fun setTopicTitle(topicTitle: String) {}

        override fun setItemTitle(itemTitle: String) {
            binding.itemTitle.text = itemTitle
        }

        override fun setLastUpdatedTimestamp(lastUpdatedTimestamp: Int) {
            binding.lastUpdatedTimestamp.text = lastUpdatedTimestamp.let { TimeUtil.convertTime(it) }
        }

        override fun setImageSize(image: String) {
            Picasso.with(binding.root.context).load(image).into(binding.itemImage)
        }
    }
}