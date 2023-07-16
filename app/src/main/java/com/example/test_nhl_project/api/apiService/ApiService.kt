package com.example.test_nhl_project.api.apiService

import com.example.test_nhl_project.data.models.modelsFromServer.TeamModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("teams")
    suspend fun getAllTeams(): Response<TeamModel>
}