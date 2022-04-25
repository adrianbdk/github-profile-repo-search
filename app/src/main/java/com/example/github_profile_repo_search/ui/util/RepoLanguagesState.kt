package com.example.github_profile_repo_search.ui.util
import java.util.concurrent.ConcurrentHashMap

data class RepoLanguagesState(
    val isLoading: Boolean = false,
    val languageList: ConcurrentHashMap<String, Int> = ConcurrentHashMap(),
    val error: String = ""
)