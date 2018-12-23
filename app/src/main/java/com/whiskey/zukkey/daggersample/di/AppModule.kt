package com.whiskey.zukkey.daggersample.di

import android.app.Application
import com.whiskey.zukkey.daggersample.api.GitHubClient
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class AppModule(private val application: Application) {

  @Provides fun provideApplication(): Application {
    return application
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
}
