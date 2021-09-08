package uk.co.bbc.bbcsportapptechchallenge

import uk.co.bbc.bbcsportapptechchallenge.presentation.*

object DataClasses {

    fun createSport(): SportData {
        val data = Data(topic(), items())

        return SportData(
            data
        )
    }

    fun createModel(): SportViewModel {
        val data = Data(topic(), items())

        return SportViewModel(
            data
        )
    }

    private fun topic(): Topic {
        return Topic(
            "formula 1",
            "url"
        )
    }

    private fun items(): List<Items> {
        return listOf(
            Items(
                "type",
                "Schumacher junior wins European F3 title with race to spare",
                "https://www.bbc.co.uk/sport/motorsport/45851176",
                "sectionLabel",
                "sectionUrl",
                false,
                "lastUpdatedText",
                "mediaType",
                "contentType",
                1539529691,
                image()
            )
        )
    }

    private fun image(): Image {
        return Image(
            "small",
            "https://ichef.bbci.co.uk/onesport/cps/320/cpsprodpb/16477/production/_103855219_schumacher.jpg",
            "large",
            "altText",
            "copyrightHolder"
        )
    }
}