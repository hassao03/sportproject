package uk.co.bbc.bbcsportapptechchallenge.model

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.junit.Test
import uk.co.bbc.bbcsportapptechchallenge.DataClasses.createModel
import uk.co.bbc.bbcsportapptechchallenge.presentation.SportPresenter
import uk.co.bbc.bbcsportapptechchallenge.presentation.SportView

class SportPresenterTest {

    private val view = mock <SportView>()

    @Test
    fun `sets topic title`() {
        val topicTitle = "formula 1"
        val model = createModel()
        val sut = createPresenter()

        sut.render(model)

        verify(view).setTopicTitle(topicTitle)
    }

    @Test
    fun `sets item title`() {
        val itemTitle = "Schumacher junior wins European F3 title with race to spare"
        val model = createModel()
        val sut = createPresenter()

        sut.render(model)

        verify(view).setItemTitle(itemTitle)
    }

    @Test
    fun `sets item url`() {
        val itemUrl = "https://www.bbc.co.uk/sport/motorsport/45851176"
        val model = createModel()
        val sut = createPresenter()

        sut.render(model)

        verify(view).setItemUrl(itemUrl)
    }

    @Test
    fun `sets last updated timestamp`() {
        val lastUpdatedTimestamp = 1539529691
        val model = createModel()
        val sut = createPresenter()

        sut.render(model)

        verify(view).setLastUpdatedTimestamp(lastUpdatedTimestamp)
    }

    @Test
    fun `sets image size`() {
        val imageSize = "https://ichef.bbci.co.uk/onesport/cps/320/cpsprodpb/16477/production/_103855219_schumacher.jpg"
        val model = createModel()
        val sut = createPresenter()

        sut.render(model)

        verify(view).setImageSize(imageSize)
    }

    private fun createPresenter(): SportPresenter {
        return SportPresenter(view)
    }
}