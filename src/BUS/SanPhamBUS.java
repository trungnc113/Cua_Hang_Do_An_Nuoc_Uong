package BUS;
import DAO.SanPhamDAO;
import DTO.SanPham;
import Custom.dialog;
import java.util.ArrayList;

public class SanPhamBUS {
    private ArrayList<SanPham> listSP = null;  
    private SanPhamDAO spDAO = new SanPhamDAO();

    public SanPhamBUS(){
        readListSanPham();
    }

    public void readListSanPham(){
            listSP = spDAO.getDanhSachSanPham();
    }

    public ArrayList<SanPham> getListSP(){
        if(listSP == null){
            readListSanPham();
        }
        return listSP;
    }
    
    public SanPham getSP(String maSP){
            if (!maSP.trim().equals("")){
                try {
                    int ma = Integer.parseInt(maSP);
                    for (SanPham sp : listSP) {
                        if (sp.getMaSP() == ma) {
                            return sp;
                        }
                    }
                } catch (Exception e) {}
        }
        return null;
    }
    
    public String getTenSP(int maSP) {
        for (SanPham sp : listSP) {
            if (sp.getMaSP() == maSP) {
                return sp.getTenSP();
            }
        }
        return "";
    }

    public ArrayList<SanPham> getSPTheoTen(String ten){
        ArrayList<SanPham> dsSanPham = new ArrayList<>();
        for(SanPham sp: listSP){
            String tenSP = sp.getTenSP().toLowerCase();
            if (tenSP.toLowerCase().contains(ten.toLowerCase())) {
                dsSanPham.add(sp);
            }
        }
        return dsSanPham;
    }

    public ArrayList<SanPham> getSanPhamTheoLoaiSP(String maSP) {
        if (!maSP.trim().equals("")) {
            ArrayList<SanPham> dssp = new ArrayList<>();
            try {
                int maLoai = Integer.parseInt(maSP);
                for (SanPham sp : listSP) {
                    if (sp.getMaLoai() == maLoai) {
                        dssp.add(sp);
                    }
                }
                return dssp;
            } catch (Exception e) {}
        }
        return null;
    }

    public String getAnh(String maSP) {
        int ma = Integer.parseInt(maSP);

        return spDAO.getHinhAnh(ma);
    }

    public void capNhatSoLuongSP(int maSP, int SLTheoMa) {
        spDAO.capNhatSoLuongSP(maSP, SLTheoMa);
    }

    public boolean themSanPham(String tenSP,
            String loai,
            String soLuong,
            String donViTinh,
            String hinhAnh,
            String donGia,
            String TrangThai) {

        if (tenSP.trim().equals("")) {
            new dialog("Tên Sản Phẩm không được để trống!", dialog.ERROR_DIALOG);
            return false;
        }

        if (donViTinh.trim().equals("")) {
            new dialog("Vui lòng điền đơn vị tính!", dialog.ERROR_DIALOG);
            return false;
        }

        try {
            String[] loaiTmp = loai.split(" - ");
            int maLoai = Integer.parseInt(loaiTmp[0]);
            int soLuongSP = Integer.parseInt(soLuong);
            donGia = donGia.replace(",", "");
            int donGiaSP = Integer.parseInt(donGia);
            int tThai = Integer.parseInt(TrangThai);
            if (maLoai == 0) {
                new dialog("Vui lòng chọn Loại sản phẩm!", dialog.ERROR_DIALOG);
                return false;
            }
            SanPham sp = new SanPham();
            sp.setTenSP(tenSP);
            sp.setMaLoai(maLoai);
            sp.setSoLuong(soLuongSP);
            sp.setDonViTinh(donViTinh);
            sp.setHinhAnh(hinhAnh);
            sp.setDonGia(donGiaSP);
            sp.setTrangThai(tThai);

            if (spDAO.themSanPham(sp)) {
                new dialog("Thêm thành công!", dialog.SUCCESS_DIALOG);
                return true;
            } else {
                new dialog("Thêm thất bại!", dialog.ERROR_DIALOG);
                return false;
            }
        } catch (Exception e) {
            new dialog("Nhập số hợp lệ cho đơn giá và số lượng!", dialog.ERROR_DIALOG);
        }
        return false;
    }

