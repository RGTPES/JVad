package b5.entity;


public class Bed {
    private int maGiuong;
    private String tenGiuong;
    private String trangThai;

    public Bed() {
    }

    public Bed(int maGiuong, String tenGiuong, String trangThai) {
        this.maGiuong = maGiuong;
        this.tenGiuong = tenGiuong;
        this.trangThai = trangThai;
    }

    public int getMaGiuong() {
        return maGiuong;
    }

    public void setMaGiuong(int maGiuong) {
        this.maGiuong = maGiuong;
    }

    public String getTenGiuong() {
        return tenGiuong;
    }

    public void setTenGiuong(String tenGiuong) {
        this.tenGiuong = tenGiuong;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}
