package com.example.recyclerviewexam


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.recyclerviewexam.databinding.ActivityMainBinding
import com.example.recyclerviewexam.db.ItemEntity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: RecyclerViewAdapter
    private lateinit var itemList: MutableList<ItemEntity>

    var count: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = RecyclerViewAdapter()
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
//        val itemList = (0..100).map {
//            for (i in 1..100) {
//                ItemEntity(title = i.toString(), content = i.toString())
//            }
//        }

        itemList = (1..++count).map {
            Log.e("count", count.toString())
            ItemEntity(title = it.toString(), content = it.toString())
        } as MutableList<ItemEntity>


        val startNum = adapter.itemCount
        Log.e("startNum", startNum.toString())
        adapter.updateList(itemList)
        Log.e("itemList", itemList.toString())
//        adapter.updateList(ManageList.makeList(count))
        adapter.notifyItemRangeInserted(startNum, itemList.size)

    }

    private fun removeList() {
        if (count != 0) {
            itemList.removeAt(--count)
            Log.e("itemList2", itemList.toString())
            val startNum = adapter.itemCount
            Log.e("startNum2", startNum.toString())
            adapter.updateList(itemList)
            adapter.notifyItemRangeInserted(startNum, itemList.size)
        }
    }

    override fun onRestart() {
        super.onRestart()
    }

    //companion object 이용해보기
//    class ManageList {
//        companion object {
//            fun makeList(cnt: Int) {
//                (1..cnt).map {
//                    Log.e("count", cnt.toString())
//                    ItemEntity(title = cnt.toString(), content = cnt.toString())
//                }
//            }
//
////            val itemList = mutableMapOf("title" to 1, "content" to 1)
//
//        }
//    }


}