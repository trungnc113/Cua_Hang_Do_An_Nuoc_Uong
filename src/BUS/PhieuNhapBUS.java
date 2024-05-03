package BUS;

import Custom.dialog;
import java.util.ArrayList;
import java.sql.*;

import DAO.PhieuNhapDAO;
import DTO.PhieuNhap;

public class PhieuNhapBUS {

    private PhieuNhapDAO PhieuNhapDAO = new PhieuNhapDAO();

    public PhieuNhapBUS() {

    }

    public ArrayList<PhieuNhap> getList() {
        return PhieuNhapDAO.getallPhieuNhap();
    }

    public ArrayList<PhieuNhap> FindPNByPNid(int MaPN) {
        return PhieuNhapDAO.getPhieuNhapbyId(MaPN);
    }

    public ArrayList<PhieuNhap> findPNByRange(Date startDate, Date endDate, int minPrice, int maxPrice) {
        ArrayList<PhieuNhap> dspn = new ArrayList<>();
        if (startDate != null && endDate != null) {
            dspn = PhieuNhapDAO.getPhieuNhapByNgayLap(startDate, endDate);
        }

        // Filter by price range only if results are retrieved from date range search
        if (!dspn.isEmpty()) {
            ArrayList<PhieuNhap> tempList = new ArrayList<>();
            for (PhieuNhap pn : dspn) {
                if (pn.getTongTien() >= minPrice && pn.getTongTien() <= maxPrice) {
                    tempList.add(pn);
                }
            }
            dspn = tempList;
        }

        return dspn;
    }

    public boolean Insert(PhieuNhap phieuNhap) {
        if (PhieuNhapDAO.themPhieuNhap(phieuNhap)) {
            new dialog("Lập phiếu nhập thành công!", dialog.SUCCESS_DIALOG);
            return true;
        }
        new dialog("Lập phiếu nhập không thành công!", dialog.ERROR_DIALOG);
        return false;
    }

    public int getNewMaPN() {
        return PhieuNhapDAO.getNewId();
    }
    public PhieuNhap getById(int maPN){
        return PhieuNhapDAO.getById(maPN);
    }
}
