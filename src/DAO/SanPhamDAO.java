package DAO;
import DTO.SanPham;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SanPhamDAO {

    public ArrayList<SanPham> getDanhSachSanPham(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            String url = "jdbc:sqlserver://DESKTOP-P\\SQLPHUOCD:1433;databaseName=quanlythucannhanh;encrypt = true;trustServerCertificate = true";
            String userName = "sa";
            String passWord = "11111111";

            Connection connection = DriverManager.getConnection(url, userName, passWord);
            String slq = "select * from sanpham";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(slq);
            ArrayList<SanPham> listSP = new ArrayList<>();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaSP(rs.getInt(1));
                sp.setTenSP(rs.getString(2));
                sp.setMaLoai(rs.getInt(3));
                sp.setDonGia(rs.getInt(4));
                sp.setSoLuong(rs.getInt(5));
                sp.setDonViTinh(rs.getString(6));
                sp.setHinhAnh(rs.getString(7));
                sp.setTrangThai(rs.getInt(8));
                
                listSP.add(sp);
            }
            return listSP;
        }catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }

        return null;
    }

    public SanPham getSanPhamTheoMA(int maSP){
        SanPham sanpham = null;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            String url = "jdbc:sqlserver://DESKTOP-P\\SQLPHUOCD:1433;databaseName=quanlythucannhanh;encrypt = true;trustServerCertificate = true";
            String userName = "sa";
            String passWord = "11111111";

            Connection connection = DriverManager.getConnection(url, userName, passWord);
            String slq = "select * from sanpham where maSP = ?";
            PreparedStatement pre = connection.prepareStatement(slq);
            pre.setInt(1,maSP);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                sanpham = new SanPham();
                sanpham.setMaSP(rs.getInt(1));
                sanpham.setTenSP(rs.getString(2));
                sanpham.setMaLoai(rs.getInt(3));
                sanpham.setDonGia(rs.getInt(4));
                sanpham.setSoLuong(rs.getInt(5));
                sanpham.setDonViTinh(rs.getString(6));
                sanpham.setHinhAnh(rs.getString(7));
                sanpham.setTrangThai(rs.getInt(8));
            }
            
            return sanpham;
        }catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }

        return null;
    }

    public SanPham getSanPhamTheoTen(String tenSP){
        SanPham sanpham = null;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            String url = "jdbc:sqlserver://DESKTOP-P\\SQLPHUOCD:1433;databaseName=quanlythucannhanh;encrypt = true;trustServerCertificate = true";
            String userName = "sa";
            String passWord = "11111111";

            Connection connection = DriverManager.getConnection(url, userName, passWord);
            String slq = "select * from sanpham where tenSP = ?";
            PreparedStatement pre = connection.prepareStatement(slq);
            pre.setString(1,tenSP);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                sanpham = new SanPham();
                sanpham.setMaSP(rs.getInt(1));
                sanpham.setTenSP(rs.getString(2));
                sanpham.setMaLoai(rs.getInt(3));
                sanpham.setDonGia(rs.getInt(4));
                sanpham.setSoLuong(rs.getInt(5));
                sanpham.setDonViTinh(rs.getString(6));
                sanpham.setHinhAnh(rs.getString(7));
                sanpham.setTrangThai(rs.getInt(8));
            }
            
            return sanpham;
        }catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }

        return null;
    }

    public String getHinhAnh(int maSP){
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            String url = "jdbc:sqlserver://DESKTOP-P\\SQLPHUOCD:1433;databaseName=quanlythucannhanh;encrypt = true;trustServerCertificate = true";
            String userName = "sa";
            String passWord = "11111111";

            Connection connection = DriverManager.getConnection(url, userName, passWord);
            String slq = "select hinhAnh from sanpham where maSP = ?";
            PreparedStatement pre = connection.prepareStatement(slq);
            pre.setInt(1,maSP);
            ResultSet rs = pre.executeQuery();
            if(rs.next()){
                System.out.println(rs.getString("hinhAnh"));
                return rs.getString("hinhAnh");
            }
        }catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }

        return "";
    } 

    public ArrayList<SanPham> getSanPhamTheoLoai(int maLoai){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            String url = "jdbc:sqlserver://DESKTOP-P\\SQLPHUOCD:1433;databaseName=quanlythucannhanh;encrypt = true;trustServerCertificate = true";
            String userName = "sa";
            String passWord = "11111111";

            Connection connection = DriverManager.getConnection(url, userName, passWord);
            String slq = "select * from sanpham where maLoai = ?";
            PreparedStatement pre = connection.prepareStatement(slq);
            pre.setInt(1,maLoai);
            ArrayList<SanPham> listSp = new ArrayList<>();
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                SanPham sanpham = new SanPham();
                sanpham.setMaSP(rs.getInt(1));
                sanpham.setTenSP(rs.getString(2));
                sanpham.setMaLoai(rs.getInt(3));
                sanpham.setDonGia(rs.getInt(4));
                sanpham.setSoLuong(rs.getInt(5));
                sanpham.setDonViTinh(rs.getString(6));
                sanpham.setHinhAnh(rs.getString(7));
                sanpham.setTrangThai(rs.getInt(8));
                listSp.add(sanpham);
            }
            
            return listSp;
        }catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }

        return null;
    }

    public boolean updateInfoSanPham(SanPham sp ){
        boolean ketqua = false;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            String url = "jdbc:sqlserver://DESKTOP-P\\SQLPHUOCD:1433;databaseName=quanlythucannhanh;encrypt = true;trustServerCertificate = true";
            String userName = "sa";
            String passWord = "11111111";

            Connection connection = DriverManager.getConnection(url, userName, passWord);
            String slq = "update sanpham set tensp=?, maLoai=?, donGia=?, soLuong=?, donViTinh=?, hinhAnh=?, trangThai=? where maSP=?";
            PreparedStatement pre = connection.prepareStatement(slq);
            pre.setString(1,sp.getTenSP());
            pre.setInt(2,sp.getMaLoai());
            pre.setInt(3,sp.getDonGia());
            pre.setInt(4,sp.getSoLuong());
            pre.setString(5,sp.getDonViTinh());
            pre.setString(6,sp.getHinhAnh());
            pre.setInt(7,sp.getTrangThai());
            pre.setInt(8,sp.getMaSP());

            ketqua = pre.executeUpdate() > 7;
            return ketqua;
            
        }catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return ketqua;
    }

    public boolean deleteSanPham(int maSP){
        boolean ketqua = false;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            String url = "jdbc:sqlserver://DESKTOP-P\\SQLPHUOCD:1433;databaseName=quanlythucannhanh;encrypt = true;trustServerCertificate = true";
            String userName = "sa";
            String passWord = "11111111";

            Connection connection = DriverManager.getConnection(url, userName, passWord);
            String slq = "update sanpham set trangThai=? where maSP=?";
            PreparedStatement pre = connection.prepareStatement(slq);
            pre.setInt(1,0);
            pre.setInt(2,maSP);
            ketqua = pre.executeUpdate() > 1;
            return ketqua;
            
        }catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return ketqua;
    }

    public  boolean themSanPham(SanPham sp){
        boolean ketqua = false;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            String url = "jdbc:sqlserver://DESKTOP-P\\SQLPHUOCD:1433;databaseName=quanlythucannhanh;encrypt = true;trustServerCertificate = true";
            String userName = "sa";
            String passWord = "11111111";

            Connection connection = DriverManager.getConnection(url, userName, passWord);
            String sql = "insert into sanpham(maSP, tenSP, maLoai, donGia, soLuong, donViTinh, hinhAnh, trangThai)  values(?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1,sp.getMaSP());
            pre.setString(2, sp.getTenSP());
            pre.setInt(3, sp.getMaLoai());
            pre.setInt(4, sp.getDonGia());
            pre.setInt(5, sp.getSoLuong());
            pre.setString(6, sp.getDonViTinh());
            pre.setString(7, sp.getHinhAnh());
            pre.setInt(8, sp.getTrangThai());
            pre.execute();
            ketqua = pre.executeUpdate() > 7;

        }catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return ketqua;
    }

    public void capNhapSoLuongSP(int maSP, int soLuong){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            String url = "jdbc:sqlserver://DESKTOP-P\\SQLPHUOCD:1433;databaseName=quanlythucannhanh;encrypt = true;trustServerCertificate = true";
            String userName = "sa";
            String passWord = "11111111";

            Connection connection = DriverManager.getConnection(url, userName, passWord);
            String slq = "update sanpham set soLuong=? where maSP=?";
            PreparedStatement pre = connection.prepareStatement(slq);
            pre.setInt(1,soLuong);
            pre.setInt(2,maSP);
            pre.executeUpdate();
            
        }catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public boolean importSanPhamFromExcel(SanPham sp){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            String url = "jdbc:sqlserver://DESKTOP-P\\SQLPHUOCD:1433;databaseName=quanlythucannhanh;encrypt = true;trustServerCertificate = true";
            String userName = "sa";
            String passWord = "11111111";

            Connection connection = DriverManager.getConnection(url, userName, passWord);
            String sql = "DELETE FROM sanpham" + 
                "insert into sanpham(maSP, tenSP, maLoai, donGia, soLuong, donViTinh, hinhAnh, TrangThai ) values(?, ?, ?, ?, ?, ?, ?, ?) ";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, sp.getMaSP());
            pre.setString(2, sp.getTenSP());
            pre.setInt(3, sp.getMaLoai());
            pre.setInt(4, sp.getDonGia());
            pre.setInt(5, sp.getSoLuong());
            pre.setString(6, sp.getDonViTinh());
            pre.setString(7, sp.getHinhAnh());
            pre.setInt(8, sp.getTrangThai());
            pre.executeUpdate();

            int rowsAffected = pre.executeUpdate();
            return rowsAffected > 0;

        }catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return false;
    }

}
