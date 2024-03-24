/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import Custom.Mytable;
import static Main.Main.changLNF;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nguye
 */
public class PnPhanQuyen extends JPanel {

    final Color ClMain = new Color(0, 160, 80);
    Font font = new Font("", Font.PLAIN, 20);

    public PnPhanQuyen() {
        changLNF("Windows");
        addControls();
    }

    public void addControls() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JPanel pnTitlePhanQuyen = new JPanel();
        JLabel lbTitlePhanQuyen = new JLabel("<html><h1>Quản lý phân quyền</h1></html>");
        lbTitlePhanQuyen.setForeground(ClMain);
        pnTitlePhanQuyen.add(lbTitlePhanQuyen);
        this.add(pnTitlePhanQuyen);

        JPanel pnCbQuyen = new JPanel();
        JLabel lbCbQuyen = new JLabel("<html><b>Nhóm quyền:<b><html>");
        lbCbQuyen.setFont(font);
        JComboBox<String> cmbQuyen = new JComboBox<>();
        cmbQuyen.setFont(font);
        cmbQuyen.addItem("Chọn quyền");
        cmbQuyen.setFocusable(false);
        cmbQuyen.setBackground(ClMain);
        pnCbQuyen.add(lbCbQuyen);
        pnCbQuyen.add(cmbQuyen);
        this.add(pnCbQuyen);

        JPanel pnCkQLnhaphang = new JPanel();
        JCheckBox ckbQLnhaphang = new JCheckBox("Quản lý nhập hàng");
        ckbQLnhaphang.setFocusable(false);
        ckbQLnhaphang.setFont(font);
        pnCkQLnhaphang.add(ckbQLnhaphang);
        this.add(pnCkQLnhaphang);

        JPanel pnCkQLsanpham = new JPanel();
        JCheckBox ckbQLsanpham = new JCheckBox("Quản lý sản phẩm");
        ckbQLsanpham.setFocusable(false);
        ckbQLsanpham.setFont(font);
        pnCkQLsanpham.add(ckbQLsanpham);
        this.add(pnCkQLsanpham);

        JPanel pnCkQLnhanvien = new JPanel();
        JCheckBox ckbQLnhanvien = new JCheckBox("Quản lý nhân viên");
        ckbQLnhanvien.setFocusable(false);
        ckbQLnhanvien.setFont(font);
        pnCkQLnhanvien.add(ckbQLnhanvien);
        this.add(pnCkQLnhanvien);

        JPanel pnCkQLkhachhang = new JPanel();
        JCheckBox ckbQLkhachhang = new JCheckBox("Quản lý khách hàng");
        ckbQLkhachhang.setFocusable(false);
        ckbQLkhachhang.setFont(font);
        pnCkQLkhachhang.add(ckbQLkhachhang);
        this.add(pnCkQLkhachhang);

        JPanel pnCkQLthongke = new JPanel();
        JCheckBox ckbQLthongke = new JCheckBox("Quản lý thống kê");
        ckbQLthongke.setFocusable(false);
        ckbQLthongke.setFont(font);
        pnCkQLthongke.add(ckbQLthongke);
        this.add(pnCkQLthongke);

        Dimension ckbSize = new Dimension(ckbQLkhachhang.getPreferredSize());
        ckbQLnhanvien.setPreferredSize(ckbSize);
        ckbQLnhaphang.setPreferredSize(ckbSize);
        ckbQLsanpham.setPreferredSize(ckbSize);
        ckbQLthongke.setPreferredSize(ckbSize);

        JPanel pnBtnQuyen = new JPanel();
        JButton btnThemquyen = new JButton("Thêm quyền");
        JButton btnSuaquyen = new JButton("Sửa quyền");
        JButton btnXoaquyen = new JButton("Xóa quyền");
        btnThemquyen.setIcon(new ImageIcon("image/btn/plus.png"));
        btnSuaquyen.setIcon(new ImageIcon("image/btn/write.png"));
        btnXoaquyen.setIcon(new ImageIcon("image/btn/bin.png"));
        btnThemquyen.setFocusable(false);
        btnSuaquyen.setFocusable(false);
        btnXoaquyen.setFocusable(false);
        btnThemquyen.setForeground(ClMain);
        btnSuaquyen.setForeground(ClMain);
        btnXoaquyen.setForeground(ClMain);
        btnThemquyen.setFont(font);
        btnSuaquyen.setFont(font);
        btnXoaquyen.setFont(font);
        pnBtnQuyen.add(btnThemquyen);
        pnBtnQuyen.add(btnSuaquyen);
        pnBtnQuyen.add(btnXoaquyen);
        this.add(pnBtnQuyen);

        Dimension btnSize3 = new Dimension(btnThemquyen.getPreferredSize());
        btnSuaquyen.setPreferredSize(btnSize3);
        btnXoaquyen.setPreferredSize(btnSize3);

        JPanel pnTitletbPhanQuyen = new JPanel();
        JLabel lbTitletbPhanQuyen = new JLabel("<html><h1>Danh sách quyền<h1><html>");
        lbTitletbPhanQuyen.setForeground(ClMain);
        pnTitletbPhanQuyen.add(lbTitletbPhanQuyen);
        this.add(pnTitletbPhanQuyen);

        DefaultTableModel dtm = new DefaultTableModel(new String[]{"Mã quyền", "Tên quyền", "QL Nhập hàng", "QL Sản phẩm", "QL Nhân viên", "QL Khách hàng", "QL Thống kê"}, 0);
        Mytable mtbQuyen = new Mytable(dtm);
        JScrollPane scrmtbQuyen = new JScrollPane(mtbQuyen, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.add(scrmtbQuyen);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        mtbQuyen.getColumnModel().getColumn(0).setPreferredWidth(50);
        mtbQuyen.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        mtbQuyen.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        mtbQuyen.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        mtbQuyen.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        mtbQuyen.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        mtbQuyen.getColumnModel().getColumn(5).setPreferredWidth(100);
        mtbQuyen.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        mtbQuyen.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
    }
}
