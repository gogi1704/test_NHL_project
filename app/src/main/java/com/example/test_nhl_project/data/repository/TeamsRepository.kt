package com.example.test_nhl_project.data.repository

import com.example.test_nhl_project.data.models.modelsFromServer.peopleModels.RosterModel
import com.example.test_nhl_project.data.models.myModels.myModelsWithState.MyGameModelWIthState
import com.example.test_nhl_project.data.models.myModels.myModelsWithState.MyTeamModelWithState

interface TeamsRepository {
    suspend fun getAllTeams(): MyTeamModelWithState
    suspend fun getTeamRoster(id: Int): List<RosterModel>

    suspend fun getGamesLastMonth(
        id: Int,
        startDate: String,
        endDate: String,
    ): MyGameModelWIthState

}