package com.thanhvinh.btap1012

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity

class ChinhSuaCongViecActivity : AppCompatActivity() {

    private lateinit var etSuaTenCongViec: EditText
    private lateinit var etSuaMoTa: EditText
    private lateinit var rgUuTien: RadioGroup
    private lateinit var rbThap: RadioButton
    private lateinit var rbTrungBinh: RadioButton
    private lateinit var rbCao: RadioButton
    private lateinit var btnLuuCongViec: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chinh_sua_cong_viec)

        etSuaTenCongViec = findViewById(R.id.etSuaTenCongViec)
        etSuaMoTa = findViewById(R.id.etSuaMoTa)
        rgUuTien = findViewById(R.id.rgUuTien)
        rbThap = findViewById(R.id.rbThap)
        rbTrungBinh = findViewById(R.id.rbTrungBinh)
        rbCao = findViewById(R.id.rbCao)
        btnLuuCongViec = findViewById(R.id.btnLuuCongViec)

        // Nhận dữ liệu cũ hiển thị lên màn hình
        val congViecHienTai = intent.getSerializableExtra("OBJ_CONG_VIEC_HIEN_TAI") as? CongViec
        etSuaTenCongViec.setText(congViecHienTai?.tenCongViec)
        etSuaMoTa.setText(congViecHienTai?.moTa)

        // 2. Hiển thị mức độ ưu tiên hiện tại
        when (congViecHienTai?.mucDoUuTien) {
            "Thấp" -> rbThap.isChecked = true
            "Cao" -> rbCao.isChecked = true
            else -> rbTrungBinh.isChecked = true
        }

        btnLuuCongViec.setOnClickListener {
            // Sẽ bổ sung phần check rỗng ở Commit 3

            val tenMoi = etSuaTenCongViec.text.toString()

            // Lấy mức độ ưu tiên mới từ RadioGroup
            val uuTienMoi = when (rgUuTien.checkedRadioButtonId) {
                R.id.rbThap -> "Thấp"
                R.id.rbCao -> "Cao"
                else -> "Trung bình"
            }

            // 3. Trả về cả tên, mô tả và mức độ ưu tiên
            val cvSuaXong = CongViec(
                tenCongViec = tenMoi,
                moTa = etSuaMoTa.text.toString(),
                trangThai = congViecHienTai?.trangThai ?: false,
                mucDoUuTien = uuTienMoi
            )

            val intentTraVe = Intent()
            intentTraVe.putExtra("OBJ_CONG_VIEC_MOI", cvSuaXong)
            setResult(RESULT_OK, intentTraVe)
            finish()
        }
    }
}