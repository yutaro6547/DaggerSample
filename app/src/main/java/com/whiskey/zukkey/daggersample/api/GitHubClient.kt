package com.whiskey.zukkey.daggersample.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import javax.inject.Inject


class GitHubClient @Inject constructor(private val service: GitHubService) {

  fun getRepos(userName: String) : Call<List<Repo>> {
    return service.listRepos(userName)
  }

  interface GitHubService {
    @GET("users/{user}/repos")
    fun listRepos(@Path("user") user: String): Call<List<Repo>>
  }
}
