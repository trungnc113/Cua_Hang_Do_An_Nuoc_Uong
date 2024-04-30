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
            Connection c = JDBCUtil.getConnection();
            String sql = "INSERT INTO hoadon(MaHD, MaKH, MaNV, MaGiam, NgayLap, TongTien) VALUES(?,?, ?, ?, ?, ?)";
            PreparedStatement prep = c.prepareStatement(sql);
            prep.setInt(1, hd.getMaHD());
            prep.setInt(2, hd.getMaKH());
            prep.setInt(3, hd.getMaNV());
            prep.setInt(4, hd.getMaGiam());
            prep.setTimestamp(5, new java.sql.Timestamp(new java.util.Date().getTime()));
            prep.setInt(6, hd.getTongTien());
            result = prep.executeUpdate() > 0;
            JDBCUtil.closeConnection(c);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return result;
    }
    public ArrayList<HoaDon> getListHoaDonTheoDateVaTongTien(Date dateMin, Date dateMax, int tongtienMin,int tongtienMax ) { // lấy list dshd theo ngày và tổng tiền
        try {
            Connection c = JDBCUtil.getConnection();
            //String sql = "SELECT * FROM hoadon WHERE (NgayLap BETWEEN ? AND ?) AND (tongTien BETWEEN ? AND ?)";
            String sql = "SELECT * FROM hoadon WHERE (NgayLap BETWEEN ? AND ?) AND (tongTien BETWEEN ? AND ?)";
            PreparedStatement pre = c.prepareStatement(sql);
            pre.setDate(1, dateMin);
            pre.setDate(2, dateMax);
            pre.setInt(3, tongtienMin);
            pre.setInt(4, tongtienMax);
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
    public HoaDon getHoaDonTheoMHD(int maHD) {
        HoaDon HD = new HoaDon();
        try {
            String sql = "SELECT * FROM hoadon where maHD="+maHD;
            Statement stmt = JDBCUtil.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                HD.setMaHD(rs.getInt(1));
                HD.setMaKH(rs.getInt(2));
                HD.setMaNV(rs.getInt(3));
                HD.setMaGiam(rs.getInt(4));
                HD.setNgayLap(rs.getDate(5));
                HD.setTongTien(rs.getInt(6));
            }
            return HD;
        } catch (SQLException ex) {
        }
        return null;
    }
    public ArrayList<HoaDon> getListHoaDonTheoDate(Date dateMin, Date dateMax ) { // lấy list dshd theo ngày và tổng tiền
        try {
            Connection c = JDBCUtil.getConnection();
            String sql = "SELECT * FROM hoadon WHERE (NgayLap BETWEEN CAST(? AS DATE) AND CAST(? AS DATE))";
            PreparedStatement pre = c.prepareStatement(sql);
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
