package com.whiskey.zukkey.daggersample.di.component

import com.whiskey.zukkey.daggersample.MainActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent
interface HandlerComponent: AndroidInjector<MainActivity> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MainActivity>()
}