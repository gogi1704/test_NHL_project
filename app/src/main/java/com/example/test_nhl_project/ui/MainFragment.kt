package com.example.test_nhl_project.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.test_nhl_project.databinding.FragmentMainBinding
import com.example.test_nhl_project.ui.adapter.TeamsAdapter
import com.example.test_nhl_project.viewModels.TeamsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private val viewModel: TeamsViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val adapter = TeamsAdapter()
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)

        with(binding) {
            teamsRecycler.adapter = adapter
        }

        viewModel.liveData.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }


        return binding.root
    }

}