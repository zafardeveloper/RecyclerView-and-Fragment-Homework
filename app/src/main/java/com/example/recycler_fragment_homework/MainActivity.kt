package com.example.recycler_fragment_homework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.recycler_fragment_homework.databinding.ActivityMainBinding
import com.example.recycler_fragment_homework.profile.ProfileFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val search = binding.searchEditText
//
//        search.setOnClickListener {
//            replaceFragment(ProfileFragment())
//        }

    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.chats_fragment_container, fragment)
        fragmentTransaction.commit()
    }


}