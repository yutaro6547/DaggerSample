package com.whiskey.zukkey.daggersample.di.module

import android.app.Activity
import android.app.Application
import com.whiskey.zukkey.daggersample.MainActivity
import com.whiskey.zukkey.daggersample.di.component.HandlerComponent
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module(subcomponents = [HandlerComponent::class])
class AppModule(private val application: Application)
