package GUI;

import Custom.Mytable;
import Custom.NonEditableTableModel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

public class PnThongKe extends JPanel {

    final Color ClMain = new Color(0, 160, 80); //#00A050
    final Color ClHover = new Color(0, 192, 96);
    final Color ClSelect = new Color(76, 204, 76);

    JComboBox<Integer> cmbYear;

    JPanel pnThongKe, pnbtnSwitch;

    JLabel lbtltTongDoanhThuNam, lbbtnSwitch;

    CardLayout cardLayout;

    Font FtTitleText = new Font("Montserrat", Font.BOLD, 20);

    ImageIcon imgBtnSwitch = new ImageIcon("image/btn/icons8_view_40px.png");
    ImageIcon imgBtnBack = new ImageIcon("image/btn/icons8_undo_40px.png");

    int sum = 0;

    NonEditableTableModel dtmSanPham, dtmKhachHang;
    Mytable tbSanPham, tbKhachHang;

    public PnThongKe() {
        addControls();
        addEvents();
    }

    private void addControls() {
        JPanel pnMain = new JPanel(new BorderLayout());
        //btn
        pnbtnSwitch = new JPanel(new FlowLayout(FlowLayout.LEFT));
        lbbtnSwitch = new JLabel(imgBtnSwitch);
        pnbtnSwitch.add(lbbtnSwitch);
        pnMain.add(pnbtnSwitch, BorderLayout.NORTH);
        //------------------------Thống kê doanh thu----------------------------
        JPanel pnThongkeDoanhThu = new JPanel();
        pnThongkeDoanhThu.setLayout(new BoxLayout(pnThongkeDoanhThu, BoxLayout.Y_AXIS));
        // cmb year
        int year = Calendar.getInstance().get(Calendar.YEAR);
        cmbYear = new JComboBox<>();
        cmbYear.setFont(FtTitleText);
        cmbYear.setCursor(null);
        JPanel pnCmbYear = new JPanel();
        pnCmbYear.add(cmbYear);
        for (int i = year; i >= year - 10; i--) {
            cmbYear.addItem(i);
        }
        // biểu đồ cột
        ChartPanel chartBarPanel = new ChartPanel(createBarChart());
        JPanel pnBarChart = new JPanel(new BorderLayout());
        pnBarChart.add(pnCmbYear, BorderLayout.NORTH);
        pnBarChart.add(chartBarPanel, BorderLayout.CENTER);
        pnThongkeDoanhThu.add(pnBarChart);
        // biểu đồ tròn
        ChartPanel chartPiePanel = new ChartPanel(createPieChart());
        chartPiePanel.setPreferredSize(new Dimension(500, 300));
        JPanel pnPieChart = new JPanel(new BorderLayout());
        // pn Tổng doanh thu
        lbtltTongDoanhThuNam = new JLabel("10000000");
        lbtltTongDoanhThuNam.setText(sum + "");
        lbtltTongDoanhThuNam.setFont(FtTitleText);
        lbtltTongDoanhThuNam.setForeground(Color.white);
        lbtltTongDoanhThuNam.setHorizontalAlignment(JLabel.CENTER);
        lbtltTongDoanhThuNam.setVerticalAlignment(JLabel.CENTER);
        JLabel lbbgTongDoanhThuNam = new JLabel(new ImageIcon("image/Menu/thongkeDoanhThu.png"));
        lbbgTongDoanhThuNam.setLayout(new BorderLayout());
        lbbgTongDoanhThuNam.add(lbtltTongDoanhThuNam, BorderLayout.CENTER);
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(100, 50));
        lbbgTongDoanhThuNam.add(panel, BorderLayout.SOUTH);
        JPanel pnlbTongDoanhThuNam = new JPanel(new BorderLayout());
        pnlbTongDoanhThuNam.add(lbbgTongDoanhThuNam, BorderLayout.CENTER);

