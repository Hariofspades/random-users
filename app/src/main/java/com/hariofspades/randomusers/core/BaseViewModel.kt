package com.hariofspades.randomusers.core

import android.arch.lifecycle.ViewModel
import android.support.annotation.CallSuper
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseViewModel : ViewModel() {

    val disposables = CompositeDisposable()

    @CallSuper
    open fun onDetach() {
        disposables.clear()
    }

    protected fun addRx(disposable: Disposable) {
        this.disposables.add(disposable)
    }

}