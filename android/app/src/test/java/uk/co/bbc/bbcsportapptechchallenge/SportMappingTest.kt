package uk.co.bbc.bbcsportapptechchallenge

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import uk.co.bbc.bbcsportapptechchallenge.DataClasses.createModel
import uk.co.bbc.bbcsportapptechchallenge.DataClasses.createSport
import uk.co.bbc.bbcsportapptechchallenge.mapper.toViewModel

class SportMappingTest {

    @Test
    fun `converts sport to sport view model`(){
        val sport = createSport()
        val model = createModel()

        val result = sport.toViewModel()

        assertThat(result).isEqualTo(model)
    }
}