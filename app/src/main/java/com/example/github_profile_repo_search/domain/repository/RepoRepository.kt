package com.example.github_profile_repo_search.domain.repository

import com.example.github_profile_repo_search.data.dto.RepoDto

interface RepoRepository {
    suspend fun getAllUserRepos(username: String, pageNumber: Int): List<RepoDto>
}