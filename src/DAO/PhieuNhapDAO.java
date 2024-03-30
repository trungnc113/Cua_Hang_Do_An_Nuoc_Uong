/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.CTPhieuNhap;
import DTO.PhieuNhap;


/**
 *
 * @author nguye
 */
public class PhieuNhapDAO {

    public ArrayList<PhieuNhap> getListPhieuNhap() {
        
        ArrayList<PhieuNhap> dspn = new ArrayList<>();

        String url ="jdbc:sqlserver://LAPTOP-PHANLOC:1433;databaseName=quanlythucannhanh;encrypt= true;trustServerCertificate=true";
        String username = "sa";
        String password = "123456";
        try {
            
            Connection connection = DriverManager.getConnection(url,username, password);
            System.out.println("connect");
            String sql = "SELECT * FROM phieunhap";
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                PhieuNhap pn = new PhieuNhap();
                pn.setMaPN(rs.getInt(1));
                pn.setMaNCC(rs.getInt(2));
                pn.setMaNV(rs.getInt(3));
                pn.setNgayLap(rs.getDate(4));
                pn.setTongTien(rs.getInt(5));
                dspn.add(pn);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(); // Xử lý lỗi tùy ý, có thể log hoặc throw ngoại lệ.
            return null;
        }
        return dspn;
        
    }
    public boolean themPhieuNhap(PhieuNhap pn) {
        String url ="jdbc:sqlserver://LAPTOP-PHANLOC:1433;databaseName=quanlythucannhanh;encrypt= true;trustServerCertificate=true";
        String username = "sa";
        String password = "123456";
        try {
            Connection connection = DriverManager.getConnection(url,username, password);
            String sql = "INSERT INTO phieunhap (MaNCC, MaNV, NgayLap, TongTien) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, pn.getMaNCC());
            stmt.setInt(2, pn.getMaNV());
            stmt.setDate(3, new java.sql.Date(pn.getNgayLap().getTime()));
            stmt.setInt(4, pn.getTongTien());
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    public boolean capNhatPhieuNhap(PhieuNhap pn) {
        String url ="jdbc:sqlserver://LAPTOP-PHANLOC:1433;databaseName=quanlythucannhanh;encrypt= true;trustServerCertificate=true";
        String username = "sa";
        String password = "123456";
        try {
            Connection connection = DriverManager.getConnection(url,username, password);
            String sql = "UPDATE phieunhap SET MaNCC=?, MaNV=?, NgayLap=?, TongTien=? WHERE MaPN=?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, pn.getMaNCC());
            stmt.setInt(2, pn.getMaNV());
            stmt.setDate(3, new java.sql.Date(pn.getNgayLap().getTime()));
            stmt.setInt(4, pn.getTongTien());
            stmt.setInt(5, pn.getMaPN());
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    public ArrayList<CTPhieuNhap> timkiemtheomaPN(int maPN) {
        ArrayList<CTPhieuNhap> dsctpn = new ArrayList<>();
        String url ="jdbc:sqlserver://LAPTOP-PHANLOC:1433;databaseName=quanlythucannhanh;encrypt= true;trustServerCertificate=true";
        String username = "sa";
        String password = "123456";
        try  {
            Connection connection = DriverManager.getConnection(url,username,password);
            String sql = "SELECT * FROM ctphieunhap WHERE MaPN = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, maPN);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                CTPhieuNhap ctpn = new CTPhieuNhap();
                ctpn.setMaPN(rs.getInt("MaPN"));
                ctpn.setMaSP(rs.getInt("MaSP"));
                ctpn.setSoLuong(rs.getInt("SoLuong"));
                ctpn.setDonGia(rs.getInt("DonGia"));
                dsctpn.add(ctpn);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return dsctpn;
    }
    
    
    
    
}
