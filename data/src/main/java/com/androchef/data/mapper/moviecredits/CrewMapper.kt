package com.androchef.data.mapper.moviecredits

import com.androchef.data.mapper.Mapper
import com.androchef.data.models.CrewEntity
import com.androchef.domain.models.movies.Crew
import javax.inject.Inject

class CrewMapper @Inject constructor() : Mapper<CrewEntity, Crew> {
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