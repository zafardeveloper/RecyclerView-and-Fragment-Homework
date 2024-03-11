package com.example.recycler_fragment_homework.profile

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.EditText
import androidx.core.widget.doAfterTextChanged
import androidx.recyclerview.widget.RecyclerView
import com.example.recycler_fragment_homework.R
import com.example.recycler_fragment_homework.profile.adapter.ProfilesAdapter
import com.example.recycler_fragment_homework.profile.model.ProfileModel


class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private val recyclerView by lazy { requireView()
        .findViewById<RecyclerView>(R.id.recyclerViewProfile) }
    private val adapter = ProfilesAdapter()


    val dataProfile = listOf(
        ProfileModel("Bryan", R.drawable.bryan),
        ProfileModel("Kari", R.drawable.kari),
        ProfileModel("Diana", R.drawable.diana),
        ProfileModel("Ben", R.drawable.ben),
        ProfileModel("Naomi", R.drawable.naomi),
        ProfileModel("Alicia", R.drawable.alicia),
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.adapter = adapter
        adapter.updateItems(dataProfile)
        view.findViewById<EditText>(R.id.searchEditText)?.apply {
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
                adapter.updateItems(dataProfile.filter {
                    it.names.lowercase().contains(searchQuery)
                })
            } else adapter.updateItems(dataProfile)
        }
    }


}