        pnPieChart.add(chartPiePanel, BorderLayout.CENTER);
        pnPieChart.add(pnlbTongDoanhThuNam, BorderLayout.EAST);
        pnThongkeDoanhThu.add(pnPieChart);
        //--------------------------------Thống kê sản phẩm---------------------
        JPanel pnThongKeSanPham = new JPanel(new BorderLayout());
        pnThongKeSanPham.setPreferredSize(new Dimension(pnThongKeSanPham.getPreferredSize().width, 350));
        //tên bảng
        JLabel lbtitleDSSP = new JLabel("Danh sách sản phẩm đã bán");
        lbtitleDSSP.setForeground(ClMain);
        lbtitleDSSP.setFont(FtTitleText);
        JPanel pnlbtltDSSP = new JPanel();
        pnlbtltDSSP.add(lbtitleDSSP);
        //bảng
        dtmSanPham = new NonEditableTableModel();
        dtmSanPham.addColumn("Mã SP");
        dtmSanPham.addColumn("Tên Sản phẩm");
        dtmSanPham.addColumn("Đã bán");
        tbSanPham = new Mytable(dtmSanPham);
        JScrollPane scrSanPham = new JScrollPane(tbSanPham);

        pnThongKeSanPham.add(pnlbtltDSSP, BorderLayout.NORTH);
        pnThongKeSanPham.add(scrSanPham, BorderLayout.CENTER);
        //-------------------------------Thống kê chi tiêu khách hàng--------------------
        JPanel pnThongKeChiTieuKhachHang = new JPanel(new BorderLayout());
        pnThongKeChiTieuKhachHang.setPreferredSize(new Dimension(pnThongKeChiTieuKhachHang.getPreferredSize().width, 350));
        //tên bảng
        JLabel lbtitleCTKH = new JLabel("Thống kê chi tiêu khách hàng");
        lbtitleCTKH.setForeground(ClMain);
        lbtitleCTKH.setFont(FtTitleText);
        JPanel pnlbtltCTKH = new JPanel();
        pnlbtltCTKH.add(lbtitleCTKH);
        //Bảng
        dtmKhachHang = new NonEditableTableModel();
        dtmKhachHang.addColumn("Mã khách hàng");
        dtmKhachHang.addColumn("Tên khách hàng");
        dtmKhachHang.addColumn("Tổng chi tiêu");
        tbKhachHang = new Mytable(dtmKhachHang);
        JScrollPane scrKhachHang = new JScrollPane(tbKhachHang);

        pnThongKeChiTieuKhachHang.add(pnlbtltCTKH, BorderLayout.NORTH);
        pnThongKeChiTieuKhachHang.add(scrKhachHang, BorderLayout.CENTER);
        //--------------------------------------------------------------------
        JPanel pnThongKeSPvsKH = new JPanel();
        pnThongKeSPvsKH.setLayout(new BoxLayout(pnThongKeSPvsKH, BoxLayout.Y_AXIS));
        pnThongKeSPvsKH.add(pnThongKeSanPham);
        pnThongKeSPvsKH.add(pnThongKeChiTieuKhachHang);

        cardLayout = new CardLayout();
        pnThongKe = new JPanel(cardLayout);
        pnThongKe.add(pnThongkeDoanhThu, "1");
        pnThongKe.add(pnThongKeSPvsKH, "2");
        pnMain.add(pnThongKe, BorderLayout.CENTER);
        this.add(pnMain);

    }

    private void addEvents() {
        lbbtnSwitch.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (lbbtnSwitch.getIcon() == imgBtnSwitch) {
                    lbbtnSwitch.setIcon(imgBtnBack);
                    cardLayout.show(pnThongKe, "2");
                    return;
                }
                lbbtnSwitch.setIcon(imgBtnSwitch);
                cardLayout.show(pnThongKe, "1");
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

    private JFreeChart createBarChart() {
        JFreeChart freeChart = ChartFactory.createBarChart("Doanh thu năm 2024", "Tháng", "Doanh thu", createBarDataset(), PlotOrientation.VERTICAL, false, false, false);
        return freeChart;
    }

    private CategoryDataset createBarDataset() {
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();

        for (int i = 1; i <= 12; i++) {
            dataSet.addValue(i * 1000000, "Doanh thu", i + "");
            sum += i * 1000000;
        }
        return dataSet;
    }

    private JFreeChart createPieChart() {
        JFreeChart freeChart = ChartFactory.createPieChart("Doanh thu theo quý", createPieDataset(), true, true, false);
        return freeChart;
    }

    private PieDataset createPieDataset() {
        ArrayList<Integer> tongThuQuy = new ArrayList<>();
        tongThuQuy.add(20);
        tongThuQuy.add(25);
        tongThuQuy.add(35);
        tongThuQuy.add(20);
        DefaultPieDataset dataSet = new DefaultPieDataset();
        for (int i = 1; i <= 4; i++) {
            dataSet.setValue("Quý " + i, tongThuQuy.get(i - 1));
        }
        return dataSet;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.add(new PnThongKe());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
