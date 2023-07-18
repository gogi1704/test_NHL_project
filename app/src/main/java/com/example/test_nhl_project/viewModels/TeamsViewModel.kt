package com.example.test_nhl_project.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.test_nhl_project.data.models.modelsFromServer.peopleModels.RosterModel
import com.example.test_nhl_project.data.models.myModels.myModelsWithState.MyGameModelWIthState
import com.example.test_nhl_project.data.models.myModels.myModelsWithState.MyTeamModelWithState
import com.example.test_nhl_project.data.repository.TeamsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TeamsViewModel @Inject constructor(
    application: Application,
    private val repository: TeamsRepository
) : AndroidViewModel(application) {
    private val defaultGame = MyGameModelWIthState()
    private val defaultTeamModel = MyTeamModelWithState()


    val teamsLiveData = MutableLiveData<MyTeamModelWithState>()
    val rosterLiveData = MutableLiveData<List<RosterModel>>()


    val gamesLiveData = MutableLiveData<MyGameModelWIthState>()
    fun getAllTeams() {
        viewModelScope.launch {
            teamsLiveData.value = defaultTeamModel
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
            gamesLiveData.value = defaultGame
            gamesLiveData.value = repository.getGamesLastMonth(id, startDate, endDate)
        }
    }

    fun buyItem(id: Int) {
        teamsLiveData.value = teamsLiveData.value?.copy(teams = teamsLiveData.value!!.teams.map {
            if (it.id == id) {
                it.copy(isOpen = true)
            } else it
        })
    }


    init {
        getAllTeams()
    }

}