//phan 1 - phan tich logic
//van de
//he thong thanh toan bi loi: tien da bi tru trong vi nhung hoa don khong duoc cap nhat.
//
//hien trang code
//da tat auto-commit: conn.setAutoCommit(false)
//co nhieu thao tac trong cung 1 transaction
//khi loi xay ra chi in ra loi bang System.out.println()
//nguyen nhan
//khi xay ra SQLException:
//
//chuong trinh nhay vao khoi catch
//chi in loi ra man hinh
//khong thuc hien rollback
//vi sao vi pham nguyen tac transaction
//transaction co nguyen tac:
//
//thanh cong toan bo -> commit
//that bai bat ky buoc nao -> rollback
//nhung o day:
//
//thao tac 1 (tru tien) da chay thanh cong
//thao tac 2 (cap nhat hoa don) bi loi
//khong rollback
//=> du lieu bi ghi mot phan (partial update)
//
//hau qua
//tien da bi tru khoi vi
//hoa don van chua thanh toan
//du lieu khong dong bo
//gay sai lech nghiep vu va mat toan ven du lieu
//hanh dong thiet yeu bi bo quen
//khong goi conn.rollback() khi xay ra loi
//ket luan
//khi dung transaction (auto-commit = false), bat buoc:
//
//commit khi thanh cong
//rollback khi loi
//neu khong rollback, database se bi giu o trang thai khong an toan