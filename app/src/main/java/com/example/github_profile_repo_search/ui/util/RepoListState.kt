package com.example.github_profile_repo_search.ui.util

import com.example.github_profile_repo_search.domain.model.Repo

data class RepoListState(
    val isLoading: Boolean = false,
    val reposList: List<Repo> = emptyList(),
    val error: String = ""
)