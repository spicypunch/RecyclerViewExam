package com.example.recyclerviewexam


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewexam.databinding.ActivityMainBinding
import com.example.recyclerviewexam.db.ItemEntity
import com.example.recyclerviewexam.db.RecyclerViewAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: RecyclerViewAdapter
    private lateinit var itemList: ItemEntity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        adapter = RecyclerViewAdapter(this)
//        binding.recyclerView.adapter = adapter
//        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        binding.plusBtn.setOnClickListener {

        }

        binding.minusBtn.setOnClickListener {

        }

        getList()
    }

    private fun getList() {
        val itemList = (0..100).map {
            for (i in 1..100) {
                ItemEntity(title = i.toString(), content = i.toString())
            }
        }

//        val itemList = (0..100).map {
//            val index = (1..100).toList()
//            ItemEntity(title = index.toString(), content = index.toString())
//        }

        adapter = RecyclerViewAdapter(itemList as ArrayList<ItemEntity>)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
//        adapter.updateList(itemList)
        adapter.notifyDataSetChanged()

    }

    override fun onRestart() {
        super.onRestart()
    }

}