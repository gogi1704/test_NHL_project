package com.example.test_nhl_project.ui.adapter.gameAdapter

import androidx.recyclerview.widget.DiffUtil
import com.example.test_nhl_project.data.models.myModels.MyGameModel

class GameAdapterCallback : DiffUtil.ItemCallback<MyGameModel>() {
    override fun areItemsTheSame(oldItem: MyGameModel, newItem: MyGameModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: MyGameModel, newItem: MyGameModel): Boolean {
        return oldItem.date == newItem.date
    }
}