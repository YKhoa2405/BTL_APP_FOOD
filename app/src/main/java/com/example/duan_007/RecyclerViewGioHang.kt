package com.example.duan_007

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewGioHang(var dsGioHang: List<OutDataSanPham>): RecyclerView.Adapter<RecyclerViewGioHang.GridViewHoder>(){
    inner class GridViewHoder(itemView: View) : RecyclerView.ViewHolder(itemView)
    private var tongTien =0.0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHoder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_sanpham_giohang,parent,false)
        return GridViewHoder(view)
    }

    override fun onBindViewHolder(holder: GridViewHoder, position: Int) {
        holder.itemView.apply {
            val imgGioHang =findViewById<ImageView>(R.id.imgSanPhamGioHang)
            val giaGioHang =findViewById<TextView>(R.id.txtGiaGioHang)
            val titleGioHang =findViewById<TextView>(R.id.txtTitleGioHang)
            giaGioHang.text = dsGioHang[position].GiaSanPham
            titleGioHang.text = dsGioHang[position].TitleSanPham
            imgGioHang.setImageResource(dsGioHang[position].imgSanPham)

            val btnCong = findViewById<ImageView>(R.id.imgCong)
            val btnTru = findViewById<ImageView>(R.id.imgTru)

            val txtGiaGioHang = findViewById<TextView>(R.id.txtGiaGioHang)
            val txtTongGiaGioHang = findViewById<TextView>(R.id.txtTongGiaGioHang)
            val txtSoLuongSanPham = findViewById<TextView>(R.id.txtSoLuongSanPham)

            var soLuongSanPham = 0
            var tongGia = 0.0


            btnCong.setOnClickListener{
                soLuongSanPham ++
                tongGia += txtGiaGioHang.text.toString().toDouble()
                txtSoLuongSanPham.text = "$soLuongSanPham"
                txtTongGiaGioHang.text = "$tongGia K VND"
            }

            btnTru.setOnClickListener{
                if(txtSoLuongSanPham.text.toString().toInt()>0 ){
                    soLuongSanPham --
                    tongGia -= txtGiaGioHang.text.toString().toDouble()
                }
                txtSoLuongSanPham.text = "$soLuongSanPham"
                txtTongGiaGioHang.text = "$tongGia K VND"
            }
        }
    }



    override fun getItemCount(): Int {
        return dsGioHang.size
    }
}