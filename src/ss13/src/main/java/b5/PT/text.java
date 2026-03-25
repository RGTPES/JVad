//phân tích rủi ro & bẫy lỗi
//Ít nhất 3 tình huống dễ làm hệ thống lỗi hoặc ghi sai dữ liệu nếu không xử lý bằng Transaction và try-catch:
//
//tình huống 1: nhập sai kiểu dữ liệu
//
//Ví dụ:
//
//tuổi nhập "hai mươi" tiền tạm ứng nhập "nam tram" mã giường nhập "abc"
//
//Nếu không validate input:
//
//chương trình có thể văng NumberFormatException console bị dừng đột ngột trải nghiệm người dùng rất tệ tình huống 2: thêm bệnh nhân thành công nhưng update giường thất bại
//
//Ví dụ:
//
//đã insert bệnh nhân vào DB nhưng mất mạng hoặc lỗi SQL khi update trạng thái giường
//
//Nếu không dùng transaction:
//
//bệnh nhân đã có hồ sơ nhưng giường vẫn đang là "trong" dữ liệu sai lệch nghiêm trọng tình huống 3: đã đổi trạng thái giường nhưng chưa ghi nhận tài chính
//
//Ví dụ:
//
//insert bệnh nhân thành công update giường thành "da co nguoi" thành công nhưng insert phiếu thu tạm ứng bị lỗi
//
//Nếu không rollback:
//
//bệnh nhân có giường nhưng không có bản ghi tài chính bệnh viện thất thoát hoặc sai sổ sách tình huống 4: chọn giường không tồn tại hoặc giường đã có người
//
//Nếu không kiểm tra:
//
//executeUpdate() có thể trả về 0 JDBC không tự ném lỗi nếu vẫn commit thì giao dịch vô nghĩa tình huống 5: tiền tạm ứng âm hoặc bằng 0
//
//Ví dụ nhập:
//
//        -500000 0
//
//Nếu không chặn:
//
//hệ thống vẫn lưu dữ liệu vô lý báo cáo tài chính sai