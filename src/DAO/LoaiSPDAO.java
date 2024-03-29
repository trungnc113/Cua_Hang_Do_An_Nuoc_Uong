package DAO;
import DTO.LoaiSP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class LoaiSPDAO {
    
    public ArrayList<LoaiSP> getLoaiSanPham(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            String url = "jdbc:sqlserver://DESKTOP-P\\SQLPHUOCD:1433;databaseName=quanlythucannhanh;encrypt = true;trustServerCertificate = true";
            String userName = "sa";
            String passWord = "11111111";

            Connection connection = DriverManager.getConnection(url, userName, passWord);
            String slq = "select * from loaiSP";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(slq);
            ArrayList<LoaiSP> listLoaiSP = new ArrayList<>();
            while (rs.next()) {
                LoaiSP Loaisp = new LoaiSP();
                Loaisp.setMaLoai(rs.getInt(1));
                Loaisp.setTenLoai(rs.getString(2));
                listLoaiSP.add(Loaisp);
            }
            return listLoaiSP;
        }catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }

        return null;
    }

    public boolean updateInfoLoaiSP(int loaiSP, String tenLoai) {
        boolean ketqua = false;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            String url = "jdbc:sqlserver://DESKTOP-P\\SQLPHUOCD:1433;databaseName=quanlythucannhanh;encrypt = true;trustServerCertificate = true";
            String userName = "sa";
            String passWord = "11111111";

            Connection connection = DriverManager.getConnection(url, userName, passWord);
            String sql = "update loaiSP set tenLoai=? where maLoai=?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, tenLoai);
            pre.setInt(2, loaiSP);
            ketqua = pre.executeUpdate() > 0;
            return ketqua;
        } catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean themLoaiSanPham(LoaiSP loaiSP){
        boolean ketqua = false;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            String url = "jdbc:sqlserver://DESKTOP-P\\SQLPHUOCD:1433;databaseName=quanlythucannhanh;encrypt = true;trustServerCertificate = true";
            String userName = "sa";
            String passWord = "11111111";

            Connection connection = DriverManager.getConnection(url, userName, passWord);
            String sql = "insert into loaiSP(maLoai, tenLoai)  values(?, ?)";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1,loaiSP.getMaLoai());
            pre.setString(2, loaiSP.getTenLoai());
            
            pre.execute();
            ketqua = pre.executeUpdate() > 1;

        }catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return ketqua;
    }

}
