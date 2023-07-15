package com.example.test_nhl_project.data.repository

interface TeamsRepository {
    suspend fun getAllTeams()
}