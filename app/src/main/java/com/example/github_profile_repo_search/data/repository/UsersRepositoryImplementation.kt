package com.example.github_profile_repo_search.data.repository

import com.example.github_profile_repo_search.api.GitHubAPI
import com.example.github_profile_repo_search.data.dto.UserDto
import com.example.github_profile_repo_search.domain.repository.UsersRepository
import javax.inject.Inject
import javax.inject.Named

class UsersRepositoryImplementation @Inject constructor(
    @Named("GitHubAPI") private val api: GitHubAPI
) : UsersRepository {

    override suspend fun searchForUsers(username: String, pageNumber: Int): List<UserDto> {
        return api.searchForUsers(username, pageNumber)
    }

}