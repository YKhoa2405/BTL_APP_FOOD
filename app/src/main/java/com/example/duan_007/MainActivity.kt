package com.example.duan_007

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.duan_007.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnDangNhap.setOnClickListener {
            if(binding.edtName.text.toString().isEmpty() ||binding.edtPass.text.toString().isEmpty()){
                showErrorMessage("Tên đăng nhập và mật khẩu không được để trống")
            }
            else{
                startActivity(Intent(this,trangChu::class.java))
            }
        }

        binding.btnDangKy.setOnClickListener {
            startActivity(Intent(this,dangKy::class.java))
        }
    }

    private fun showErrorMessage(s: String) {
        Toast.makeText(this,s,Toast.LENGTH_SHORT).show()
    }
}