package com.whiskey.zukkey.daggersample

import android.app.Activity
import android.app.Application
import com.whiskey.zukkey.daggersample.di.component.AppComponent
import com.whiskey.zukkey.daggersample.di.component.DaggerAppComponent
import com.whiskey.zukkey.daggersample.di.module.HandlerModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject


class SampleApp : Application(), HasActivityInjector {

  @Inject lateinit var activityInjector: DispatchingAndroidInjector<Activity>
  lateinit var appComponent: AppComponent

  override fun onCreate() {
    super.onCreate()
    appComponent = DaggerAppComponent
            .builder()
            .application(this)
            .build()
    appComponent.inject(this)
  }

  override fun activityInjector(): AndroidInjector<Activity> {
    return activityInjector
  }
}
