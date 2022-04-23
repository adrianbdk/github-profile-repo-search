package com.example.github_profile_repo_search.di

import com.example.github_profile_repo_search.api.GitHubAPI
import com.example.github_profile_repo_search.data.repository.RepoRepositoryImplementation
import com.example.github_profile_repo_search.data.repository.UsersRepositoryImplementation
import com.example.github_profile_repo_search.domain.repository.RepoRepository
import com.example.github_profile_repo_search.domain.repository.UsersRepository
import com.example.github_profile_repo_search.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    @Named("GitHubAPI")
    fun provideGitHubAPI(): GitHubAPI {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GitHubAPI::class.java)
    }
    @Provides
    @Singleton
    @Named("RepoRepository")
    fun provideRepoRepository(api: GitHubAPI): RepoRepository{
        return RepoRepositoryImplementation(api);
    }

    @Provides
    @Singleton
    @Named("UsersRepository")
    fun provideUsersRepository(api: GitHubAPI): UsersRepository {
        return UsersRepositoryImplementation(api);
    }

}