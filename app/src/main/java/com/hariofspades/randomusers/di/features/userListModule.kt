package com.hariofspades.randomusers.di.features

import com.hariofspades.data.features.userlist.UserDataRepositoryImpl
import com.hariofspades.data.features.userlist.mapper.LocationMapper
import com.hariofspades.data.features.userlist.mapper.NameMapper
import com.hariofspades.data.features.userlist.mapper.PictureMapper
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


    bind<RLoginMapper>("r-login-mapper") with provider { RLoginMapper() }

    bind<RNameMapper>("r-name-mapper") with provider { RNameMapper() }

    bind<RPictureMapper>("r-pic-mapper") with provider { RPictureMapper() }

    bind<RLocationMapper>("r-loc-mapper") with provider { RLocationMapper() }

    bind<RIdMapper>("r-id-mapper") with provider { RIdMapper() }

    bind<RResultItemMapper>("r-result-mapper") with provider {

        RResultItemMapper(
                instance("r-id-mapper"),
                instance("r-loc-mapper"),
                instance("r-name-mapper"),
                instance("r-pic-mapper"),
                instance("r-login-mapper")
        )
    }

    bind<UserRemote>("user-remote") with provider {

        UserRemoteImpl(
                instance("retrofit"),
                instance("r-result-mapper")
        )

    }

    bind<NameMapper>("name-mapper") with provider { NameMapper() }

    bind<LocationMapper>("loc-mapper") with provider { LocationMapper() }

    bind<PictureMapper>("pic-mapper") with provider { PictureMapper() }

    bind<ResultItemMapper>("result-mapper") with provider {

        ResultItemMapper(
                instance("name-mapper"),
                instance("loc-mapper"),
                instance("pic-mapper")
        )
    }

    bind<UserDataRepository>("user-repo") with provider {

        UserDataRepositoryImpl(
                instance("result-mapper"),
                instance("user-remote")
        )
    }

}
