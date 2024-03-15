package com.example.recycler_fragment_homework.chat

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.recycler_fragment_homework.R
import com.example.recycler_fragment_homework.chat.adapter.ChatsAdapter
import com.example.recycler_fragment_homework.chat.model.ChatModel
import com.example.recycler_fragment_homework.profile.ProfileFragment


class ChatFragment :Fragment(R.layout.fragment_chat), ChatsAdapter.Listener {

    private val recyclerView by lazy { requireView()
        .findViewById<RecyclerView>(R.id.recyclerViewChat)}
    private val adapter = ChatsAdapter(this)

    private val data = mutableListOf(
        ChatModel("Bryan","What do you think?" , R.drawable.bryan),
        ChatModel("Kari","Looks great!" , R.drawable.kari),
        ChatModel("Diana","Lunch on Monday?" , R.drawable.diana),
        ChatModel("Ben","You sent a photo." , R.drawable.ben),
        ChatModel("Naomi","Naomi sent a photo." , R.drawable.naomi),
        ChatModel("Alicia","See you at 8." , R.drawable.alicia),
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.adapter = adapter
        adapter.updateItems(data)

        val textView = view.findViewById<TextView>(R.id.TextView)

        textView?.setOnClickListener {

            val profileFragment = ProfileFragment()
            parentFragmentManager.beginTransaction()
                .add(R.id.chats_fragment_container, profileFragment)
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onClick(item: ChatModel) {
        val alertDialog = AlertDialog.Builder(context)
            .setTitle("Delete contact")
            .setMessage("Are you sure you want to delete?")
            .setIcon(R.drawable.delete_icon)
            .setPositiveButton(android.R.string.yes) { dialog, which ->
                val position = data.indexOf(item)
                deleteItem(position)
                adapter.updateItems(data)
            }
            .setNegativeButton(android.R.string.no) { dialog, which ->
                dialog.dismiss()
            }
            .create()
        alertDialog.show()
    }

    fun deleteItem(position: Int) {
        data.removeAt(position)
        adapter.notifyItemRemoved(position)
    }

}

