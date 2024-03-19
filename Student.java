public class Student {
    private String MSV;
    private String hoTen;
    private String gioiTinh;
    private double diemPython;
    private double diemJava;
    private double diemtb;
    private String kqua;
    public Student() {}
    public Student(String MSV, String hoTen, String gioiTinh, double diemPython, double diemJava) {
        this.MSV = MSV;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.diemPython = diemPython;
        this.diemJava = diemJava;
        this.diemtb = (diemJava*2 + diemPython)/3;
        this.kqua = checkKQ();
    }
    public String getMSV() {
        return MSV;
    }
    public String getHoTen() {
        return hoTen;
    }
    public String getGioiTinh() {
        return gioiTinh;
    }
    public double getDiemPython() {
        return diemPython;
    }
    public double getDiemJava() {
        return diemJava;
    }
    public double getDiemtb() {
        return diemtb;
    }
    public String getKqua() {
        return kqua;
    }
    public String checkKQ() {
        if(this.diemtb>=5) {
            return "Dau";
        } else if("nam".equals(gioiTinh)) {
            return "Truot";
        } else {
            return "Dau";
        }
    }
    @Override
    public String toString() {
        return "Student [MSV=" + MSV + ", Ho ten=" + hoTen + ", Gioi tinh=" + gioiTinh + ", Diem Python=" + diemPython + ", Diem Java="
                + diemJava + ", Diem trung binh=" + diemtb + ", Ket qua=" + kqua + "]";
    }
}
