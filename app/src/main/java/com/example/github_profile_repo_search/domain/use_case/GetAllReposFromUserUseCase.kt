package com.example.github_profile_repo_search.domain.use_case

import com.example.github_profile_repo_search.data.dto.toRepo
import com.example.github_profile_repo_search.domain.model.Repo
import com.example.github_profile_repo_search.domain.repository.RepoRepository
import com.example.github_profile_repo_search.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetAllReposFromUserUseCase @Inject constructor(
    private val repository: RepoRepository
) {

    operator fun invoke(username: String, pageNumber: Int): Flow<Resource<List<Repo>>> = flow {
        try {
            emit(Resource.Loading<List<Repo>>())
            val repos = repository.getAllUserRepos(username, pageNumber).map { it.toRepo() }
            emit(Resource.Success<List<Repo>>(repos))
        } catch (e: HttpException) {
            emit(Resource.Error<List<Repo>>(
                    e.localizedMessage ?: "An unexpected error has occurred"
                )
            )
        } catch (e: IOException) {
            emit(Resource.Error<List<Repo>>("Couldn't reach the server"))
        }
    }
}