package com.example.github_profile_repo_search.domain.repository

import com.example.github_profile_repo_search.data.dto.UserDto

interface UsersRepository {
    suspend fun searchForUsers(username: String, pageNumber: Int): List<UserDto>
}