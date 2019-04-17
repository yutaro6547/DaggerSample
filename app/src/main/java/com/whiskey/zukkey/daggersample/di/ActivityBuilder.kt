package com.whiskey.zukkey.daggersample.di


import com.whiskey.zukkey.daggersample.MainActivity
import com.whiskey.zukkey.daggersample.di.module.HandlerModule

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

//    @ContributesAndroidInjector(modules = [HandlerModule::class])
//    internal abstract fun bindMainActivity(): MainActivity
}
