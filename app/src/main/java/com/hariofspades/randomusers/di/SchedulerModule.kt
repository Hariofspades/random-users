package com.hariofspades.randomusers.di

import com.hariofspades.randomusers.common.scheduling.DefaultSchedulerProvider
import com.hariofspades.randomusers.common.scheduling.SchedulerProvider
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

val schedulerModule = Kodein.Module {

    bind<SchedulerProvider>("scheduler") with provider { DefaultSchedulerProvider() }
}