    public boolean nhapSanPhamTuExcel(String ten,
            String loai,
            String soLuong,
            String donViTinh,
            String anh,
            String donGia,
            String tranhThai) {

        try {
            String[] loaiTmp = loai.split(" - ");
            int maLoai = Integer.parseInt(loaiTmp[0]);
            int soLuongSP = Integer.parseInt(soLuong);
            donGia = donGia.replace(",", "");
            int donGiaSP = Integer.parseInt(donGia);
            int tThai = Integer.parseInt(tranhThai);

            SanPham sp = new SanPham();
            sp.setTenSP(ten);
            sp.setMaLoai(maLoai);
            sp.setSoLuong(soLuongSP);
            sp.setDonViTinh(donViTinh);
            sp.setHinhAnh(anh);
            sp.setDonGia(donGiaSP);
            sp.setTrangThai(tThai);

            spDAO.importSanPhamFromExcel(sp);
        } catch (Exception e) {
        }
        return false;
    }

    public boolean xoaSanPham(String masp) {
        if (masp.trim().equals("")) {
            new dialog("Chưa chọn sản phẩm để xoá!", dialog.ERROR_DIALOG);
            return false;
        }

        int ma = Integer.parseInt(masp);
        if (spDAO.deleteSanPham(ma)) {
            new dialog("Xoá thành công!", dialog.SUCCESS_DIALOG);
            return true;
        }

        new dialog("Xoá thất bại!", dialog.ERROR_DIALOG);
        return false;
    }

    public boolean suaThongTinSanPham(String maSP,
            String ten,
            String loai,
            String soLuong,
            String donViTinh,
            String anh,
            String donGia,
            String trangThai) {

        try {
            if (maSP.trim().equals("")) {
                new dialog("Chưa chọn sản phẩm để sửa!", dialog.ERROR_DIALOG);
                return false;
            }
            donGia = donGia.replace(",", "");
            int ma = Integer.parseInt(maSP);
            String[] loaiTmp = loai.split(" - ");
            int maLoai = Integer.parseInt(loaiTmp[0]);
            int soLuongSP = Integer.parseInt(soLuong);
            int donGiaSP = Integer.parseInt(donGia);
            int tThai  = Integer.parseInt(trangThai);

            if (maLoai == 0) {
                new dialog("Vui lòng chọn Loại sản phẩm!", dialog.ERROR_DIALOG);
                return false;
            }

            if (ten.trim().equals("")) {
                new dialog("Tên SP không được để rỗng!", dialog.ERROR_DIALOG);
                return false;
            }

            if (donViTinh.trim().equals("")) {
                new dialog("Vui lòng điền Đơn vị tính!", dialog.ERROR_DIALOG);
                return false;
            }

            SanPham sp = new SanPham();
            sp.setMaSP(ma);
            sp.setTenSP(ten);
            sp.setMaLoai(maLoai);
            sp.setSoLuong(soLuongSP);
            sp.setDonViTinh(donViTinh);
            sp.setHinhAnh(anh);
            sp.setDonGia(donGiaSP);
            sp.setTrangThai(tThai);

            if (spDAO.updateInfoSanPham(sp)) {
                new dialog("Sửa thành công!", dialog.SUCCESS_DIALOG);
                return true;
            } else {
                new dialog("Sửa thất bại!", dialog.ERROR_DIALOG);
                return false;
            }
        } catch (Exception e) {
            new dialog(" Vui lòng nhập số hợp lệ cho đơn giá và số lượng!", dialog.ERROR_DIALOG);
        }
        return false;
    }

}
