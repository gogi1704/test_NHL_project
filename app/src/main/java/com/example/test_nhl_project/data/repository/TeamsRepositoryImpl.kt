package com.example.test_nhl_project.data.repository

import com.example.test_nhl_project.api.apiService.ApiService
import com.example.test_nhl_project.data.models.modelsFromServer.peopleModels.RosterModel
import com.example.test_nhl_project.data.models.myModels.MyGameModel
import com.example.test_nhl_project.data.models.myModels.MyTeamModel
import com.example.test_nhl_project.data.models.myModels.myModelsWithState.MyGameModelWIthState
import com.example.test_nhl_project.data.models.myModels.myModelsWithState.MyTeamModelWithState
import java.util.Random
import javax.inject.Inject

class TeamsRepositoryImpl @Inject constructor(private val apiService: ApiService) :
    TeamsRepository {


    override suspend fun getAllTeams(): MyTeamModelWithState {
        val response = apiService.getAllTeams()
        if (response.isSuccessful) {
            return MyTeamModelWithState(response.body()?.teams?.map {
                MyTeamModel(
                    it.id,
                    it.name,
                    location = it.locationName,
                    isOpen = Random().nextBoolean()
                )
            } ?: throw Exception() , false)
        } else {
            throw Exception()
        }
    }

    override suspend fun getTeamRoster(id: Int): List<RosterModel> {

        val response = apiService.getTeamRoster(id)
        if (response.isSuccessful) {
            return response.body()?.roster ?: throw Exception()
        } else throw Exception()
    }

    override suspend fun getGamesLastMonth(
        id: Int,
        startDate: String,
        endDate: String
    ): MyGameModelWIthState {
        val response = apiService.getGamesLastMonth(id, startDate, endDate)
        if (response.isSuccessful) {
            return MyGameModelWIthState(response.body()?.dates?.map {
                MyGameModel(
                    date = it.date,
                    nameFirstTeam = it.games[0].teams.away.team.name,
                    nameSecondTeam = it.games[0].teams.home.team.name,
                    scoreFirstTeam = it.games[0].teams.away.score,
                    scoreSecondTeam = it.games[0].teams.home.score,
                )
            }?.reversed() ?: throw Exception(), false)
        } else throw Exception()
    }


}