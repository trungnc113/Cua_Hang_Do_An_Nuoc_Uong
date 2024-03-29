package DAO;
import DTO.NhanVien;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class NhanVienDAO {

    public ArrayList<NhanVien> getDanhSachNhanVien(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            String url = "jdbc:sqlserver://DESKTOP-P\\SQLPHUOCD:1433;databaseName=quanlythucannhanh;encrypt = true;trustServerCertificate = true";
            String userName = "sa";
            String passWord = "11111111";

            Connection connection = DriverManager.getConnection(url, userName, passWord);
            String sql = "select * from nhanvien";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            ArrayList<NhanVien> listNV = new ArrayList<>();
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getInt(1));
                nv.setHo(rs.getString(2));
                nv.setTen(rs.getString(3));
                nv.setGioiTinh(rs.getString(4));
                nv.setDienThoai(rs.getString(5));
                nv.setTrangThai(rs.getInt(6));
                listNV.add(nv);
            }
            return listNV;
        }catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }

        return null;
    }

    public boolean updateInfoNhanVien(NhanVien nv){
        boolean ketqua = false;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            String url = "jdbc:sqlserver://DESKTOP-P\\SQLPHUOCD:1433;databaseName=quanlythucannhanh;encrypt = true;trustServerCertificate = true";
            String userName = "sa";
            String passWord = "11111111";

            Connection connection = DriverManager.getConnection(url, userName, passWord);
            String sql = "update nhanvien set ho=?, ten=?, gioiTinh=?, dienThoai=?, trangThai=? where maNV=?";
            PreparedStatement pre = connection.prepareStatement(sql);

            pre.setString(1,nv.getHo());
            pre.setString(2,nv.getTen());
            pre.setString(3,nv.getGioiTinh());
            pre.setString(4,nv.getDienThoai());
            pre.setInt(5,nv.getTrangThai());
            pre.setInt(6,nv.getMaNV());
            ketqua = pre.executeUpdate() > 5;

        }catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }

        return ketqua;
    }

    public boolean deleteNhanVien(int MaNV){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            String url = "jdbc:sqlserver://DESKTOP-P\\SQLPHUOCD:1433;databaseName=quanlythucannhanh;encrypt = true;trustServerCertificate = true";
            String userName = "sa";
            String passWord = "11111111";

            Connection connection = DriverManager.getConnection(url, userName, passWord);
            String sql = "update nhanvien set trangThai=? where maNV=?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, 0);
            pre.setInt(2, MaNV);
            pre.executeUpdate();
            int rowsAffected = pre.executeUpdate();

            return rowsAffected > 0;
        }catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean themNhanVien(NhanVien nv){
        boolean ketqua = false;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            String url = "jdbc:sqlserver://DESKTOP-P\\SQLPHUOCD:1433;databaseName=quanlythucannhanh;encrypt = true;trustServerCertificate = true";
            String userName = "sa";
            String passWord = "11111111";

            Connection connection = DriverManager.getConnection(url, userName, passWord);
            String sql = "insert into nhanvien(maNV, ho, ten, gioiTinh, dienThoai, trangThai)  values(?, ?, ?, ?, ?, ?)";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1,nv.getMaNV());
            pre.setString(2, nv.getHo());
            pre.setString(3, nv.getTen());
            pre.setString(4, nv.getGioiTinh());
            pre.setString(5, nv.getDienThoai());
            pre.setInt(6, nv.getTrangThai());
            ketqua = pre.executeUpdate() > 5;

        }catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return ketqua;
    }

    public NhanVien getNhanVien(int maNV){
            NhanVien nv = null;
            try{
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    
                String url = "jdbc:sqlserver://DESKTOP-P\\SQLPHUOCD:1433;databaseName=quanlythucannhanh;encrypt = true;trustServerCertificate = true";
                String userName = "sa";
                String passWord = "11111111";
    
                Connection connection = DriverManager.getConnection(url, userName, passWord);
                String sql = "select * from nhanvien where maNV = ?";
                PreparedStatement pre = connection.prepareStatement(sql);
                pre.setInt(1,maNV);
                ResultSet rs = pre.executeQuery();
                while (rs.next()) {
                    nv = new NhanVien();
                    nv.setMaNV(maNV);
                    nv.setHo(rs.getString(2));
                    nv.setTen(rs.getString(3));
                    nv.setGioiTinh(rs.getString(4));
                    nv.setDienThoai(rs.getString(5));
                    nv.setTrangThai(rs.getInt(6));
                }

                return nv;
            }catch(SQLException | ClassNotFoundException e){
                e.printStackTrace();
            }
            return null;
    }

    public boolean importNhanVienFromExcel(NhanVien nv){

        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            String url = "jdbc:sqlserver://DESKTOP-P\\SQLPHUOCD:1433;databaseName=quanlythucannhanh;encrypt = true;trustServerCertificate = true";
            String userName = "sa";
            String passWord = "11111111";

            Connection connection = DriverManager.getConnection(url, userName, passWord);
            String sql = "DELETE FROM nhanvien" + 
                "insert into nhanvien(maNV, ho, ten, gioiTinh, dienThoai, trangThai) values(?, ?, ?, ?, ?, ?) ";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, nv.getMaNV());
            pre.setString(2, nv.getHo());
            pre.setString(3, nv.getTen());
            pre.setString(4, nv.getGioiTinh());
            pre.setString(5, nv.getDienThoai());
            pre.setInt(6, nv.getTrangThai());
            pre.executeUpdate();

            int rowsAffected = pre.executeUpdate();
            return rowsAffected > 0;

        }catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return false;
    }
        
}
