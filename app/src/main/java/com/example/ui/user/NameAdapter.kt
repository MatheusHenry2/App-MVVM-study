package com.example.ui.user

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NameAdapter : RecyclerView.Adapter<NameAdapter.NameViewHolder>() {

    private val names = mutableListOf<String>()

    class NameViewHolder(private val textView: TextView) : RecyclerView.ViewHolder(textView) {
        fun bind(name: String) {
            textView.text = name
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(newList: List<String>) {
        names.clear()
        names.addAll(newList)
        notifyDataSetChanged()
    }

    fun getItem(position: Int): String {
        return names[position]
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameAdapter.NameViewHolder {
        val textView = LayoutInflater.from(parent.context)
            .inflate(android.R.layout.simple_list_item_1, parent, false) as TextView
        return NameViewHolder(textView)
    }

    override fun onBindViewHolder(holder: NameViewHolder, position: Int) {
        holder.bind(names[position])
    }

    override fun getItemCount(): Int = names.size
}