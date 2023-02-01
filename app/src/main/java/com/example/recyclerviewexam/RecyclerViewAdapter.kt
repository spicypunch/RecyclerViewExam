package com.example.recyclerviewexam

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewexam.databinding.ItemViewBinding
import com.example.recyclerviewexam.db.RecyclerViewItem

class RecyclerViewAdapter(private val itemList: MutableList<RecyclerViewItem>) : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>(){

        class MyViewHolder(binding: ItemViewBinding) : RecyclerView.ViewHolder(binding.root) {
            val title = binding.title
            val content = binding.content
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding: ItemViewBinding = ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = itemList[position]
        holder.title.text = data.title
        holder.content.text = data.content
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}