package com.example.test_nhl_project.data.models.modelsFromServer.gameModels

data class GameDate(
    val date:String,
    val totalItems:Int,
    val totalEvents:Int,
    val totalGames:Int,
    val totalMatches:Int,
    val games :List<Game>
)


