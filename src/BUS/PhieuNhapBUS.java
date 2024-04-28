package BUS;

import Custom.dialog;
import DAO.PhieuNhapDAO;
import DTO.PhieuNhap;

public class PhieuNhapBUS {
    
    PhieuNhapDAO phieuNhapDAO = new PhieuNhapDAO();
    
    public PhieuNhapBUS() {
    }
    
    public boolean Insert(PhieuNhap phieuNhap){
        if(phieuNhapDAO.themPhieuNhap(phieuNhap))
        {
            new dialog("Lập phiếu nhập thành công!",dialog.SUCCESS_DIALOG);
            return true;
        }
        new dialog("Lập phiếu nhập không thành công!", dialog.ERROR_DIALOG);
        return false;
    }
    
    public int getNewMaPN(){
        return phieuNhapDAO.getNewId();
    }
}
