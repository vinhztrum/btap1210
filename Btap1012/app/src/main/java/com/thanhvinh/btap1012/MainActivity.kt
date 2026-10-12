package com.thanhvinh.btap1012

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

        // Ánh xạ các thành phần từ XML thông qua id
        tvThongTinSinhVien = findViewById(R.id.tvThongTinSinhVien)
        etTenCongViec = findViewById(R.id.etTenCongViec)
        etMoTa = findViewById(R.id.etMoTa)
        btnTaoCongViec = findViewById(R.id.btnTaoCongViec)
        btnXemDanhSach = findViewById(R.id.btnXemDanhSach)

        // Thiết lập sự kiện khi nhấn nút (Logic sẽ được viết tiếp ở các câu sau)
        btnTaoCongViec.setOnClickListener {
            // Code chuyển sang màn hình Chi tiết (Intent) sẽ được viết ở Câu 2
        }

        btnXemDanhSach.setOnClickListener {
            // Nút này để trống chờ xử lý hiển thị danh sách (nếu có phát triển ở các bước sau)
        }
    }
}