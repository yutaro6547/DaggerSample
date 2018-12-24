package com.whiskey.zukkey.daggersample.di.component

import com.whiskey.zukkey.daggersample.MainActivity
import com.whiskey.zukkey.daggersample.di.module.HandlerModule
import dagger.Subcomponent

@Subcomponent(modules = [HandlerModule::class])
interface HandlerComponent {
  fun inject(activity: MainActivity)
}
