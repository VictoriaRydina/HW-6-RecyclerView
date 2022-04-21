package com.example.hw_6_recyclerview

import android.app.AlertDialog
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.hw_6_recyclerview.databinding.ContactItemBinding

class ContactAdapter(contacts: MutableList<Contact>, private val openContactDetails: OpenContactDetails) :
    RecyclerView.Adapter<ContactAdapter.ContactHolder>() {

    private lateinit var binding: ContactItemBinding
    private val contactsList = contacts

    //Создается элемент
    class ContactHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView: TextView = view.findViewById(R.id.contact_name)
        val surnameTextView: TextView = view.findViewById(R.id.contact_surname)
        val numberTextView: TextView = view.findViewById(R.id.contact_number)
        val imageView: ImageView = view.findViewById(R.id.iv_image)
    }

    // Элемент отрисовывается на экране
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactHolder {
        binding = ContactItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContactHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return contactsList.size
    }

    //Заполняется данными
    override fun onBindViewHolder(viewHolder: ContactHolder, position: Int) {
        viewHolder.nameTextView.text = contactsList[position].name
        viewHolder.surnameTextView.text = contactsList[position].surname
        viewHolder.numberTextView.text = contactsList[position].number

//      viewHolder.imageView = createContactsList()[position].image

        viewHolder.itemView.setOnClickListener {
            openContactDetails.openDetails(contactsList[position])
        }

        viewHolder.itemView.setOnLongClickListener {
            /// создать диалог назначить кнопки татйтл и потом сказать что по нажатию ок мы удалаяем элемет
            //val builder = AlertDialog.Builder(this)


            contactsList.removeAt(position)
            notifyDataSetChanged()
            true
        }
    }
}