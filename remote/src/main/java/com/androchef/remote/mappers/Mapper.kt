package com.androchef.remote.mappers

interface Mapper<M, E> {

    fun mapFromModel(model : M) :E

}