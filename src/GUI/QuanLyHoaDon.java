package GUI;

import Custom.*;
import javax.swing.table.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class QuanLyHoaDon extends JPanel {
    int w = 800;
    int h = 700;
    Font font = new Font("Montserrat", Font.BOLD, 20);
    Font fontMedium = new Font("Montserrat", Font.BOLD, 15).deriveFont(Font.BOLD, 15f);
    Font fontMediumsmall = new Font("Montserrat", Font.BOLD, 15).deriveFont(Font.BOLD, 13f);
    Color colorMain = new Color(0, 160, 80);
    Border customBorder = BorderFactory.createLineBorder(colorMain, 2);
    public QuanLyHoaDon(){
        addGiaodien();
    }
    private void addGiaodien(){
        this.setLayout(null);
        JPanel Search = new JPanel();
        Search.setLayout(null);
        Search.setBounds(0, 0, 784, 300);
        Search.setBorder(customBorder);
        JLabel Title = new JLabel("THÔNG TIN HÓA ĐƠN");
        Title.setBounds(280, 5, 300, 45);
        Title.setFont(font);
        Search.add(Title);
        JPanel SearchMAHD = new JPanel();
        SearchMAHD.setLayout(null);
        SearchMAHD.setBounds(0, 50, 392, 250);
        SearchMAHD.setBorder(customBorder);
        Search.add(SearchMAHD);
        JLabel titleSearchMAHD = new JLabel("Tìm kiếm Mã Hóa Đơn");
        titleSearchMAHD.setBounds(120, 5, 200, 25);
        titleSearchMAHD.setFont(fontMedium);
        SearchMAHD.add(titleSearchMAHD);
        JLabel MAHD = new JLabel("Mã HD:");
        MAHD.setBounds(50, 40, 60, 30);
        MAHD.setFont(fontMediumsmall);
        SearchMAHD.add(MAHD);
        JTextField textMAHD = new JTextField();
        textMAHD.setBounds(120,40, 200, 30 );
        SearchMAHD.add(textMAHD);
        JLabel buttonSearchMAHD = new JLabel(new ImageIcon("image/btn/research.png")); // hình ảnh tìm kiếm
        buttonSearchMAHD.setOpaque(true);
        buttonSearchMAHD.setBounds(185, 80, 45, 35);
        buttonSearchMAHD.setBorder(customBorder);
        Hover(buttonSearchMAHD);
        SearchMAHD.add(buttonSearchMAHD);

        JPanel SearchDate = new JPanel();
        SearchDate.setBounds(390, 50, 394, 250);
        SearchDate.setLayout(null);
        SearchDate.setBorder(customBorder);
        Search.add(SearchDate);
        JLabel titleSearchDate = new JLabel("Tìm kiếm theo ngày");
        titleSearchDate.setBounds(120, 5,200, 25);
        titleSearchDate.setFont(fontMedium);
        JLabel TuNgay = new JLabel("Từ ngày    :");
        TuNgay.setBounds(50, 40, 80, 30);
        TuNgay.setFont(fontMediumsmall);
        SearchDate.add(TuNgay);
        JTextField dateStart = new JTextField();
        dateStart.setBounds(130, 40, 200, 30);
        SearchDate.add(dateStart);
        JLabel DenDate = new JLabel("Đến Ngày :");
        DenDate.setBounds(50, 80, 80, 30);
        DenDate.setFont(fontMediumsmall);
        SearchDate.add(DenDate);
        JTextField dateEnd = new JTextField();
        dateEnd.setBounds(130, 80, 200, 30 );
        SearchDate.add(dateEnd);
        SearchDate.add(titleSearchDate);
        JLabel GiaTu = new JLabel("Giá từ       :");
        GiaTu.setBounds(50, 120, 80, 30);
        GiaTu.setFont(fontMediumsmall);
        SearchDate.add(GiaTu);
        JTextField textGiaTu = new JTextField();
        textGiaTu.setBounds(130, 120, 200, 30);
        SearchDate.add(textGiaTu);
        JLabel DenGia = new JLabel("Đến          :");
        DenGia.setBounds(50, 160, 80, 30);
        DenGia.setFont(fontMediumsmall);
        SearchDate.add(DenGia);
        JTextField GiaEnd = new JTextField();
        GiaEnd.setBounds(130, 160, 200, 30 );
        SearchDate.add(GiaEnd);
        JLabel buttonSearchDate = new JLabel(new ImageIcon("image/btn/research.png")); // hình ảnh tìm kiếm
        buttonSearchDate.setOpaque(true);
        buttonSearchDate.setBounds(200, 200, 45, 35);
        buttonSearchDate.setBorder(customBorder);
        Hover(buttonSearchDate);
        SearchDate.add(buttonSearchDate);

        JPanel table = new JPanel();
        table.setBounds(0, 305, 784, 400);
        table.setLayout(new BorderLayout());
        String[] TitleColumn ={"Mã HD", "Mã NV","Mã KH","Ngày tạo", "Tổng tiền"};
        DefaultTableModel model = new DefaultTableModel(TitleColumn, 0);
        JTable tableHD = new JTable(model);
        tableHD.getColumnModel().getColumn(0).setPreferredWidth(150);// 784
        tableHD.getColumnModel().getColumn(1).setPreferredWidth(150);
        tableHD.getColumnModel().getColumn(2).setPreferredWidth(150);
        tableHD.getColumnModel().getColumn(3).setPreferredWidth(150);
        tableHD.getColumnModel().getColumn(4).setPreferredWidth(184);
        tableHD.setBounds(0, 0, 784, 400);
        tableHD.getTableHeader().setFont(fontMedium);
        TableCellRenderer editTable = tableHD.getTableHeader().getDefaultRenderer();
        tableHD.getTableHeader().setDefaultRenderer(new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JLabel label = (JLabel) editTable.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                label.setBackground(colorMain);
                label.setBorder(BorderFactory.createEmptyBorder());
                return label;
            }
        });
        JScrollPane scroll = new JScrollPane(tableHD);
        scroll.setBorder(BorderFactory.createLineBorder(colorMain));
        table.add(scroll);
        this.setPreferredSize(new Dimension(w, h));
        this.add(table);
        this.add(Search);
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


}
