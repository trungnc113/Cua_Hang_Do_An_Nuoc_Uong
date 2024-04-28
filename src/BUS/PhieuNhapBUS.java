/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import java.util.ArrayList;
// import java.util.Date;
import java.sql.*;

import DAO.PhieuNhapDAO;
import DTO.PhieuNhap;
import demoGUI.phieunhap;

/**
 *
 * @author nguye
 */
public class PhieuNhapBUS {
    private PhieuNhapDAO PhieuNhapDAO = new PhieuNhapDAO();
    public PhieuNhapBUS(){

    }
    public ArrayList<PhieuNhap> getList(){
        return PhieuNhapDAO.getallPhieuNhap();
    }
    public ArrayList<PhieuNhap> FindPNByPNid(int MaPN){
        return PhieuNhapDAO.getPhieuNhapbyId(MaPN);
    }
   public ArrayList<PhieuNhap> findPNByRange(Date startDate,Date endDate, int minPrice, int maxPrice) {
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
}
