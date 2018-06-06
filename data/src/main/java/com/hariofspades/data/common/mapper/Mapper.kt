package com.hariofspades.data.common.mapper

/**
 * Interface for model mappers. It provides helper methods that facilitate
 * retrieving of models from domain layer.
 *
 * @param <D> the domain model
 * @param <E> the entity model
 */
interface Mapper<E, D> {

    fun mapFromEntity(type: E): D

    fun mapToEntity(type: D): E

}