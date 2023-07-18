package com.example.test_nhl_project.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.test_nhl_project.R
import com.example.test_nhl_project.app.NhlApp.Companion.BUNDLE_ID
import com.example.test_nhl_project.app.NhlApp.Companion.BUNDLE_LOCATION
import com.example.test_nhl_project.app.NhlApp.Companion.BUNDLE_NAME
import com.example.test_nhl_project.databinding.FragmentMainBinding
import com.example.test_nhl_project.ui.adapter.teamsAdapter.AdapterClickListener
import com.example.test_nhl_project.ui.adapter.teamsAdapter.TeamsAdapter
import com.example.test_nhl_project.viewModels.MoneyViewModel
import com.example.test_nhl_project.viewModels.TeamsViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private val teamsViewModel: TeamsViewModel by viewModels()
    private val moneyViewModel: MoneyViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)


        val adapter = TeamsAdapter(object : AdapterClickListener {

            override fun clickMore(id: Int, name: String, location: String, isOpen: Boolean) {
                if (isOpen) {
                    findNavController().navigate(
                        R.id.action_mainFragment_to_teamInfoFragment,
                        Bundle().apply {
                            putInt(BUNDLE_ID, id)
                            putString(BUNDLE_NAME, name)
                            putString(BUNDLE_LOCATION, location)
                        })
                } else {
                    val snack = Snackbar.make(
                        binding.root,
                        "Item is closed. Price = 25$ . By ?",
                        Snackbar.LENGTH_LONG
                    )
                    snack.animationMode = Snackbar.ANIMATION_MODE_SLIDE
                    snack.setAction("By") {
                        if (moneyViewModel.myMoney >= 25) {
                            moneyViewModel.buyItem()
                            teamsViewModel.buyItem(id)
                            Toast.makeText(requireContext(), "Ok", Toast.LENGTH_SHORT).show()
                        } else {
                            val lowMoneySnack = Snackbar.make(
                                binding.root,
                                "Insufficient funds",
                                Snackbar.LENGTH_LONG
                            )
                            lowMoneySnack.setAction("Go to earn ! ") {
                                findNavController().navigate(R.id.moneyFragment)
                            }
                                .animationMode = Snackbar.ANIMATION_MODE_SLIDE

                            lowMoneySnack.show()

                        }

                    }
                    snack.show()
                }

            }

        })


        with(binding) {
            teamsRecycler.adapter = adapter
        }

        teamsViewModel.teamsLiveData.observe(viewLifecycleOwner) {
            binding.progress.visibility = if (it.isLoading) View.VISIBLE else View.GONE
            adapter.submitList(it.teams)
        }

        moneyViewModel.myMoneyLiveData.observe(viewLifecycleOwner) {
            binding.myMoney.text = it.toString()
        }


        return binding.root
    }

}