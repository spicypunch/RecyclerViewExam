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
    private val adapter by lazy { RecyclerViewAdapter() }
    private val presenter by lazy { MainPresenter(this) }

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
        presenter.add()
    }

    private fun removeList() {
        presenter.remove()
    }

    override fun updateItems(items: MutableList<RecyclerViewItem>, division: String) {
        adapter.updateList(items)
        if (division == "add") {
            adapter.notifyItemChanged(adapter.itemCount)
        }
        else if (division == "remove") {
            adapter.notifyItemRemoved(adapter.itemCount)
        }

    }
}