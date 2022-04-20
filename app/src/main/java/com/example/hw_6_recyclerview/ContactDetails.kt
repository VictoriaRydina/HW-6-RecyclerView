package com.example.hw_6_recyclerview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hw_6_recyclerview.databinding.DetailsContactBinding

class ContactDetails: Fragment(R.layout.details_contact) {

    private lateinit var binding: DetailsContactBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DetailsContactBinding.inflate(inflater, container, false)
        return binding.root
    }
}