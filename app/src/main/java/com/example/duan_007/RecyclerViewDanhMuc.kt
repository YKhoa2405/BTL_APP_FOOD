package com.example.duan_007

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewDanhMuc(var dsDanhMuc: List<OutData>): RecyclerView.Adapter<RecyclerViewDanhMuc.GridViewHoder>(){
    inner class GridViewHoder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHoder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_danhmuc,parent,false)
        return GridViewHoder(view)
    }

    override fun onBindViewHolder(holder: GridViewHoder, position: Int) {
        holder.itemView.apply {
            val imgDanhMuc =findViewById<ImageView>(R.id.imgDanhMuc)
            val titleDanhMuc =findViewById<TextView>(R.id.titleDanhMuc)
            titleDanhMuc.text = dsDanhMuc[position].Title
            imgDanhMuc.setImageResource(dsDanhMuc[position].img)
        }
    }

    override fun getItemCount(): Int {
        return dsDanhMuc.size
    }
}