package com.thanhvinh.btap1012

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class ChinhSuaCongViecActivity : AppCompatActivity() {

    private lateinit var etSuaTenCongViec: EditText
    private lateinit var etSuaMoTa: EditText
    private lateinit var btnLuuCongViec: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chinh_sua_cong_viec)

        etSuaTenCongViec = findViewById(R.id.etSuaTenCongViec)
        etSuaMoTa = findViewById(R.id.etSuaMoTa)
        btnLuuCongViec = findViewById(R.id.btnLuuCongViec)

        // Nhận dữ liệu hiện tại để hiển thị lên EditText
        val tenHienTai = intent.getStringExtra("TEN_HIEN_TAI")
        val moTaHienTai = intent.getStringExtra("MO_TA_HIEN_TAI")
        etSuaTenCongViec.setText(tenHienTai)
        etSuaMoTa.setText(moTaHienTai)

        // Xử lý nút Lưu
        btnLuuCongViec.setOnClickListener {
            // Lấy dữ liệu mới nhập
            val tenMoi = etSuaTenCongViec.text.toString()
            val moTaMoi = etSuaMoTa.text.toString()

            // Dùng Intent để gói dữ liệu trả về (không dùng startActivity)
            val intentTraVe = Intent()
            intentTraVe.putExtra("TEN_MOI", tenMoi)
            intentTraVe.putExtra("MO_TA_MOI", moTaMoi)

            // Đặt Result là OK và gắn intent mang dữ liệu
            setResult(RESULT_OK, intentTraVe)

            // Đóng Activity này để quay về màn hình Chi tiết
            finish()
        }
    }
}