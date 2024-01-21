package com.example.assignment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FragmentViewModel: ViewModel() {

    private val clothesName = MutableLiveData<String>()

    fun getClotheName():LiveData<String>{
        return clothesName
    }

    fun setClotheName(name: String){
        clothesName.value = name
    }
}