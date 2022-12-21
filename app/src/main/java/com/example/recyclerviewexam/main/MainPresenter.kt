package com.example.recyclerviewexam.main

import android.util.Log
import com.example.recyclerviewexam.db.RecyclerViewItem

class MainPresenter : MainContract.Presenter {
    var count: Int = 0
    private var itemList = mutableListOf<RecyclerViewItem>()

    override fun add() {
        Thread {
            count++
            itemList.add(RecyclerViewItem("$count", "$count"))
            Log.e("list", itemList.toString())
        }.start()
    }

    override fun remove() {
        Thread {
            if (count != 0) {
                itemList.removeAt(--count)
                Log.e("list", itemList.toString())
            }
        }.start()
    }
}