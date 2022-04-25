package com.example.github_profile_repo_search.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.github_profile_repo_search.domain.model.Repo
import com.example.github_profile_repo_search.domain.use_case.GetAllReposFromUserUseCase
import com.example.github_profile_repo_search.domain.use_case.GetLanguagesDataRepoUseCase
import com.example.github_profile_repo_search.ui.util.RepoLanguagesState
import com.example.github_profile_repo_search.ui.util.RepoListState
import com.example.github_profile_repo_search.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.util.concurrent.ConcurrentHashMap
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getAllReposFromUserUseCase: GetAllReposFromUserUseCase,
    private val getLanguagesDataRepoUseCase: GetLanguagesDataRepoUseCase
) : ViewModel() {

    private val _stateRepo = MutableLiveData(RepoListState())
    private val _stateLanguageRepo = MutableLiveData(RepoLanguagesState())
    private var _selectedRepo = MutableLiveData(Repo())

    val stateRepo: LiveData<RepoListState> = _stateRepo
    val stateLanguageRepo: LiveData<RepoLanguagesState> = _stateLanguageRepo
    val selectedRepo: LiveData<Repo> = _selectedRepo

    fun selectRepo(repo: Repo) {
        _selectedRepo.postValue(repo)
    }

    fun getAllUserRepos(username: String, perPage: Int) {
        getAllReposFromUserUseCase(username, perPage).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _stateRepo.value = RepoListState(reposList = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _stateRepo.value = RepoListState(
                        error = result.uiText ?: "An unexpected error occurred"
                    )
                }
                is Resource.Loading -> {
                    _stateRepo.value = RepoListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun getLanguagesDataRepo(username: String, repo: String) {
        getLanguagesDataRepoUseCase(username, repo).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _stateLanguageRepo.value = RepoLanguagesState(
                        languageList = result.data
                            ?: emptyMap<String, Int>() as ConcurrentHashMap<String, Int>
                    )
                }
                is Resource.Error -> {
                    _stateLanguageRepo.value = RepoLanguagesState(
                        error = result.uiText ?: "An unexpected error occurred"
                    )
                }
                is Resource.Loading -> {
                    _stateLanguageRepo.value = RepoLanguagesState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}