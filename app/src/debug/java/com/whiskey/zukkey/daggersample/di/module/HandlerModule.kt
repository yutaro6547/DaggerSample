package com.whiskey.zukkey.daggersample.di.module

import android.support.v7.app.AppCompatActivity
import com.whiskey.zukkey.daggersample.api.GitHubClient
import com.whiskey.zukkey.daggersample.di.DebugShakeHandler
import com.whiskey.zukkey.daggersample.di.ShakeHandler
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import android.app.Activity
import dagger.android.AndroidInjector
import com.whiskey.zukkey.daggersample.MainActivity
import com.whiskey.zukkey.daggersample.di.component.HandlerComponent
import dagger.multibindings.IntoMap
import dagger.Binds
import dagger.android.ActivityKey
import dagger.multibindings.Multibinds


@Module(includes = [HandlerModule.BindableModule::class])
abstract class HandlerModule(
    private val activity: AppCompatActivity
) {

  @Module
  interface BindableModule {
    @Binds
    @IntoMap
    @ActivityKey(MainActivity::class)
    abstract fun bindInjectorFactory(builder: HandlerComponent.Builder): AndroidInjector.Factory<out Activity>
  }

  @Provides fun provideRetrofit(): Retrofit {
    return Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
  }

  @Provides fun provideGitHubService(retrofit: Retrofit) : GitHubClient.GitHubService {
    return retrofit.create(GitHubClient.GitHubService::class.java)
  }

  @Provides
  fun provideShakeHandler(): ShakeHandler {
    return DebugShakeHandler(activity)
  }
}
