package com.example.hw_6_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.example.hw_6_recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        startContactsListFragment()
    }

    private fun startContactsListFragment() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.activity_frame_layout, ContactsList())
            .commit()
    }
}