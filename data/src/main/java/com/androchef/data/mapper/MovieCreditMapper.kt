package com.androchef.data.mapper

import com.androchef.data.models.CastEntity
import com.androchef.data.models.CrewEntity
import com.androchef.data.models.MovieCreditEntity
import com.androchef.domain.models.movies.Cast
import com.androchef.domain.models.movies.Crew
import com.androchef.domain.models.movies.MovieCredits
import javax.inject.Inject

class MovieCreditMapper @Inject constructor(
    private val crewMapper: CrewMapper,
    private val castMapper: CastMapper
) : Mapper<MovieCreditEntity,MovieCredits> {

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


    /**
     * Cast and Crew Mapper
     */
    inner class CrewMapper @Inject constructor() : Mapper<CrewEntity,Crew> {
        override fun mapFromEntity(type: CrewEntity): Crew {
            return Crew(
                id = type.id,
                profile_path = type.profile_path,
                name = type.name
            )
        }

        override fun mapToEntity(type: Crew): CrewEntity {
            return CrewEntity(
                id = type.id,
                profile_path = type.profile_path,
                name = type.name
            )
        }
    }

    inner class CastMapper @Inject constructor(): Mapper<CastEntity,Cast> {
        override fun mapFromEntity(type: CastEntity): Cast {
            return Cast(
                character = type.character,
                name = type.name,
                profile_path = type.profile_path,
                id = type.id,
                order = type.id
            )
        }

        override fun mapToEntity(type: Cast): CastEntity {
            return CastEntity(
                character = type.character,
                name = type.name,
                profile_path = type.profile_path,
                id = type.id,
                order = type.id
            )
        }
    }
}