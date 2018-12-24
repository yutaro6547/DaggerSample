package com.whiskey.zukkey.daggersample.di.module

import android.app.Application
import com.whiskey.zukkey.daggersample.api.GitHubClient
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class AppModule(private val application: Application) {

  @Provides fun provideApplication(): Application {
    return application
  }
}
