package com.thanhvinh.btap1012

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var tvThongTinSinhVien: TextView
    private lateinit var etTenCongViec: EditText
    private lateinit var etMoTa: EditText
    private lateinit var btnTaoCongViec: Button
    private lateinit var btnXemDanhSach: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Ánh xạ các thành phần giao diện
        tvThongTinSinhVien = findViewById(R.id.tvThongTinSinhVien)
        etTenCongViec = findViewById(R.id.etTenCongViec)
        etMoTa = findViewById(R.id.etMoTa)
        btnTaoCongViec = findViewById(R.id.btnTaoCongViec)
        btnXemDanhSach = findViewById(R.id.btnXemDanhSach)

        // Xử lý sự kiện khi bấm nút Tạo công việc
        btnTaoCongViec.setOnClickListener {
            val ten = etTenCongViec.text.toString()
            val moTa = etMoTa.text.toString()

            // Tạo đối tượng CongViec (Câu 4)
            val congViecMoi = CongViec(ten, moTa)

            // Tạo Intent và truyền nguyên đối tượng qua màn hình ChiTietCongViecActivity
            val intent = Intent(this, ChiTietCongViecActivity::class.java)
            intent.putExtra("OBJ_CONG_VIEC", congViecMoi)

            startActivity(intent)
        }

        // Xử lý nút xem danh sách (Đề không yêu cầu xử lý logic màn hình này nên để trống)
        btnXemDanhSach.setOnClickListener {

        }
    }
}