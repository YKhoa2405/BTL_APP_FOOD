package com.example.duan_007

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.duan_007.databinding.ActivityShoppingBinding

class shopping : AppCompatActivity() {
    private lateinit var binding: ActivityShoppingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityShoppingBinding.inflate(layoutInflater)
        /*setContentView(R.layout.activity_shopping)*/
        setContentView(binding.root)
        tongTienThanhToan()
        hienThiListGioHang()
        clickTrangChu()
    }

    private fun clickTrangChu() {
        //chuyển trang từ giỏ hàng sang trang chủ
        binding.lvTrangChu.setOnClickListener{
            startActivity(Intent(this@shopping,trangChu::class.java))
        }
    }

    private fun tongTienThanhToan() {
        //tính tiền thanh toán
        val giaTriHang = binding.txtTienHang.text.toString().toDoubleOrNull() ?: 0.0
        val giaTriVanChuyen = binding.txtTienVanChuyen.text.toString().toDoubleOrNull() ?: 0.0

        val tienThue = (giaTriHang * 0.05).toInt()
        val tongTien = giaTriHang+tienThue+giaTriVanChuyen

        binding.txtTienThue.text = "$tienThue"
        binding.txtTongTien.text= "$tongTien K VND"



    }


    private fun hienThiListGioHang() {
        val listGioHang : MutableList<OutDataSanPham> = mutableListOf()
        listGioHang.add(OutDataSanPham(R.drawable.sua,"Sữa chuối","50"))
        listGioHang.add(OutDataSanPham(R.drawable.kitkat,"Kitkat","20"))

/*        binding.listGioHang.adapter= RecyclerViewGioHang(listGioHang)
        binding.listGioHang.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL,false)*/

        binding.RecyGioHang.adapter= RecyclerViewGioHang(listGioHang)
        binding.RecyGioHang.layoutManager =LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
    }
}