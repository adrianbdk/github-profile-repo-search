package com.example.github_profile_repo_search.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.github_profile_repo_search.data.dto.UserDto
import com.example.github_profile_repo_search.domain.model.Repo
import com.example.github_profile_repo_search.domain.model.User
import com.example.github_profile_repo_search.domain.repository.RepoRepository
import com.example.github_profile_repo_search.domain.repository.UsersRepository
import com.example.github_profile_repo_search.domain.use_case.GetAllReposFromUserUseCase
import com.example.github_profile_repo_search.domain.use_case.SearchForUsersUseCase
import com.example.github_profile_repo_search.ui.util.RepoListState
import com.example.github_profile_repo_search.ui.util.UserListState
import com.example.github_profile_repo_search.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import java.util.concurrent.ConcurrentHashMap
import javax.inject.Inject
@HiltViewModel
class MainViewModel @Inject constructor(
    private val getAllReposFromUserUseCase: GetAllReposFromUserUseCase
) : ViewModel() {

    private val _stateRepo = MutableLiveData(RepoListState())
    val stateRepo: LiveData<RepoListState> = _stateRepo

    var selectedRepo = MutableLiveData(Repo())
    var selectedRepoLanguages = MutableLiveData(ConcurrentHashMap<String, Int>())

    fun selectRepo(repo: Repo){
        selectedRepo.postValue(repo)
    }
    fun selectRepoLanguages(languages: ConcurrentHashMap<String, Int>){
        selectedRepoLanguages.postValue(languages)
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
}