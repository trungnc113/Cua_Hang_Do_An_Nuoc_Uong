package GUI;

import Custom.Mytable;
import static Main.Main.changLNF;
import demoGUI.QuanLySanPham;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class PnQuanLySanPhamGUI extends JPanel{
    DefaultTableModel dtmSanPham;
    JTextField txtMa, txtTen, txtsoLuong, txtdonViTinh, txtdonGia, txtTimKiem;
    JComboBox<String> cmbLoai;
    JButton btnThem, btnLuu, btnXoa, btnTim, btnChonAnh, btnReset, btnXuatExcel, btnNhapExcel;
    JLabel lblAnhSP;
    
    final Color ClHover  = new Color(0,160,80);
    final Color colorPanel = new Color(247, 247, 247);
    
    public PnQuanLySanPhamGUI(){
        changLNF("Windows");
        addControlsSanPham();
    }
    
    private void addControlsSanPham() {
        Font font = new Font("Tahoma", Font.PLAIN, 20);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(colorPanel);

        JPanel pnTitle = new JPanel();
        JLabel lblTitle = new JLabel("<html><h1>QUẢN LÝ SẢN PHẨM</h1></html>");
        lblTitle.setForeground(ClHover);
        btnReset = new JButton(new ImageIcon("image/btn/refresh.png"));
        btnReset.setPreferredSize(new Dimension(40, 40));
        btnReset.setFocusable(false);
        btnReset.setBorder(null);
        pnTitle.add(lblTitle);
        pnTitle.add(btnReset);
        this.add(pnTitle);

        JPanel pnThongTin = new JPanel();
        pnThongTin.setLayout(new BoxLayout(pnThongTin, BoxLayout.X_AXIS));

        //================PANEL INPUT=========
        JPanel pnTextField = new JPanel();
        pnTextField.setLayout(new BoxLayout(pnTextField, BoxLayout.Y_AXIS));
        JLabel lblMa, lblTen, lblLoai, lblSoLuong, lblDonViTinh, lblDonGia;

        lblMa = new JLabel("Mã SP");
        lblTen = new JLabel("Tên SP");
        lblLoai = new JLabel("Loại");
        lblSoLuong = new JLabel("Số lượng");
        lblDonViTinh = new JLabel("Đơn vị tính");
        lblDonGia = new JLabel("Đơn giá");

        txtMa = new JTextField(15);
        txtMa.setEditable(false);
        txtTen = new JTextField(15);
        cmbLoai = new JComboBox<String>();
        txtsoLuong = new JTextField(15);
        txtdonViTinh = new JTextField(15);
        txtdonGia = new JTextField(15);

        JPanel pnMa = new JPanel();
        lblMa.setFont(font);
        txtMa.setFont(font);
        pnMa.add(lblMa);
        pnMa.add(txtMa);
        pnTextField.add(pnMa);

        JPanel pnTen = new JPanel();
        lblTen.setFont(font);
        txtTen.setFont(font);
        pnTen.add(lblTen);
        pnTen.add(txtTen);
        pnTextField.add(pnTen);

        JPanel pnLoai = new JPanel();
        lblLoai.setFont(font);
        cmbLoai.setFont(font);
        cmbLoai.setPreferredSize(txtMa.getPreferredSize());
        cmbLoai.setFocusable(false);
        pnLoai.add(lblLoai);
        pnLoai.add(cmbLoai);
        pnTextField.add(pnLoai);

        JPanel pnSoLuong = new JPanel();
        lblSoLuong.setFont(font);
        txtsoLuong.setFont(font);
        pnSoLuong.add(lblSoLuong);
        pnSoLuong.add(txtsoLuong);
        pnTextField.add(pnSoLuong);

        JPanel pnDonViTinh = new JPanel();
        lblDonViTinh.setFont(font);
        txtdonViTinh.setFont(font);
        pnDonViTinh.add(lblDonViTinh);
        pnDonViTinh.add(txtdonViTinh);
        pnTextField.add(pnDonViTinh);

        JPanel pnDonGia = new JPanel();
        lblDonGia.setFont(font);
        txtdonGia.setFont(font);
        pnDonGia.add(lblDonGia);
        pnDonGia.add(txtdonGia);
        pnTextField.add(pnDonGia);

        Dimension lblSize = lblDonViTinh.getPreferredSize();
        lblMa.setPreferredSize(lblSize);
        lblTen.setPreferredSize(lblSize);
        lblLoai.setPreferredSize(lblSize);
        lblSoLuong.setPreferredSize(lblSize);
        lblDonViTinh.setPreferredSize(lblSize);
        lblDonGia.setPreferredSize(lblSize);

        pnThongTin.add(pnTextField);

        //=================PANEL ẢNH==========
        JPanel pnAnh = new JPanel();
        pnAnh.setLayout(new BoxLayout(pnAnh, BoxLayout.Y_AXIS));

        JPanel pnChuaAnh = new JPanel();
        pnChuaAnh.setPreferredSize(new Dimension((int) pnAnh.getPreferredSize().getWidth(), 250));
        lblAnhSP = new JLabel();
        lblAnhSP.setPreferredSize(new Dimension(200, 200));
        lblAnhSP.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        lblAnhSP.setIcon(getAnhSP(""));
        pnChuaAnh.add(lblAnhSP);
        pnAnh.add(pnChuaAnh);

        JPanel pnButtonAnh = new JPanel();
        pnButtonAnh.setPreferredSize(new Dimension(
        (int) pnChuaAnh.getPreferredSize().getHeight(), 40));
        btnChonAnh = new JButton("Chọn ảnh");
        btnChonAnh.setFont(font);
        btnChonAnh.setBackground(colorPanel);
        btnChonAnh.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        pnButtonAnh.add(btnChonAnh);
        pnChuaAnh.add(pnButtonAnh);

        pnThongTin.add(pnAnh);
        this.add(pnThongTin);

        JPanel pnButton = new JPanel();

        btnThem = new JButton("Thêm");
        btnLuu = new JButton("Lưu");
        btnXoa = new JButton("Xoá");
        btnTim = new JButton("Tìm kiếm");
        btnXuatExcel = new JButton("Xuất");
        btnNhapExcel = new JButton("Nhập");

        Font fontButton = new Font("Tahoma", Font.PLAIN, 16);
        btnThem.setFont(fontButton);
        btnLuu.setFont(fontButton);
        btnXoa.setFont(fontButton);
        btnTim.setFont(fontButton);
        btnXuatExcel.setFont(fontButton);
        btnNhapExcel.setFont(fontButton);

        btnThem.setIcon(new ImageIcon("image/btn/plus.png"));
        btnLuu.setIcon(new ImageIcon("image/btn/write.png"));
        btnXoa.setIcon(new ImageIcon("image/btn/bin.png"));
        btnTim.setIcon(new ImageIcon("image/btn/search.png"));
        btnXuatExcel.setIcon(new ImageIcon("image/btn/excel.png"));
        btnNhapExcel.setIcon(new ImageIcon("image/btn/excel.png"));

        JPanel pnTimKiem = new JPanel();
        JLabel lblTimKiem = new JLabel("Từ khoá tìm");
        lblTimKiem.setFont(font);
        txtTimKiem = new JTextField(20);
        txtTimKiem.setFont(font);
        pnTimKiem.add(lblTimKiem);
        pnTimKiem.add(txtTimKiem);
        this.add(pnTimKiem);

        pnButton.add(btnThem);
        pnButton.add(btnLuu);
        pnButton.add(btnXoa);
        pnButton.add(btnTim);
        pnButton.add(btnXuatExcel);
        pnButton.add(btnNhapExcel);

        Dimension btnSize = btnTim.getPreferredSize();
        btnThem.setPreferredSize(btnSize);
        btnLuu.setPreferredSize(btnSize);
        btnXoa.setPreferredSize(btnSize);
        btnTim.setPreferredSize(btnSize);
        btnXuatExcel.setPreferredSize(btnSize);
        btnNhapExcel.setPreferredSize(btnSize);
        
        btnThem.setFocusable(false);
        btnLuu.setFocusable(false);
        btnXoa.setFocusable(false);
        btnTim.setFocusable(false);
        btnXuatExcel.setFocusable(false);
        btnNhapExcel.setFocusable(false);

        this.add(pnButton);

        //============PANEL BẢNG===========
        JPanel pnTable = new JPanel(new BorderLayout());
        //====================Bảng hàng hoá====================
        dtmSanPham = new DefaultTableModel();
        dtmSanPham.addColumn("Mã SP");
        dtmSanPham.addColumn("Tên SP");
        dtmSanPham.addColumn("Loại SP");
        dtmSanPham.addColumn("Đơn giá");
        dtmSanPham.addColumn("Số lượng");
        dtmSanPham.addColumn("Đơn vị tính");
        dtmSanPham.addColumn("Ảnh");
        Mytable tblSanPham = new Mytable(dtmSanPham);
//        tblSanPham.getTableHeader().setDefaultRenderer(new QuanLySanPham.HeaderRenderer());

        tblSanPham.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tblSanPham.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tblSanPham.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tblSanPham.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        tblSanPham.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        tblSanPham.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        tblSanPham.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);

        TableColumnModel columnModelBanHang = tblSanPham.getColumnModel();
        columnModelBanHang.getColumn(0).setPreferredWidth(10);
        columnModelBanHang.getColumn(1).setPreferredWidth(100);
        columnModelBanHang.getColumn(2).setPreferredWidth(20);
        columnModelBanHang.getColumn(3).setPreferredWidth(20);
        columnModelBanHang.getColumn(4).setPreferredWidth(20);
        columnModelBanHang.getColumn(5).setPreferredWidth(20);
        columnModelBanHang.getColumn(6).setPreferredWidth(20);

        JScrollPane scrTblSanPham = new JScrollPane(tblSanPham);
        pnTable.add(scrTblSanPham, BorderLayout.CENTER);
        this.add(pnTable);

        loadDataCmbLoai();
    }
    private void loadDataCmbLoai() {
        cmbLoai.removeAllItems();
        cmbLoai.addItem("0 - Chọn loại");
        cmbLoai.addItem("Loại 1");
        cmbLoai.addItem("Loại 2");
        cmbLoai.addItem("Loại 3");
        cmbLoai.addItem("Khác...");
    }
    
    private ImageIcon getAnhSP(String src) {
        src = src.trim().equals("") ? "image/products/default.png" : src;
        //Xử lý ảnh
        ImageIcon imageIcon = new ImageIcon(src);
        Image image = imageIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        imageIcon = new ImageIcon(newimg);  // transform it back
        return imageIcon;
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Quản Lý Sản Phẩm");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        PnQuanLySanPhamGUI panel = new PnQuanLySanPhamGUI();
        frame.getContentPane().add(panel);

        frame.pack();
        frame.setSize(1200, 720);
        frame.setVisible(true);
    }
}
