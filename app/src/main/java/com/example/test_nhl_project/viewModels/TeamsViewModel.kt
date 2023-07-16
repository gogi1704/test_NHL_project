package com.example.test_nhl_project.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
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

    val liveData = MutableLiveData<List<MyTeamModel>>()
    fun getAllTeams() {
        viewModelScope.launch {
            liveData.value = repository.getAllTeams()
        }
    }


    init {
        getAllTeams()
    }

}