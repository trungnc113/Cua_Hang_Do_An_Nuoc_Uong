/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Custom.JDBCUtil;
import DTO.GiamGia;
import java.sql.*;
import java.util.ArrayList;



/**
 *
 * @author nguye
 */
public class GiamGiaDAO {
    public ArrayList<GiamGia> getListGiamGia(){
        ArrayList<GiamGia> dsgg = new ArrayList<>();
        try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String sql = "SELECT * FROM GiamGia WHERE trangThai=1";
                Connection connection = JDBCUtil.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
            while (rs.next()){
                GiamGia gg = new GiamGia();
                gg.setMaGiam(rs.getInt("maGiam"));
                gg.setTenGiamGia(rs.getString("tenGiamGia"));
                gg.setPhanTramGiam(rs.getInt("phanTramGiam"));
                gg.setDieuKien(rs.getInt("dieuKien"));
                gg.setNgayBD(rs.getDate("ngayBD"));
                gg.setNgayKT(rs.getDate("ngayKT"));
                gg.setTrangThai(rs.getInt("trangThai"));
                dsgg.add(gg);
               
            }
            JDBCUtil.closeConnection(connection);
            return dsgg;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        
         
       
    }
    
    public boolean addGiamGia (GiamGia gg){
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = " INSERT INTO GiamGia(maGiam, tenGiamGia, phanTramGiam, dieuKien, ngayBD,ngayKT, trangThai)"
                    + " VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, gg.getMaGiam());
            ps.setString(2, gg.getTenGiamGia());
            ps.setInt(3, gg.getPhanTramGiam());
            ps.setInt(4, gg.getDieuKien());
            ps.setDate(5, new Date(gg.getNgayBD().getTime()));
            ps.setDate(6, new Date(gg.getNgayKT().getTime()));
            ps.setInt(7, gg.getTrangThai());
            
            int result = ps.executeUpdate();
            JDBCUtil.closeConnection(connection);
            return result>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean deleteGiamGia (int maGiam){
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "DELETE FROM GiamGia WHERE maGiam=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, maGiam);
            int result = ps.executeUpdate();
            JDBCUtil.closeConnection(connection);
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
        
    }
    public boolean updateGiamGia (int maGiam, GiamGia gg){
        try {
            Connection connection= JDBCUtil.getConnection();
            String sql =" UPDATE GiamGia SET maGiam=?, tenGiamGia=?, phanTramGiam=?, dieuKien=?, ngayBD=?, ngayKT=?, trangThai=? WHERE maGiam=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, gg.getMaGiam());
            ps.setString(2, gg.getTenGiamGia());
            ps.setInt(3,gg.getPhanTramGiam());
            ps.setInt(4, gg.getDieuKien());
            ps.setDate(5, new Date(gg.getNgayBD().getTime()));
            ps.setDate(6, new Date(gg.getNgayKT().getTime()));
            ps.setInt(7, gg.getTrangThai());
         int result = ps.executeUpdate();
         JDBCUtil.closeConnection(connection);
         return result>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
        
    }
   
    public static void main(String[] args) {
        GiamGiaDAO test=new GiamGiaDAO();
        System.out.println(test.getListGiamGia());
    }

    
}
