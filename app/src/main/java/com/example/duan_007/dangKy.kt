package com.example.duan_007

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class dangKy : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dang_ky)

        var edtName = findViewById<EditText>(R.id.edtNameDangKy)
        var edtPass = findViewById<EditText>(R.id.edtPassDangKy)
        var edtAgPass = findViewById<EditText>(R.id.edtPassAgDangKy)
        var btnDangKy =findViewById<Button>(R.id.btnDangKyThanhCong)

        btnDangKy.setOnClickListener {
            if(edtName.text.toString().isEmpty()||edtPass.text.toString().isEmpty()||edtAgPass.text.toString().isEmpty())
            {
                showMessage("Không được để trống thông tin")
            }
            else if (edtPass.text.toString() != edtAgPass.text.toString()){
                Toast.makeText(this,"Mật khẩu không hợp lệ",Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(this,"Đăng ký thành công",Toast.LENGTH_SHORT).show()
                startActivity(Intent(this,MainActivity::class.java))
            }
        }
    }


    private fun showMessage(s: String) {
        Toast.makeText(this,s,Toast.LENGTH_SHORT).show()
    }
}