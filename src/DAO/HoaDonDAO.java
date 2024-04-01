/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Custom.JDBCUtil;
import DTO.HoaDon;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author nguye
 */
public class HoaDonDAO {
    public ArrayList<HoaDon> getListHoaDon() {
        ArrayList<HoaDon> dshd = new ArrayList<>();
        try {
            String sql = "SELECT * FROM hoadon";
            Statement stmt = JDBCUtil.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setMaHD(rs.getInt(1));
                hd.setMaKH(rs.getInt(2));
                hd.setMaNV(rs.getInt(3));
                hd.setMaGiam(rs.getInt(4));
                hd.setNgayLap(rs.getDate(5));
                hd.setTongTien(rs.getInt(6));
                dshd.add(hd);
            }
        } catch (SQLException ex) {
            return null;
        }
        return dshd;
    }
    public boolean addHoaDon(HoaDon hd) {
        boolean result = false;
        try {
            String sql1 = "UPDATE KhachHang SET TongChiTieu=TongChiTieu+" + hd.getTongTien() + " WHERE MaKH=" + hd.getMaKH();
            Statement st = JDBCUtil.getConnection().createStatement();
            st.executeUpdate(sql1);
            String sql = "INSERT INTO hoadon(MaHD, MaKH, MaNV, MaGiam, NgayLap, TongTien) VALUES(?,?, ?, ?, ?, ?)";
            PreparedStatement prep = JDBCUtil.getConnection().prepareStatement(sql);
            prep.setInt(1, hd.getMaHD());
            prep.setInt(2, hd.getMaKH());
            prep.setInt(3, hd.getMaNV());
            prep.setInt(4, hd.getMaGiam());
            prep.setTimestamp(5, new java.sql.Timestamp(new java.util.Date().getTime()));
            prep.setInt(5, hd.getTongTien());
            result = prep.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return result;
    }
    public ArrayList<HoaDon> getListHoaDon(Date dateMin, Date dateMax) {
        try {
            String sql = "SELECT * FROM hoadon WHERE NgayLap BETWEEN CAST(? AS DATE) AND CAST(? AS DATE)";
            PreparedStatement pre = JDBCUtil.getConnection().prepareStatement(sql);
            pre.setDate(1, dateMin);
            pre.setDate(2, dateMax);
            ResultSet rs = pre.executeQuery();

            ArrayList<HoaDon> dshd = new ArrayList<>();

            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setMaHD(rs.getInt(1));
                hd.setMaKH(rs.getInt(2));
                hd.setMaNV(rs.getInt(3));
                hd.setMaGiam(rs.getInt(4));
                hd.setNgayLap(rs.getDate(5));
                hd.setTongTien(rs.getInt(6));
                dshd.add(hd);
            }
            return dshd;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
