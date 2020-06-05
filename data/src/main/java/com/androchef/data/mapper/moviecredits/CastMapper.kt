package com.androchef.data.mapper.moviecredits

import com.androchef.data.mapper.Mapper
import com.androchef.data.models.CastEntity
import com.androchef.domain.models.movies.Cast
import javax.inject.Inject

class CastMapper @Inject constructor() : Mapper<CastEntity, Cast> {
    override fun mapFromEntity(type: CastEntity): Cast {
        return Cast(
            character = type.character,
            name = type.name,
            profilePath = type.profilePath,
            id = type.id,
            order = type.id
        )
    }

    override fun mapToEntity(type: Cast): CastEntity {
        return CastEntity(
            character = type.character,
            name = type.name,
            profilePath = type.profilePath,
            id = type.id,
            order = type.id
        )
    }
}
