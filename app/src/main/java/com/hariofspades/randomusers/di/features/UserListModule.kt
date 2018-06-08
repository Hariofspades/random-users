package com.hariofspades.randomusers.di.features

import android.arch.persistence.room.Room
import com.hariofspades.data.features.userlist.UserDataRepositoryImpl
import com.hariofspades.data.features.userlist.mapper.ResultItemMapper
import com.hariofspades.data.features.userlist.repository.UserRemote
import com.hariofspades.data.features.userlist.repository.UserStorage
import com.hariofspades.domain.features.userlist.UserDataRepository
import com.hariofspades.remote.features.userlist.UserRemoteImpl
import com.hariofspades.remote.features.userlist.mapper.*
import com.hariofspades.storage.features.userlist.UserStorageImpl
import com.hariofspades.storage.features.userlist.database.UserDB
import com.hariofspades.storage.features.userlist.mapper.SResultItemMapper
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

fun userListModule() = Kodein.Module {

    bind<RResultItemMapper>("r-result-mapper") with provider { RResultItemMapper() }

    bind<UserRemote>("user-remote") with provider {

        UserRemoteImpl(
                instance("retrofit"),
                instance("r-result-mapper")
        )

    }

    bind<ResultItemMapper>("result-mapper") with provider { ResultItemMapper() }

    bind<UserDB>("room-db") with singleton {
        UserDB.create(instance("appContext"))
    }

    bind<SResultItemMapper>("s-result-mapper") with provider { SResultItemMapper() }

    bind<UserStorage>("user-storage") with provider {

        UserStorageImpl(
                instance("room-db"),
                instance("s-result-mapper")
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
