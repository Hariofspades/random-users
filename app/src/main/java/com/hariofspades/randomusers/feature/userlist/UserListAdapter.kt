package com.hariofspades.randomusers.feature.userlist

import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.hariofspades.domain.features.userlist.model.ResultsItem
import com.hariofspades.randomusers.R
import com.hariofspades.randomusers.common.extensions.toCamelCase
import com.hariofspades.randomusers.common.glide.GlideApp
import com.hariofspades.randomusers.common.glide.PlaceHolder
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.user_list_content.view.*

class UserListAdapter(

        private val onClickCallback: (ResultsItem) -> Unit

) : ListAdapter<ResultsItem, UserListAdapter.UserViewHolder>(UserListDiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {

        return UserViewHolder(
                LayoutInflater.from(parent.context)
                        .inflate(R.layout.user_list_content, parent, false)
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {

        val item = getItem(position)

        GlideApp.with(holder.avatar.context)
                .load(item.thumbnail)
                .centerCrop()
                .placeholder(PlaceHolder.getRandomPlaceholders())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.avatar)

        holder.name.text = String.format(
                holder.name.context.getString(R.string.namePlaceholder),
                item.firstName,
                item.lastName).toCamelCase()

        holder.email.text = item.email

        holder.itemView.setOnClickListener {
            onClickCallback(item)
        }
    }

    inner class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.name
        val email: TextView = view.email
        val avatar: CircleImageView = view.avatar
    }
}