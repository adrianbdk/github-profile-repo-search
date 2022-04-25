package com.example.github_profile_repo_search.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.github_profile_repo_search.MainActivity
import com.example.github_profile_repo_search.R
import com.example.github_profile_repo_search.databinding.SearchFragmentBinding
import com.example.github_profile_repo_search.domain.model.Repo
import com.example.github_profile_repo_search.ui.adapters.RepoListAdapter
import com.example.github_profile_repo_search.ui.util.RepoListState
import com.example.github_profile_repo_search.ui.viewmodel.MainViewModel
import com.example.github_profile_repo_search.util.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SearchFragment : Fragment(R.layout.search_fragment) {
    private val viewModel by activityViewModels<MainViewModel>()
    private lateinit var repoListAdapter: RepoListAdapter
    private lateinit var binding: SearchFragmentBinding
    val TAG = "SearchNewsFragment"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SearchFragmentBinding.inflate(
            inflater, container, false)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val button: Button = requireView().findViewById(R.id.Button)
        val editText: EditText = requireView().findViewById(R.id.inputEditText)
        val recyclerView: RecyclerView = requireView().findViewById(R.id.rvRepoList)

        val reposObserver = Observer<RepoListState> { repos ->

            val linearLayoutManager = LinearLayoutManager(context)
            val repoListAdapter = RepoListAdapter(repos.reposList) { repo ->
                viewModel.selectRepo(repo)
                this.findNavController().navigate(R.id.action_searchFragment_to_repoDetailsFragment)
            }
            recyclerView.apply{
                layoutManager = linearLayoutManager
                adapter = repoListAdapter
            }
        }

        viewModel.stateRepo.observe(viewLifecycleOwner, reposObserver)

        binding.Button.setOnClickListener {
            viewModel.getAllUserRepos(editText.text.toString(), 100)
        }
    }

}