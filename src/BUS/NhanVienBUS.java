package BUS;
import DAO.NhanVienDAO;
import DTO.NhanVien;
import Custom.dialog;
import java.util.ArrayList;

public class NhanVienBUS {
    private ArrayList<NhanVien> listNV = null;
    private NhanVienDAO nvDAO = new NhanVienDAO();

    public NhanVienBUS() {
        docDanhSach();
    }

    public void docDanhSach() {
        this.listNV = nvDAO.getDanhSachNhanVien();
    }

    public ArrayList<NhanVien> getDanhSachNhanVien() {
        if (this.listNV == null)
            docDanhSach();
        return this.listNV;
    }

    public boolean themNhanVien(String ho, String ten, String gioiTinh, String dienThoai, String trangThai) {
        ho = ho.trim();
        ten = ten.trim();
        dienThoai = dienThoai.trim();
        trangThai = trangThai.trim();
        int tThai = Integer.parseInt(trangThai);
        if (ten.equals("")) {
            new dialog("Tên không được để trống!", dialog.ERROR_DIALOG);
            return false;
        }
        if (dienThoai.equals("")) {
            new dialog("Điện thoại không được để trống!", dialog.ERROR_DIALOG);
            return false;
        }
        NhanVien nv = new NhanVien();
        nv.setHo(ho);
        nv.setTen(ten);
        nv.setGioiTinh(gioiTinh);
        nv.setDienThoai(dienThoai);
        nv.setTrangThai(tThai);
        boolean flag = nvDAO.themNhanVien(nv);
        if (!flag) {
            new dialog("Thêm thất bại!", dialog.ERROR_DIALOG);
        } else {
            new dialog("Thêm thành công!", dialog.SUCCESS_DIALOG);
        }
        return flag;
    }

    public boolean updateNhanVien(String ma, String ho, String ten, String gioiTinh, String dienThoai, String trangThai) {
        int maNV = Integer.parseInt(ma);
        ho = ho.trim();
        ten = ten.trim();
        trangThai = trangThai.trim();
        int tThai = Integer.parseInt(trangThai);
        dienThoai = dienThoai.trim();
        if (ten.equals("")) {
            new dialog("Tên không được để trống!", dialog.ERROR_DIALOG);
            return false;
        }
        if (dienThoai.equals("")) {
            new dialog("Điện thoại không được để trống!", dialog.ERROR_DIALOG);
            return false;
        }
        NhanVien nv = new NhanVien();
        nv.setMaNV(maNV);
        nv.setHo(ho);
        nv.setTen(ten);
        nv.setGioiTinh(gioiTinh);
        nv.setDienThoai(dienThoai);
        nv.setTrangThai(tThai);
        boolean flag = nvDAO.updateInfoNhanVien(nv);
        if (!flag) {
            new dialog("Cập nhập thất bại!", dialog.ERROR_DIALOG);
        } else {
            new dialog("Cập nhập thành công!", dialog.SUCCESS_DIALOG);
        }
        return flag;
    }

    public ArrayList<NhanVien> timNhanVien(String tuKhoa) {
        tuKhoa = tuKhoa.toLowerCase();
        ArrayList<NhanVien> dsnv = new ArrayList<>();
        for (NhanVien nv : listNV) {
            if (nv.getHo().toLowerCase().contains(tuKhoa) || nv.getTen().toLowerCase().contains(tuKhoa) ||
                    nv.getGioiTinh().toLowerCase().contains(tuKhoa) || nv.getDienThoai().contains(tuKhoa)) {
                dsnv.add(nv);
            }
        }
        return dsnv;
    }

    public boolean xoaNhanVien(String ma) {
        try {
            int maNV = Integer.parseInt(ma);
            dialog dlg = new dialog("Bạn có chắc chắn muốn xoá không?", dialog.WARNING_DIALOG);
            boolean flag = false;
            if (dlg.getAction() == dialog.OK_OPTION) {
                flag = nvDAO.deleteNhanVien(maNV);
                if (flag) {
                    new dialog("Xoá thành công!", dialog.SUCCESS_DIALOG);
                } else {
                    new dialog("Xoá thất bại!", dialog.ERROR_DIALOG);
                }
            }
            return flag;
        } catch (Exception e) {
            new dialog("Bạn chưa chọn nhân viên!", dialog.ERROR_DIALOG);
        }
        return false;
    }

    public boolean nhapExcel(String ho, String ten, String gioiTinh, String dienThoai, String trangThai) {
        int tThai = Integer.parseInt(trangThai);
        NhanVien nv = new NhanVien();
        nv.setHo(ho);
        nv.setTen(ten);
        nv.setGioiTinh(gioiTinh);
        nv.setDienThoai(dienThoai);
        nv.setTrangThai(tThai);
        boolean flag = nvDAO.importNhanVienFromExcel(nv);
        return flag;
    }
    
    public ArrayList<NhanVien> getList(){
        return nvDAO.getDanhSachNhanVien();
    }
    
    public NhanVien getById(int maNV){
        return nvDAO.getNhanVien(maNV);
    }
}
