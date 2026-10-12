package com.thanhvinh.btap1012

import java.io.Serializable

class CongViec(
    var tenCongViec: String,
    var moTa: String,
    var trangThai: Boolean = false
) : Serializable {

    // Hàm trả về chuỗi thông tin công việc
    fun layThongTin(): String {
        val stt = if (trangThai) "Đã hoàn thành" else "Chưa hoàn thành"
        return "Tên công việc: $tenCongViec\nMô tả: $moTa\nTrạng thái: $stt"
    }
}