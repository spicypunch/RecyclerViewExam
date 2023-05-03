package com.example.recyclerviewexam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewexam.databinding.ActivityMainBinding
import com.example.recyclerviewexam.db.RecyclerViewItem

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val adapter by lazy { RecyclerViewAdapter() }
    private var itemList = mutableListOf<RecyclerViewItem>()

    var count: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        binding.plusBtn.setOnClickListener {
            addList()
        }

        binding.minusBtn.setOnClickListener {
            removeList()
        }
    }

    private fun addList() {
        count++
        itemList.add(RecyclerViewItem("$count", "$count"))
        Log.e("add", itemList.toString())
        adapter.submitList(itemList)
    }

    private fun removeList() {
        if (count != 0) {
            itemList.removeAt(--count)
            Log.e("remove", itemList.toString())
            adapter.submitList(itemList)
        }

    }
}
