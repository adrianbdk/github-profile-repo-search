package com.example.github_profile_repo_search.api

import com.example.github_profile_repo_search.data.dto.RepoDto
import com.example.github_profile_repo_search.data.dto.UserDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GitHubAPI {

    @GET("search/users")
    suspend fun searchForUsers(
        @Query("q")
        searchQuery: String,
        @Query("page")
        pageNumber: Int = 1,
    ): List<UserDto>

    @GET("users/{username}/repos")
    suspend fun getAllUserRepos(
        @Path("username") username: String,
        @Query("per_page") perPage: Int
    ): List<RepoDto>
}