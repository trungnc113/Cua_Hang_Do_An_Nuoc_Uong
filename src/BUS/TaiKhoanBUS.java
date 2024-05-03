package BUS;
import DAO.TaiKhoanDAO;
import DTO.TaiKhoan;
import Custom.dialog;

public class TaiKhoanBUS {

    private TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAO();

    public String getTenDangNhapTheoMa(String ma) {
        int maNV = Integer.parseInt(ma);
        return taiKhoanDAO.layTenDangNhapTheoMa(maNV);
    }

    public String getQuyenTheoMa(String ma) {
        int maNV = Integer.parseInt(ma);
        return taiKhoanDAO.layQuyenTheoMa(maNV);
    }

    public void datLaiMatKhau(String ma, String tenDangNhap) {
        int maNV = Integer.parseInt(ma);
        boolean flag = taiKhoanDAO.datLaiMatKhau(maNV, tenDangNhap);
        if (flag) {
            new dialog("Đặt lại thành công! Mật khẩu mới là: " + tenDangNhap, dialog.SUCCESS_DIALOG);
        } else {
            new dialog("Đặt lại thất bại!", dialog.ERROR_DIALOG);
        }
    }

    public void datLaiQuyen(String ma, String quyen) {
        int maNV = Integer.parseInt(ma);
        boolean flag = taiKhoanDAO.datLaiQuyen(maNV, quyen);
        if (flag) {
            new dialog("Đặt lại thành công!", dialog.SUCCESS_DIALOG);
        } else {
            new dialog("Đặt lại thất bại!", dialog.ERROR_DIALOG);
        }
    }

    public boolean kiemTraTrungTenDangNhap(String tenDangNhap) {
        return taiKhoanDAO.kiemTraTrungTenDangNhap(tenDangNhap);
    }

    public boolean themTaiKhoan(String ma, String tenDangNhap, int maquyen) {
        int maNV = Integer.parseInt(ma);
        if (tenDangNhap.trim().equals("")) {
            new dialog("Không được để trống Tên đăng nhập!", dialog.ERROR_DIALOG);
            return false;
        }
        if (kiemTraTrungTenDangNhap(tenDangNhap)) {
            dialog dlg = new dialog("Tên đăng nhập bị trùng! Có thể tài khoản bị khoá, thực hiện mở khoá?", dialog.WARNING_DIALOG);
            if (dlg.getAction() == dialog.OK_OPTION) {
                moKhoaTaiKhoan(ma);
                return true;
            }
            return false;
        }
        TaiKhoan tk = new TaiKhoan(maNV,maquyen , tenDangNhap,tenDangNhap, 1);
        boolean flag = taiKhoanDAO.insert(tk);
        if (flag) {
            new dialog("Cấp tài khoản thành công! Mật khẩu là " + tenDangNhap, dialog.SUCCESS_DIALOG);
        } else {
            new dialog("Cấp tài khoản thất bại! Tài khoản đã tồn tại", dialog.ERROR_DIALOG);
        }
        return flag;
    }

    public void khoaTaiKhoan(String ma) {
        int maNV = Integer.parseInt(ma);
        boolean flag = taiKhoanDAO.khoaTaiKhoan(maNV);
        if (flag) {
            new dialog("Khoá tài khoản thành công!", dialog.SUCCESS_DIALOG);
        } else {
            new dialog("Khoá tài khoản thất bại!", dialog.ERROR_DIALOG);
        }
    }

    public void moKhoaTaiKhoan(String ma) {
        int maNV = Integer.parseInt(ma);
        boolean flag = taiKhoanDAO.moKhoaTaiKhoan(maNV);
        if (flag) {
            new dialog("Mở khoá tài khoản thành công!", dialog.SUCCESS_DIALOG);
        } else {
            new dialog("Mở khoá tài khoản thất bại!", dialog.ERROR_DIALOG);
        }
    }

    public boolean doiMatKhau(String matKhauCu, String matKhauMoi, String nhapLaiMatKhau) {
        if(!matKhauMoi.equals(nhapLaiMatKhau)) {
            new dialog("Mật khẩu mới không khớp!", dialog.ERROR_DIALOG);
            return false;
        }
        boolean flag = taiKhoanDAO.doiMatKhau(matKhauCu, matKhauMoi);
        if (flag) {
            new dialog("Đổi thành công!", dialog.SUCCESS_DIALOG);
        } else {
            new dialog("Mật khẩu cũ nhập sai!", dialog.ERROR_DIALOG);
        }
        return flag;
    }
    
    public int getTrangThai(String maNV) {
        int ma = Integer.parseInt(maNV);
        return taiKhoanDAO.getTrangThai(ma);
    }

}
