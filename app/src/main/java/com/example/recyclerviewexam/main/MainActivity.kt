package com.example.recyclerviewexam.main


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewexam.RecyclerViewAdapter

import com.example.recyclerviewexam.databinding.ActivityMainBinding
import com.example.recyclerviewexam.db.RecyclerViewItem

class MainActivity : AppCompatActivity(), MainContract.View {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var adapter: RecyclerViewAdapter
    private val presenter by lazy {
        MainPresenter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = RecyclerViewAdapter()

        binding.plusBtn.setOnClickListener {
            addList()
        }

        binding.minusBtn.setOnClickListener {
            removeList()
        }
    }
    private fun addList() {
        presenter.add()
        binding.recyclerView.adapter = adapter

    }

    private fun removeList() {
        presenter.remove()
        binding.recyclerView.adapter = adapter
    }

    override fun updateItems(items: MutableList<RecyclerViewItem>) {
        runOnUiThread {
            adapter.updateList(items)
            adapter.notifyDataSetChanged()
        }
    }


}