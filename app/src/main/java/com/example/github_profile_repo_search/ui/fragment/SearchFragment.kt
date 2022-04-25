package com.example.github_profile_repo_search.ui.fragment

import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.View.*
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.github_profile_repo_search.R
import com.example.github_profile_repo_search.databinding.SearchFragmentBinding
import com.example.github_profile_repo_search.ui.adapters.RepoListAdapter
import com.example.github_profile_repo_search.ui.util.RepoListState
import com.example.github_profile_repo_search.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SearchFragment : Fragment(R.layout.search_fragment) {

    private val viewModel by activityViewModels<MainViewModel>()
    private lateinit var binding: SearchFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SearchFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val reposObserver = Observer<RepoListState> { repos ->
            val linearLayoutManager = LinearLayoutManager(context)

            binding.progressIndicator.visibility = if (repos.isLoading) VISIBLE else GONE

            val repoListAdapter = RepoListAdapter(repos.reposList) { repo ->
                viewModel.selectRepo(repo)
                this.findNavController().navigate(R.id.action_searchFragment_to_repoDetailsFragment)
            }

            binding.rvRepoList.apply {
                layoutManager = linearLayoutManager
                adapter = repoListAdapter
            }
        }

        viewModel.stateRepo.observe(viewLifecycleOwner, reposObserver)

        binding.Button.setOnClickListener {
            viewModel.getAllUserRepos(binding.inputEditText.text.toString(), PER_PAGE)
        }
    }

    companion object {
        private const val PER_PAGE = 100
    }
}