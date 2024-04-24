/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.SanPhamDAO;
import DTO.SanPham;
import java.util.ArrayList;

/**
 *
 * @author nguye
 */
public class SanPhamBUS {
    private SanPhamDAO sanPhamDAO =new SanPhamDAO();

    public SanPhamBUS() {
    }
    public ArrayList<SanPham> getList(){
        return sanPhamDAO.getDanhSachSanPham();
    }
    
    public SanPham getById(int maSP){
        return sanPhamDAO.getSanPhamTheoMa(maSP);
    }
}
