package uk.co.bbc.bbcsportapptechchallenge.ui

import uk.co.bbc.bbcsportapptechchallenge.presentation.SportViewModel

interface Component<Model : SportViewModel> {
    fun render(model: Model)
}