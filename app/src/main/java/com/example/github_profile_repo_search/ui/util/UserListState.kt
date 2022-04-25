package com.example.github_profile_repo_search.ui.util

import com.example.github_profile_repo_search.domain.model.User

data class UserListState(
        val isLoading: Boolean = false,
        val usersList: List<User> = emptyList(),
        val error: String = ""
)
