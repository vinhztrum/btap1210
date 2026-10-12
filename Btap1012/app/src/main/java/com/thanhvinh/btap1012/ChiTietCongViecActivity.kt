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
    private lateinit var btnHoanThanh: Button

    private lateinit var congViecHienTai: CongViec

    // Hứng kết quả từ màn hình chỉnh sửa trả về
    private val dangKySuaCongViec = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            val dataTraVe = result.data
            val cvMoi = dataTraVe?.getSerializableExtra("OBJ_CONG_VIEC_MOI") as? CongViec

            if (cvMoi != null) {
                congViecHienTai = cvMoi // Ghi đè object cũ bằng object mới
                tvTenCongViecChiTiet.text = congViecHienTai.layThongTin()
                tvMoTaChiTiet.text = ""
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chi_tiet_cong_viec)

        tvTenCongViecChiTiet = findViewById(R.id.tvTenCongViecChiTiet)
        tvMoTaChiTiet = findViewById(R.id.tvMoTaChiTiet)
        btnChinhSua = findViewById(R.id.btnChinhSua)
        btnHoanThanh = findViewById(R.id.btnHoanThanh)

        // Nhận Object từ MainActivity
        congViecHienTai = intent.getSerializableExtra("OBJ_CONG_VIEC") as CongViec

        // Hiển thị lần đầu
        tvTenCongViecChiTiet.text = congViecHienTai.layThongTin()
        tvMoTaChiTiet.text = ""

        // Câu 5: Đánh dấu hoàn thành
        btnHoanThanh.setOnClickListener {
            congViecHienTai.trangThai = true
            tvTenCongViecChiTiet.text = congViecHienTai.layThongTin()
        }

        // Chuyển sang màn hình sửa
        btnChinhSua.setOnClickListener {
            val intent = Intent(this, ChinhSuaCongViecActivity::class.java)
            intent.putExtra("OBJ_CONG_VIEC_HIEN_TAI", congViecHienTai)
            dangKySuaCongViec.launch(intent)
        }
    }
}