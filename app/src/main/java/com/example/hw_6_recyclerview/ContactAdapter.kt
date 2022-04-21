package com.example.hw_6_recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hw_6_recyclerview.databinding.ContactItemBinding
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.Picasso

class ContactAdapter(contacts: MutableList<Contact>, private val openContactDetails: OpenContactDetails) :
    RecyclerView.Adapter<ContactAdapter.ContactHolder>() {

    private lateinit var binding: ContactItemBinding
    private val contactsList = contacts
    private val urlIm = "https://picsum.photos/200/200"
    private val dialogFragment = AlertDialogFragment()

    //Создается элемент
    class ContactHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView: TextView = view.findViewById(R.id.contact_name)
        val surnameTextView: TextView = view.findViewById(R.id.contact_surname)
        val numberTextView: TextView = view.findViewById(R.id.contact_number)
    }

    // Элемент отрисовывается на экране
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactHolder {
        binding = ContactItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val imageView: ImageView = binding.ivImage
        Picasso.get()
            .load(urlIm)
            .memoryPolicy(MemoryPolicy.NO_CACHE)
            .error(R.drawable.ic_baseline_person_24)
            .into(imageView)
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