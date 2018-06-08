package com.hariofspades.randomusers.feature.userlist

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import com.hariofspades.randomusers.R
import com.hariofspades.randomusers.common.extensions.isNetworkStatusAvailable
import com.hariofspades.randomusers.core.BaseActivity
import com.hariofspades.randomusers.core.BaseModelFactory
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance
import timber.log.Timber

class TempActivity : BaseActivity(), KodeinAware {

    override val kodein by closestKodein()
    private val factory: BaseModelFactory by instance("factory")

    private lateinit var viewModel: TempViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temp)
        init()
        getNetworkState()
        observe()
    }

    private fun getNetworkState() {
        Timber.d("internet connection - ${this.isNetworkStatusAvailable()}")
        viewModel.isConnected.value = this.isNetworkStatusAvailable()
    }

    private fun observe() {
        viewModel.getRandomUserList().observe(this, Observer {

            Timber.d("received user size- ${it?.size}")

        })
    }

    private fun init() {
        viewModel = ViewModelProviders.of(this, factory).get(TempViewModel::class.java)
    }
}
