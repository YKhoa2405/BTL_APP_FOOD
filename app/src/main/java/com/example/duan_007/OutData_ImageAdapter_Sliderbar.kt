package com.example.duan_007

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2

class OutData_ImageAdapter_Sliderbar(private val ListImageSlideBar: ArrayList<Int>, private val viewPager2: ViewPager2): RecyclerView.Adapter<OutData_ImageAdapter_Sliderbar.ImageViewHolder>() {
    class ImageViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.layout_slidebar,parent,false)
        return ImageViewHolder(view)
    }

    override fun getItemCount(): Int {
        return ListImageSlideBar.size
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.itemView.apply {
            val imgSlideBar = findViewById<ImageView>(R.id.imgSlideBar)
            imgSlideBar.setImageResource(ListImageSlideBar[position])
        }
    }

}