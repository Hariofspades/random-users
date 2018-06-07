package com.hariofspades.randomusers

import android.app.Application
import android.content.Context
import com.hariofspades.randomusers.core.BaseModelFactory
import com.hariofspades.randomusers.di.features.userListModule
import com.hariofspades.randomusers.di.httpModule
import com.hariofspades.randomusers.di.schedulerModule
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton
import timber.log.Timber

class App : Application(), KodeinAware {

    override val kodein = Kodein.lazy {

        bind<Context>("appContext") with singleton { applicationContext }

        import(schedulerModule)

        import(httpModule())

        import(userListModule())

        bind<BaseModelFactory>("factory") with provider {

            BaseModelFactory(
                    instance("scheduler"),
                    instance("user-repo")
            )

        }
    }

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG)
            Timber.plant(Timber.DebugTree())
    }
}