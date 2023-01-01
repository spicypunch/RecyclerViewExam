package com.example.recyclerviewexam.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recyclerviewexam.db.RecyclerViewItem

class ViewModel: ViewModel() {
    private var _itemList = MutableLiveData<MutableList<RecyclerViewItem>> ()
    val itemList: LiveData<MutableList<RecyclerViewItem>>
        get() = _itemList
    private var count: Int = 0

    fun add() {
        Log.e("test", "add")
        ++count
        itemList.value!!.add(RecyclerViewItem(count.toString(), count.toString()))
    }
    fun remove() {
        Log.e("test", "remove")
        if (count != 0) {
            --count
            itemList.value!!.removeAt(count)
        }
    }
}