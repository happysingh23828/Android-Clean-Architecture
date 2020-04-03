package com.androchef.remote.mappers.credits

import com.androchef.data.models.CastEntity
import com.androchef.data.models.CrewEntity
import com.androchef.data.models.MovieCreditEntity
import com.androchef.remote.mappers.Mapper
import com.androchef.remote.models.credits.CastModel
import com.androchef.remote.models.credits.CrewModel
import com.androchef.remote.models.credits.MovieCreditsModel

class MovieCreditResponseMapper(
    private val crewResponseMapper: CrewResponseMapper,
    private val castResponseMapper : CastResponseMapper
) : Mapper<MovieCreditsModel,MovieCreditEntity> {

    override fun mapFromModel(model: MovieCreditsModel): MovieCreditEntity {
        return MovieCreditEntity(
            cast = model.cast.map { castResponseMapper.mapFromModel(it) },
            crew = model.crew.map { crewResponseMapper.mapFromModel(it) },
            id = model.id
        )
    }

    inner class CrewResponseMapper : Mapper<CrewModel,CrewEntity> {
        override fun mapFromModel(model: CrewModel): CrewEntity {
          return  CrewEntity(
                id = model.id,
                profile_path = model.profilePath,
                name = model.name
            )
        }
    }

    inner class CastResponseMapper : Mapper<CastModel,CastEntity> {
        override fun mapFromModel(model: CastModel): CastEntity {
            return CastEntity(
                character = model.character,
                name = model.name,
                profile_path = model.profilePath,
                id = model.id,
                order = model.id
            )
        }
    }
}