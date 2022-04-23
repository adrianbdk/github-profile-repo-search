package com.example.github_profile_repo_search.domain.use_case

import com.example.github_profile_repo_search.data.dto.toUser
import com.example.github_profile_repo_search.domain.model.User
import com.example.github_profile_repo_search.domain.repository.UsersRepository
import com.example.github_profile_repo_search.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class SearchForUsersUseCase @Inject constructor(
    private val repository: UsersRepository
) {

    operator fun invoke(username: String, pageNumber: Int): Flow<Resource<out List<User>>> = flow {
        try {
            emit(Resource.Loading<List<User>>())
            val users = repository.searchForUsers(username, pageNumber).map { it.toUser() }
            emit(Resource.Success<List<User>>(users))
        } catch (e: HttpException) {
            emit(
                Resource.Error<List<User>>(
                    e.localizedMessage ?: "An unexpected error has occurred"
                )
            )
        } catch (e: IOException) {
            emit(Resource.Error<List<User>>("Couldn't reach the server"))
        }
    }
}