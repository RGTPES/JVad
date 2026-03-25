//phan 1 - phan tich logic
//van de
//he thong bi loi: thuoc da bi tru trong kho nhung khong co ban ghi lich su.
//
//nguyen nhan chinh
//mac dinh trong jdbc, connection chay o che do auto-commit = true.
//
//dieu nay co nghia:
//
//moi cau lenh executeUpdate() duoc xem la mot transaction rieng
//sau khi chay xong se tu dong commit ngay
//luong chay cua chuong trinh
//chay lenh update kho thuoc -> executeUpdate() -> database commit ngay lap tuc
//
//xay ra loi runtime (10 / 0) -> chuong trinh bi dung
//
//lenh insert lich su khong duoc chay
//
//ket qua
//kho thuoc da bi tru (vi da commit)
//lich su khong duoc luu -> du lieu bi sai lech (mat toan ven)
//ket luan
//hai cau lenh sql khong duoc dat trong cung mot transaction.
//
//can phai:
//
//tat auto-commit
//dung commit khi thanh cong
//dung rollback khi loi
//de dam bao: tat ca thanh cong hoac tat ca bi huy (all or nothing)