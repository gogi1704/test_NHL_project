package com.example.test_nhl_project.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.test_nhl_project.data.repository.TeamsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TeamsViewModel @Inject constructor(
    application: Application,
    private val repository: TeamsRepository
) : AndroidViewModel(application) {

    fun getAllTeams(){
        viewModelScope.launch {
            repository.getAllTeams()
        }
    }

}