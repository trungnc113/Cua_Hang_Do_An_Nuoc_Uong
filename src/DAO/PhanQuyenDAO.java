/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Custom.JDBCUtil;
import DTO.PhanQuyen;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author nguye
 */
public class PhanQuyenDAO {

    public PhanQuyenDAO() {
    }

    public int insert(PhanQuyen t) {
        int ketQua = 0;
        try {
            Connection c = JDBCUtil.getConnection();
            String sql = "insert into phanquyen(maQuyen,tenQuyen,nhapHang,qlSanPham,qlNhanVien,qlKhachHang,thongKe,trangThai) "
                    + "values(?,?,?,?,?,?,?,?)";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setInt(1, t.getMaQuyen());
            pst.setString(2, "" + t.getTenQuyen());
            pst.setInt(3, t.getNhapHang());
            pst.setInt(4, t.getQlSanPham());
            pst.setInt(5, t.getQlNhanVien());
            pst.setInt(6, t.getQlKhachHang());
            pst.setInt(7, t.getThongKe());
            pst.setInt(8, t.getTrangThai());
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    public int update(PhanQuyen t) {
        int ketQua = 0;
        try {
            Connection c = JDBCUtil.getConnection();
            String sql = "update phanquyen set tenQuyen=? ,nhapHang=?,qlSanPham=?,qlNhanVien=?,qlKhachHang=?,thongKe=?,trangThai=? where maQuyen=? ";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, t.getTenQuyen());
            pst.setInt(2, t.getNhapHang());
            pst.setInt(3, t.getQlSanPham());
            pst.setInt(4, t.getQlNhanVien());
            pst.setInt(5, t.getQlKhachHang());
            pst.setInt(6, t.getThongKe());
            pst.setInt(7, t.getTrangThai());
            pst.setInt(8, t.getMaQuyen());
            ketQua = pst.executeUpdate();

            JDBCUtil.closeConnection(c);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    public int delete(PhanQuyen t) {
        int ketQua = 0;
        try {
            Connection c = JDBCUtil.getConnection();
            String sql = "update phanquyen set trangThai=0 where maQuyen = ?";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setInt(1, t.getMaQuyen());

            ketQua = pst.executeUpdate();

            JDBCUtil.closeConnection(c);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    public ArrayList<PhanQuyen> selectAll() {
        ArrayList<PhanQuyen> phanQuyens = new ArrayList<>();
        try {
            Connection c = JDBCUtil.getConnection();
            String sql = "select * from phanquyen where trangThai=1";
            PreparedStatement pst = c.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int maQuyen = rs.getInt("maQuyen");
                String tenQuyen = rs.getString("tenQuyen");
                int nhapHang = rs.getInt("nhapHang");
                int qlSanPham = rs.getInt("qlNhanVien");
                int qlKhachHang = rs.getInt("qlKhachHang");
                int thongke = rs.getInt("thongKe");
                int trangThai = rs.getInt("trangThai");
                PhanQuyen phanQuyen = new PhanQuyen(maQuyen, tenQuyen, nhapHang, qlSanPham, qlKhachHang, qlKhachHang, thongke, trangThai);
                phanQuyens.add(phanQuyen);
            }
            JDBCUtil.closeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phanQuyens;
    }

    public PhanQuyen selectById(PhanQuyen t) {
        PhanQuyen phanQuyen = null;
        try {
            Connection c = JDBCUtil.getConnection();
            String sql = "select * from phanquyen where maQuyen=? and trangThai=1";
            PreparedStatement pst = c.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int maQuyen = rs.getInt("maQuyen");
                String tenQuyen = rs.getString("tenQuyen");
                int nhapHang = rs.getInt("nhapHang");
                int qlSanPham = rs.getInt("qlNhanVien");
                int qlKhachHang = rs.getInt("qlKhachHang");
                int thongke = rs.getInt("thongKe");
                int trangThai = rs.getInt("trangThai");
                phanQuyen = new PhanQuyen(maQuyen, tenQuyen, nhapHang, qlSanPham, qlKhachHang, qlKhachHang, thongke, trangThai);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phanQuyen;
    }

   
    public ArrayList<PhanQuyen> selectByCondition(String condition) {
        ArrayList<PhanQuyen> phanQuyens = new ArrayList<>();
        try {
            Connection c = JDBCUtil.getConnection();
            String sql = "select * from phanquyen where " + condition;
            PreparedStatement pst = c.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int maQuyen = rs.getInt("maQuyen");
                String tenQuyen = rs.getString("tenQuyen");
                int nhapHang = rs.getInt("nhapHang");
                int qlSanPham = rs.getInt("qlNhanVien");
                int qlKhachHang = rs.getInt("qlKhachHang");
                int thongke = rs.getInt("thongKe");
                int trangThai = rs.getInt("trangThai");
                PhanQuyen phanQuyen = new PhanQuyen(maQuyen, tenQuyen, nhapHang, qlSanPham, qlKhachHang, qlKhachHang, thongke, trangThai);
                phanQuyens.add(phanQuyen);
            }
            JDBCUtil.closeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phanQuyens;
    }
}
