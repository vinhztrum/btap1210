package com.thanhvinh.btap1012

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class ChiTietCongViecActivity : AppCompatActivity() {

    private lateinit var tvTenCongViecChiTiet: TextView
    private lateinit var tvMoTaChiTiet: TextView
    private lateinit var btnChinhSua: Button

    // Biến lưu trữ trạng thái hiện tại của công việc
    private var tenHienTai: String? = ""
    private var moTaHienTai: String? = ""

    // ĐĂNG KÝ ACTIVITY RESULT API (Bắt buộc phải để ngoài onCreate)
    private val dangKySuaCongViec = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            val dataTraVe = result.data

            // Lấy dữ liệu mới từ intentTraVe của ChinhSuaCongViecActivity
            tenHienTai = dataTraVe?.getStringExtra("TEN_MOI")
            moTaHienTai = dataTraVe?.getStringExtra("MO_TA_MOI")

            // Cập nhật lại giao diện với chữ mới
            tvTenCongViecChiTiet.text = "Tên công việc: $tenHienTai"
            tvMoTaChiTiet.text = "Mô tả: $moTaHienTai"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chi_tiet_cong_viec)

        // Ánh xạ giao diện
        tvTenCongViecChiTiet = findViewById(R.id.tvTenCongViecChiTiet)
        tvMoTaChiTiet = findViewById(R.id.tvMoTaChiTiet)
        btnChinhSua = findViewById(R.id.btnChinhSua) // Nút này phải có trong file activity_chi_tiet_cong_viec.xml

        // Nhận dữ liệu ban đầu từ MainActivity gửi qua
        tenHienTai = intent.getStringExtra("TEN_CONG_VIEC")
        moTaHienTai = intent.getStringExtra("MO_TA_CONG_VIEC")

        // Hiển thị dữ liệu lên TextView lần đầu
        tvTenCongViecChiTiet.text = "Tên công việc: $tenHienTai"
        tvMoTaChiTiet.text = "Mô tả: $moTaHienTai"

        // Xử lý sự kiện bấm nút Chỉnh sửa
        btnChinhSua.setOnClickListener {
            val intent = Intent(this, ChinhSuaCongViecActivity::class.java)
            // Gửi dữ liệu hiện tại sang cho màn hình Sửa
            intent.putExtra("TEN_HIEN_TAI", tenHienTai)
            intent.putExtra("MO_TA_HIEN_TAI", moTaHienTai)

            // Dùng launcher đã đăng ký ở trên để gọi Activity (Không dùng startActivity)
            dangKySuaCongViec.launch(intent)
        }
    }
}