package com.example.github_profile_repo_search.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.github_profile_repo_search.R
import com.example.github_profile_repo_search.databinding.LanguageItemBinding
import com.example.github_profile_repo_search.databinding.RepositoryItemBinding
import com.example.github_profile_repo_search.domain.model.Repo
import com.example.github_profile_repo_search.ui.viewholder.RepoItemViewHolder


class RepoListAdapter(
    private val dataSet: List<Repo>,
    private val onClick: (Repo) -> Unit
) : RecyclerView.Adapter<RepoItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoItemViewHolder {
        val binding =
            RepositoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RepoItemViewHolder(binding, onClick)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: RepoItemViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }

}