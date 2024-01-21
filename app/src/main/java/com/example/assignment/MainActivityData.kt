package com.example.assignment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.assignment.database.Todo


class MainActivityData:ViewModel() {
private val _data = MutableLiveData<List<Todo>>()
val data:LiveData<List<Todo>> = _data
    fun setData(data:List<Todo>){
        _data.value = data
    }

    fun addData(item: Todo){
        val currentData = _data.value ?: emptyList()
        _data.value = currentData + listOf(item)
    }

}