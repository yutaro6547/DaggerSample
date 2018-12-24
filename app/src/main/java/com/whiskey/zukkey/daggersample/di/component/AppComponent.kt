package com.whiskey.zukkey.daggersample.di.component

import com.whiskey.zukkey.daggersample.MainActivity
import com.whiskey.zukkey.daggersample.SampleApp
import com.whiskey.zukkey.daggersample.di.module.HandlerModule
import com.whiskey.zukkey.daggersample.di.module.AppModule
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {
  fun inject(application: SampleApp)
  fun plus(module: HandlerModule): HandlerComponent
}
