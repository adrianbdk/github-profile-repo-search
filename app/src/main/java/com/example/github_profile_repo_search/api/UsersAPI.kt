package com.example.github_profile_repo_search.api

import com.example.github_profile_repo_search.data.dto.UsersResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface UsersAPI {
    @GET("users")
    suspend fun getUsers(
        @Query("page")
        pageNumber: Int = 1,
    ): Response<UsersResponse>

    @GET("users/{username}")
    suspend fun searchForUsers(
        @Query("username")
        searchQuery: String,
        @Query("page")
        pageNumber: Int = 1,
    ): Response<UsersResponse>
}