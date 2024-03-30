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

/**
 *
 * @author nguye
 */
public class CTPhieuNhapDAO {
     String url ="jdbc:sqlserver://LAPTOP-PHANLOC:1433;databaseName=quanlythucannhanh;encrypt= true;trustServerCertificate=true";
        String username = "sa";
        String password = "123456";
    // Phương thức lấy danh sách chi tiết phiếu nhập dựa trên mã phiếu nhập
    public ArrayList<CTPhieuNhap> getListCTPhieuNhapByMaPN(int maPN) {
        ArrayList<CTPhieuNhap> dsctpn = new ArrayList<>();
        // Thực hiện kết nối cơ sở dữ liệu và truy vấn dữ liệu
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
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

    // Phương thức thêm một chi tiết phiếu nhập mới vào cơ sở dữ liệu
    public boolean addCTPhieuNhap(CTPhieuNhap ctpn) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "INSERT INTO ctphieunhap (MaPN, MaSP, SoLuong, DonGia) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, ctpn.getMaPN());
            stmt.setInt(2, ctpn.getMaSP());
            stmt.setInt(3, ctpn.getSoLuong());
            stmt.setInt(4, ctpn.getDonGia());
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    // Phương thức cập nhật thông tin một chi tiết phiếu nhập trong cơ sở dữ liệu
    public boolean updateCTPhieuNhap(CTPhieuNhap ctpn) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "UPDATE ctphieunhap SET SoLuong = ?, DonGia = ? WHERE MaPN = ? AND MaSP = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, ctpn.getSoLuong());
            stmt.setInt(2, ctpn.getDonGia());
            stmt.setInt(3, ctpn.getMaPN());
            stmt.setInt(4, ctpn.getMaSP());
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    // Phương thức xóa một chi tiết phiếu nhập khỏi cơ sở dữ liệu
    public boolean deleteCTPhieuNhap(int maPN, int maSP) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "DELETE FROM ctphieunhap WHERE MaPN = ? AND MaSP = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, maPN);
            stmt.setInt(2, maSP);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    public CTPhieuNhap timkiemCTPhieuNhap(int maPN, int maSP) {
        CTPhieuNhap ctpn = null;
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT * FROM ctphieunhap WHERE MaPN = ? AND MaSP = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, maPN);
            stmt.setInt(2, maSP);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                ctpn = new CTPhieuNhap();
                ctpn.setMaPN(rs.getInt("MaPN"));
                ctpn.setMaSP(rs.getInt("MaSP"));
                ctpn.setSoLuong(rs.getInt("SoLuong"));
                ctpn.setDonGia(rs.getInt("DonGia"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ctpn;
    }
}
