package com.example.diffutilapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.diffutilapp.databinding.RowLayoutBinding

class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    private var oldPersonList = emptyList<Person>()
    class MyViewHolder(val binding: RowLayoutBinding): RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(RowLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.apply {
            nameTextView.text = oldPersonList[position].name
            ageTextView.text = oldPersonList[position].age.toString()
        }
    }

    override fun getItemCount(): Int{
        return oldPersonList.size
    }
    fun setData(newPersonList: List<Person>){
        val diffUtil = MyDiffUitl(oldPersonList, newPersonList)
        val diffResults = DiffUtil.calculateDiff(diffUtil)
        oldPersonList = newPersonList
        diffResults.dispatchUpdatesTo(this)
    }
}