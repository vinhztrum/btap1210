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

        // Ánh xạ các thành phần
        tvThongTinSinhVien = findViewById(R.id.tvThongTinSinhVien)
        etTenCongViec = findViewById(R.id.etTenCongViec)
        etMoTa = findViewById(R.id.etMoTa)
        btnTaoCongViec = findViewById(R.id.btnTaoCongViec)
        btnXemDanhSach = findViewById(R.id.btnXemDanhSach)

        // XỬ LÝ CÂU 2: Nhấn nút Tạo công việc và dùng Intent truyền dữ liệu
        btnTaoCongViec.setOnClickListener {
            // Lấy chuỗi văn bản người dùng đã nhập
            val ten = etTenCongViec.text.toString()
            val moTa = etMoTa.text.toString()

            // Tạo Intent để chuyển từ MainActivity sang ChiTietCongViecActivity
            val intent = Intent(this, ChiTietCongViecActivity::class.java)

            // Gói dữ liệu vào Intent bằng putExtra
            intent.putExtra("TEN_CONG_VIEC", ten)
            intent.putExtra("MO_TA_CONG_VIEC", moTa)

            // Bắt đầu chuyển màn hình
            startActivity(intent)
        }

        btnXemDanhSach.setOnClickListener {
            // Nút này chưa có yêu cầu xử lý
        }
    }
}
