package com.example.recyclerviewexam

import androidx.recyclerview.widget.DiffUtil
import com.example.recyclerviewexam.db.RecyclerViewItem

class DiffUtilCallback(
    private val oldList: MutableList<RecyclerViewItem>,
    private val newList: MutableList<RecyclerViewItem>): DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size
    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition].title == newList[newItemPosition].title

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition] == newList[newItemPosition]

}