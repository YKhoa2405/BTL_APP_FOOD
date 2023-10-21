package com.example.duan_007

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.duan_007.databinding.ActivityTrangChuBinding
import com.google.android.material.navigation.NavigationView
import kotlin.concurrent.timer
import kotlin.math.abs

class trangChu : AppCompatActivity() {
    private lateinit var imageListSlideBar:ArrayList<Int>
    private lateinit var binding: ActivityTrangChuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityTrangChuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        hienThiDanhSach()
        hienThiSlideBar()
        hienThiDanhSachNgang()
        clickGioHang()
        clickDanhSachNgang()
        hienThiDanhSachNgang1()
        hienThiDanhSachNgang2()
        searchAuto()


    }

    private fun clickGioHang() {
        binding.lvGioHang.setOnClickListener(){
            startActivity(Intent(this@trangChu,shopping::class.java))
        }
    }

    private fun clickDanhSachNgang() {

    }



    private fun hienThiSlideBar() {
        var trangHienTai =0
        val timeDelay: Long =3000
        imageListSlideBar = ArrayList()
        imageListSlideBar.add(R.drawable.slidebar1)
        imageListSlideBar.add(R.drawable.slidebar2)
        imageListSlideBar.add(R.drawable.slidebar3)

        //adapter hien thi
        binding.viewPager2.adapter = OutData_ImageAdapter_Sliderbar(imageListSlideBar, binding.viewPager2 )
        //sidebar chạy vô hạn
        val timer = timer(period = timeDelay) {
            runOnUiThread {
                if(trangHienTai == imageListSlideBar.size){
                    trangHienTai = 0
                }
                binding.viewPager2.currentItem = trangHienTai++
            }
        }
        binding.viewPager2.offscreenPageLimit = 3
        binding.viewPager2.clipToPadding = false
        binding.viewPager2.clipChildren = false
        binding.viewPager2.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
   }

    //sản phẩm mới về
    private fun hienThiDanhSachNgang() {
        binding.hienThiChieuNgang.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        val ListTong = mutableListOf<OutDataSanPham>()
        ListTong.add(OutDataSanPham(R.drawable.banhtrungthu,"Trúc em nhân đậu xanh ","180.000vnd ~ 300.000vnd"))
        ListTong.add(OutDataSanPham(R.drawable.banhtrungthu,"Trúc em đậu xanh ","180.000vnd ~ 300.000vnd"))
        ListTong.add(OutDataSanPham(R.drawable.banhtrungthu,"Bánh trung thu nhân đậu xanh ","180.000vnd ~ 300.000vnd"))
        ListTong.add(OutDataSanPham(R.drawable.banhtrungthu,"Bánh trung thu nhân đậu xanh ","180.000vnd ~ 300.000vnd"))
        val i =  Intent(this@trangChu,chiTietSanPham::class.java)

        binding.hienThiChieuNgang.adapter= RecyclerViewNgangAdapter(ListTong, object : RecyclerViewNgangInterFace{
            override fun OnClickItem(pos: Int) {
                Toast.makeText(this@trangChu,"Click ${ListTong[pos].TitleSanPham}",Toast.LENGTH_SHORT).show()
                startActivity(Intent(this@trangChu,chiTietSanPham::class.java))
            }
        })

    }
    //sản phẩm khuyến mãi
    private fun hienThiDanhSachNgang1() {
        binding.hienThiChieuNgang1.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        val ListTong1 = mutableListOf<OutDataSanPham>()
        ListTong1.add(OutDataSanPham(R.drawable.kitkat,"Kẹo Kitkat 10g","70.000vnd ~ 100.000vnd"))
        ListTong1.add(OutDataSanPham(R.drawable.kitkat,"Kẹo Kitkat 10g","70.000vnd ~ 100.000vnd"))
        ListTong1.add(OutDataSanPham(R.drawable.kitkat,"Kẹo Kitkat 10g","70.000vnd ~ 100.000vnd"))
        ListTong1.add(OutDataSanPham(R.drawable.kitkat,"Kẹo Kitkat 10g","70.000vnd ~ 100.000vnd"))
        binding.hienThiChieuNgang1.adapter= RecyclerViewNgangAdapter(ListTong1, object : RecyclerViewNgangInterFace{
            override fun OnClickItem(pos: Int) {
                Toast.makeText(this@trangChu,"Click ${ListTong1[pos].TitleSanPham}",Toast.LENGTH_SHORT).show()
            }
        })
    }
    //sản phẩm bán chạy
    private fun hienThiDanhSachNgang2() {
        binding.hienThiChieuNgang2.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        val ListTong2 = mutableListOf<OutDataSanPham>()
        ListTong2.add(OutDataSanPham(R.drawable.sua,"Sữa Chobani Oat","50.000vnd ~ 200.000vnd"))
        ListTong2.add(OutDataSanPham(R.drawable.sua,"Sữa Chobani Oat","50.000vnd ~ 200.000vnd"))
        ListTong2.add(OutDataSanPham(R.drawable.sua,"Sữa Chobani Oat","50.000vnd ~ 200.000vnd"))
        ListTong2.add(OutDataSanPham(R.drawable.sua,"Sữa Chobani Oat","50.000vnd ~ 200.000vnd"))
        binding.hienThiChieuNgang2.adapter= RecyclerViewNgangAdapter(ListTong2, object : RecyclerViewNgangInterFace{
            override fun OnClickItem(pos: Int) {
                Toast.makeText(this@trangChu,"Click ${ListTong2[pos].TitleSanPham}",Toast.LENGTH_SHORT).show()
            }
        })
    }


    private fun hienThiDanhSach() {
        val ListDanhMuc: MutableList<OutData> = mutableListOf()
        ListDanhMuc.add(OutData(R.drawable.cat_1,"Hải sản"))
        ListDanhMuc.add(OutData(R.drawable.cat_2,"Rau củ"))
        ListDanhMuc.add(OutData(R.drawable.cat_3,"Trái cây"))
        ListDanhMuc.add(OutData(R.drawable.cat_4,"Gà & Vịt"))
        ListDanhMuc.add(OutData(R.drawable.cat_5,"Thịt heo"))


        binding.RecyDanhMuc.adapter= RecyclerViewDanhMuc(ListDanhMuc)
        binding.RecyDanhMuc.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)


    }

    private fun searchAuto() {
        //lay du lieu trong string
        val arrMonAn = resources.getStringArray(R.array.searchMonAn)
        //dung adapter de hien thi
        val adt = ArrayAdapter(this,android.R.layout.simple_list_item_1,arrMonAn)
        binding.autoTimKiem.setAdapter(adt)
    }
}