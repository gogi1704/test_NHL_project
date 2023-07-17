package com.example.test_nhl_project.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class NhlApp : Application() {

    companion object {
        const val BUNDLE_ID = "ID"
        const val BUNDLE_NAME = "NAME"
        const val BUNDLE_LOCATION = "LOCATION"
    }
}