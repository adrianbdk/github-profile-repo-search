package com.example.github_profile_repo_search.ui.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.github_profile_repo_search.databinding.LanguageItemBinding

class RepoLanguagesViewHolder(private val binding: LanguageItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(languages: Pair<String, Int>) {
        binding.language.text = languages.first
        binding.bytes.text = languages.second.toString() + " bytes"
    }
}