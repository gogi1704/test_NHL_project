package com.example.test_nhl_project.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.test_nhl_project.R
import com.example.test_nhl_project.app.NhlApp.Companion.BUNDLE_ID
import com.example.test_nhl_project.databinding.FragmentMainBinding
import com.example.test_nhl_project.ui.adapter.AdapterClickListener
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
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)


        val adapter = TeamsAdapter(object : AdapterClickListener {

            override fun clickMore(id: Int) {
                findNavController().navigate(
                    R.id.action_mainFragment_to_teamInfoFragment,
                    Bundle().apply { putInt(BUNDLE_ID, id) })
            }

        })


        with(binding) {
            teamsRecycler.adapter = adapter
        }

        viewModel.liveData.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }


        return binding.root
    }

}