package com.example.recyclerviewexam.main;

import com.example.recyclerviewexam.db.RecyclerViewItem

interface MainContract {

    interface View {
        fun updateItems(items: MutableList<RecyclerViewItem>, division: String)
    }

    interface Presenter {
        fun add()

        fun remove()

    }
}
