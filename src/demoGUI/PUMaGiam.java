package demoGUI;

import BUS.GiamGiaBUS;
import Custom.Mytable;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;
import java.util.Date;

public class PUMaGiam extends JPanel {
    private int W = 500;
    private int H = 500;
    final Color ClMain = new Color(0, 160, 80); //#00A050
    final Color ClHover = new Color(0, 192, 96);
    final Color ClSelect = new Color(76, 204, 76);
    Border customBorder = BorderFactory.createLineBorder(ClMain, 2);
    Font FtTitleText = new Font("Montserrat", Font.BOLD, 15);
    public static DefaultTableModel model;
    public static Mytable TB;

    public PUMaGiam() {
        addGUI();
    }

    private void addGUI() {
        this.setPreferredSize(new Dimension(W, H));
        this.setBorder(customBorder);
        this.setLayout(null);

        // title
        JLabel TitleCTHD = new JLabel("Danh Sách Mã Giảm Giá");
        TitleCTHD.setBounds(125, 10, 300, 40);
        TitleCTHD.setFont(FtTitleText);
        this.add(TitleCTHD);

        // table
        String NameColume[] = {"Mã Giảm", "Tên Mã", "% Giảm", "Ngày BD", "Ngày KT"};
        model = new DefaultTableModel(NameColume, 0);
        TB = new Mytable(model){
            public boolean isCellEditable(int row, int column) { // không cho phép sửa nội dung trong table
                return false;
            }
        };
        TB.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

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

        JScrollPane Scl = new JScrollPane(TB); // Thêm JTable vào JScrollPane
        Scl.setBounds(2, 70, 496, 350);
        this.add(Scl);

        JButton OK = new JButton("OK");
        OK.setFont(FtTitleText);
        OK.setBounds(200, 440, 100, 50);
        this.add(OK);
    }
    public static void addrow(int tong){
        GiamGiaBUS listGG = new GiamGiaBUS();
        for(int i=0; i<listGG.getList().size(); i++) {
            if(tong > listGG.getList().get(i).getDieuKien())
            {
                Object[] data = {listGG.getList().get(i).getMaGiam(), listGG.getList().get(i).getTenGiamGia(), listGG.getList().get(i).getPhanTramGiam(), listGG.getList().get(i).getNgayBD(), listGG.getList().get(i).getNgayKT()};
                model.addRow(data);
            }
        }
    }
}

