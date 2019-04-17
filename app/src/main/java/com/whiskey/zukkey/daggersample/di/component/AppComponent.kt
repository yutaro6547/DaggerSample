package com.whiskey.zukkey.daggersample.di.component

import android.app.Application
import com.whiskey.zukkey.daggersample.SampleApp
import com.whiskey.zukkey.daggersample.di.ActivityBuilder
import com.whiskey.zukkey.daggersample.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication


@Component(modules = [AndroidInjectionModule::class, AppModule::class, ActivityBuilder::class])
interface AppComponent: AndroidInjector<DaggerApplication> {

    override fun inject(instance: DaggerApplication)

    fun inject(application: SampleApp)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}
