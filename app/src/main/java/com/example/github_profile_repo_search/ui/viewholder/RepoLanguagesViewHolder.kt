package com.example.github_profile_repo_search.ui.viewholder

import android.content.res.Resources
import androidx.recyclerview.widget.RecyclerView
import com.example.github_profile_repo_search.R
import com.example.github_profile_repo_search.databinding.LanguageItemBinding
import com.example.github_profile_repo_search.domain.model.RepoLanguage

class RepoLanguagesViewHolder(private val binding: LanguageItemBinding) : RecyclerView.ViewHolder(binding.root) {

    private val resources: Resources = binding.root.resources

    fun bind(languages: RepoLanguage) {
        binding.language.text = languages.language
        binding.bytes.text = resources.getString(R.string.bytes, languages.bytes.toString())
    }
}