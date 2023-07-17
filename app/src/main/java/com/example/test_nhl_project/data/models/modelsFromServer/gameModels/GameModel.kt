package com.example.test_nhl_project.data.models.modelsFromServer.gameModels

data class GameModel(
    val copyright:String ,
    val totalItems:Int ,
    val totalEvents:Int ,
    val totalGames:Int ,
    val totalMatches:Int ,
    val metaData: MetaData,
    val dates:List<GameDate>,
    val events:Any,
    val matches:Any

)
