package com.example.github_profile_repo_search.domain.repository

import com.example.github_profile_repo_search.data.dto.RepoDto
import java.util.concurrent.ConcurrentHashMap

interface RepoRepository {
    suspend fun getAllUserRepos(username: String, pageNumber: Int): List<RepoDto>
    suspend fun getLanguagesDataRepo(username: String, repo: String): ConcurrentHashMap<String, Int>

}