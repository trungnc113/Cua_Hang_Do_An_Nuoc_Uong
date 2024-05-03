package GUI;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import BUS.CTPhieuNhapBUS;
import BUS.PhieuNhapBUS;
import BUS.SanPhamBUS;
import DTO.CTPhieuNhap;

import java.awt.*;
import java.util.ArrayList;

public class PUCTPN extends JPanel {
    private int W = 500;
    private int H = 500;
    final Color ClMain = new Color(0, 160, 80); //#00A050
    final Color ClHover = new Color(0, 192, 96);
    final Color ClSelect = new Color(76, 204, 76);
    Border customBorder = BorderFactory.createLineBorder(ClMain, 2);
    Font FtTitleText = new Font("Montserrat", Font.BOLD, 15);

    public PUCTPN(int MPN) {
        addGUI(MPN);
    }

    private void addGUI(int MPN) {
        this.setPreferredSize(new Dimension(W, H));
        this.setBorder(customBorder);
        this.setLayout(null);

        // title
        JLabel TitleCTHD = new JLabel("---------- Chi Tiết Phiếu Nhập ----------");
        TitleCTHD.setBounds(125, 10, 300, 40);
        TitleCTHD.setFont(FtTitleText);
        this.add(TitleCTHD);

        // table
        String NameColume[] = {"mã SP","số lượng","Đơn Giá","Thành Tiền"};
        DefaultTableModel model = new DefaultTableModel(NameColume, 0);
        JTable TB = new JTable(model);
        TB.getColumnModel().getColumn(0).setPreferredWidth(50);
        TB.getColumnModel().getColumn(1).setPreferredWidth(100);
        TB.getColumnModel().getColumn(2).setPreferredWidth(30);
        TB.getColumnModel().getColumn(3).setPreferredWidth(120);
        TB.getTableHeader().setFont(FtTitleText);
        addRowtable(model,MPN);

        // chỉnh headertable ( chỉnh màu tiêu đề + xóa border tiêu đề)
        TableCellRenderer TBHeader = TB.getTableHeader().getDefaultRenderer();
        TB.getTableHeader().setDefaultRenderer(new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JLabel label = (JLabel) TBHeader.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                label.setBackground(ClMain);
                label.setBorder(BorderFactory.createEmptyBorder());
                return label;
            }
        });
        JScrollPane Scl = new JScrollPane(TB); // Thêm JTable vào JScrollPane
        Scl.setBounds(2, 70, 496, 350);
        this.add(Scl);

        
    }
    public void addRowtable(DefaultTableModel tble, int MPN){
        CTPhieuNhapBUS listBUS = new CTPhieuNhapBUS();
        ArrayList<CTPhieuNhap> listCTPN = new ArrayList<>();
        listCTPN = listBUS.getlistPhieuNhaps();
        SanPhamBUS temp = new SanPhamBUS();
        for(int i=0; i<listCTPN.size(); i++)
        {
            if(listCTPN.get(i).getMaPN() == MPN){
                Object[] data = {listCTPN.get(i).getMaSP(),listCTPN.get(i).getDonGia(), listCTPN.get(i).getSoLuong(), listCTPN.get(i).getThanhTien() };
                tble.addRow(data);
            }
        }
    }
    public static void main(String[] args) {
        PUCTPN popup = new PUCTPN(1);
        JDialog dialog = new JDialog();
        dialog.add(popup);
        dialog.pack();
        dialog.setModal(true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }
}

