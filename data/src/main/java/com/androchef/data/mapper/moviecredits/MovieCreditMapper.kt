package com.androchef.data.mapper.moviecredits

import com.androchef.data.mapper.Mapper
import com.androchef.data.models.MovieCreditEntity
import com.androchef.domain.models.movies.MovieCredits
import javax.inject.Inject

class MovieCreditMapper @Inject constructor(
    private val crewMapper: CrewMapper,
    private val castMapper: CastMapper
) : Mapper<MovieCreditEntity, MovieCredits> {

    override fun mapFromEntity(type: MovieCreditEntity): MovieCredits {
        return MovieCredits(
            cast = type.cast.map { castMapper.mapFromEntity(it) },
            crew = type.crew.map { crewMapper.mapFromEntity(it) },
            id = type.id
        )
    }

    override fun mapToEntity(type: MovieCredits): MovieCreditEntity {
        return MovieCreditEntity(
            cast = type.cast.map { castMapper.mapToEntity(it) },
            crew = type.crew.map { crewMapper.mapToEntity(it) },
            id = type.id
        )
    }
}
