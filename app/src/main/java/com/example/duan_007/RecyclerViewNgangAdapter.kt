package com.example.duan_007

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewNgangAdapter(var dsGridView: MutableList<OutDataSanPham>,val clickItemNgang: RecyclerViewNgangInterFace): RecyclerView.Adapter<RecyclerViewNgangAdapter.GridViewHoder>(){
    inner class GridViewHoder(itemView: View) :RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHoder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_item_sanpham,parent,false)
        return GridViewHoder(view)
    }

    override fun onBindViewHolder(holder: GridViewHoder, position: Int) {
        holder.itemView.apply {
            val imgSanPham =findViewById<ImageView>(R.id.imgSanPham)
            val txtTitleSanPham =findViewById<TextView>(R.id.txtTitleSanPham)
            val txtGiaSanPham =findViewById<TextView>(R.id.txtGiaSanPham)
            txtTitleSanPham.text = dsGridView[position].TitleSanPham
            txtGiaSanPham.text = dsGridView[position].GiaSanPham
            imgSanPham.setImageResource(dsGridView[position].imgSanPham)
        }
        holder.itemView.setOnClickListener {
            clickItemNgang.OnClickItem(position)
        }
    }

    override fun getItemCount(): Int {
        return dsGridView.size
    }
}