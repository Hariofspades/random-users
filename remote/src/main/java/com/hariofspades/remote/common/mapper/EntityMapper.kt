package com.hariofspades.remote.common.mapper


/**
 * Interface for model mappers. It provides helper methods that facilitate
 * conversion of models from remote layer to data layer.
 *
 * @param <R> the remote model as input type
 * @param <E> the entity model as output type
 */
interface EntityMapper<in R, out E> {

    fun mapFromRemote(type: R): E

}