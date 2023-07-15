package com.example.test_nhl_project.data.repository

import com.example.test_nhl_project.api.apiService.ApiService
import javax.inject.Inject

class TeamsRepositoryImpl @Inject constructor(private val apiService: ApiService) :
    TeamsRepository {


    override suspend fun getAllTeams() {
        val response = apiService.getAllTeams()
        if (response.isSuccessful){
            response.body()
        } else{
            throw Exception()
        }
    }
}