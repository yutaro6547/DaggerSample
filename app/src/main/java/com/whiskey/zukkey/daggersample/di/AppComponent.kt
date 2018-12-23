package com.whiskey.zukkey.daggersample.di

import com.whiskey.zukkey.daggersample.MainActivity
import com.whiskey.zukkey.daggersample.SampleApp
import dagger.Component

@Component(modules = [(AppModule::class)])
interface AppComponent {
  fun inject(application: SampleApp)
  fun inject(activity: MainActivity)
}
