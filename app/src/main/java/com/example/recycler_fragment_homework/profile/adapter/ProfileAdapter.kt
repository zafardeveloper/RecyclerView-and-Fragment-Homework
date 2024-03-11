package com.example.recycler_fragment_homework.profile.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.recycler_fragment_homework.R
import com.example.recycler_fragment_homework.profile.model.ProfileModel

class ProfilesAdapter : RecyclerView.Adapter<ProfilesAdapter.ViewHolder>() {

    private val items = ArrayList<ProfileModel>()

    @SuppressLint("notifyDataSetChanged")
    fun updateItems(items: List<ProfileModel>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        private val titleTextView = itemView.findViewById<TextView>(R.id.titleTvProfile)
        private val avatarImageView = itemView.findViewById<ImageView>(R.id.imageViewProfile)

        fun bind(item: ProfileModel) {
            titleTextView.text = item.names
            avatarImageView.setImageDrawable(ContextCompat.getDrawable(itemView.context, item.avatar))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.profile_item, parent, false)
        )
    }

    override fun getItemCount(): Int = items.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])

    }
}