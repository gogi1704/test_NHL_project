package com.example.test_nhl_project.data.repository.di

import com.example.test_nhl_project.data.repository.TeamsRepository
import com.example.test_nhl_project.data.repository.TeamsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
interface RepositoryModule {


    @Singleton
    @Binds
    fun bindTeamsRepository(repositoryImpl: TeamsRepositoryImpl): TeamsRepository

}