package com.example.recyclerviewexam.main

import android.util.Log
import com.example.recyclerviewexam.db.RecyclerViewItem

class MainPresenter(private val view: MainContract.View) : MainContract.Presenter {
    var count: Int = 0
    lateinit var division: String
    private var itemList = mutableListOf<RecyclerViewItem>()

    override fun add() {
        count++
        division = "add"
        itemList.add(RecyclerViewItem("$count", "$count"))
        Log.e("list", itemList.toString())
        view.updateItems(itemList, division)
    }

    override fun remove() {
        if (count != 0) {
            division = "remove"
            itemList.removeAt(--count)
            Log.e("list", itemList.toString())
            view.updateItems(itemList, division)
        }
    }
}