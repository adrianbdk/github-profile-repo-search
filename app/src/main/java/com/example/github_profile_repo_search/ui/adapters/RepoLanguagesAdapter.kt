package com.example.github_profile_repo_search.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.github_profile_repo_search.databinding.LanguageItemBinding
import com.example.github_profile_repo_search.domain.model.RepoLanguage
import com.example.github_profile_repo_search.ui.viewholder.RepoLanguagesViewHolder
import java.util.concurrent.ConcurrentHashMap

class RepoLanguagesAdapter(
    private val dataSet: ConcurrentHashMap<String, Int>,
) : RecyclerView.Adapter<RepoLanguagesViewHolder>() {

    private lateinit var dataSetArray: ArrayList<RepoLanguage>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoLanguagesViewHolder {
        val itemBinding =
            LanguageItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        dataSetArray = dataSet.convertToArrayList()
        return RepoLanguagesViewHolder(itemBinding)
    }

    override fun getItemCount() = dataSet.size

    override fun onBindViewHolder(holder: RepoLanguagesViewHolder, position: Int) =
        holder.bind(dataSetArray[position])

    private fun ConcurrentHashMap<String, Int>.convertToArrayList(): ArrayList<RepoLanguage> {
        val languageEntries: ArrayList<RepoLanguage> = arrayListOf()
        for (entry in this.entries.iterator()) {
            languageEntries.add(RepoLanguage(entry.key, entry.value))
        }
        return languageEntries
    }
}