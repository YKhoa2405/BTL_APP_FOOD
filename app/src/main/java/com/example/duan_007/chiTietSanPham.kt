package com.example.duan_007

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.duan_007.databinding.ActivityChiTietSanPhamBinding
import java.util.zip.Inflater
import kotlin.concurrent.timer

class chiTietSanPham : AppCompatActivity() {
    private  lateinit var binding : ActivityChiTietSanPhamBinding
    private lateinit var imageListSlideBar:ArrayList<Int>
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChiTietSanPhamBinding.inflate(layoutInflater)
        /*setContentView(R.layout.activity_chi_tiet_san_pham)*/
        setContentView(binding.root)
        hienThiSlideBar()
        clickCongTru()
        clickThemGioHang()

    }

    private fun clickThemGioHang() {
        binding.btnThemGioHang.setOnClickListener{
            Toast.makeText(this@chiTietSanPham,"Thêm thành công", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this,shopping::class.java))
        }
    }

    private fun clickCongTru() {
        var soLuong =0
        binding.imgCong.setOnClickListener{
            soLuong++
            binding.txtSoLuongSanPham.text ="$soLuong"
        }

        binding.imgTru.setOnClickListener{
            if(binding.txtSoLuongSanPham.text.toString().toInt()>0){
                soLuong--
            }
            binding.txtSoLuongSanPham.text ="$soLuong"
        }
    }

    private fun hienThiSlideBar() {
        //danh sách hình ảnh trong slide bar
        imageListSlideBar = ArrayList()
        imageListSlideBar.add(R.drawable.kitkat)
        imageListSlideBar.add(R.drawable.slidebar2)
        imageListSlideBar.add(R.drawable.slidebar3)

        //adapter hien thi slide bar người dùng tự lướt
        binding.viewPager2.adapter = OutData_ImageAdapter_Sliderbar(imageListSlideBar, binding.viewPager2 )

    }
}