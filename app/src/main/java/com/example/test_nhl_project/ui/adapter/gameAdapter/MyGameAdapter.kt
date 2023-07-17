package com.example.test_nhl_project.ui.adapter.gameAdapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.test_nhl_project.data.models.myModels.MyGameModel
import com.example.test_nhl_project.databinding.GameItemLayoutBinding


class MyGameAdapter :
    ListAdapter<MyGameModel, MyGameAdapter.GameAdapterViewHolder>(GameAdapterCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameAdapterViewHolder {
        val binding =
            GameItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GameAdapterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GameAdapterViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    class GameAdapterViewHolder(private val binding: GameItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MyGameModel) {
            with(binding) {
                textNameFirstTeam.text = item.nameFirstTeam
                textNameSecondTeam.text = item.nameSecondTeam
                textScoreFirstTeam.text = item.scoreFirstTeam.toString()
                textScoreSecondTeam.text = item.scoreSecondTeam.toString()
                textDate.text = item.date
                if (item.scoreFirstTeam > item.scoreSecondTeam) {
                    textScoreFirstTeam.setTextColor(Color.GREEN)
                    textScoreSecondTeam.setTextColor(Color.RED)
                } else {
                    textScoreFirstTeam.setTextColor(Color.RED)
                    textScoreSecondTeam.setTextColor(Color.GREEN)
                }
            }
        }
    }
}