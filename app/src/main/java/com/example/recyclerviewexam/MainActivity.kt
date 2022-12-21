package com.example.recyclerviewexam


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.recyclerviewexam.databinding.ActivityMainBinding
import com.example.recyclerviewexam.db.RecyclerViewItem

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val adapter by lazy { RecyclerViewAdapter(itemList) }
    private var itemList = mutableListOf<RecyclerViewItem>()

    var count: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
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

//        itemList = (1..++count).map {
//            Log.e("count", count.toString())
//            RecyclerViewItem(title = it.toString(), content = it.toString())
//        } as MutableList<RecyclerViewItem>
//
//
//        val startNum = adapter.itemCount
//        Log.e("startNum", startNum.toString())
//        adapter.updateList(itemList)
//        Log.e("itemList", itemList.toString())
////        adapter.updateList(ManageList.makeList(count))
//        adapter.notifyItemRangeInserted(startNum, itemList.size)

        count++
        itemList.add(RecyclerViewItem("$count", "$count"))
        Log.e("list", itemList.toString())
        binding.recyclerView.adapter = adapter

    }

    private fun removeList() {
//        if (count != 0) {
//            itemList.removeAt(--count)
//            Log.e("itemList2", itemList.toString())
//            val startNum = adapter.itemCount
//            Log.e("startNum2", startNum.toString())
//            adapter.updateList(itemList)
//            adapter.notifyItemRangeInserted(startNum, itemList.size)
//        }
        if (count != 0) {
            itemList.removeAt(--count)
            Log.e("list", itemList.toString())
            binding.recyclerView.adapter = adapter
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