package com.example.test_nhl_project.data.models.myModels


data class MyTeamModel(
    val id: Int,
    val name: String,
    val location: String,
    val isOpen: Boolean = true
)