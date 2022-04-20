package com.example.hw_6_recyclerview

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class ContactListViewModel : ViewModel() {

    val dataId: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

}