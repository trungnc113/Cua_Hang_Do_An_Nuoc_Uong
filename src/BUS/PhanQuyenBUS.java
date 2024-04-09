/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.PhanQuyenDAO;
import DTO.PhanQuyen;

/**
 *
 * @author nguye
 */
public class PhanQuyenBUS {
    public static PhanQuyen currentQuyen=null;
    private PhanQuyenDAO phanQuyenDAO=new PhanQuyenDAO();

    public PhanQuyenBUS() {
    }
    
    public void UpdateCurrentQuyen(){
        if(DangNhapBUS.taiKhoanLogin==null) return;
        int maQuyen=DangNhapBUS.taiKhoanLogin.getMaQuyen();
        PhanQuyen phanQuyentmp=new PhanQuyen();
        phanQuyentmp.setMaQuyen(maQuyen);
        this.currentQuyen=phanQuyenDAO.selectById(phanQuyentmp);
    }
}
