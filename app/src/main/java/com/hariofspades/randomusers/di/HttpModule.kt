package com.hariofspades.randomusers.di

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.hariofspades.randomusers.BuildConfig
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.kcontext
import org.kodein.di.generic.singleton
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber

fun httpModule(context: Context) = Kodein.Module {

    bind<HttpLoggingInterceptor>("log-interceptor") with singleton {
        val level = if(BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else
            HttpLoggingInterceptor.Level.NONE
        HttpLoggingInterceptor(HttpLoggingInterceptor.Logger {
            message -> Timber.d("HttpLog Interceptor - $message")
        }).setLevel(level)
    }

    bind<RxJava2CallAdapterFactory>("rx-adapter") with singleton {
        RxJava2CallAdapterFactory.create()
    }

    bind<Cache>("cache") with singleton {
        Cache(kcontext(context).value.cacheDir, 10 * 1024 * 1024)
    }

    bind<OkHttpClient>("httpclient") with singleton {
        OkHttpClient.Builder()
                .addInterceptor(instance("log-interceptor"))
                .cache(instance("cache"))
                .build()
    }

    bind<Gson>("gson") with singleton {
        GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setLenient()
                .create()
    }

    bind<Retrofit>("retrofit") with singleton {
        Retrofit.Builder()
                .client(instance("httpclient"))
                .baseUrl(BuildConfig.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(instance("gson")))
                .addCallAdapterFactory(instance("rx-adapter"))
                .build()
    }
}

