package GUI;

import demoGUI.*;
import Custom.Mytable;
import static Main.Main.changLNF;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;


public class PnNhanVien extends JPanel {

    public PnNhanVien() {
        changLNF("Windows");
        addControls();
    }

    final Color colorPanel = new Color(247, 247, 247);
    final Color ClHover  = new Color(0,160,80);
    final Color ClClick = new Color(76,204,76);
    final Color ClMain = new Color(0, 160, 80);

    DefaultTableModel dtmNhanVien;
    JTextField txtMaNV, txtHodem, Ten, txtChucVu, txtTimKiem;
    JComboBox<String> cmbGioiTinh;
    JButton btnThemNV, btnLuuNV, btnXoaNV, btnTimNV,btnCapTaiKhoan, btnResetMatKhauNV, btnKhoaTaiKhoanNV, btnResetNV, btnXuatExcel, btnNhapExcel;

    private void addControls() {
        Font font = new Font("", Font.PLAIN, 20);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(colorPanel);

        JPanel pnTitle = new JPanel();
        JLabel lblTitle = new JLabel("<html><h1>QUẢN LÍ NHÂN VIÊN</h1></html>");
        lblTitle.setForeground(ClMain);
        btnResetNV = new JButton(new ImageIcon("image/btn/refresh.png")); 
        btnResetNV.setPreferredSize(new Dimension(40, 40));
        btnResetNV.setBorder(null); // xóa viền
        btnResetNV.setFocusable(false); // bỏ focus để không hiển thị viền khi focus
        btnResetNV.setOpaque(false); // nền trong suốt 
        pnTitle.add(lblTitle);
        pnTitle.add(btnResetNV);
        this.add(pnTitle);

        JPanel pnThongTin = new JPanel();
        pnThongTin.setLayout(new BoxLayout(pnThongTin, BoxLayout.X_AXIS));

        //================PANEL INPUT=========
        JPanel pnTextField = new JPanel();
        pnTextField.setLayout(new BoxLayout(pnTextField, BoxLayout.Y_AXIS));

        JLabel lblMaNV, lblHoDem, lblTen,lblGioiTinh, lblChucVu, lblTimKiem;

        lblMaNV = new JLabel("Mã NV");
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
        cmbGioiTinh.setFocusable(false); // bỏ focus 
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

        Dimension lblSize = lblTimKiem.getPreferredSize();// nên lấy kích thước của label có độ rộng lớn nhất
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

        btnThemNV.setIcon(new ImageIcon("image/btn/plus.png"));
        btnLuuNV.setIcon(new ImageIcon("image/btn/write.png"));
        btnXoaNV.setIcon(new ImageIcon("image/btn/bin.png"));
        btnTimNV.setIcon(new ImageIcon("image/btn/search.png"));
        btnCapTaiKhoan.setIcon(new ImageIcon("image/btn/avatar.png"));
        btnResetMatKhauNV.setIcon(new ImageIcon("image/btn/reset-password.png"));
        btnKhoaTaiKhoanNV.setIcon(new ImageIcon("image/btn/lock.png"));
        btnXuatExcel.setIcon(new ImageIcon("image/btn/excel.png"));
        btnNhapExcel.setIcon(new ImageIcon("image/btn/excel.png"));
        //setFocusable(false) để bỏ viền khi click vào
        btnThemNV.setFocusable(false);
        btnLuuNV.setFocusable(false);
        btnXoaNV.setFocusable(false);
        btnTimNV.setFocusable(false);
        btnCapTaiKhoan.setFocusable(false);
        btnResetMatKhauNV.setFocusable(false);
        btnKhoaTaiKhoanNV.setFocusable(false);
        btnXuatExcel.setFocusable(false);
        btnNhapExcel.setFocusable(false);

        pnButton.add(btnThemNV);
        pnButton.add(btnLuuNV);
        pnButton.add(btnXoaNV);
        pnButton.add(btnTimNV);
        pnButton.add(btnXuatExcel);
        pnButton.add(btnNhapExcel);
        //tách ra 2 dòng button 
        JPanel pnButton2=new JPanel();
        pnButton2.add(btnCapTaiKhoan);
        pnButton2.add(btnResetMatKhauNV);
        pnButton2.add(btnKhoaTaiKhoanNV);

        Dimension btnSize = btnTimNV.getPreferredSize();
        btnThemNV.setPreferredSize(btnSize);
        btnLuuNV.setPreferredSize(btnSize);
        btnXoaNV.setPreferredSize(btnSize);
        btnTimNV.setPreferredSize(btnSize);
        btnXuatExcel.setPreferredSize(btnSize);
        btnNhapExcel.setPreferredSize(btnSize);

        Dimension btnSize2=btnResetMatKhauNV.getPreferredSize();
        btnCapTaiKhoan.setPreferredSize(btnSize2);
        btnResetMatKhauNV.setPreferredSize(btnSize2);
        
        this.add(pnButton);
        this.add(pnButton2);

        //============PANEL BẢNG===========
        JPanel pnTable = new JPanel(new BorderLayout());
        //====================Bảng hàng hoá====================
        dtmNhanVien = new DefaultTableModel();
        dtmNhanVien.addColumn("Mã Nhân viên");
        dtmNhanVien.addColumn("Họ đệm");
        dtmNhanVien.addColumn("Tên");
        dtmNhanVien.addColumn("Giới tính");
        dtmNhanVien.addColumn("Chức vụ");
        dtmNhanVien.addColumn("Tài khoản");
        Mytable tblSanPham = new Mytable(dtmNhanVien); // sử dụng MyTable mình tạo sẵn

        TableColumnModel columnModelBanHang = tblSanPham.getColumnModel();
        columnModelBanHang.getColumn(0).setPreferredWidth(20);
        columnModelBanHang.getColumn(1).setPreferredWidth(20);
        columnModelBanHang.getColumn(2).setPreferredWidth(20);
        columnModelBanHang.getColumn(3).setPreferredWidth(20);
        columnModelBanHang.getColumn(4).setPreferredWidth(20);
        columnModelBanHang.getColumn(5).setPreferredWidth(20);

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

    public static void main(String[] args) {
        JFrame frame = new JFrame("Quản lí nhân viên");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        PnNhanVien panel = new PnNhanVien();
        frame.getContentPane().add(panel);

        frame.pack();
        frame.setSize(1200, 720);
        frame.setVisible(true);
    }
}

