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

    private var count: Int = 1

    fun add() {
        Log.e("check",_itemList.value.toString())
        ++count
        _itemList.value = _itemList.value?.toMutableList().also {
            it?.add(RecyclerViewItem(count.toString(), count.toString()))
            Log.e("check2", _itemList.value.toString())

        }
    }

    fun remove() {
        Log.e("test", "remove")
        if (count != 0) {
            --count
            _itemList.value!!.removeAt(count)
        }
    }
}