package demoGUI;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;


public class quanLiNhanVien extends JPanel {

    public quanLiNhanVien() {
        addControlsNhanVien();
        addHoverEffects();
        addClickEffects();
    }

    final Color colorPanel = new Color(247, 247, 247);
    final Color ClHover  = new Color(0,160,80);
    final Color ClClick = new Color(76,204,76);
    DefaultTableModel dtmNhanVien;
    JTextField txtMaNV, txtHodem, Ten, txtChucVu, txtTimKiem;
    JComboBox<String> cmbGioiTinh;
    JButton btnThemNV, btnLuuNV, btnXoaNV, btnTimNV, btnChonAnh,btnCapTaiKhoan, btnResetMatKhauNV, btnKhoaTaiKhoanNV, btnResetNV, btnXuatExcel, btnNhapExcel;
    JLabel lblAnhSP;

    private void addControlsNhanVien() {
        Font font = new Font("", Font.PLAIN, 20);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(colorPanel);

        JPanel pnTitle = new JPanel();
        JLabel lblTitle = new JLabel("<html><h1>QUẢN LÍ NHÂN VIÊN</h1></html>");
        btnResetNV = new JButton(new ImageIcon("image/Refresh-icon.png"));
        btnResetNV.setPreferredSize(new Dimension(40, 40));
        pnTitle.add(lblTitle);
        pnTitle.add(btnResetNV);
        this.add(pnTitle);

        JPanel pnThongTin = new JPanel();
        pnThongTin.setLayout(new BoxLayout(pnThongTin, BoxLayout.X_AXIS));

        //================PANEL INPUT=========
        JPanel pnTextField = new JPanel();
        pnTextField.setLayout(new BoxLayout(pnTextField, BoxLayout.Y_AXIS));

        JLabel lblMaNV, lblHoDem, lblTen,lblGioiTinh, lblChucVu, lblTimKiem;

        lblMaNV = new JLabel("Mã nhân viên");
        lblHoDem = new JLabel("Họ đệm");
        lblTen = new JLabel("Tên");
        lblGioiTinh = new JLabel("Giới tính");
        lblChucVu = new JLabel("Chức vụ");
        lblTimKiem = new JLabel("Từ khóa tìm");
        txtMaNV = new JTextField(25);
        txtMaNV.setEditable(false);
        txtHodem = new JTextField(25);
        Ten = new JTextField(25);
        cmbGioiTinh = new JComboBox<String>();
        txtChucVu = new JTextField(25);
        txtTimKiem = new JTextField(25);

        JPanel pnMaNV = new JPanel();
        lblMaNV.setFont(font);
        txtMaNV.setFont(font);
        pnMaNV.add(lblMaNV);
        pnMaNV.add(txtMaNV);
        pnTextField.add(pnMaNV);

        JPanel pnHoDem = new JPanel();
        lblHoDem.setFont(font);
        txtHodem.setFont(font);
        pnHoDem.add(lblHoDem);
        pnHoDem.add(txtHodem);
        pnTextField.add(pnHoDem);

        JPanel pnGioiTinh = new JPanel();
        lblGioiTinh.setFont(font);
        cmbGioiTinh.setFont(font);
        cmbGioiTinh.setPreferredSize(txtMaNV.getPreferredSize()); 
        pnGioiTinh.add(lblGioiTinh);
        pnGioiTinh.add(cmbGioiTinh);
        pnTextField.add(pnGioiTinh);

        JPanel pnTen = new JPanel();
        lblTen.setFont(font);
        Ten.setFont(font);
        pnTen.add(lblTen);
        pnTen.add(Ten);
        pnTextField.add(pnTen);

        JPanel pnChucVu = new JPanel();
        lblChucVu.setFont(font);
        txtChucVu.setFont(font);
        pnChucVu.add(lblChucVu);
        pnChucVu.add(txtChucVu);
        pnTextField.add(pnChucVu);

        JPanel TimKiem = new JPanel();
        lblTimKiem.setFont(font);
        txtTimKiem.setFont(font);
        TimKiem.add(lblTimKiem);
        TimKiem.add(txtTimKiem);
        pnTextField.add(TimKiem);

        Dimension lblSize = lblMaNV.getPreferredSize();
        lblMaNV.setPreferredSize(lblSize);
        lblHoDem.setPreferredSize(lblSize);
        lblGioiTinh.setPreferredSize(lblSize);
        lblTen.setPreferredSize(lblSize);
        lblChucVu.setPreferredSize(lblSize);
        lblTimKiem.setPreferredSize(lblSize);

        pnThongTin.add(pnTextField);
        this.add(pnThongTin);

        JPanel pnButton = new JPanel();

        btnThemNV = new JButton("Thêm");
        btnLuuNV = new JButton("Lưu");
        btnXoaNV = new JButton("Xoá");
        btnTimNV = new JButton("Tìm kiếm");
        btnCapTaiKhoan = new JButton("Cấp tài khoản");
        btnResetMatKhauNV = new JButton("Mật khẩu/Quyền");
        btnKhoaTaiKhoanNV = new JButton("Khóa tài khoản");
        btnXuatExcel = new JButton("Xuất");
        btnNhapExcel = new JButton("Nhập");

        btnThemNV.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btnLuuNV.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btnXoaNV.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btnTimNV.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btnCapTaiKhoan.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btnResetMatKhauNV.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btnKhoaTaiKhoanNV.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btnXuatExcel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btnNhapExcel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        // btnXoaNV.setBackground(colorPanel);
        // btnLuuNV.setBackground(colorPanel);
        // btnXuatExcel.setBackground(colorPanel);
        // btnTimNV.setBackground(colorPanel);
        // btnCapTaiKhoan.setBackground(colorPanel);
        // btnResetMatKhauNV.setBackground(colorPanel);
        // btnKhoaTaiKhoanNV.setBackground(colorPanel);
        // btnNhapExcel.setBackground(colorPanel);
        // btnThemNV.setBackground(colorPanel);

        Font fontButton = new Font("Tahoma", Font.PLAIN, 16);
        btnThemNV.setFont(fontButton);
        btnLuuNV.setFont(fontButton);
        btnXoaNV.setFont(fontButton);
        btnTimNV.setFont(fontButton);
        btnCapTaiKhoan.setFont(fontButton);
        btnResetMatKhauNV.setFont(fontButton);
        btnKhoaTaiKhoanNV.setFont(fontButton);
        btnXuatExcel.setFont(fontButton);
        btnNhapExcel.setFont(fontButton);

        btnThemNV.setIcon(new ImageIcon("image/add-icon.png"));
        btnLuuNV.setIcon(new ImageIcon("image/Pencil-icon.png"));
        btnXoaNV.setIcon(new ImageIcon("image/delete-icon.png"));
        btnTimNV.setIcon(new ImageIcon("image/Search-icon.png"));
        btnCapTaiKhoan.setIcon(new ImageIcon("image/icons8_man_with_key_32px.png"));
        btnResetMatKhauNV.setIcon(new ImageIcon("image/icons8_password_reset_32px.png"));
        btnKhoaTaiKhoanNV.setIcon(new ImageIcon("image/icons8_denied_32px.png"));
        btnXuatExcel.setIcon(new ImageIcon("image/excel-icon.png"));
        btnNhapExcel.setIcon(new ImageIcon("image/excel-icon.png"));

        pnButton.add(btnThemNV);
        pnButton.add(btnLuuNV);
        pnButton.add(btnXoaNV);
        pnButton.add(btnTimNV);
        pnButton.add(btnXuatExcel);
        pnButton.add(btnNhapExcel);
        pnButton.add(btnCapTaiKhoan);
        pnButton.add(btnResetMatKhauNV);
        pnButton.add(btnKhoaTaiKhoanNV);

        Dimension btnSize = btnTimNV.getPreferredSize();
        btnThemNV.setPreferredSize(btnSize);
        btnLuuNV.setPreferredSize(btnSize);
        btnXoaNV.setPreferredSize(btnSize);
        btnTimNV.setPreferredSize(btnSize);
        btnCapTaiKhoan.setPreferredSize(btnSize);
        btnResetMatKhauNV.setPreferredSize(btnSize);
        btnKhoaTaiKhoanNV.setPreferredSize(btnSize);
        btnXuatExcel.setPreferredSize(btnSize);
        btnNhapExcel.setPreferredSize(btnSize);

        this.add(pnButton);

        //============PANEL BẢNG===========
        JPanel pnTable = new JPanel(new BorderLayout());
        //====================Bảng hàng hoá====================
        dtmNhanVien = new DefaultTableModel();
        dtmNhanVien.addColumn("Mã Nhân viên");
        dtmNhanVien.addColumn("Tên SP");
        dtmNhanVien.addColumn("Loại SP");
        dtmNhanVien.addColumn("Đơn giá");
        dtmNhanVien.addColumn("Số lượng");
        dtmNhanVien.addColumn("Đơn vị tính");
        dtmNhanVien.addColumn("Ảnh");
        JTable tblSanPham = new JTable(dtmNhanVien);
        tblSanPham.getTableHeader().setDefaultRenderer(new HeaderRenderer());

        tblSanPham.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tblSanPham.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        tblSanPham.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        tblSanPham.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);

