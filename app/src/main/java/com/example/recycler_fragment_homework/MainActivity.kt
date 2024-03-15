package com.example.recycler_fragment_homework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.recycler_fragment_homework.chat.adapter.ChatsAdapter
import com.example.recycler_fragment_homework.chat.model.ChatModel
import com.example.recycler_fragment_homework.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(){

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }



}