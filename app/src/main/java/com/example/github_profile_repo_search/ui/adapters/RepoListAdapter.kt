package com.example.github_profile_repo_search.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.github_profile_repo_search.R
import com.example.github_profile_repo_search.domain.model.Repo
import com.example.github_profile_repo_search.ui.viewholder.RepoItemViewHolder


class RepoListAdapter(
    private val dataSet: List<Repo>,
    private val onClick: (Repo) -> Unit
) : RecyclerView.Adapter<RepoItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.repository_item, parent, false)
        return RepoItemViewHolder(view, onClick)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: RepoItemViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }

}