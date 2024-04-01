/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Custom.JDBCUtil;
import DTO.KhachHang;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author nguye
 */
public class KhachHangDAO {
    public ArrayList<KhachHang> getListKhachHang() {
        try {
            String sql = "SELECT * FROM KhachHang WHERE TinhTrang=1";
            PreparedStatement pre = JDBCUtil.getConnection().prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            ArrayList<KhachHang> dskh = new ArrayList<>();
            while (rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setMaKH(rs.getInt(1));
                kh.setHo(rs.getString(2));
                kh.setTen(rs.getString(3));
                kh.setGioiTinh(rs.getString(4));
                kh.setDienThoai(rs.getString(5));
                kh.setTongChiTieu(rs.getInt(6));
                kh.setTrangThai(rs.getInt(7));
                dskh.add(kh);
            }
            return dskh;
        } catch (SQLException ex) {
        }
        return null;
    }
    public KhachHang getKhachHang(int maKH) {
        KhachHang kh = null;
        try {
            String sql = "SELECT * FROM khachhang WHERE MaKH=? AND TinhTrang=1";
            PreparedStatement prep = JDBCUtil.getConnection().prepareStatement(sql);
            prep.setInt(1, maKH);
            ResultSet rs = prep.executeQuery();
            while (rs.next()) {
                kh = new KhachHang();
                kh.setMaKH(rs.getInt(1));
                kh.setHo(rs.getString(2));
                kh.setTen(rs.getString(3));
                kh.setGioiTinh(rs.getString(4));
                kh.setDienThoai(rs.getString(5));
                kh.setTongChiTieu(rs.getInt(6));
                kh.setTrangThai(rs.getInt(7));
            }
        } catch (SQLException ex) {
            return null;
        }
        return kh;
    }
    public boolean addKhachHang(KhachHang kh) {
        boolean result = false;
        try {
            String sql = "INSERT INTO khachhang VALUES(?,?,?,?,?,?,1)";
            PreparedStatement prep = JDBCUtil.getConnection().prepareStatement(sql);
            prep.setInt(1, kh.getMaKH());
            prep.setString(2, kh.getHo());
            prep.setString(3, kh.getTen());
            prep.setString(4, kh.getGioiTinh());
            prep.setString(5, kh.getDienThoai());
            prep.setInt(6, kh.getTongChiTieu());
            result = prep.executeUpdate() > 0;
        } catch (SQLException ex) {
            return false;
        }
        return result;
    }
    public boolean deleteKhachHang(int maKH) {
        boolean result = false;
        try {
            String sql = "UPDATE khachhang SET TinhTrang=0 WHERE MaKH=?";
            PreparedStatement prep = JDBCUtil.getConnection().prepareStatement(sql);
            prep.setInt(1, maKH);
            result = prep.executeUpdate() > 0;
        } catch (SQLException ex) {
            return false;
        }
        return result;
    }
    public boolean updateKhachHang(int maKH, KhachHang kh) {
        boolean result = false;
        try {
            String sql = "UPDATE khachhang SET Ho=?, Ten=?, GioiTinh=?, DienThoai=?  WHERE MaKH=?";
            PreparedStatement prep = JDBCUtil.getConnection().prepareStatement(sql);
            prep.setString(1, kh.getHo());
            prep.setString(2, kh.getTen());
            prep.setString(3, kh.getGioiTinh());
            prep.setString(4, kh.getDienThoai());
            prep.setInt(5, kh.getMaKH());
            result = prep.executeUpdate() > 0;
        } catch (SQLException ex) {
            return false;
        }
        return result;
    }
    public boolean updateTongChiTieu(int maKH, int tongChiTieu) {
        boolean result = false;
        try {
            String sql = "UPDATE khachhang SET TongChiTieu=" + tongChiTieu + " WHERE MaKH=" + maKH;
            Statement stmt = JDBCUtil.getConnection().createStatement();
            result = stmt.executeUpdate(sql) > 0;
        } catch (SQLException ex) {
            return false;
        }
        return result;
    }
}
