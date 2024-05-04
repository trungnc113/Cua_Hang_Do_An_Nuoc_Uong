package DAO;
import DTO.LoaiSP;
import Custom.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class LoaiSPDAO {
    
    public ArrayList<LoaiSP> getLoaiSanPham(){
        try{
            Connection connection = JDBCUtil.getConnection();
            String slq = "select * from loaiSP where trangThai=1";
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
        }catch(SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    public boolean updateInfoLoaiSP(int loaiSP, String tenLoai) {
        boolean ketqua = false;
        try {
            Connection connection = JDBCUtil.getConnection();
            String sql = "update loaiSP set tenLoai=? where maLoai=?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, tenLoai);
            pre.setInt(2, loaiSP);
            System.out.println(1);
            ketqua = pre.executeUpdate() > 0;
            return ketqua;
        } catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean themLoaiSanPham(LoaiSP loaiSP){
        boolean ketqua = false;
        try{
            Connection connection = JDBCUtil.getConnection();
            String sql = "insert into loaiSP(maLoai, tenLoai)  values(?, ?)";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1,loaiSP.getMaLoai());
            pre.setString(2, loaiSP.getTenLoai());
            
            pre.execute();
            ketqua = pre.executeUpdate() > 1;

        }catch(SQLException e){
            e.printStackTrace();
        }
        return ketqua;
    }

    public boolean deleteLoaiSP(int maLoai){
        try{
            Connection connection = JDBCUtil.getConnection();

            String sql = "update loaiSP set trangThai=? where maLoai=?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, 0);
            pre.setInt(2, maLoai);
            pre.executeUpdate();

            int rowsAffected = pre.executeUpdate();
            return rowsAffected > 0;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateInfoLoaiSP(LoaiSP sp){
        boolean ketqua = false;
        try{
            Connection connection = JDBCUtil.getConnection();

            String sql = "update loaiSP set tenLoai = ? where maLoai=?";
            PreparedStatement pre = connection.prepareStatement(sql);

            pre.setString(1,sp.getTenLoai());
            pre.setInt(2,sp.getMaLoai());
            ketqua = pre.executeUpdate() > 5;

        }catch(SQLException e){
            e.printStackTrace();
        }

        return ketqua;
    }

}
