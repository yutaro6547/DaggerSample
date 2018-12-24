package com.whiskey.zukkey.daggersample

import android.app.Application
import com.whiskey.zukkey.daggersample.di.component.AppComponent
import com.whiskey.zukkey.daggersample.di.component.DaggerAppComponent
import com.whiskey.zukkey.daggersample.di.module.AppModule


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
