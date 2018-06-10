package com.hariofspades.randomusers.feature.userlist

import android.support.v7.util.DiffUtil
import com.hariofspades.domain.features.userlist.model.ResultsItem

class UserListDiffCallback : DiffUtil.ItemCallback<ResultsItem>() {

    override fun areItemsTheSame(oldItem: ResultsItem?, newItem: ResultsItem?): Boolean {
        return oldItem?.firstName == newItem?.firstName
    }

    override fun areContentsTheSame(oldItem: ResultsItem?, newItem: ResultsItem?): Boolean {
        return oldItem == newItem
    }
}