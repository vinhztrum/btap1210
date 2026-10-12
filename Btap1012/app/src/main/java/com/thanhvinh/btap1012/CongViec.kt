package com.thanhvinh.btap1012

import java.io.Serializable

class CongViec(
    var tenCongViec: String,
    var moTa: String,
    var trangThai: Boolean = false,
    var mucDoUuTien: String = "Trung bình" // Bổ sung trường ưu tiên
) : Serializable {

    fun layThongTin(): String {
        val stt = if (trangThai) "Đã hoàn thành" else "Chưa hoàn thành"
        return "Tên công việc: $tenCongViec\nMô tả: $moTa\nƯu tiên: $mucDoUuTien\nTrạng thái: $stt"
    }
}