package com.example.github_profile_repo_search.ui.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.github_profile_repo_search.R
import com.example.github_profile_repo_search.databinding.RepositoryItemBinding
import com.example.github_profile_repo_search.domain.model.Repo

class RepoItemViewHolder(view: View, val onClick: (Repo) -> Unit) : RecyclerView.ViewHolder(view) {
    val repoName: TextView
    private var currentRepo: Repo? = null
    init {
        repoName = view.findViewById(R.id.repoName)
        view.setOnClickListener {
            currentRepo?.let {
                    onClick(it)
            }
        }
    }

    fun bind(repo: Repo) {
        repoName.text = repo.name
        currentRepo = repo
    }
}