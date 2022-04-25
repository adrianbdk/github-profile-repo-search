package com.example.github_profile_repo_search.ui.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.github_profile_repo_search.R
import com.example.github_profile_repo_search.databinding.RepositoryItemBinding
import com.example.github_profile_repo_search.domain.model.Repo

class RepoItemViewHolder(
    private val binding: RepositoryItemBinding,
    private val onClick: (Repo) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    private var currentRepo: Repo? = null

    init {
        binding.repoItem.setOnClickListener {
            currentRepo?.let {
                onClick(it)
            }
        }
    }

    fun bind(repo: Repo) {
        binding.repoName.text = repo.name
        currentRepo = repo
    }
}