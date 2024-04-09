/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import Custom.Mytable;
import Custom.listCard; 
import DTO.SanPham;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
public class PnBanHang extends JPanel {

    final Color ClMain = new Color(0, 160, 80);
    final Color ClHover = new Color(0, 192, 96);
    final Color ClSelect = new Color(76, 204, 76);

    Font FtTitleText = new Font("Montserrat", Font.BOLD, 20);
    Font font = new Font("", Font.PLAIN, 20);

    listCard listCardSP;

    public PnBanHang() {
        addControls();
    }

    private void addControls() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();//lấy định dạng mặc định của ô
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);//set căn giữa nội dung cho định dạng
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));//sắp xếp theo chiều dọc

        JPanel pnTitleBanHang = new JPanel();//tạo khung chứa title và nút reset
        JLabel textTitle = new JLabel("<html><h1>Danh sách sản phẩm</h1></html>");
        textTitle.setForeground(ClMain);//thêm màu xanh
        JButton btnResetBanHang = new JButton(new ImageIcon("image/btn/refresh.png")); //đổi thành JButton
        btnResetBanHang.setPreferredSize(new Dimension(40, 40));// đặt kích thước ưa thích 40x40
        btnResetBanHang.setFocusable(false);// bỏ focus để mất viền của focus
        btnResetBanHang.setBorder(null);// xóa viền
        pnTitleBanHang.add(textTitle);
        pnTitleBanHang.add(btnResetBanHang);

        this.add(pnTitleBanHang);//thêm vào khung bán hàng

        JPanel pnSearchSP = new JPanel(); //tạo khung chứa nơi tìm kiếm
        pnSearchSP.setLayout(new BoxLayout(pnSearchSP, BoxLayout.X_AXIS));

        JPanel pnTypeSP = new JPanel();//tạo khung chứa nơi chọn loại sp
        JLabel lbTypeSP = new JLabel("Loại");
        lbTypeSP.setFont(font);
        JComboBox<String> cmbTypeSP = new JComboBox<>();
        cmbTypeSP.addItem("Loại sản phẩm");// khi có database thì xóa dòng này tạo hàm mới để lấy data các loại và add vào combobox này
        cmbTypeSP.setFont(font);
        cmbTypeSP.setFocusable(false);
        pnTypeSP.add(lbTypeSP);
        pnTypeSP.add(cmbTypeSP);
        pnSearchSP.add(pnTypeSP);

        JPanel pnFindSP = new JPanel();//tạo khung chứa thanh tìm sp
        pnFindSP.setLayout(new BoxLayout(pnFindSP,BoxLayout.X_AXIS));
        JLabel lbFindSP = new JLabel("Tìm kiếm");
        lbFindSP.setFont(font);
        JTextField textFind = new JTextField(25);
        textFind.setFont(font);
        JButton btnFindSP = new JButton(new ImageIcon("image/btn/search.png"));
        btnFindSP.setPreferredSize(new Dimension(40, 40));
        btnFindSP.setBorder(null);
        btnFindSP.setFocusable(false);
        pnFindSP.add(lbFindSP);
        pnFindSP.add(textFind);
        pnFindSP.add(btnFindSP);
        pnSearchSP.add(pnFindSP);

        this.add(pnSearchSP);

        listCardSP = new listCard(); // tạo listCard
        this.add(listCardSP);

        JPanel pnTltGioHang = new JPanel();//tạo khung chứa tên giỏ hàng
        JLabel lbTltGioHang = new JLabel("<html><h1>Giỏ hàng</h1></html>");
        lbTltGioHang.setForeground(ClMain);
        pnTltGioHang.add(lbTltGioHang);
        this.add(pnTltGioHang);

        JPanel pnTbGioHang = new JPanel(new BorderLayout());//tạo khung chứa giỏ hàng
        String[] columnTable = {"Mã SP", "Tên SP", "Số Lượng", "Đơn Giá", "Thành Tiền"};
        DefaultTableModel dtmGioHang = new DefaultTableModel(columnTable, 0);
        Mytable mtbGioHang = new Mytable(dtmGioHang);

        mtbGioHang.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        mtbGioHang.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        mtbGioHang.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        mtbGioHang.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        mtbGioHang.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);

        mtbGioHang.getColumnModel().getColumn(0).setPreferredWidth(10);
        mtbGioHang.getColumnModel().getColumn(1).setPreferredWidth(100);
        mtbGioHang.getColumnModel().getColumn(2).setPreferredWidth(20);
        mtbGioHang.getColumnModel().getColumn(3).setPreferredWidth(20);
        mtbGioHang.getColumnModel().getColumn(4).setPreferredWidth(20);

        JScrollPane scrmtbGioHang = new JScrollPane(mtbGioHang);

        pnTbGioHang.add(scrmtbGioHang, BorderLayout.CENTER);
        this.add(pnTbGioHang);
        loadDatalistSP();

    }

    private void loadDatalistSP() { // có database thì sửa lại
        for (int i = 1; i <= 8; i++) {
            listCardSP.addCard(new SanPham(i, "Pizza " + i, 1, 100, "cái", "image/Logo/logo.png", 100000,1));
        }
    }
}