package com.example.recyclerviewexam

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewexam.databinding.ItemViewBinding
import com.example.recyclerviewexam.db.RecyclerViewItem

class RecyclerViewAdapter() : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>(){

    private val itemList = mutableListOf<RecyclerViewItem>()

    fun updateList(items: MutableList<RecyclerViewItem>) {
        itemList.clear()
        itemList.addAll(items)
    }
        class MyViewHolder(private val binding: ItemViewBinding) : RecyclerView.ViewHolder(binding.root) {

            fun bind(item: RecyclerViewItem) {
                binding.data = item
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding: ItemViewBinding = ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int = itemList.size
}