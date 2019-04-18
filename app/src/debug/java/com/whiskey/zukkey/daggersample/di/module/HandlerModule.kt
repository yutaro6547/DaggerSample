package com.whiskey.zukkey.daggersample.di.module

import android.support.v7.app.AppCompatActivity
import com.whiskey.zukkey.daggersample.api.GitHubClient
import com.whiskey.zukkey.daggersample.di.DebugShakeHandler
import com.whiskey.zukkey.daggersample.di.ShakeHandler
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
class HandlerModule(
    private val activity: AppCompatActivity
) {

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
