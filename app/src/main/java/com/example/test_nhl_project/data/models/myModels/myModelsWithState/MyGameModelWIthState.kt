package com.example.test_nhl_project.data.models.myModels.myModelsWithState

import com.example.test_nhl_project.data.models.myModels.MyGameModel

data class MyGameModelWIthState(
    val games: List<MyGameModel> = emptyList(),
    val isLoading: Boolean = true
)