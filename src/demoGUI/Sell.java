package demoGUI;
import Custom.listCard;
import DTO.SanPham;

import javax.swing.table.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Sell extends JPanel {
    int w = 800;
    int h = 700;
    Font font = new Font("Montserrat", Font.BOLD, 20);
    Font fontSmall = new Font("Montserrat", Font.BOLD, 15);
    Color colorMain = new Color(0, 160, 80);
    Border customBorder = BorderFactory.createLineBorder(colorMain, 2);

    public Sell() {
        addGiaodien();
    }
    private void addGiaodien(){
        // mấy cái giao diện này chia theo số dựa trên w, h chứ kh phải chia theo w, h
        this.setLayout(null);
        JPanel listProduct = new JPanel();
        listProduct.setLayout(null);
        listProduct.setBounds(0, 0, 800, 400);
        listProduct.setLayout(null);
        JLabel textTitle = new JLabel("Danh sách sản phẩm");
        textTitle.setBounds(300, 2, 250, 45);
        textTitle.setFont(font);
        JLabel buttonReset = new JLabel(new ImageIcon("image/btn/reset.png")); //hình ảnh reset
        buttonReset.setBounds(710, 8, 45, 35);
        buttonReset.setBorder(customBorder);
        Hover(buttonReset);
        //buttonReset.setOpaque(true);
        listProduct.add(buttonReset);
        JPanel bottomListProduct = new JPanel(); // chứa list
        bottomListProduct.setLayout(null);
        bottomListProduct.setBounds(0, 45, 783, 353);
        bottomListProduct.setBorder(customBorder);
        JPanel Search = new JPanel();
        Search.setLayout(null);
        Search.setBounds(2, 5, 779, 50);
        JTextField textFind = new JTextField();
        textFind.setBounds(420, 5, 280, 35);
        JLabel buttonSearch = new JLabel(new ImageIcon("image/btn/research.png")); // hình ảnh tìm kiếm
        buttonSearch.setBounds(708, 5, 45, 35);
        buttonSearch.setBorder(customBorder);
        Hover(buttonSearch);
        buttonSearch.setOpaque(true);
        Search.add(textFind);
        Search.add(buttonSearch);
        bottomListProduct.add(Search);
        // ================ chổ này thêm list product  w 783, h 318
        //ArrayList<SanPham> SP = new ArrayList<>();
        //listCard ls = new listCard(SP);


        JPanel Cart = new JPanel();
        Cart.setLayout(null);
        Cart.setBounds(0, 405, 783, 250);
        JLabel titleCart = new JLabel("Giỏ hàng");
        titleCart.setFont(font);
        titleCart.setBounds(350, 0, 100, 25);
        Cart.add(titleCart);
        JPanel table = new JPanel(new BorderLayout());
        table.setBounds(0, 27, 783, 223);
        String[] columnTable = {"Mã SP", "Tên SP", "Số Lượng", "Đơn Giá", "Thành Tiền"};
        DefaultTableModel modelTable = new DefaultTableModel(columnTable, 0);
        JTable tableCart = new JTable(modelTable);
        tableCart.setOpaque(true);
        tableCart.getColumnModel().getColumn(0).setPreferredWidth(150);
        tableCart.getColumnModel().getColumn(1).setPreferredWidth(250);
        tableCart.getColumnModel().getColumn(2).setPreferredWidth(90);
        tableCart.getColumnModel().getColumn(3).setPreferredWidth(100);
        tableCart.getColumnModel().getColumn(4).setPreferredWidth(193);
        tableCart.setBounds(2, 60, 779, 225);
        tableCart.getTableHeader().setFont(fontSmall);
        Border colorBoder = BorderFactory.createLineBorder(colorMain);
        TableCellRenderer editTable = tableCart.getTableHeader().getDefaultRenderer();
        tableCart.getTableHeader().setDefaultRenderer(new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JLabel label = (JLabel) editTable.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                label.setBackground(colorMain);
                label.setBorder(BorderFactory.createEmptyBorder());
                return label;
            }
        });
        JScrollPane scroll = new JScrollPane(tableCart);
        scroll.setBorder(colorBoder);
        table.add(scroll);
        Cart.add(table);
        this.setPreferredSize(new Dimension(w, h));
        this.add(Cart);
        listProduct.add(bottomListProduct);
        listProduct.add(textTitle);
        this.add(listProduct);
    }
    private void Hover(JLabel button){
        button.setBackground(Color.LIGHT_GRAY);
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(Color.DARK_GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(Color.LIGHT_GRAY);
            }
        });
    }
    public static void main(String[] args) {
        JFrame myfFrame=new JFrame();
        Sell s=new Sell();
        myfFrame.add(s);
        myfFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        myfFrame.pack();
        myfFrame.setResizable(false);
        myfFrame.setLocationRelativeTo(null);
        myfFrame.setVisible(true);
    }
}
