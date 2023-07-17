package com.example.test_nhl_project.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.test_nhl_project.data.models.modelsFromServer.peopleModels.RosterModel
import com.example.test_nhl_project.data.models.myModels.MyGameModel
import com.example.test_nhl_project.data.models.myModels.MyTeamModel
import com.example.test_nhl_project.data.repository.TeamsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TeamsViewModel @Inject constructor(
    application: Application,
    private val repository: TeamsRepository
) : AndroidViewModel(application) {

    val teamsLiveData = MutableLiveData<List<MyTeamModel>>()
    val rosterLiveData = MutableLiveData<List<RosterModel>>()
    val gamesLiveData = MutableLiveData<List<MyGameModel>>()
    fun getAllTeams() {
        viewModelScope.launch {
            teamsLiveData.value = repository.getAllTeams()
        }
    }

    fun getTeamsRoster(id: Int) {
        viewModelScope.launch {
            rosterLiveData.value = repository.getTeamRoster(id)
        }
    }

    fun getGamesLastMonth(id: Int, startDate: String, endDate: String) {
        viewModelScope.launch {
            gamesLiveData.value = repository.getGamesLastMonth(id, startDate, endDate)
        }
    }


    init {
        getGamesLastMonth(12, "2018-01-02", "2019-01-02")
        getAllTeams()
    }

}