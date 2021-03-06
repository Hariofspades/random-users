package com.hariofspades.randomusers.di.features

import android.arch.persistence.room.Room
import com.hariofspades.data.features.userlist.UserDataRepositoryImpl
import com.hariofspades.data.features.userlist.mapper.ResultItemMapper
import com.hariofspades.data.features.userlist.repository.UserRemote
import com.hariofspades.data.features.userlist.repository.UserStorage
import com.hariofspades.domain.features.userlist.UserDataRepository
import com.hariofspades.remote.features.userlist.UserRemoteImpl
import com.hariofspades.remote.features.userlist.UserService
import com.hariofspades.remote.features.userlist.mapper.*
import com.hariofspades.storage.features.userlist.UserStorageImpl
import com.hariofspades.storage.features.userlist.dao.UserDao
import com.hariofspades.storage.features.userlist.database.UserDB
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

fun userListModule() = Kodein.Module {

    bind<RResultItemMapper>("r-result-mapper") with provider { RResultItemMapper() }

    bind<UserRemote>("user-remote") with provider {

        UserRemoteImpl(
                instance("user-service"),
                instance("r-result-mapper")
        )

    }

    bind<ResultItemMapper>("result-mapper") with provider { ResultItemMapper() }

    bind<UserDao>("room-db") with singleton {
        Room.databaseBuilder(instance("appContext"),
                UserDB::class.java, "user.db").build().userDao()
    }

    bind<UserStorage>("user-storage") with provider {

        UserStorageImpl(
                instance("room-db")
        )
    }

    bind<UserDataRepository>("user-repo") with provider {

        UserDataRepositoryImpl(
                instance("result-mapper"),
                instance("user-remote"),
                instance("user-storage")
        )
    }

}
