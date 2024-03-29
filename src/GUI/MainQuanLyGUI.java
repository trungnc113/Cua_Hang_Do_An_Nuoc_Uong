package GUI;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class MainQuanLyGUI extends JFrame {

    JPanel pnTitle, pnCardListMenu;

    CardLayout cardListMenu;

    JLabel btnDoiMatKhau, btnClose, btnMinimize, lbBanhang, lbKhuyenmai, lbNhaphang, lbSanpham, lbNhanvien, lbKhachhang, lbThongke;

    Font FtTitleText = new Font("Montserrat", Font.BOLD, 20);

    ArrayList<JLabel> listMenuLeft;

    final Color ClMain = new Color(0, 160, 80); //#00A050
    final Color ClHover = new Color(0, 192, 96);
    final Color ClSelect = new Color(76, 204, 76);

    int xMouse = 0;
    int yMouse = 0;

    public MainQuanLyGUI() {
        this.setTitle("Quản lý bán đồ ăn thức uống");
        this.setSize(1280, 900);
        Image icon = new ImageIcon("image/logo/logo32x32.png").getImage();
        this.setIconImage(icon);
        this.setUndecorated(true);
        this.setLocationRelativeTo(null);
        addControls();
        addEvents();
    }

    public void addControls() {
        int width = this.getWidth();
        int height = this.getHeight();

        Container con = getContentPane();

        JPanel pnMain = new JPanel();
        pnMain.setLayout(new BorderLayout());

        /*
        ============================================================
                                TITLE BAR
        ============================================================
         */
        pnTitle = new JPanel(null);
        pnTitle.setPreferredSize(new Dimension(width, 46));
        pnTitle.setBackground(ClMain);
        pnTitle.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));

        btnDoiMatKhau = new JLabel(new ImageIcon("image/btn/gear.png"));
        btnDoiMatKhau.setToolTipText("Đổi mật khẩu");
        btnDoiMatKhau.setBounds(5, 0, 46, 46);
        btnDoiMatKhau.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        pnTitle.add(btnDoiMatKhau);

        JLabel lbTitleText = new JLabel("Phần mềm quản lý cửa hàng đồ ăn nước uống");
        lbTitleText.setFont(FtTitleText);
        lbTitleText.setForeground(Color.white);
        lbTitleText.setBounds(width / 2 - 492 / 2, 3, 492, 38);
        pnTitle.add(lbTitleText);

        btnClose = new JLabel(new ImageIcon("image/btn/close.png"));
        btnClose.setBounds(width - 55, 8, 32, 32);
        btnClose.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        pnTitle.add(btnClose);

        btnMinimize = new JLabel(new ImageIcon("image/btn/minimize.png"));
        btnMinimize.setBounds(width - 102, 8, 32, 32);
        btnMinimize.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        pnTitle.add(btnMinimize);

        pnMain.add(pnTitle, BorderLayout.NORTH);
        /*
        ============================================================
                                SIDE BAR MENU
        ============================================================
         */
        JPanel pnMenuLeft = new JPanel();
        pnMenuLeft.setPreferredSize(new Dimension(250, height - pnTitle.getHeight()));
        pnMenuLeft.setBackground(ClMain);
        pnMenuLeft.setLayout(new BoxLayout(pnMenuLeft, BoxLayout.Y_AXIS));
        pnMenuLeft.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.white));

        JLabel iconApp = new JLabel(new ImageIcon("image/logo/logo.png"));
        iconApp.setHorizontalAlignment(JLabel.CENTER);
        iconApp.setPreferredSize(new Dimension(250, 210));
        iconApp.setOpaque(true);
        pnMenuLeft.add(iconApp);

        lbBanhang = new JLabel(new ImageIcon("image/Menu/lblBanHang.png"));
        lbKhuyenmai = new JLabel(new ImageIcon("image/Menu/lblKhuyenMai.png"));
        lbNhanvien = new JLabel(new ImageIcon("image/Menu/lblNhanVien.png"));
        lbSanpham = new JLabel(new ImageIcon("image/Menu/lblSanPham.png"));
        lbKhachhang = new JLabel(new ImageIcon("image/Menu/lblKhachHang.png"));
        lbNhaphang = new JLabel(new ImageIcon("image/Menu/lblNhapHang.png"));
        lbThongke = new JLabel(new ImageIcon("image/Menu/lblThongke.png"));

        listMenuLeft = new ArrayList<>();
        listMenuLeft.add(lbBanhang);
        listMenuLeft.add(lbKhuyenmai);
        listMenuLeft.add(lbSanpham);
        listMenuLeft.add(lbNhanvien);
        listMenuLeft.add(lbKhachhang);
        listMenuLeft.add(lbNhaphang);
        listMenuLeft.add(lbThongke);

        for (JLabel opt : listMenuLeft) {
            opt.setPreferredSize(new Dimension(250, 65));
            opt.setOpaque(false);
            opt.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            pnMenuLeft.add(opt);
        }
        lbBanhang.setBackground(ClSelect);
        lbBanhang.setOpaque(true);
        pnMain.add(pnMenuLeft, BorderLayout.WEST);

        PnQuanLyNhanVienGUI pnQuanLyNhanVienGUI = new PnQuanLyNhanVienGUI();
        PnQuanLySanPhamGUI pnQuanLySanPhamGUI = new PnQuanLySanPhamGUI();
        PnQuanLyBanHangGUI pnQuanLyBanHangGUI = new PnQuanLyBanHangGUI();
        PnQuanLyNhapHangGUI pnQuanLyNhapHangGUI = new PnQuanLyNhapHangGUI();
        PnQuanLyKhachHangGUI pnQuanLyKhachHangGUI = new PnQuanLyKhachHangGUI();
        PnQuanLyKhuyenMaiGUI pnQuanLyKhuyenMaiGUI = new PnQuanLyKhuyenMaiGUI();

        cardListMenu = new CardLayout();
        pnCardListMenu = new JPanel(cardListMenu);
        pnCardListMenu.add(pnQuanLyBanHangGUI, "1");
        pnCardListMenu.add(pnQuanLyKhuyenMaiGUI, "2");
        pnCardListMenu.add(pnQuanLySanPhamGUI, "3");
        pnCardListMenu.add(pnQuanLyNhanVienGUI, "4");
        pnCardListMenu.add(pnQuanLyKhachHangGUI, "5");
        pnCardListMenu.add(pnQuanLyNhapHangGUI, "6");

        pnMain.add(pnCardListMenu, BorderLayout.EAST);
        con.add(pnMain);
    }

    public void addEvents() {
        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) { //gọi khi kéo chuột
                moveFrame(e.getXOnScreen(), e.getYOnScreen());
            }

            @Override
            public void mouseMoved(MouseEvent e) { //gọi khi di chuyển chuột
                xMouse = e.getX();
                yMouse = e.getY();
            }
        });

        btnClose.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnClose.setIcon(new ImageIcon("image/btn/close-hover.png"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnClose.setIcon(new ImageIcon("image/btn/close.png"));
            }
        });

        btnMinimize.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                minimizeFrame();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnMinimize.setIcon(new ImageIcon("image/btn/minimize-hover.png"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnMinimize.setIcon(new ImageIcon("image/btn/minimize.png"));
            }
        });

        for (JLabel opt : listMenuLeft) {
            opt.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    for (JLabel lb : listMenuLeft) {
                        lb.setOpaque(false);
                        lb.setBackground(null);
                    }
                    opt.setOpaque(true);
                    opt.setBackground(ClSelect);
                    String cardName = "";
                    if (opt == lbBanhang) {
                        cardName = "1";
                    } else if (opt == lbKhuyenmai) {
                        cardName = "2";
                    } else if (opt == lbSanpham) {
                        cardName = "3";
                    } else if (opt == lbNhanvien) {
                        cardName = "4";
                    } else if (opt == lbKhachhang) {
                        cardName = "5";
                    } else if (opt == lbNhaphang) {
                        cardName = "6";
                    }
                    cardListMenu.show(pnCardListMenu, cardName);
                }

                @Override
                public void mousePressed(MouseEvent e) {
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    if (!opt.getBackground().equals(ClSelect)) {
                        opt.setOpaque(true);
                        opt.setBackground(ClHover);
                    }
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    if (opt.getBackground().equals(ClHover)) {
                        opt.setOpaque(false);
                        opt.setBackground(null);
                    }
                }
            });
        }

    }

    public void minimizeFrame() {
        this.setState(Frame.ICONIFIED);
    }

    public void moveFrame(int x, int y) {
        this.setLocation(x - xMouse, y - yMouse);
    }

    public static void main(String[] args) {
        MainQuanLyGUI test = new MainQuanLyGUI();
        test.setVisible(true);

    }
}
