package uk.co.bbc.bbcsportapptechchallenge.presentation

internal class SportPresenter(
    private val view: SportView
){
    fun render(model: SportViewModel){
        with(model){
            view.setTopicTitle(data.topic.title)
            data.items.map {
                with(it) {
                    view.setItemTitle(title)
                    view.setItemUrl(url)
                    view.setLastUpdatedTimestamp(lastUpdatedTimestamp)
                    view.setImageSize(image.medium)
                }
            }
        }
    }
}