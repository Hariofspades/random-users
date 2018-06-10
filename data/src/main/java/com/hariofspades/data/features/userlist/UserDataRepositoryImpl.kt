package com.hariofspades.data.features.userlist

import com.hariofspades.data.features.userlist.mapper.ResultItemMapper
import com.hariofspades.data.features.userlist.repository.UserRemote
import com.hariofspades.data.features.userlist.repository.UserStorage
import com.hariofspades.domain.features.userlist.UserDataRepository
import com.hariofspades.domain.features.userlist.model.ResultsItem
import io.reactivex.Single
import io.reactivex.rxkotlin.Singles
import timber.log.Timber

/**
 * Data Repository implementation for the app. This is the single source of truth
 *
 * @param resultItemMapper - mapper helper
 * @param userRemote - Retrofit, network
 * @param userStorage - Room database
 *
 * @author Hari Vignesh Jayapalan
 */
class UserDataRepositoryImpl(
        private val resultItemMapper: ResultItemMapper,
        private val userRemote: UserRemote,
        private val userStorage: UserStorage

) : UserDataRepository {


    /**
     * Getting only one user from the DB. For DetailActivity
     *
     * @param firstName - name of the user
     * @return Single<ResultItem> - data class
     */
    override fun getOneUser(firstName: String): Single<ResultsItem> {
        return userStorage.getOneUser(firstName).map(resultItemMapper::mapFromEntity)
    }


    /**
     * Getting the list of users from network and database
     *
     * @param isConnected - network status
     *
     * If isConnected, get from network, save to DB and then show to UI
     * If !isConnected, get from DB
     */
    override fun getRandomUserList(isConnected: Boolean): Single<List<ResultsItem>> {

        if (isConnected) {
            //get from network and save to db

            val storage = userStorage.getUsers()
            val remote = userRemote.getRandomUserList()

            return Singles.zip(remote, storage)
                    .doOnError{
                        Timber.d("error - ${it.printStackTrace()}")
                    }
                    .doOnSuccess{ (remote, _) ->
                        userStorage.insertUsers(remote)
                    }
                    .flatMap { (remoteList, _) ->

                        Single.just(remoteList.map { resultItemMapper.mapFromEntity(it) })
                    }
        } else {
            //get from db
            return userStorage.getUsers().map {
                it.map { resultItemMapper.mapFromEntity(it) }
            }.doOnError { Timber.d("db error - ${it.printStackTrace()}") }
        }
    }


}