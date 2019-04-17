package com.whiskey.zukkey.daggersample.di.module

import android.app.Application
import com.whiskey.zukkey.daggersample.di.component.HandlerComponent
import dagger.Module

@Module(subcomponents = [HandlerComponent::class])
class AppModule(private val application: Application)
