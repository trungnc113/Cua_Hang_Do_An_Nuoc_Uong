package Custom;

import DTO.SanPham;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;

public class ProductCard extends JPanel {

    private SanPham sp;

    JTextArea nameProduct;

    private int w = 200;
    private int h = 250;

    public ProductCard(SanPham sp) {
        this.sp = sp;
        drawProductCard();
        addEvents();
    }

    private void drawProductCard() {
        //lấy ảnh và scale
        ImageIcon imageIcon = new ImageIcon(sp.getHinhAnh());
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(w - 50, 145, java.awt.Image.SCALE_SMOOTH); // scale img 
        imageIcon = new ImageIcon(newimg);  // gán lại

        JLabel imageJLabel = new JLabel(imageIcon);
        imageJLabel.setHorizontalAlignment(JLabel.CENTER);
        imageJLabel.setVerticalAlignment(JLabel.CENTER);
        imageJLabel.setBounds(0, 5, w, imageIcon.getIconHeight());
        //tên sản phẩm
        nameProduct = new JTextArea(sp.getTenSP());
        nameProduct.setFont(new Font("Arial", Font.BOLD, 20));
        nameProduct.setLineWrap(true);
        nameProduct.setForeground(Color.red);
        nameProduct.setEditable(false);
        nameProduct.setHighlighter(null);
        nameProduct.setBorder(null);
        //giá
        JLabel price = new JLabel("" + sp.getDonGia());
        price.setFont(new Font("Arial", Font.PLAIN, 18));
        price.setFocusable(false);
        //hiển thị thông tin
        JPanel info = new JPanel();
        info.setOpaque(false);
        info.setLayout(new BorderLayout());
        info.add(nameProduct, BorderLayout.NORTH);
        info.add(price, BorderLayout.CENTER);
        info.setBounds(5, imageJLabel.getHeight() + 10, w - 10, h - imageJLabel.getHeight() - 10);

        this.setLayout(null);
        this.setBackground(Color.white);
        this.add(info);
        this.add(imageJLabel);
        this.setPreferredSize(new Dimension(200, 250));
        this.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
    }

    private void addEvents() {
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(sp.getMaSP());
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        nameProduct.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(sp.getMaSP());
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

    }

}
