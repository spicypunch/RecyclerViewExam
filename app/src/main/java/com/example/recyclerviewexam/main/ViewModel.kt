package com.example.recyclerviewexam.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recyclerviewexam.db.RecyclerViewItem

class ViewModel: ViewModel() {
    private var _itemList = MutableLiveData<MutableList<RecyclerViewItem>>()
    val itemList: LiveData<MutableList<RecyclerViewItem>>
        get() = _itemList

    init {
        _itemList.value = mutableListOf()
    }

    private var count: Int = 0

    fun add() {
        ++count
        _itemList.value = _itemList.value?.toMutableList().also {
            it?.add(RecyclerViewItem(count.toString(), count.toString()))
            Log.e("add", _itemList.value.toString())

        }
    }

    fun remove() {
        if (count != 0) {
            --count
            _itemList.value = _itemList.value?.toMutableList().also {
                it?.removeAt(count)
                Log.e("remove", _itemList.value.toString())

            }
        }
    }
}