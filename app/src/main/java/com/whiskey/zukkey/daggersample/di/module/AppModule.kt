package com.whiskey.zukkey.daggersample.di.module

import android.app.Application
import com.whiskey.zukkey.daggersample.api.GitHubClient
import com.whiskey.zukkey.daggersample.di.component.HandlerComponent
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module(subcomponents = [HandlerComponent::class])
class AppModule(private val application: Application) {

  @Provides fun provideApplication(): Application {
    return application
  }
}
