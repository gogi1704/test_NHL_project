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
                    navController.navigate(R.id.mainFragment)
                    true
                }

                R.id.live -> {
                    navController.navigate(R.id.liveGameFragment)
                    true
                }

                R.id.money -> {
                    navController.navigate(R.id.moneyFragment)
                    true
                }

                R.id.info -> {
                    navController.navigate(R.id.infoFragment)
                    true
                }

                else -> false

            }

        }


    }
}