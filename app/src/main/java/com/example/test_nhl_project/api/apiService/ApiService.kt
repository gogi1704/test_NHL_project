package com.example.test_nhl_project.api.apiService

import com.example.test_nhl_project.data.models.modelsFromServer.gameModels.GameModel
import com.example.test_nhl_project.data.models.modelsFromServer.teamModels.TeamModel
import com.example.test_nhl_project.data.models.myModels.MyRosterModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("teams")
    suspend fun getAllTeams(): Response<TeamModel>

    @GET("teams/{id}/roster")
    suspend fun getTeamRoster(@Path("id") id: Int): Response<MyRosterModel>

    @GET("schedule?")
    suspend fun getGamesLastMonth(
        @Query("teamId") id: Int,
        @Query("startDate") startDate: String,
        @Query("endDate") endDate: String,

    ): Response<GameModel>
}