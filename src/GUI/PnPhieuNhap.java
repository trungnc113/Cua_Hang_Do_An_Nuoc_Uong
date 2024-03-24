/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import Custom.Mytable;
import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nguye
 */
public class PnPhieuNhap extends JPanel{
    final Color ClMain = new Color(0, 160, 80);
    final Color ClHover = new Color(0, 192, 96);
    final Color ClSelect = new Color(76, 204, 76);

    Font FtTitleText = new Font("Montserrat", Font.BOLD, 20);
    Font font = new Font("", Font.PLAIN, 20);
    
    public PnPhieuNhap(){
        addControls();
    }
    private void addControls(){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JPanel pnTltHoaDon = new JPanel();
        JLabel lbTltHoaDon = new JLabel("<html><h1>Thông tin phiếu nhập</h1></html>");
        lbTltHoaDon.setForeground(ClMain);
        pnTltHoaDon.add(lbTltHoaDon);
        this.add(pnTltHoaDon);

        JPanel pnSearchPhieuNhap = new JPanel(); // tạo panel tìm kiếm
        pnSearchPhieuNhap.setLayout(new BoxLayout(pnSearchPhieuNhap, BoxLayout.X_AXIS));

        JPanel pnSearchMaPN = new JPanel(); // panel tìm kiếm theo mã
        pnSearchMaPN.setLayout(new BoxLayout(pnSearchMaPN, BoxLayout.Y_AXIS));

        JPanel pnTltSearchMaPN = new JPanel();
        JLabel lbTltSearchMaPN = new JLabel("Tìm kiếm Mã Phiếu Nhập");
        lbTltSearchMaPN.setFont(FtTitleText);
        pnTltSearchMaPN.add(lbTltSearchMaPN);
        pnSearchMaPN.add(pnTltSearchMaPN);

        JPanel pntxtSearchMaPN = new JPanel();
        JLabel lbtxtSearchMaPN = new JLabel("Mã PN");
        lbtxtSearchMaPN.setFont(font);
        JTextField txtSearchMaPN = new JTextField(25);
        txtSearchMaPN.setFont(font);
        pntxtSearchMaPN.add(lbtxtSearchMaPN);
        pntxtSearchMaPN.add(txtSearchMaPN);

        JButton btnSearchMaPN = new JButton(new ImageIcon("image/btn/search.png"));
        btnSearchMaPN.setPreferredSize(new Dimension(40, 40));
        btnSearchMaPN.setBorder(null);
        btnSearchMaPN.setFocusable(false);
        pntxtSearchMaPN.add(btnSearchMaPN);
        pnSearchMaPN.add(pntxtSearchMaPN);

        JPanel pnSearchDate = new JPanel();// tạo panel tìm kiếm theo ngày
        pnSearchDate.setLayout(new BoxLayout(pnSearchDate, BoxLayout.Y_AXIS));

        JPanel pnTltSearchDate = new JPanel();
        JLabel lbTltSearchDate = new JLabel("Tìm kiếm Phiếu Nhập");
        lbTltSearchDate.setFont(FtTitleText);
        pnTltSearchDate.add(lbTltSearchDate);
        pnSearchDate.add(pnTltSearchDate);

        JPanel pntxtStartDate = new JPanel();
        JLabel lbtxtStartDate = new JLabel("Từ ngày");
        lbtxtStartDate.setFont(font);
        JDateChooser dtcStartDate = new JDateChooser();
        dtcStartDate.setPreferredSize(new Dimension(150, 30));
        pntxtStartDate.add(lbtxtStartDate);
        pntxtStartDate.add(dtcStartDate);
        pnSearchDate.add(pntxtStartDate);

        JPanel pntxtEndDate = new JPanel();
        
        JLabel lbtxtEndDate = new JLabel("Đến ngày");
        lbtxtEndDate.setFont(font);
        JDateChooser dtcEndDate = new JDateChooser();
        dtcEndDate.setPreferredSize(new Dimension(150, 30));
        pntxtEndDate.add(lbtxtEndDate);
        pntxtEndDate.add(dtcEndDate);
        pnSearchDate.add(pntxtEndDate);

        JPanel pntxtStartPrice = new JPanel();
        JLabel lbtxtStartPrice = new JLabel("Giá từ");
        lbtxtStartPrice.setFont(font);
        JTextField txtStartPrice = new JTextField();
        txtStartPrice.setPreferredSize(dtcEndDate.getPreferredSize());
        txtStartPrice.setFont(font);
        pntxtStartPrice.add(lbtxtStartPrice);
        pntxtStartPrice.add(txtStartPrice);
        pnSearchDate.add(pntxtStartPrice);
        
        JPanel pntxtEndPrice = new JPanel();
        JLabel lbtxtEndPrice = new JLabel("Đến");
        lbtxtEndPrice.setFont(font);
        JTextField txtEndPrice = new JTextField();
        txtEndPrice.setPreferredSize(dtcEndDate.getPreferredSize());
        txtEndPrice.setFont(font);
        pntxtEndPrice.add(lbtxtEndPrice);
        pntxtEndPrice.add(txtEndPrice);
        pnSearchDate.add(pntxtEndPrice);
        
        JButton btnSearchDate = new JButton(new ImageIcon("image/btn/search.png"));
        btnSearchDate.setPreferredSize(new Dimension(40, 40));
        btnSearchDate.setBorder(null);
        btnSearchDate.setFocusable(false);
        pnSearchDate.add(btnSearchDate);

        lbtxtStartPrice.setPreferredSize(lbtxtEndDate.getPreferredSize());
        lbtxtEndPrice.setPreferredSize(lbtxtEndDate.getPreferredSize());
        lbtxtStartDate.setPreferredSize(lbtxtEndDate.getPreferredSize());
        lbtxtStartDate.setPreferredSize(lbtxtEndDate.getPreferredSize());
        
        pnSearchMaPN.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, ClHover));
        pnSearchDate.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 0, ClHover));

        pnSearchPhieuNhap.add(pnSearchMaPN);
        pnSearchPhieuNhap.add(pnSearchDate);
        this.add(pnSearchPhieuNhap);
        
        JPanel pnTbPhieuNhap = new JPanel(new BorderLayout());//tạo khung chứa table
        String[] coltbPhieuNhap = {"Mã SP", "Mã NV", "Mã NCC", "Ngày tạo", "Tổng tiền"};
        DefaultTableModel dtmPhieuNhap = new DefaultTableModel(coltbPhieuNhap, 0);
        Mytable mtbPhieuNhap = new Mytable(dtmPhieuNhap);
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();//lấy định dạng mặc định của ô
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);//set căn giữa nội dung cho định dạng

        mtbPhieuNhap.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        mtbPhieuNhap.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        mtbPhieuNhap.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        mtbPhieuNhap.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        mtbPhieuNhap.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);

        mtbPhieuNhap.getColumnModel().getColumn(0).setPreferredWidth(10);
        mtbPhieuNhap.getColumnModel().getColumn(1).setPreferredWidth(10);
        mtbPhieuNhap.getColumnModel().getColumn(2).setPreferredWidth(10);
        mtbPhieuNhap.getColumnModel().getColumn(3).setPreferredWidth(10);
        mtbPhieuNhap.getColumnModel().getColumn(4).setPreferredWidth(10);

        JScrollPane scrmtbPhieuNhap = new JScrollPane(mtbPhieuNhap);
        pnTbPhieuNhap.add(scrmtbPhieuNhap, BorderLayout.CENTER);
        this.add(pnTbPhieuNhap);
    }
}
