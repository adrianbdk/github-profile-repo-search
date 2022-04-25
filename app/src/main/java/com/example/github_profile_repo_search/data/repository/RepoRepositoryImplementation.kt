package com.example.github_profile_repo_search.data.repository

import com.example.github_profile_repo_search.api.GitHubAPI
import com.example.github_profile_repo_search.data.dto.RepoDto
import com.example.github_profile_repo_search.domain.repository.RepoRepository
import java.util.concurrent.ConcurrentHashMap
import javax.inject.Inject
import javax.inject.Named

class RepoRepositoryImplementation @Inject constructor(
    @Named("GitHubAPI") private val api: GitHubAPI
) : RepoRepository {
    override suspend fun getAllUserRepos(username: String, pageNumber: Int): List<RepoDto> {
        return api.getAllUserRepos(username, pageNumber)
    }

    override suspend fun getLanguagesDataRepo(
        username: String,
        repo: String
    ): ConcurrentHashMap<String, Int> {
        return api.getLanguagesDataRepo(username, repo)
    }
}