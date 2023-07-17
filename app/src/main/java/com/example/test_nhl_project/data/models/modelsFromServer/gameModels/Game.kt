package com.example.test_nhl_project.data.models.modelsFromServer.gameModels


data class Game(
    val gamePk:Long,
    val link:String,
    val gameType:String,
    val season:String,
    val gameDate:String,
    val status: Status,
    val teams:TeamsProfilesFromThisGame,
    val venue: GameVenue,
    val content: Content

)
