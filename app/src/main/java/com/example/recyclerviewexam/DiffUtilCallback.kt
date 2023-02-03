package com.example.recyclerviewexam

import androidx.recyclerview.widget.DiffUtil
import com.example.recyclerviewexam.db.RecyclerViewItem

class DiffUtilCallback(
    private val oldList: MutableList<RecyclerViewItem>,
    private val newList: MutableList<RecyclerViewItem>
) : DiffUtil.Callback() {

    // 이전 목록의 크기
    override fun getOldListSize(): Int = oldList.size

    // 변경된 목록의 크기
    override fun getNewListSize(): Int = newList.size

    /**
     * 두 객체가 같은 아이템인지 비교함
     * 보통 유니크 키 값을 사용하여 비교함
     * 현재 프로젝트에선 item의 title로 비교
     */
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition].title == newList[newItemPosition].title

    /**
     * areItemsTheSame 함수가 True이면 호출됨
     * 두 개의 아이템이 같은 데이터를 가지고 있는지 '=='를 통해 동등성을 비교함
     * 같은 아이템이라도 다른 값을 가지고 있는 경우가 발생함
     */
    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition] == newList[newItemPosition]

}