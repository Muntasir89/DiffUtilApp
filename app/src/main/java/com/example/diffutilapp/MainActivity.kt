package com.example.diffutilapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.diffutilapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val myAdapter by lazy {MyAdapter()}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclverView.layoutManager = LinearLayoutManager(this)
        binding.recyclverView.adapter = myAdapter
        // Inflate the layout for this fragment

        val person1 = Person(1, "John", 21)
        val person2 = Person(2, "Steve", 22)
        val person3 = Person(3, "mary", 23)

        myAdapter.setData(listOf(person1, person2, person3))

        binding.addButton.setOnClickListener{
            val person4 = Person(4, "Henry", 24)
            myAdapter.setData(listOf(person1, person2, person3, person4))
        }
    }
}