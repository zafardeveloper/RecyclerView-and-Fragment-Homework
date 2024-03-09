package com.example.recycler_fragment_homework.chats

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.EditText
import androidx.core.widget.doAfterTextChanged
import androidx.recyclerview.widget.RecyclerView
import com.example.recycler_fragment_homework.R
import com.example.recycler_fragment_homework.chats.adapter.ChatsAdapter
import com.example.recycler_fragment_homework.chats.model.ChatModel


class ChatFragment : Fragment(R.layout.fragment_chat) {

    private val recyclerView by lazy { requireView()
        .findViewById<RecyclerView>(R.id.recyclerView) }
    private val adapter = ChatsAdapter()

    private val data = listOf(
        ChatModel("Bryan"),
        ChatModel("Kari"),
        ChatModel("Diana"),
        ChatModel("Ben"),
        ChatModel("Naomi"),
        ChatModel("Alicia"),
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.adapter = adapter
        adapter.updateItems(data)
        view.findViewById<EditText>(R.id.searchEditText).apply {
            background = null
            doAfterTextChanged {
                filterChats(it)
            }
        }
    }

    private fun filterChats(query: Editable?) {
        query?.let {
            if (it.isNotEmpty()) {
                val searchQuery = query.toString().lowercase()
                adapter.updateItems(data.filter {
                    it.names.lowercase().contains(searchQuery)
                })
            } else adapter.updateItems(data)
        }
    }

}