package uk.co.bbc.bbcsportapptechchallenge.stats

sealed class StatsEvent (val event: String) {
    object Display : StatsEvent("display")
    object LOAD : StatsEvent("load")
    object ERROR : StatsEvent("error")
}