package com.whiskey.zukkey.daggersample.di.component

import com.whiskey.zukkey.daggersample.SampleApp
import com.whiskey.zukkey.daggersample.di.module.AppModule
import dagger.Component
import dagger.android.AndroidInjectionModule

@Component(modules = [AndroidInjectionModule::class, AppModule::class])
interface AppComponent {
  fun inject(application: SampleApp)
}
