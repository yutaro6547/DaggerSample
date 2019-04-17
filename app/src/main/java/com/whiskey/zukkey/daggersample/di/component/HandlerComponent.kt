package com.whiskey.zukkey.daggersample.di.component

import android.support.v7.app.AppCompatActivity
import com.whiskey.zukkey.daggersample.di.module.HandlerModule
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(modules = [HandlerModule::class])
interface HandlerComponent
//{
//  @Subcomponent.Builder
//  abstract class Builder: AndroidInjector.Builder<AppCompatActivity>() {
//    abstract fun activityModule(module: HandlerModule)
//
//    override fun seedInstance(instance: AppCompatActivity) {
//      activityModule(HandlerModule(instance))
//    }
//  }
//}
