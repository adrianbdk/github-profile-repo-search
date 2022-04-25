package com.example.github_profile_repo_search.data.dto

data class LanguagesDto(
    val languages: List<Language>
){
    data class Language(
        val programmingLanguage : String,
        val bytes : Int,
            )
}