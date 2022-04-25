package com.example.github_profile_repo_search.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.github_profile_repo_search.R
import com.example.github_profile_repo_search.databinding.RepositoryDetailsBinding
import com.example.github_profile_repo_search.databinding.SearchFragmentBinding
import com.example.github_profile_repo_search.domain.model.Repo
import com.example.github_profile_repo_search.ui.adapters.RepoListAdapter
import com.example.github_profile_repo_search.ui.util.RepoListState
import com.example.github_profile_repo_search.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.concurrent.ConcurrentHashMap

@AndroidEntryPoint
class RepoDetailsFragment : Fragment(R.layout.repository_details) {
    private val viewModel by activityViewModels<MainViewModel>()
    private lateinit var repoListAdapter: RepoListAdapter
    private lateinit var binding: RepositoryDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = RepositoryDetailsBinding.inflate(
            inflater, container, false
        )

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val selectedRepoObserver = Observer<Repo> { repo ->
            binding.tvTitle.text = repo.name
            binding.tvOwner.text = repo.owner
            binding.tvCreatedAt.text = repo.created_at
        }

        viewModel.selectedRepo.observe(viewLifecycleOwner, selectedRepoObserver)

        val languagesObserver = Observer<ConcurrentHashMap<String, Int>> { languages ->
            viewModel.selectRepoLanguages(languages)
        }

        viewModel.selectedRepoLanguages.observe(viewLifecycleOwner, languagesObserver)

    }

}