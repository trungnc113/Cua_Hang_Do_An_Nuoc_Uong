package DAO;
import DTO.SanPham;
import Custom.JDBCUtil;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SanPhamDAO {

    public ArrayList<SanPham> getDanhSachSanPham(){
        try{
            Connection connection = JDBCUtil.getConnection();
            String slq = "select * from sanpham where trangThai=1";
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
        }catch(SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    public SanPham getSanPhamTheoMa(int maSP){
        SanPham sanpham = null;
        try{
            Connection connection = JDBCUtil.getConnection();
            String slq = "select * from sanpham where maSP = ? and trangThai=1";
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
        }catch(SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    public SanPham getSanPhamTheoTen(String tenSP){
        SanPham sanpham = null;
        try{
            Connection connection = JDBCUtil.getConnection();

            String slq = "select * from sanpham where tenSP=? and trangThai=1";
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
        }catch(SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    public String getHinhAnh(int maSP){
        
        try{
            Connection connection = JDBCUtil.getConnection();

            String slq = "select hinhAnh from sanpham where maSP = ? and trangThai=1";
            PreparedStatement pre = connection.prepareStatement(slq);
            pre.setInt(1,maSP);
            ResultSet rs = pre.executeQuery();
            if(rs.next()){
                System.out.println(rs.getString("hinhAnh"));
                return rs.getString("hinhAnh");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }

        return "";
    } 

    public ArrayList<SanPham> getSanPhamTheoLoai(int maLoai){
        try{
            Connection connection = JDBCUtil.getConnection();

            String slq = "select * from sanpham where maLoai = ? and trangThai=1";
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
        }catch(SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    public boolean updateInfoSanPham(SanPham sp ){
        boolean ketqua = false;
        try{
            Connection connection = JDBCUtil.getConnection();

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
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return ketqua;
    }

    public boolean deleteSanPham(int maSP){
        boolean ketqua = false;
        try{
            Connection connection = JDBCUtil.getConnection();

            String slq = "update sanpham set trangThai=? where maSP=?";
            PreparedStatement pre = connection.prepareStatement(slq);
            pre.setInt(1,0);
            pre.setInt(2,maSP);
            ketqua = pre.executeUpdate() > 1;
            return ketqua;
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return ketqua;
    }

    public  boolean themSanPham(SanPham sp){
        boolean ketqua = false;
        try{
            Connection connection = JDBCUtil.getConnection();

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

        }catch(SQLException e){
            e.printStackTrace();
        }
        return ketqua;
    }

    public void capNhatSoLuongSP(int maSP, int soLuong){
        try{
            Connection connection = JDBCUtil.getConnection();

            String slq = "update sanpham set soLuong=? where maSP=?";
            PreparedStatement pre = connection.prepareStatement(slq);
            pre.setInt(1,soLuong);
            pre.setInt(2,maSP);
            pre.executeUpdate();
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public boolean importSanPhamFromExcel(SanPham sp){
        try{
            Connection connection = JDBCUtil.getConnection();

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

        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    public ArrayList<SanPham> getDanhSachSanPhamTheoLoai(String tenloai){
        try{
            Connection connection = JDBCUtil.getConnection();
            String slq = "select * from sanpham, loaiSP where sanpham.trangThai=1 and loaiSP.maLoai = sanpham.maLoai and loaiSP.tenLoai = N'"+tenloai+"'";
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
        }catch(SQLException e){
            e.printStackTrace();
        }

        return null;
    }
    public ArrayList<SanPham> getDanhSachSanPhamTheoTimKiem(String tenSP){
        try{
            Connection connection = JDBCUtil.getConnection();
            String slq = "select * from sanpham where sanpham.trangThai=1 and tenSP like N'%"+tenSP+"%'";
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
        }catch(SQLException e){
            e.printStackTrace();
        }

        return null;
    }
    public ArrayList<SanPham> getDanhSachSanPhamTheoLoaivaTimKiem(String tenloai, String tenSP){
        try{
            Connection connection = JDBCUtil.getConnection();
            String slq = "select * from sanpham, loaiSP where sanpham.trangThai=1 and loaiSP.maLoai = sanpham.maLoai and loaiSP.tenLoai = N'"+tenloai+"' and sanpham.tenSP like N'%"+tenSP+"%'";
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
        }catch(SQLException e){
            e.printStackTrace();
        }

        return null;
    }


}
