package com.whiskey.zukkey.daggersample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.whiskey.zukkey.daggersample.api.GitHubClient
import com.whiskey.zukkey.daggersample.api.Repo
import com.whiskey.zukkey.daggersample.di.AppComponent
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

  @Inject
  lateinit var client: GitHubClient

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    (application as SampleApp).component.inject(this)
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
  }
}
