package com.example.randomuserapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.randomuserapplication.databinding.UserGridBinding
import com.example.randomuserapplication.db.UserEntity
import com.squareup.picasso.Picasso

class UserAdapter : ListAdapter<UserEntity, UserAdapter.UserViewHolder>(UserDiffCallback())  {

    inner class UserViewHolder(private val binding: UserGridBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: UserEntity) {
            Picasso.with(binding.root.context)
                .load(item.pictureUrl)
                .into(binding.profileImage)

            val location = "${item.city}, ${item.country}"
            binding.userCity.text = location
            val fullName = "${item.firstName} ${item.lastName}"
            binding.profileName.text = fullName
            binding.followBtn.setOnClickListener {
                binding.followBtn.text = "Following"
                Toast.makeText(binding.root.context, "Follow successful!", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    class UserDiffCallback : DiffUtil.ItemCallback<UserEntity>() {
        override fun areItemsTheSame(oldItem: UserEntity, newItem: UserEntity): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: UserEntity, newItem: UserEntity): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = UserGridBinding.inflate(inflater, parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}