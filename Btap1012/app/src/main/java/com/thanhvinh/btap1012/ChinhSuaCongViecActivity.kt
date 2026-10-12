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

        // Ánh xạ các thành phần giao diện
        etSuaTenCongViec = findViewById(R.id.etSuaTenCongViec)
        etSuaMoTa = findViewById(R.id.etSuaMoTa)
        rgUuTien = findViewById(R.id.rgUuTien)
        rbThap = findViewById(R.id.rbThap)
        rbTrungBinh = findViewById(R.id.rbTrungBinh)
        rbCao = findViewById(R.id.rbCao)
        btnLuuCongViec = findViewById(R.id.btnLuuCongViec)

        // Nhận Object CongViec hiện tại để điền lên giao diện
        val congViecHienTai = intent.getSerializableExtra("OBJ_CONG_VIEC_HIEN_TAI") as? CongViec

        etSuaTenCongViec.setText(congViecHienTai?.tenCongViec)
        etSuaMoTa.setText(congViecHienTai?.moTa)

        // Hiển thị mức độ ưu tiên hiện tại
        when (congViecHienTai?.mucDoUuTien) {
            "Thấp" -> rbThap.isChecked = true
            "Cao" -> rbCao.isChecked = true
            else -> rbTrungBinh.isChecked = true // Trung bình hoặc mặc định
        }

        // Xử lý sự kiện khi bấm nút Lưu
        btnLuuCongViec.setOnClickListener {
            val tenMoi = etSuaTenCongViec.text.toString()

            // Kiểm tra: Nếu tên để trống hoặc chỉ chứa khoảng trắng thì báo lỗi và dừng lại
            if (tenMoi.isBlank()) {
                etSuaTenCongViec.error = "Tên công việc không hợp lệ (không được để trống)!"
                return@setOnClickListener
            }

            // Lấy mức độ ưu tiên được chọn mới
            val uuTienMoi = when (rgUuTien.checkedRadioButtonId) {
                R.id.rbThap -> "Thấp"
                R.id.rbCao -> "Cao"
                else -> "Trung bình"
            }

            // Lấy dữ liệu mới và đóng gói thành Object CongViec (lưu ý dùng tenMoi.trim() để bỏ khoảng trắng thừa)
            val cvSuaXong = CongViec(
                tenCongViec = tenMoi.trim(),
                moTa = etSuaMoTa.text.toString(),
                trangThai = congViecHienTai?.trangThai ?: false, // Giữ nguyên trạng thái cũ
                mucDoUuTien = uuTienMoi // Thêm mức độ ưu tiên mới
            )

            // Dùng Intent để gói Object trả về
            val intentTraVe = Intent()
            intentTraVe.putExtra("OBJ_CONG_VIEC_MOI", cvSuaXong)

            // Đặt Result là OK và gắn intent mang dữ liệu trả về
            setResult(RESULT_OK, intentTraVe)

            // Đóng Activity này để quay về màn hình Chi tiết
            finish()
        }
    }
}