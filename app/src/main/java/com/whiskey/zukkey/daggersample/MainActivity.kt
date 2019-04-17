package com.whiskey.zukkey.daggersample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.whiskey.zukkey.daggersample.api.GitHubClient
import com.whiskey.zukkey.daggersample.api.Repo
import com.whiskey.zukkey.daggersample.di.ShakeHandler
import com.whiskey.zukkey.daggersample.di.module.HandlerModule
import dagger.android.AndroidInjection
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

  @Inject
  lateinit var client: GitHubClient

  @Inject
  lateinit var shakeHandler: ShakeHandler

  override fun onCreate(savedInstanceState: Bundle?) {
    AndroidInjection.inject(this)
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    val id = findViewById<TextView>(R.id.github_id)
    val name = findViewById<TextView>(R.id.github_name)
    client.getRepos("Set Your GitHub Account").enqueue(object : Callback<List<Repo>> {
      override fun onFailure(call: Call<List<Repo>>?, t: Throwable?) {
        Log.e("API Error", t?.message)
      }

      override fun onResponse(call: Call<List<Repo>>?, response: Response<List<Repo>>?) {
        val first = response?.body()?.first() ?: return
        id.text = first.id.toString()
        name.text = first.name
      }

    })
    shakeHandler.onCreate()
  }

  override fun onDestroy() {
    super.onDestroy()
    shakeHandler.onDestroy()
  }
}
