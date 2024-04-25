/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import Custom.InputValidator;
import Custom.dialog;
import DAO.HoaDonDAO;
import DTO.HoaDon;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author nguye
 */
public class HoaDonBUS {
    private HoaDonDAO HDDAO = new HoaDonDAO();

    public ArrayList<HoaDon> getlistHD(){
        return HDDAO.getListHoaDon();
    }
    public ArrayList<HoaDon> getlistHDtheoDateVaTongTien(Date DateMin, Date DateMax, int TongTienMin, int TongTienMax)
    {
        if(DateMin.after(DateMax)){
            new dialog("Khoảng ngày không hợp lệ!", dialog.ERROR_DIALOG);
            return null;
        }
        if(TongTienMin > TongTienMax){
            new dialog("Khoảng tiền không hợp lệ", dialog.ERROR_DIALOG);
        }
        return HDDAO.getListHoaDonTheoDateVaTongTien((java.sql.Date) DateMin, (java.sql.Date) DateMax, TongTienMin, TongTienMax);
    }
    public ArrayList<HoaDon> getlisttheoMHD(int MHD){
        String temp = ""+MHD;
        if(!InputValidator.isValidNumber(temp)){
            return null;
        }
        return HDDAO.getListHoaDonTheoMHD(MHD);
    }
    
}
