package com.example.test_nhl_project.data.repository

import com.example.test_nhl_project.api.apiService.ApiService
import com.example.test_nhl_project.data.models.modelsFromServer.peopleModels.RosterModel
import com.example.test_nhl_project.data.models.myModels.MyTeamModel
import java.util.Random
import javax.inject.Inject

class TeamsRepositoryImpl @Inject constructor(private val apiService: ApiService) :
    TeamsRepository {


    override suspend fun getAllTeams(): List<MyTeamModel> {
        val response = apiService.getAllTeams()
        if (response.isSuccessful) {
            return response.body()?.teams?.map {
                MyTeamModel(
                    it.id,
                    it.name,
                    location = it.locationName,
                    isOpen = Random().nextBoolean()
                )
            } ?: throw Exception()
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


}