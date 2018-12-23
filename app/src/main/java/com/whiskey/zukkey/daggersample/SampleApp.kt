package com.whiskey.zukkey.daggersample

import android.app.Application
import com.whiskey.zukkey.daggersample.di.AppComponent
import com.whiskey.zukkey.daggersample.di.AppModule
import com.whiskey.zukkey.daggersample.di.DaggerAppComponent


class SampleApp : Application() {

  lateinit var component: AppComponent

  override fun onCreate() {
    super.onCreate()
    component = DaggerAppComponent.builder()
        .appModule(AppModule(this))
        .build()
    component.inject(this)
  }
}
