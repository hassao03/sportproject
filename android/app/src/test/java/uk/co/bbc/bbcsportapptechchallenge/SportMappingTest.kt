package uk.co.bbc.bbcsportapptechchallenge

import org.junit.Test
import org.assertj.core.api.Assertions.assertThat
import uk.co.bbc.bbcsportapptechchallenge.mapper.toViewModel
import uk.co.bbc.bbcsportapptechchallenge.presentation.*

class SportMappingTest {

    @Test
    fun `converts sport to sport view model`(){
        val sport = createSport()
        val model = createModel()

        val result = sport.toViewModel()

        assertThat(result).isEqualTo(model)
    }

    private fun createSport(): SportData {
        val data = Data(topic(), items())

        return SportData(
            data
        )
    }

    private fun createModel(): SportViewModel {
        val data = Data(topic(), items())

        return SportViewModel(
            data
        )
    }

    private fun topic(): Topic {
        return Topic(
            "title",
            "url"
        )
    }

    private fun items(): List<Items> {
        return listOf(Items(
            "type",
            "title",
            "url",
            "sectionLabel",
            "sectionUrl",
            false,
            "lastUpdatedText",
            "mediaType",
            "contentType",
            100,
            image()
        ))
    }

    private fun image(): Image {
        return Image(
            "small",
            "medium",
            "large",
            "altText",
            "copyrightHolder"
        )
    }
}