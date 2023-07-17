package com.example.test_nhl_project.data.models.modelsFromServer.gameModels

data class Status(
    val abstractGameState:String,
    val codedGameState:String,
    val detailedState:String,
    val statusCode:String,
    val startTimeTBD:Boolean
)