        TableColumnModel columnModelBanHang = tblSanPham.getColumnModel();
        columnModelBanHang.getColumn(0).setPreferredWidth(77);
        columnModelBanHang.getColumn(1).setPreferredWidth(282);
        columnModelBanHang.getColumn(2).setPreferredWidth(120);
        columnModelBanHang.getColumn(3).setPreferredWidth(85);
        columnModelBanHang.getColumn(4).setPreferredWidth(138);
        columnModelBanHang.getColumn(5).setPreferredWidth(140);
        columnModelBanHang.getColumn(6).setPreferredWidth(0);

        JScrollPane scrTblSanPham = new JScrollPane(tblSanPham);
        pnTable.add(scrTblSanPham, BorderLayout.CENTER);
        this.add(pnTable);

        loadDataCmbGioiTinh();
    }

    private void loadDataCmbGioiTinh() {
        cmbGioiTinh.removeAllItems();
        cmbGioiTinh.addItem("Chọn giới tính");
        cmbGioiTinh.addItem("Nữ");
        cmbGioiTinh.addItem("Nam");
        cmbGioiTinh.addItem("Khác");
    }

    private void addClickEffects(){
        addClickEffects(btnThemNV);
        addClickEffects(btnLuuNV);
        addClickEffects(btnXoaNV);
        addClickEffects(btnTimNV);
        addClickEffects(btnXuatExcel);
        addClickEffects(btnNhapExcel);
        addClickEffects(btnResetNV);
        addClickEffects(btnCapTaiKhoan);
        addClickEffects(btnResetMatKhauNV);
        addClickEffects(btnKhoaTaiKhoanNV);
    }

    private void addClickEffects(JButton button){
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button.setBackground(ClClick); // Màu nền khi hover
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(colorPanel); // Màu nền mặc định khi không hover
            }
        });
    }

    private void addHoverEffects() {
        addHoverEffect(btnThemNV);
        addHoverEffect(btnLuuNV);
        addHoverEffect(btnXoaNV);
        addHoverEffect(btnTimNV);
        addHoverEffect(btnXuatExcel);
        addHoverEffect(btnNhapExcel);
        addHoverEffect(btnCapTaiKhoan);
        addHoverEffect(btnResetMatKhauNV);
        addHoverEffect(btnKhoaTaiKhoanNV);
    }

    private void addHoverEffect(JButton button) {
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(ClHover); // Màu nền khi hover
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(colorPanel); // Màu nền mặc định khi không hover
            }
        });
    }

    static class HeaderRenderer extends DefaultTableCellRenderer{
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelect, boolean hasfocus, int row, int column){
            super.getTableCellRendererComponent(table, value, isSelect, hasfocus, row, column);
            setBackground(new Color(0,160,80));
            setForeground(Color.WHITE);
            return this;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Quản lí nhân viên");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        quanLiNhanVien panel = new quanLiNhanVien();
        frame.getContentPane().add(panel);

        frame.pack();
        frame.setSize(1200, 720);
        frame.setVisible(true);
    }
}

