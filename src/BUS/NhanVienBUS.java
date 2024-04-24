/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.NhanVienDAO;
import DTO.NhanVien;

/**
 *
 * @author nguye
 */
public class NhanVienBUS {
    NhanVienDAO nhanVienDAO = new NhanVienDAO();

    public NhanVienBUS() {
    }
    public NhanVien getById(int maNV){
        return nhanVienDAO.getNhanVien(maNV);
    }
}
