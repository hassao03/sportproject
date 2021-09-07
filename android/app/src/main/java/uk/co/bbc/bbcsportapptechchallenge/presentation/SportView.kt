package uk.co.bbc.bbcsportapptechchallenge.presentation

internal interface SportView{
    fun setTopicTitle(topicTitle: String)
    fun setItemTitle(itemTitle: String)
    fun setLastUpdatedTimestamp(lastUpdatedTimestamp: Int)
    fun setImageSize(image: String)
}