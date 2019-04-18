package com.whiskey.zukkey.daggersample.di.component

import com.whiskey.zukkey.daggersample.MainActivity
import com.whiskey.zukkey.daggersample.di.module.HandlerModule
import dagger.BindsInstance
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent
interface HandlerComponent: AndroidInjector<MainActivity> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MainActivity>() {
        abstract fun handlerModule(module: HandlerModule)

        override fun seedInstance(activity: MainActivity) {
            handlerModule(HandlerModule(activity))
        }
    }
}