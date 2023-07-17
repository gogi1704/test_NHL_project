package com.example.test_nhl_project.data.models.myModels.myModelsWithState

import com.example.test_nhl_project.data.models.myModels.MyTeamModel

data class MyTeamModelWithState(
    val teams: List<MyTeamModel> = emptyList(),
    val isLoading: Boolean = true
)
