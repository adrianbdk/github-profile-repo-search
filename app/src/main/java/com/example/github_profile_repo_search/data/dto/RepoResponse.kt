package com.example.github_profile_repo_search.data.dto

data class RepoResponse(
    val repos: List<RepoDto>,
    val status: String,
    val totalResults: Int
)