package com.example.test_nhl_project.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.example.test_nhl_project.R
import com.example.test_nhl_project.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment

        val navController = navHostFragment.navController


        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.teams -> {
                    navController
                    true
                }

                R.id.info -> {
                    true
                }
                else -> false

            }

        }


    }
}