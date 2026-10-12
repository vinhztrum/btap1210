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

    // Đổi thành dùng Object thay vì String rời rạc
    private lateinit var congViecHienTai: CongViec

    private val dangKySuaCongViec = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            val dataTraVe = result.data
            // Nhận object mới sửa từ bên kia về
            val cvMoi = dataTraVe?.getSerializableExtra("OBJ_CONG_VIEC_MOI") as? CongViec

            if (cvMoi != null) {
                congViecHienTai = cvMoi
                // Gọi hàm layThongTin() từ class để hiển thị thẳng lên 1 TextView
                tvTenCongViecChiTiet.text = congViecHienTai.layThongTin()
                tvMoTaChiTiet.text = "" // Xóa rỗng text này vì hàm trên đã gộp chung tên và mô tả
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chi_tiet_cong_viec)

        tvTenCongViecChiTiet = findViewById(R.id.tvTenCongViecChiTiet)
        tvMoTaChiTiet = findViewById(R.id.tvMoTaChiTiet)
        btnChinhSua = findViewById(R.id.btnChinhSua)

        // Nhận Object từ MainActivity
        congViecHienTai = intent.getSerializableExtra("OBJ_CONG_VIEC") as CongViec

        // Hiển thị thông qua hàm của class
        tvTenCongViecChiTiet.text = congViecHienTai.layThongTin()
        tvMoTaChiTiet.text = ""

        btnChinhSua.setOnClickListener {
            val intent = Intent(this, ChinhSuaCongViecActivity::class.java)
            // Gửi Object hiện tại qua màn hình Sửa
            intent.putExtra("OBJ_CONG_VIEC_HIEN_TAI", congViecHienTai)
            dangKySuaCongViec.launch(intent)
        }
    }
}