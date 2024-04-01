package GUI;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class MainQuanLyGUI extends JFrame {

    JPanel pnTitle, pnCardListMenu, pnMain;

    CardLayout cardListMenu;

    JLabel btnDoiMatKhau, btnClose, btnMinimize, lbBanhang, lbKhuyenmai, lbNhaphang, lbSanpham, lbNhanvien, lbKhachhang, lbThongke;

    Font FtTitleText = new Font("Montserrat", Font.BOLD, 20);

    ArrayList<JLabel> listMenuLeft;

    final Color ClMain = new Color(0, 160, 80); //#00A050
    final Color ClHover = new Color(0, 192, 96);
    final Color ClSelect = new Color(76, 204, 76);

    int xMouse = 0;
    int yMouse = 0;

    boolean resizing = false;
    boolean canMove = false;
    int PosX, PosY;
    Point initialClick;

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

    private void addControls() {
        int width = this.getWidth();
        int height = this.getHeight();

        Container con = getContentPane();

        pnMain = new JPanel();
        pnMain.setLayout(new BorderLayout());

        //title
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
        //menuleft
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

        pnMain.add(pnCardListMenu, BorderLayout.CENTER);
        pnMain.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        con.add(pnMain);

    }

    private void addEvents() {
        pnMain.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                initialClick = e.getLocationOnScreen(); //lấy vị trí chuột khi ấn
                resizing = true;
                if (e.getX() == 0) {
                    canMove = true;
                } else if (e.getX() == getWidth() - 1) {
                    canMove = false;
                } else if (e.getY() == 0) {
                    canMove = true;
                } else if (e.getY() == getHeight() - 1) {
                    canMove = false;
                } else {
                    setCursor(null);
                    resizing = false;
                    canMove = false;
                }
            }

            public void mouseReleased(MouseEvent e) {
                resizing = false;
                setCursor(null);
            }
        });

        pnMain.addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                if (initialClick == null) {
                    return;
                }
                if (resizing) {
                    Point currentClick = e.getLocationOnScreen();
                    int dx = currentClick.x - initialClick.x;
                    int dy = currentClick.y - initialClick.y;
                    if (canMove) {
                        moveFrame(e.getXOnScreen(), e.getYOnScreen());
                        dx = -dx;
                        dy = -dy;
                    }
                    int newWidth = getWidth() + dx;
                    int newHeight = getHeight() + dy;

                    int minWidth = 100;
                    int minHeight = 100;

                    if (newWidth >= minWidth && newHeight >= minHeight) {
                        setSize(newWidth, newHeight);
                        initialClick = currentClick;
                    }
                }
            }

            public void mouseMoved(MouseEvent e) {
                xMouse = e.getX();
                yMouse = e.getY();
                if (e.getX() == 0) {
                    setCursor(Cursor.getPredefinedCursor(Cursor.W_RESIZE_CURSOR));
                } else if (e.getX() == getWidth() - 1) {
                    setCursor(Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR));
                } else if (e.getY() == 0) {
                    setCursor(Cursor.getPredefinedCursor(Cursor.N_RESIZE_CURSOR));
                } else if (e.getY() == getHeight() - 1) {
                    setCursor(Cursor.getPredefinedCursor(Cursor.S_RESIZE_CURSOR));
                } else if (e.getX() == 0 && e.getY() == 0) {
                    setCursor(Cursor.getPredefinedCursor(Cursor.NW_RESIZE_CURSOR));
                } else if (e.getX() == getWidth() - 1 && e.getY() == 0) {
                    setCursor(Cursor.getPredefinedCursor(Cursor.NE_RESIZE_CURSOR));
                } else if (e.getX() == 0 && e.getY() == getHeight() - 1) {
                    setCursor(Cursor.getPredefinedCursor(Cursor.SW_RESIZE_CURSOR));
                } else if (e.getX() == getWidth() - 1 && e.getY() == getHeight() - 1) {
                    setCursor(Cursor.getPredefinedCursor(Cursor.SE_RESIZE_CURSOR));
                } else {
                    setCursor(null);
                }
            }
        });

        pnTitle.addMouseMotionListener(new MouseMotionListener() {
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

    private void minimizeFrame() {
        this.setState(Frame.ICONIFIED);
    }

    private void moveFrame(int x, int y) {
        this.setLocation(x - xMouse, y - yMouse);
    }

    public static void main(String[] args) {
        MainQuanLyGUI test = new MainQuanLyGUI();
        test.setVisible(true);

    }
}
