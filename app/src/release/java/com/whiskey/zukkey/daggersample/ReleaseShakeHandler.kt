package com.whiskey.zukkey.daggersample

import android.support.v7.app.AppCompatActivity
import com.whiskey.zukkey.daggersample.di.ShakeHandler


class ReleaseShakeHandler(
    private val activity: AppCompatActivity
) : ShakeHandler {
  override fun onCreate() = Unit

  override fun onDestroy() = Unit
}
