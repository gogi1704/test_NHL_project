package com.example.test_nhl_project.data.repository

import com.example.test_nhl_project.data.models.myModels.MyRosterModel
import com.example.test_nhl_project.data.models.myModels.MyTeamModel

interface TeamsRepository {
    suspend fun getAllTeams():List<MyTeamModel>
    suspend fun getTeamRoster(id:Int):MyRosterModel
}