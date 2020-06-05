package com.androchef.remote.mappers.credits

import com.androchef.data.models.MovieCreditEntity
import com.androchef.remote.mappers.EntityMapper
import com.androchef.remote.models.credits.MovieCreditsModel
import javax.inject.Inject

class MovieCreditResponseEntityMapper @Inject constructor(
    private val crewResponseMapper: CrewResponseEntityMapper,
    private val castResponseMapper: CastResponseEntityMapper
) : EntityMapper<MovieCreditsModel, MovieCreditEntity> {

    override fun mapFromModel(model: MovieCreditsModel): MovieCreditEntity {
        return MovieCreditEntity(
            cast = model.cast.map { castResponseMapper.mapFromModel(it) },
            crew = model.crew.map { crewResponseMapper.mapFromModel(it) },
            id = model.id
        )
    }
}
