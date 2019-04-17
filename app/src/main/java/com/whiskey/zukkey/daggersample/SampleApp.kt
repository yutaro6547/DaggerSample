package com.whiskey.zukkey.daggersample

import com.whiskey.zukkey.daggersample.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication


class SampleApp : DaggerApplication() {
  override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
    val appComponent = DaggerAppComponent
            .builder()
            .application(this).build()
    appComponent.inject(this)
    return appComponent
  }
}
