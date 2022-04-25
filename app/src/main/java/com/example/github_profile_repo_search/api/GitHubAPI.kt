package com.example.github_profile_repo_search.api

import com.example.github_profile_repo_search.data.dto.RepoDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.concurrent.ConcurrentHashMap

interface GitHubAPI {

    @GET("users/{username}/repos")
    suspend fun getAllUserRepos(
        @Path("username") username: String,
        @Query("per_page") perPage: Int
    ): List<RepoDto>

    @GET("repos/{username}/{repo}/languages")
    suspend fun getLanguagesDataRepo(
        @Path("username") username: String,
        @Path("repo") repo: String,
    ): ConcurrentHashMap<String, Int>
}