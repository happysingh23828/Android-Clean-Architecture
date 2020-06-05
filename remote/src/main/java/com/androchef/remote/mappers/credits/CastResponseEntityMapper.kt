package com.androchef.remote.mappers.credits

import com.androchef.data.models.CastEntity
import com.androchef.remote.mappers.EntityMapper
import com.androchef.remote.models.credits.CastModel
import javax.inject.Inject

class CastResponseEntityMapper @Inject constructor() : EntityMapper<CastModel, CastEntity> {
    override fun mapFromModel(model: CastModel): CastEntity {
        return CastEntity(
            character = model.character,
            name = model.name,
            profilePath = model.profilePath,
            id = model.id,
            order = model.id
        )
    }
}
