package demoGUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class PUChiTietSP extends JPanel{
    private int W = 400;
    private int H = 500;
    final Color ClMain = new Color(0, 160, 80); //#00A050
    final Color ClHover = new Color(0, 192, 96);
    final Color ClSelect = new Color(76, 204, 76);
    Border customBorder = BorderFactory.createLineBorder(ClMain, 2);
    Font FtTitleText = new Font("Montserrat", Font.BOLD, 15);
    public PUChiTietSP(){
        addGUI();
    }
    private void addGUI(){
        this.setPreferredSize(new Dimension(W, H));
        this.setBorder(customBorder);
        this.setLayout(null);

        // ảnh sp
        JPanel ImagePanel = new JPanel();
        ImagePanel.setBounds(50, 5, 300, 300);
        ImagePanel.setBackground(Color.pink);
        ImagePanel.setLayout(new BoxLayout(ImagePanel, BoxLayout.Y_AXIS));
        JLabel ImageProduct = new JLabel(new ImageIcon("C:/Users/PC/Downloads/logo.png"));
        ImageProduct.setPreferredSize(new Dimension(200, 200));
        ImagePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        ImagePanel.add(ImageProduct);
        ImagePanel.setBorder(customBorder);
        this.add(ImagePanel);

        // id sp
        JPanel idPanel = new JPanel();
        idPanel.setBounds(10, 315, 350, 20 );
        idPanel.setLayout(new BoxLayout(idPanel, BoxLayout.X_AXIS));
        JLabel idSanPham = new JLabel("ID Sản Phẩm: ");
        idSanPham.setFont(FtTitleText);
        JLabel txtID = new JLabel("test");
        txtID.setFont(FtTitleText);
        idPanel.add(idSanPham);
        idPanel.add(Box.createHorizontalStrut(80));
        idPanel.add(txtID);
        this.add(idPanel);

        // tên sp
        JPanel namePanel = new JPanel();
        namePanel.setBounds(10, 345, 350, 20);
        namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.X_AXIS));
        JLabel nameSanPham = new JLabel("Tên Sản Phẩm: ");
        nameSanPham.setFont(FtTitleText);
        JLabel txtName = new JLabel("test");
        txtName.setFont(FtTitleText);
        namePanel.add(nameSanPham);
        namePanel.add(Box.createHorizontalStrut(69));
        namePanel.add(txtName);
        this.add(namePanel);

        // loại sp
        JPanel LoaiPanel = new JPanel();
        LoaiPanel.setBounds(10, 375, 350, 20);
        LoaiPanel.setLayout(new BoxLayout(LoaiPanel, BoxLayout.X_AXIS));
        JLabel loaiSanPham = new JLabel("Loại Sản Phẩm: ");
        loaiSanPham.setFont(FtTitleText);
        JLabel txtLoai = new JLabel("test");
        txtLoai.setFont(FtTitleText);
        LoaiPanel.add(loaiSanPham);
        LoaiPanel.add(Box.createHorizontalStrut(65));
        LoaiPanel.add(txtLoai);
        this.add(LoaiPanel);

        //sl sp
        JPanel SLPanel = new JPanel();
        SLPanel.setBounds(10, 405, 350, 20);
        SLPanel.setLayout(new BoxLayout(SLPanel, BoxLayout.X_AXIS));
        JLabel SLSanPham = new JLabel("SL Sản Phẩm: ");
        SLSanPham.setFont(FtTitleText);
        JLabel txtSL = new JLabel("test");
        txtSL.setFont(FtTitleText);
        SLPanel.add(SLSanPham);
        SLPanel.add(Box.createHorizontalStrut(79));
        SLPanel.add(txtSL);
        this.add(SLPanel);

        // đơn giá
        JPanel PricePanel = new JPanel();
        PricePanel.setBounds(10, 435, 350, 20);
        PricePanel.setLayout(new BoxLayout(PricePanel, BoxLayout.X_AXIS));
        JLabel PriceSanPham = new JLabel("Đơn Giá Sản Phẩm: ");
        PriceSanPham.setFont(FtTitleText);
        JLabel txtPrice = new JLabel("test");
        txtPrice.setFont(FtTitleText);
        PricePanel.add(PriceSanPham);
        PricePanel.add(Box.createHorizontalStrut(37));
        PricePanel.add(txtPrice);
        this.add(PricePanel);

        // đơn vị tính của sp, cái, ...
        JPanel DonViPanel = new JPanel();
        DonViPanel.setBounds(10, 465, 350, 20);
        DonViPanel.setLayout(new BoxLayout(DonViPanel, BoxLayout.X_AXIS));
        JLabel DonViSanPham = new JLabel("Đơn Vị Tính Sản Phẩm: ");
        DonViSanPham.setFont(FtTitleText);
        JLabel txtDonVi = new JLabel("test");
        txtDonVi.setFont(FtTitleText);
        DonViPanel.add(DonViSanPham);
        DonViPanel.add(Box.createHorizontalStrut(9));
        DonViPanel.add(txtDonVi);
        this.add(DonViPanel);
    }

}

