package com.mycompany.shopproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

 class nhaphang extends javax.swing.JPanel {
    // hàm tạo ô nhập
    public void createInputField(JPanel panel, String labelText, int  HorizontalAlignment) {
        // Tạo JLabel với nội dung được truyền vào
        JLabel label = new JLabel(labelText);
            label.setHorizontalAlignment(HorizontalAlignment);

        // Tạo JTextField để nhập dữ liệu
        JTextField textField = new JTextField(20);

        // Thêm JLabel và JTextField vào JPanel
        panel.add(label);
        panel.add(textField);
    }
    // hàm tô màu dòng đầu trong bảng
     static class HeaderRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            // Đặt màu nền cho tiêu đề cột
            setBackground(new Color(0,160,80));
            setForeground(Color.WHITE);

            return this;
        }
    }
    // hover button
    private static JButton createHoverButton(String text, Color defaultColor, Color hoverColor) {
        JButton button = new JButton(text);
        button.setBackground(defaultColor);
        button.setForeground(Color.WHITE);

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(hoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(defaultColor);
            }
        });

        return button;
    }
    public static void main(String[] args) {
        nhaphang input_ttsp= new nhaphang();
        int width = 1080;
        int heigh = 720;
        final Color Clmain= new Color(0,180,60);
        final Color ClHover = new Color(0,192,96);

        // create panel

        JPanel import_product = new JPanel();
        import_product.setBackground(Color.RED); 
        import_product.setBounds(0, 0, 700, 400);
        import_product.setLayout(new BorderLayout());
        JPanel import_waiting = new JPanel();
        import_waiting.setBackground(Color.green);
        import_waiting.setLayout(new BorderLayout());
        import_waiting.setBounds(0, 400, 700, 320);
        JPanel infor_product = new JPanel();
        // infor_product.setBackground();
        infor_product.setBounds(700, 0, 380, 400);
        infor_product.setLayout(new BorderLayout());
        JPanel entry_infor = new JPanel();
        entry_infor.setBackground(Color.LIGHT_GRAY);
        entry_infor.setBounds(700, 400, 380, 250);
        entry_infor.setLayout(new BorderLayout());
        // end panel 

    // setup
        // panel_1
        JPanel headPanel = new JPanel( new BorderLayout());
        JLabel titlepanel = new JLabel();
            titlepanel.setText("NHẬP HÀNG");
            titlepanel.setFont(new Font("Arial Unicode MS", Font.BOLD, 25));
            // titlepanel.setBackground(Color.WHITE);
            titlepanel.setOpaque(true);// cần để hiển thị background
            titlepanel.setVerticalAlignment(JLabel.CENTER);
            titlepanel.setBounds(0, 0, 700, 100);
            titlepanel.setHorizontalAlignment(JLabel.CENTER);
            titlepanel.setForeground(Color.BLACK);
        JPanel searchPanel = new JPanel();
            // searchPanel.setBackground(Color.YELLOW); // Màu nền của panel tìm kiếm (có thể thay đổi)
            searchPanel.setLayout(new FlowLayout());
        // Tạo ô tìm kiếm (JTextField)
            JTextField searchField = new JTextField(20);
            searchPanel.add(new JLabel("Tìm Kiếm: "));
            searchPanel.add(searchField);
            searchPanel.setBounds(0, 100, 200, 50);
            
            //set header
            headPanel.add(titlepanel, BorderLayout.NORTH);
            headPanel.add(searchPanel, BorderLayout.SOUTH);
            // set table
            Object[][] data = {
                {"1", "pepsi", "25"},
                {"2", "coca cola", "30"},
                {"3", "hot dog", "40"},
                {"","",""},
                {"","",""},
                {"","",""},
                {"","",""},
                {"","",""},
                {"","",""},
                {"","",""},
                {"","",""},

                
            };
            String[] columnNames = { "Mã SP", "Tên SP", "Tồn Kho" };
            DefaultTableModel model = new DefaultTableModel(data, columnNames);
            
            JTable table = new JTable(model);
            table.getTableHeader().setDefaultRenderer(new HeaderRenderer());
            JScrollPane scrollPane = new JScrollPane(table);// Đặt bảng vào JScrollPane để hỗ trợ cuộn nếu có nhiều dữ liệu
            scrollPane.setBorder(new EmptyBorder(10,10,10,10));
            scrollPane.setBorder(BorderFactory.createLineBorder(Color.darkGray));

            import_product.add(scrollPane);
        // end label_1
        // panel_2
        JLabel title_import_waiting = new JLabel();
            title_import_waiting.setText("HÀNG CHỜ NHẬP");
            title_import_waiting.setFont(new Font("Arial Unicode MS", Font.BOLD, 25));
            // title_import_waiting.setBackground(Color.WHITE);
            title_import_waiting.setOpaque(true);// cần để hiển thị background
            title_import_waiting.setVerticalAlignment(JLabel.CENTER);
            title_import_waiting.setBounds(0, 400, 700, 50);
            title_import_waiting.setHorizontalAlignment(JLabel.CENTER);
            title_import_waiting.setForeground(Color.BLACK);
            Object[][] data_waiting={};
            String[] columnName_waiting ={"Mã SP","Tên SP","Số Lương","Đơn Giá","Thành Tiền"};
            DefaultTableModel model2 = new DefaultTableModel(data_waiting,columnName_waiting);
            JTable table2 = new JTable(model2);
            table2.getTableHeader().setDefaultRenderer(new HeaderRenderer());

            JScrollPane scrollPane2 =new JScrollPane(table2);
            scrollPane2.setBorder( new EmptyBorder(10,10,10,10));
            scrollPane2.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
            
            

            
        // panel_3
        JLabel title_infor_product = new JLabel();
            title_infor_product.setText("THÔNG TIN SẢN PHẨM");
            title_infor_product.setFont(new Font("Arial Unicode MS", Font.BOLD, 20));
            // title_infor_product.setBackground(Color.WHITE);
            title_infor_product.setOpaque(true);// cần để hiển thị background
            title_infor_product.setVerticalAlignment(JLabel.CENTER);
            title_infor_product.setBounds(700, 20, 380, 100);
            title_infor_product.setHorizontalAlignment(JLabel.CENTER);
            title_infor_product.setForeground(Color.BLACK);
            title_infor_product.setBorder(new EmptyBorder(20,20,20,20));
           // Tạo cặp JLabel và JTextField bằng cách gọi hàm createInputField
           JPanel mainPanel3 = new JPanel();
           mainPanel3.setLayout( new BoxLayout(mainPanel3, BoxLayout.Y_AXIS));
           mainPanel3.setBorder(new EmptyBorder(30,50,30,50));

           JPanel id_product= new JPanel();
           JPanel name_product= new JPanel();
           JPanel sl_nhap = new JPanel();
           JPanel dongia_nhap = new JPanel(); 
                int labelAlignment_center = SwingConstants.CENTER;
                int labelAlignment_left  = SwingConstants.LEFT;

            input_ttsp.createInputField(id_product, "Mã SP",labelAlignment_center);
            input_ttsp.createInputField(name_product, "Tên SP:",labelAlignment_center);
            input_ttsp.createInputField(sl_nhap, "Số Lượng Nhập",labelAlignment_center);
            input_ttsp.createInputField(dongia_nhap, "Đơn Giá Nhập",labelAlignment_center);
            JButton bt_add = createHoverButton("Chọn Nhiều",Clmain , ClHover);
            bt_add.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
            bt_add.setLayout(new BorderLayout());
            mainPanel3.add(id_product);
            mainPanel3.add(name_product);
            mainPanel3.add(sl_nhap);
            mainPanel3.add(dongia_nhap);
            mainPanel3.add(bt_add);


        // label_4
        // header
        JLabel title_entry_product = new JLabel();
            title_entry_product.setText("THÔNG TIN SẢN PHẨM");
            title_entry_product.setFont(new Font("Arial Unicode MS", Font.BOLD, 20));
            // title_entry_product.setBackground(Color.WHITE);
            title_entry_product.setOpaque(true);// cần để hiển thị background
            title_entry_product.setVerticalAlignment(JLabel.CENTER);
            title_entry_product.setBounds(700, 0, 380, 50);
            title_entry_product.setHorizontalAlignment(JLabel.CENTER);
            title_entry_product.setForeground(Color.BLACK);
            title_entry_product.setBorder(new EmptyBorder(20,0,20,0));
        // body
        JPanel bodyJPanel_4= new JPanel();
        bodyJPanel_4.setBorder(new EmptyBorder(10,50,10,50));
        JPanel NCC = new JPanel();
        JPanel NV = new JPanel();
        input_ttsp.createInputField(NCC,"Nhà Cung Cấp",labelAlignment_left);
        // input_ttsp.createInputField(NV, "Nhân Viên");
        JLabel Nhanvien= new JLabel("Nhân Viên:");
        String[] employ = {"Nhân viên A", "Nhân Viên B", "Nhân viên C"};
        JComboBox employee = new JComboBox<>(employ);
        employee.setPreferredSize(new Dimension(200,30));
        Nhanvien .setLayout( new FlowLayout());
        NV.add(Nhanvien);
        NV.add(employee);
        JButton deleButton = createHoverButton("Chọn Nhiều",Clmain , ClHover);
        deleButton.setLayout(new FlowLayout());
        JButton comfirmBtn = createHoverButton("Chọn Nhiều",Clmain , ClHover);
        comfirmBtn.setLayout(new FlowLayout());
    
        bodyJPanel_4.add(NCC);
        bodyJPanel_4.add(NV);
        bodyJPanel_4.add(deleButton);
        bodyJPanel_4.add(comfirmBtn);
        


        // màn hình
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setSize(width, heigh);
        frame.setTitle("nhaphang");
        frame.setLayout(null);
        frame.add(import_product);
        import_product.add(headPanel, BorderLayout.NORTH);
       
        import_product.add(scrollPane, BorderLayout.CENTER); // Đặt bảng ở vị trí CENTER (chính giữa)

        frame.add(import_waiting);
        import_waiting.add(title_import_waiting, BorderLayout.NORTH);
        import_waiting.add(scrollPane2, BorderLayout.CENTER);
        frame.add(infor_product);
        infor_product.add(title_infor_product ,BorderLayout.NORTH);
        infor_product.add(mainPanel3, BorderLayout.CENTER);
        frame.add(entry_infor);
        entry_infor.add(title_entry_product,BorderLayout.NORTH);
        entry_infor.add(bodyJPanel_4);
    }
}
