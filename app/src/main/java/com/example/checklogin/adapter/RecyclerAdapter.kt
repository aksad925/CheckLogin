package com.example.checklogin.adapter

import com.example.checklogin.onClickListener.ItemClickListener
import androidx.recyclerview.widget.RecyclerView
import com.example.checklogin.adapter.RecyclerAdapter.ItemHolder
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.example.checklogin.R
import android.widget.TextView
import com.example.checklogin.data.Notes
import java.util.ArrayList

class RecyclerAdapter(
    private val arrayList: ArrayList<Notes>,
    private val itemClickListener: ItemClickListener
) : RecyclerView.Adapter<ItemHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_notes, parent, false)
        return ItemHolder(view)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val notes = arrayList[position]
        holder.textViewTitle.text = notes.title
        holder.textViewDescription.text = notes.description
        holder.itemView.setOnClickListener { itemClickListener.onClick(notes) }
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    inner class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textViewTitle: TextView
        var textViewDescription: TextView

        init {
            textViewTitle = itemView.findViewById(R.id.title_recycle)
            textViewDescription = itemView.findViewById(R.id.desc_recycle)
        }
    }
}