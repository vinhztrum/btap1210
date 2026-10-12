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

        // Nhận dữ liệu cũ hiển thị lên màn hình
        val congViecHienTai = intent.getSerializableExtra("OBJ_CONG_VIEC_HIEN_TAI") as? CongViec
        etSuaTenCongViec.setText(congViecHienTai?.tenCongViec)
        etSuaMoTa.setText(congViecHienTai?.moTa)

        btnLuuCongViec.setOnClickListener {
            val tenMoi = etSuaTenCongViec.text.toString().trim()

            // Câu 5: Báo lỗi nếu tên chỉnh sửa bị để trống
            if (tenMoi.isEmpty()) {
                etSuaTenCongViec.error = "Tên công việc không được để trống!"
                return@setOnClickListener
            }

            val cvSuaXong = CongViec(
                tenCongViec = tenMoi,
                moTa = etSuaMoTa.text.toString(),
                trangThai = congViecHienTai?.trangThai ?: false // Giữ nguyên trạng thái cũ
            )

            val intentTraVe = Intent()
            intentTraVe.putExtra("OBJ_CONG_VIEC_MOI", cvSuaXong)
            setResult(RESULT_OK, intentTraVe)
            finish()
        }
    }
}