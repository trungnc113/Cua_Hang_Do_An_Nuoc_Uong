/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.CTHoaDonDAO;
import DTO.CTHoaDon;

import java.util.ArrayList;

/**
 *
 * @author nguye
 */
public class CTHoaDonBUS {
    CTHoaDonDAO CTHD = new CTHoaDonDAO();
    public ArrayList<CTHoaDon> getlistCTHD(){
        return CTHD.getListCTHD();
    }
    
}
