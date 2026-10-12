package com.thanhvinh.btap1012


import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ChiTietCongViecActivity : AppCompatActivity() {

    private lateinit var tvTenCongViecChiTiet: TextView
    private lateinit var tvMoTaChiTiet: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chi_tiet_cong_viec) // Đảm bảo bạn đã tạo file XML này

        // Ánh xạ giao diện
        tvTenCongViecChiTiet = findViewById(R.id.tvTenCongViecChiTiet)
        tvMoTaChiTiet = findViewById(R.id.tvMoTaChiTiet)

        // Nhận dữ liệu từ Intent gửi qua
        val tenNhanDuoc = intent.getStringExtra("TEN_CONG_VIEC")
        val moTaNhanDuoc = intent.getStringExtra("MO_TA_CONG_VIEC")

        // Hiển thị dữ liệu lên TextView
        tvTenCongViecChiTiet.text = "Tên công việc: $tenNhanDuoc"
        tvMoTaChiTiet.text = "Mô tả: $moTaNhanDuoc"
    }
}