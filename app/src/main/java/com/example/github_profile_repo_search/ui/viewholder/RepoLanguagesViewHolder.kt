package com.example.github_profile_repo_search.ui.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.github_profile_repo_search.R
import com.example.github_profile_repo_search.domain.model.Repo
import java.util.concurrent.ConcurrentHashMap

class RepoLanguagesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val language: TextView
    val bytes: TextView

    private var repoLanguages: ConcurrentHashMap<String, Int>? = null

    init {
        language = view.findViewById(R.id.language)
        bytes = view.findViewById(R.id.bytes)
    }

    fun bind(languages: ConcurrentHashMap<String, Int>) {
        language.text = languages.get().toString()
        currentRepo = repo
    }
}