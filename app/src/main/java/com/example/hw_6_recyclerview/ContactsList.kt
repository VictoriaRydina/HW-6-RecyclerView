package com.example.hw_6_recyclerview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hw_6_recyclerview.databinding.ListContactBinding
import com.github.javafaker.Faker

class ContactsList : Fragment(R.layout.list_contact) {

    private lateinit var binding: ListContactBinding
    private lateinit var adapter: ContactAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ListContactBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private val faker = Faker.instance()
    private var contacts: MutableList<Contact> = (1..120).map {
        Contact(
            id = it,
            name = faker.name().firstName(),
            surname = faker.name().lastName(),
            number = faker.phoneNumber().cellPhone(),
            image = "https://picsum.photos/id/200/200"
        )
    } as MutableList<Contact>

    private fun init() {
        binding.apply {
            adapter = ContactAdapter(
                contacts,
                object : OpenContactDetails {
                    override fun openDetails(contact: Contact) {
                        activity?.supportFragmentManager?.beginTransaction()
                            ?.replace(R.id.activity_frame_layout, ContactDetails(contact))
                            ?.addToBackStack(null)
                            ?.commit()
                    }
                }
            )
            rcView.layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.VERTICAL, false
            )
            rcView.adapter = adapter
        }
    }
}