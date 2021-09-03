package uk.co.bbc.bbcsportapptechchallenge.presentation

data class SportData(
    val data: Data
)

data class Data(
    val topic: Topic,
    val items: List<Items>
)

data class Topic(
    val title: String,
    val url: String
    )

data class Items(
    val type: String,
    val title: String,
    val url: String,
    val sectionLabel: String,
    val sectionUrl: String,
    val isLive: Boolean,
    val lastUpdatedText: String,
    val mediaType: String?,
    val contentType: String?,
    val lastUpdatedTimestamp: Int,
    val image: Image
)

data class Image(
    val small: String,
    val medium: String,
    val large: String,
    val altText: String,
    val copyrightHolder: String
)