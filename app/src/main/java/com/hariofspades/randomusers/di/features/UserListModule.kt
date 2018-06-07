package com.hariofspades.randomusers.di.features

import com.hariofspades.data.features.userlist.UserDataRepositoryImpl
import com.hariofspades.data.features.userlist.mapper.ResultItemMapper
import com.hariofspades.data.features.userlist.repository.UserRemote
import com.hariofspades.domain.features.userlist.UserDataRepository
import com.hariofspades.remote.features.userlist.UserRemoteImpl
import com.hariofspades.remote.features.userlist.mapper.*
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider

fun userListModule() = Kodein.Module {

    bind<RResultItemMapper>("r-result-mapper") with provider { RResultItemMapper() }

    bind<UserRemote>("user-remote") with provider {

        UserRemoteImpl(
                instance("retrofit"),
                instance("r-result-mapper")
        )

    }

    bind<ResultItemMapper>("result-mapper") with provider { ResultItemMapper() }

    bind<UserDataRepository>("user-repo") with provider {

        UserDataRepositoryImpl(
                instance("result-mapper"),
                instance("user-remote")
        )
    }

}
