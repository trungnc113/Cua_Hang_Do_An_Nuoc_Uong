/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BUS.DangNhapBUS;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author nguye
 */
public class DangNhapGUI extends JFrame {

    Font font = new Font("Montserrat", Font.BOLD, 20);

    final Color ClMain = new Color(0, 160, 80); //#00A050
    final Color ClHover = new Color(0, 192, 96);
    final Color ClSelect = new Color(76, 204, 76);

    JTextField txtUsername;
    JPasswordField txtPassword;
    JButton btnLogin;

    public DangNhapGUI() {
//        Main.changLNF("Nimbus");
        addControls();
        addEvents();
        this.setTitle("Đăng nhập");
        this.setIconImage(new ImageIcon("image/Logo/logo32x32.png").getImage());
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.getRootPane().setDefaultButton(btnLogin);
    }

    private void addControls() {
        Container con = getContentPane();
        con.setPreferredSize(new Dimension(500, 650));
        con.setBackground(Color.white);
        JPanel pnMain = new JPanel();
        pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

        JPanel pnIcon = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pnIcon.setBackground(Color.white);
        JLabel lbIcon = new JLabel(new ImageIcon("image/Logo/logo.png"));
        lbIcon.setOpaque(false);
        pnIcon.add(lbIcon);
        pnMain.add(pnIcon);

        JPanel pnLogin = new JPanel();
        pnLogin.setBackground(Color.white);

        JPanel pnUsername = new JPanel(new GridLayout(0, 1));
        JPanel pnlbUsername = new JPanel();
        pnlbUsername.setBackground(Color.white);
        JLabel lbUsername = new JLabel("Tên đăng nhập");
        lbUsername.setOpaque(false);
        lbUsername.setFont(font);
        lbUsername.setForeground(ClMain);
        pnlbUsername.add(lbUsername);
        txtUsername = new JTextField(20);
        txtUsername.setPreferredSize(new Dimension(txtUsername.getPreferredSize().width, 30));
        txtUsername.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, ClHover));
        txtUsername.setFont(font);
        lbUsername.setPreferredSize(new Dimension(txtUsername.getPreferredSize().width, lbUsername.getPreferredSize().height));

        pnUsername.add(pnlbUsername);
        pnUsername.add(txtUsername);

        JPanel pnPasswd = new JPanel(new GridLayout(0, 1));
        JPanel pnlbPasswd = new JPanel();
        pnlbPasswd.setBackground(Color.white);
        JLabel lbPasswd = new JLabel("Mật khẩu");
        lbPasswd.setOpaque(false);
        lbPasswd.setFont(font);
        lbPasswd.setForeground(ClMain);
        pnlbPasswd.add(lbPasswd);
        txtPassword = new JPasswordField(20);
        txtPassword.setPreferredSize(new Dimension(txtPassword.getPreferredSize().width, 30));
        txtPassword.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, ClHover));
        txtPassword.setFont(font);
        lbPasswd.setPreferredSize(new Dimension(txtPassword.getPreferredSize().width, lbPasswd.getPreferredSize().height));

        pnPasswd.add(pnlbPasswd);
        pnPasswd.add(txtPassword);

        JPanel pnBtn = new JPanel();
        pnBtn.setBackground(Color.WHITE);
        btnLogin = new JButton("Đăng nhập");
        btnLogin.setFocusable(false);
        btnLogin.setFont(font);
        btnLogin.setForeground(Color.white);
        btnLogin.setBackground(ClMain);
        btnLogin.setPreferredSize(new Dimension(txtPassword.getPreferredSize().width, 40));
        pnBtn.add(btnLogin);

        pnLogin.add(pnUsername);
        pnLogin.add(pnPasswd);

        pnMain.add(pnLogin);
        pnMain.add(pnBtn);
        con.add(pnMain);

    }

    private void addEvents() {
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xulydangnhap();
            }
        });

    }

    private void xulydangnhap() {
        DangNhapBUS dangNhapBUS = new DangNhapBUS();
        dangNhapBUS.login(txtUsername.getText(), new String(txtPassword.getPassword()));
        if(DangNhapBUS.taiKhoanLogin==null) return ;
        MainQuanLyGUI mainQuanLyGUI = new MainQuanLyGUI();
        mainQuanLyGUI.setVisible(true);
        this.dispose();
    }
}
