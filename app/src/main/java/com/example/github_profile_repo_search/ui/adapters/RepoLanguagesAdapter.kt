package com.example.github_profile_repo_search.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.github_profile_repo_search.R
import com.example.github_profile_repo_search.domain.model.Repo
import com.example.github_profile_repo_search.ui.viewholder.RepoItemViewHolder
import com.example.github_profile_repo_search.ui.viewholder.RepoLanguagesViewHolder
import java.util.concurrent.ConcurrentHashMap

class RepoLanguagesAdapter (
    private val dataSet: ConcurrentHashMap<String, Int>
    ) : RecyclerView.Adapter<RepoLanguagesViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoLanguagesViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.language_item, parent, false)
            return RepoLanguagesViewHolder(view)
        }

        override fun getItemCount(): Int {
            return dataSet.size
        }

        override fun onBindViewHolder(holder: RepoLanguagesViewHolder, position: Int) {
            holder.repoName.text = dataSet[position].name
            holder.bind(dataSet[position])
        }

    }