package com.example.recycler_fragment_homework.chats.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recycler_fragment_homework.R
import com.example.recycler_fragment_homework.chats.model.ChatModel

class ChatsAdapter : RecyclerView.Adapter<ChatsAdapter.ViewHolder>() {

    private val items = ArrayList<ChatModel>()

    @SuppressLint("notifyDataSetChanged")
    fun updateItems(items: List<ChatModel>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        private val titleTextView = itemView.findViewById<TextView>(R.id.titleTextView)

        fun bind(item: ChatModel) {
            titleTextView.text = item.names

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.chat_item, parent, false)
        )
    }

    override fun getItemCount(): Int = items.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])

    }
}