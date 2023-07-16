package com.example.test_nhl_project.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.test_nhl_project.data.models.myModels.MyTeamModel

class MyAdapterCallback:DiffUtil.ItemCallback<MyTeamModel>() {
    override fun areItemsTheSame(oldItem: MyTeamModel, newItem: MyTeamModel): Boolean {
        return  oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: MyTeamModel, newItem: MyTeamModel): Boolean {
      return oldItem.id == newItem.id
    }
}