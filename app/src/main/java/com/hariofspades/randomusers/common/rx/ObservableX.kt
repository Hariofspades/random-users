package com.hariofspades.randomusers.common.rx

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.exceptions.CompositeException
import java.util.concurrent.TimeUnit

fun <T> Observable<T>.dropBreadcrumb(): Observable<T> {
    val breadcrumb = BreadcrumbException()
    return this.onErrorResumeNext { error: Throwable ->
        throw CompositeException(error, breadcrumb)
    }
}

class BreadcrumbException : Exception()