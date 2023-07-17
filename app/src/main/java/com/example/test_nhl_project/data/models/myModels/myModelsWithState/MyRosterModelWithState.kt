package com.example.test_nhl_project.data.models.myModels.myModelsWithState

import com.example.test_nhl_project.data.models.modelsFromServer.peopleModels.RosterModel

data class MyRosterModelWithState(
    val roster:List<RosterModel>,
    val isLoading:Boolean = false
)
