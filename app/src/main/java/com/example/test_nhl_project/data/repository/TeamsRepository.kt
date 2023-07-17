package com.example.test_nhl_project.data.repository

import com.example.test_nhl_project.data.models.modelsFromServer.peopleModels.RosterModel
import com.example.test_nhl_project.data.models.myModels.MyTeamModel

interface TeamsRepository {
    suspend fun getAllTeams():List<MyTeamModel>
    suspend fun getTeamRoster(id:Int):List<RosterModel>
}