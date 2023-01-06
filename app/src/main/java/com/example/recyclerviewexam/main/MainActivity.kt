package com.example.recyclerviewexam.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewexam.R
import com.example.recyclerviewexam.RecyclerViewAdapter

import com.example.recyclerviewexam.databinding.ActivityMainBinding
import com.example.recyclerviewexam.db.RecyclerViewItem

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: ViewModel
    private val adapter by lazy { RecyclerViewAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(ViewModel::class.java)

        binding.data = viewModel

        binding.recyclerView.run {
            adapter = this@MainActivity.adapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
        viewModel.itemList.observe(this, Observer {
            (binding.recyclerView.adapter as RecyclerViewAdapter).updateList(it)
        })
    }
}