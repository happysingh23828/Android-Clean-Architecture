package com.androchef.remote.mappers.credits

import com.androchef.data.models.CrewEntity
import com.androchef.remote.mappers.EntityMapper
import com.androchef.remote.models.credits.CrewModel
import javax.inject.Inject

class CrewResponseEntityMapper @Inject constructor() : EntityMapper<CrewModel, CrewEntity> {
    override fun mapFromModel(model: CrewModel): CrewEntity {
        return CrewEntity(
            id = model.id,
            profilePath = model.profilePath,
            name = model.name
        )
    }
}
