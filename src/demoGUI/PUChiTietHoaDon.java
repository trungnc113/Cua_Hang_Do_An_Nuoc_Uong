package demoGUI;

import Custom.Mytable;
import DTO.CTHoaDon;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class PUChiTietHoaDon extends JPanel {
    private int W = 500;
    private int H = 500;
    final Color ClMain = new Color(0, 160, 80); //#00A050
    final Color ClHover = new Color(0, 192, 96);
    final Color ClSelect = new Color(76, 204, 76);
    Border customBorder = BorderFactory.createLineBorder(ClMain, 2);
    Font FtTitleText = new Font("Montserrat", Font.BOLD, 15);

    public PUChiTietHoaDon(CTHoaDon CTHD) {
        addGUI(CTHD);
    }

    private void addGUI(CTHoaDon CTHD) {
        this.setPreferredSize(new Dimension(W, H));
        this.setBorder(customBorder);
        this.setLayout(null);

        // title
        JLabel TitleCTHD = new JLabel("---------- Chi Tiết Hóa Đơn ----------");
        TitleCTHD.setBounds(125, 10, 300, 40);
        TitleCTHD.setFont(FtTitleText);
        this.add(TitleCTHD);

        // table
        String NameColume[] = {"IDSP","Tên SP","Đơn Giá","SL","Thành Tiền"};
        DefaultTableModel model = new DefaultTableModel(NameColume, 0);
        Mytable TB = new Mytable(model);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();//lấy định dạng mặc định của ô
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);//set căn giữa nội dung cho định dạng
        TB.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        TB.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        TB.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        TB.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        TB.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);

        TB.getColumnModel().getColumn(0).setPreferredWidth(10);
        TB.getColumnModel().getColumn(1).setPreferredWidth(10);
        TB.getColumnModel().getColumn(2).setPreferredWidth(10);
        TB.getColumnModel().getColumn(3).setPreferredWidth(10);
        TB.getColumnModel().getColumn(4).setPreferredWidth(10);
        TB.getTableHeader().setFont(FtTitleText);

        // chỉnh headertable ( chỉnh màu tiêu đề + xóa border tiêu đề)
//        TableCellRenderer TBHeader = TB.getTableHeader().getDefaultRenderer();
//        TB.getTableHeader().setDefaultRenderer(new TableCellRenderer() {
//            @Override
//            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//                JLabel label = (JLabel) TBHeader.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
//                label.setBackground(ClMain);
//                label.setBorder(BorderFactory.createEmptyBorder());
//                return label;
//            }
//        });
        JScrollPane Scl = new JScrollPane(TB); // Thêm JTable vào JScrollPane
        Scl.setBounds(2, 70, 496, 350);
        this.add(Scl);

        // Tổng tiền
        JLabel TongTien = new JLabel();
        TongTien.setBounds(250, 430, 100, 30);
        TongTien.setFont(FtTitleText);
        JLabel KQTongTien = new JLabel("100.000đ");// thay giá trị tổng tiền
        KQTongTien.setFont(FtTitleText);
        KQTongTien.setBounds(360, 430, 130, 30);
        this.add(KQTongTien);
        this.add(TongTien);

        // cảm ơn
//        JLabel txtThanks = new JLabel("Cảm ơn quý khách đã ủng hộ !!!");
//        txtThanks.setFont(FtTitleText);
//        txtThanks.setForeground(Color.RED);
//        txtThanks.setBounds(130, 470, 300, 25);
//        this.add(txtThanks);
    }
}
