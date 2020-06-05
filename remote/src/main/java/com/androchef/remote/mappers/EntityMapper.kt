package com.androchef.remote.mappers

interface EntityMapper<M, E> {

    fun mapFromModel(model: M): E
}
