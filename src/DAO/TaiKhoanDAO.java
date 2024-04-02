/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Custom.JDBCUtil;
import DTO.TaiKhoan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author nguye
 */
public class TaiKhoanDAO {
    public TaiKhoanDAO() {

    }

    public TaiKhoan selectById(TaiKhoan t) {
        TaiKhoan taiKhoan = null;
        try {
            Connection c = JDBCUtil.getConnection();
            String sql = "select * from taikhoan where maNhanVien=? and trangThai=1";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, "" + t.getMaQuyen());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int maNhanVien = rs.getInt("maNhanVien");
                int maQuyen = rs.getInt("maQuyen");
                String tenDangNhap = rs.getString("tenDangNhap");
                String matKhau = rs.getString("matKhau");
                int trangThai = rs.getInt("trangThai");
                taiKhoan = new TaiKhoan(maNhanVien, maQuyen, tenDangNhap, matKhau, trangThai);
            }
            JDBCUtil.closeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return taiKhoan;
    }

    public ArrayList<TaiKhoan> selectByCondition(String condition) {
        ArrayList<TaiKhoan> taiKhoans = new ArrayList<>();
        try {
            Connection c = JDBCUtil.getConnection();
            String sql = "select * from taikhoan where " + condition;
            PreparedStatement pst = c.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int maNhanVien = rs.getInt("maNhanVien");
                int maQuyen = rs.getInt("maQuyen");
                String tenDangNhap = rs.getString("tenDangNhap");
                String matKhau = rs.getString("matKhau");
                int trangThai = rs.getInt("trangThai");
                TaiKhoan taiKhoan = new TaiKhoan(maNhanVien, maQuyen, tenDangNhap, matKhau, trangThai);
                taiKhoans.add(taiKhoan);
            }
            JDBCUtil.closeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return taiKhoans;
    }

    public int insert(TaiKhoan t) {
        int ketQua = 0;
        try {
            Connection c = JDBCUtil.getConnection();
            String sql = "insert into taikhoan(maNV,maQuyen,tenDangNhap,matKhau,trangThai) "
                    + "values(?,?,?,?,?)";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setInt(1, t.getMaNhanVien());
            pst.setInt(2, t.getMaQuyen());
            pst.setString(3, t.getTenDangNhap());
            pst.setString(4, t.getMatKhau());
            pst.setInt(5, t.getTrangThai());

            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    public int update(TaiKhoan t) {
        int ketQua = 0;
        try {
            Connection c = JDBCUtil.getConnection();
            String sql = "update taikhoan set maQuyen=?,tenDangNhap=?,matKhau=?,trangThai=? where maNV=?";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setInt(1, t.getMaNhanVien());
            pst.setString(2, t.getTenDangNhap());
            pst.setString(3, t.getMatKhau());
            pst.setInt(4, t.getTrangThai());
            pst.setInt(5, t.getMaNhanVien());

            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    public int delete(TaiKhoan t) {
        int ketQua = 0;
        try {
            Connection c = JDBCUtil.getConnection();
            String sql = "update taikhoan set trangThai=0 where maNV=?";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setInt(1, t.getMaNhanVien());
           
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    public ArrayList<TaiKhoan> selectAll() {
        ArrayList<TaiKhoan> taiKhoans = new ArrayList<>();
        try {
            Connection c = JDBCUtil.getConnection();
            String sql = "select * from taikhoan where trangThai=1";
            PreparedStatement pst = c.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int maNhanVien = rs.getInt("maNhanVien");
                int maQuyen = rs.getInt("maQuyen");
                String tenDangNhap = rs.getString("tenDangNhap");
                String matKhau = rs.getString("matKhau");
                int trangThai = rs.getInt("trangThai");
                TaiKhoan taiKhoan = new TaiKhoan(maNhanVien, maQuyen, tenDangNhap, matKhau, trangThai);
                taiKhoans.add(taiKhoan);
            }
            JDBCUtil.closeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return taiKhoans;
    }
}
