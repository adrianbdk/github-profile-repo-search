package com.example.github_profile_repo_search.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.github_profile_repo_search.R
import com.example.github_profile_repo_search.databinding.RepositoryDetailsBinding
import com.example.github_profile_repo_search.domain.model.Repo
import com.example.github_profile_repo_search.ui.adapters.RepoLanguagesAdapter
import com.example.github_profile_repo_search.ui.adapters.RepoListAdapter
import com.example.github_profile_repo_search.ui.util.RepoLanguagesState
import com.example.github_profile_repo_search.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import java.util.concurrent.ConcurrentHashMap

@AndroidEntryPoint
class RepoDetailsFragment : Fragment(R.layout.repository_details) {

    private val viewModel by activityViewModels<MainViewModel>()
    private lateinit var binding: RepositoryDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = RepositoryDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val selectedRepoObserver = Observer<Repo> { repo ->
            binding.tvTitle.text = repo.name
            binding.tvOwner.text = repo.owner
            binding.tvCreatedAt.text = repo.created_at.toDate()

            viewModel.getLanguagesDataRepo(repo.owner, repo.name)
        }

        val languagesObserver = Observer<RepoLanguagesState> { languages ->

            val linearLayoutManager = LinearLayoutManager(context)
            val repoLanguagesAdapter = RepoLanguagesAdapter(languages.languageList)

            binding.rvRepoLanguages.apply {
                layoutManager = linearLayoutManager
                adapter = repoLanguagesAdapter
            }
        }

        viewModel.stateLanguageRepo.observe(viewLifecycleOwner, languagesObserver)
        viewModel.selectedRepo.observe(viewLifecycleOwner, selectedRepoObserver)
    }

    private fun String.toDate(): String = ZonedDateTime
        .parse(this)
        .withZoneSameInstant(ZoneId.of("UTC"))
        .format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
}