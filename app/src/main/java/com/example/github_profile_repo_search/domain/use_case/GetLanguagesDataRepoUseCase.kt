package com.example.github_profile_repo_search.domain.use_case

import com.example.github_profile_repo_search.data.dto.toRepo
import com.example.github_profile_repo_search.domain.model.Repo
import com.example.github_profile_repo_search.domain.repository.RepoRepository
import com.example.github_profile_repo_search.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import java.util.concurrent.ConcurrentHashMap
import javax.inject.Inject

class GetLanguagesDataRepoUseCase @Inject constructor(
    private val repository: RepoRepository
) {

    operator fun invoke(
        username: String,
        repo: String
    ): Flow<Resource<ConcurrentHashMap<String, Int>>> = flow {
        try {
            emit(Resource.Loading<ConcurrentHashMap<String, Int>>())
            val languages = repository.getLanguagesDataRepo(username, repo)
            emit(Resource.Success<ConcurrentHashMap<String, Int>>(languages))
        } catch (e: HttpException) {
            emit(Resource.Error<ConcurrentHashMap<String, Int>>(
                    e.localizedMessage ?: "An unexpected error has occurred"
                )
            )
        } catch (e: IOException) {
            emit(Resource.Error<ConcurrentHashMap<String, Int>>("Couldn't reach the server"))
        }
    }
}