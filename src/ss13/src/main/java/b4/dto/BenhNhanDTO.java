package b4.dto;


import b4.model.DichVu;
import java.util.ArrayList;
import java.util.List;

public class BenhNhanDTO {
    private int maBenhNhan;
    private String tenBenhNhan;
    private int tuoi;
    private String gioiTinh;
    private String trangThai;
    private List<DichVu> dsDichVu;

    public BenhNhanDTO() {
        this.dsDichVu = new ArrayList<>();
    }

    public BenhNhanDTO(int maBenhNhan, String tenBenhNhan, int tuoi, String gioiTinh, String trangThai) {
        this.maBenhNhan = maBenhNhan;
        this.tenBenhNhan = tenBenhNhan;
        this.tuoi = tuoi;
        this.gioiTinh = gioiTinh;
        this.trangThai = trangThai;
        this.dsDichVu = new ArrayList<>();
    }

    public int getMaBenhNhan() {
        return maBenhNhan;
    }

    public void setMaBenhNhan(int maBenhNhan) {
        this.maBenhNhan = maBenhNhan;
    }

    public String getTenBenhNhan() {
        return tenBenhNhan;
    }

    public void setTenBenhNhan(String tenBenhNhan) {
        this.tenBenhNhan = tenBenhNhan;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public List<DichVu> getDsDichVu() {
        return dsDichVu;
    }

    public void setDsDichVu(List<DichVu> dsDichVu) {
        this.dsDichVu = dsDichVu;
    }
}
