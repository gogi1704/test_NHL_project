package com.example.test_nhl_project.ui.fragments

import android.icu.text.SimpleDateFormat
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.test_nhl_project.R
import com.example.test_nhl_project.app.NhlApp.Companion.BUNDLE_ID
import com.example.test_nhl_project.app.NhlApp.Companion.BUNDLE_LOCATION
import com.example.test_nhl_project.app.NhlApp.Companion.BUNDLE_NAME
import com.example.test_nhl_project.databinding.FragmentTeamInfoBinding
import com.example.test_nhl_project.ui.adapter.gameAdapter.MyGameAdapter
import com.example.test_nhl_project.ui.adapter.rosterAdapter.MyRosterAdapter
import com.example.test_nhl_project.viewModels.TeamsViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.Date


@AndroidEntryPoint
class TeamInfoFragment : Fragment() {

    private lateinit var binding: FragmentTeamInfoBinding
    private val teamsViewModel: TeamsViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTeamInfoBinding.inflate(layoutInflater, container, false)
        val adapterRoster = MyRosterAdapter()
        val adapterGame = MyGameAdapter()
        val id = arguments?.getInt(BUNDLE_ID)
        val startDate =
            SimpleDateFormat("yyyy-MM-dd").format(Date(System.currentTimeMillis() - 2628000000L * 12))
        val endDate = SimpleDateFormat("yyyy-MM-dd").format(Date(System.currentTimeMillis()))



        if (id != null) {
            teamsViewModel.getTeamsRoster(id)
            binding.textTeamName.text = arguments?.getString(BUNDLE_NAME)
            binding.textTeamLocation.text = arguments?.getString(BUNDLE_LOCATION)
        }


        with(binding) {
            recyclerRoster.adapter = adapterRoster
            recyclerGames.adapter = adapterGame
            toggleButton.addOnButtonCheckedListener { toggleButton, checkedId, isChecked ->
                when (checkedId) {
                    R.id.button_history -> {
                        toggleButton.uncheck(R.id.button_roster)
                        recyclerRoster.visibility = View.GONE
                        recyclerGames.visibility = View.VISIBLE
                    }

                    R.id.button_roster -> {
                        toggleButton.uncheck(R.id.button_history)
                        recyclerRoster.visibility = View.VISIBLE
                        recyclerGames.visibility = View.GONE
                    }
                }

            }

            toggleButton.check(R.id.button_history)

            teamsViewModel.getGamesLastMonth(id!!, startDate, endDate)
        }

        teamsViewModel.rosterLiveData.observe(viewLifecycleOwner) {
            adapterRoster.submitList(it)
        }

        teamsViewModel.gamesLiveData.observe(viewLifecycleOwner) {
            binding.progress.visibility = if (it.isLoading) View.VISIBLE else View.GONE
            adapterGame.submitList(it.games)
        }





        return binding.root
    }


}