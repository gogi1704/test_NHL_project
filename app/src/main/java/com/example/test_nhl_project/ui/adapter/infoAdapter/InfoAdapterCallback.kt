package com.example.test_nhl_project.ui.adapter.infoAdapter

import androidx.recyclerview.widget.DiffUtil
import com.example.test_nhl_project.data.models.myModels.MyInfoModel

class InfoAdapterCallback:DiffUtil.ItemCallback<MyInfoModel>() {
    override fun areItemsTheSame(oldItem: MyInfoModel, newItem: MyInfoModel): Boolean {
     return   oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: MyInfoModel, newItem: MyInfoModel): Boolean {
        return  oldItem.title == newItem.title
    }
}