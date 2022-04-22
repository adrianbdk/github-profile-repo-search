package com.example.github_profile_repo_search.domain.repository

import com.example.github_profile_repo_search.api.RetrofitInstance

class UsersRepository {
    suspend fun getAllUsers(pageNumber: Int) =
        RetrofitInstance.api.getUsers(pageNumber)

    suspend fun searchUsers(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchForUsers(searchQuery, pageNumber)
}