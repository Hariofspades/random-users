package com.hariofspades.randomusers

import android.app.Application
import android.content.Context
import com.hariofspades.randomusers.di.features.userListModule
import com.hariofspades.randomusers.di.httpModule
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton
import timber.log.Timber

class App : Application(), KodeinAware {

    override val kodein = Kodein.lazy {

        bind<Context>("appContext") with singleton { applicationContext }

        import(httpModule())

        import(userListModule())
    }

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG)
            Timber.plant(Timber.DebugTree())
    }
}