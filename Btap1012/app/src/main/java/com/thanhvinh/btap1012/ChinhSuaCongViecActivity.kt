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

        // Ánh xạ các thành phần giao diện
        etSuaTenCongViec = findViewById(R.id.etSuaTenCongViec)
        etSuaMoTa = findViewById(R.id.etSuaMoTa)
        btnLuuCongViec = findViewById(R.id.btnLuuCongViec)

        // Nhận Object CongViec hiện tại từ ChiTietCongViecActivity để điền lên giao diện
        val congViecHienTai = intent.getSerializableExtra("OBJ_CONG_VIEC_HIEN_TAI") as? CongViec

        // Hiển thị dữ liệu cũ lên EditText để người dùng sửa
        etSuaTenCongViec.setText(congViecHienTai?.tenCongViec)
        etSuaMoTa.setText(congViecHienTai?.moTa)

        // Xử lý sự kiện khi bấm nút Lưu
        btnLuuCongViec.setOnClickListener {
            // Lấy dữ liệu mới nhập và đóng gói thành một Object CongViec mới
            val cvSuaXong = CongViec(
                tenCongViec = etSuaTenCongViec.text.toString(),
                moTa = etSuaMoTa.text.toString(),
                trangThai = congViecHienTai?.trangThai ?: false // Giữ nguyên trạng thái hoàn thành cũ
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