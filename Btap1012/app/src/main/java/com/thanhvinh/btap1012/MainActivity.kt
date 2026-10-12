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

        tvThongTinSinhVien = findViewById(R.id.tvThongTinSinhVien)
        etTenCongViec = findViewById(R.id.etTenCongViec)
        etMoTa = findViewById(R.id.etMoTa)
        btnTaoCongViec = findViewById(R.id.btnTaoCongViec)
        btnXemDanhSach = findViewById(R.id.btnXemDanhSach)

        btnTaoCongViec.setOnClickListener {
            val ten = etTenCongViec.text.toString().trim()
            val moTa = etMoTa.text.toString()

            // Câu 5: Báo lỗi nếu tên công việc để trống
            if (ten.isEmpty()) {
                etTenCongViec.error = "Tên công việc không được để trống!"
                return@setOnClickListener
            }

            // Tạo Object và chuyển màn hình
            val congViecMoi = CongViec(ten, moTa)
            val intent = Intent(this, ChiTietCongViecActivity::class.java)
            intent.putExtra("OBJ_CONG_VIEC", congViecMoi)
            startActivity(intent)
        }

        btnXemDanhSach.setOnClickListener {
            // Nút xem danh sách (không yêu cầu logic)
        }
    }
}