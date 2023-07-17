package com.example.test_nhl_project.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.test_nhl_project.app.NhlApp.Companion.BUNDLE_ID
import com.example.test_nhl_project.databinding.FragmentTeamInfoBinding
import com.example.test_nhl_project.ui.adapter.rosterAdapter.MyRosterAdapter
import com.example.test_nhl_project.viewModels.TeamsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TeamInfoFragment : Fragment() {

    private lateinit var binding: FragmentTeamInfoBinding
    private val viewModel: TeamsViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTeamInfoBinding.inflate(layoutInflater, container, false)
        val adapter = MyRosterAdapter()
        val id = arguments?.getInt(BUNDLE_ID)
        if (id != null) {
            viewModel.getTeamsRoster(id)
        }


        with(binding) {
            recyclerAdapter.adapter = adapter
        }



        viewModel.rosterLiveData.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        return binding.root
    }


}