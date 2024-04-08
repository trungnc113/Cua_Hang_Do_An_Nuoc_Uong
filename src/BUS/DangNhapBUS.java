/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import Custom.InputValidator;
import Custom.dialog;
import DAO.DangNhapDAO;
import DTO.TaiKhoan;

/**
 *
 * @author nguye
 */
public class DangNhapBUS {
    DangNhapDAO dangNhapDAO=new DangNhapDAO();
    public static TaiKhoan taiKhoanLogin=null;
    public DangNhapBUS() {
    }
    
    public void login(String username,String password){
        if(checkEmpty(username, password))
        {
            new dialog("Không được để trống", dialog.ERROR_DIALOG);
            return;
        }
        if(!checkAccount(username, password))
        {
            new dialog("Tài khoản không đúng hoặc đã bị khóa", dialog.ERROR_DIALOG);
            return;
        }
        new dialog("Đăng nhập thành công", dialog.SUCCESS_DIALOG);
        
    }
    
    private boolean checkAccount(String username, String password){
        TaiKhoan tk=dangNhapDAO.checkAccount(new TaiKhoan(0,0, username, password,0));
        if(tk== null)
            return false;
        taiKhoanLogin=tk;
        return true;
    }
    
    private boolean checkEmpty(String username, String password) {
        if (InputValidator.IsEmpty(username) || InputValidator.IsEmpty(password)) {
            return true;
        }
        return false;
    }
    
}
