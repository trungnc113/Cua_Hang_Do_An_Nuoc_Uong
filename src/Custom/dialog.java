package Custom;

import Main.Main;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class dialog extends JDialog {

    private String content;
    private int type;

    Font font = new Font("Montserrat", Font.BOLD, 14);

    private final Color success = new Color(0, 160, 80);
    private final Color error = new Color(220, 53, 69);
    private final Color info = new Color(0, 123, 255);
    private final Color warning = new Color(255, 193, 7);

    final ImageIcon iconError = new ImageIcon("image/btn/icons8_cancel_70px.png");
    final ImageIcon iconSuccess = new ImageIcon("image/btn/icons8_checkmark_70px.png");
    final ImageIcon iconInfo = new ImageIcon("image/btn/icons8_info_70px.png");
    final ImageIcon iconWarning = new ImageIcon("image/btn/icons8_warning_shield_70px.png");

    public final static int ERROR_DIALOG = 1;
    public final static int SUCCESS_DIALOG = 2;
    public final static int INFO_DIALOG = 3;
    public final static int WARNING_DIALOG = 4;

    JButton btnOK, btnCancel;
    JLabel lbClose, lbIcon, lbContent;
    JPanel pnHeader;

    private int Action;
    public final static int OK_OPTION = 1;
    public final static int CANCEL_OPTION = 2;

    int PosX, PosY;

    public dialog(String content, int type) {
        this.content = content;
        this.type = type;
        Show();
    }

    private void addControls() {
        Container con = this.getContentPane();

        JPanel pnMain = new JPanel();
        pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

        pnHeader = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        pnHeader.setPreferredSize(new Dimension(400, 25));
        pnHeader.setBackground(Color.red);
        lbClose = new JLabel(new ImageIcon("image/btn/close_x24.png"));
        pnHeader.add(lbClose);
        pnMain.add(pnHeader);

        JPanel pnIcon = new JPanel();
        lbIcon = new JLabel();
        pnIcon.add(lbIcon);
        pnMain.add(pnIcon);

        JPanel pnContent = new JPanel();
        lbContent = new JLabel(content);
        lbContent.setForeground(Color.BLACK);
        lbContent.setFont(font);
        pnContent.add(lbContent);
        pnMain.add(pnContent);

        JPanel pnbtn = new JPanel(new FlowLayout());
        btnOK = new JButton("OK");
        btnOK.setFont(font);
        btnOK.setFocusable(false);
        btnCancel = new JButton("Cancel");
        btnCancel.setFont(font);
        btnCancel.setFocusable(false);
        btnOK.setPreferredSize(btnCancel.getPreferredSize());
        pnbtn.add(btnOK);
        pnMain.add(pnbtn);
        
        JPanel pnFooter = new JPanel();
        pnFooter.setPreferredSize(new Dimension(400, 20));
        pnMain.add(pnFooter);

        switch (type) {
            case ERROR_DIALOG:
                lbIcon.setIcon(iconError);
                pnHeader.setBackground(error);
                break;
            case SUCCESS_DIALOG:
                lbIcon.setIcon(iconSuccess);
                pnHeader.setBackground(success);
                break;
            case INFO_DIALOG:
                lbIcon.setIcon(iconInfo);
                pnHeader.setBackground(info);
                break;
            case WARNING_DIALOG:
                lbIcon.setIcon(iconWarning);
                pnHeader.setBackground(warning);
                pnbtn.add(btnCancel);
                break;
        }

        con.add(pnMain);

    }

    private void addEvents() {

        pnHeader.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Move(e.getXOnScreen(), e.getYOnScreen());
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                PosX = e.getX();
                PosY = e.getY();
            }
        });

        lbClose.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Close();
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
        
        btnOK.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Action=OK_OPTION;
                Close();
            }
        });
        btnCancel.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Action=CANCEL_OPTION;
                Close();
            }
        });
    }

    private void Close() {
        this.setVisible(false);
    }

    private void Show() {
        Main.changLNF("Windows");
        addControls();
        addEvents();
        this.setUndecorated(true);
        this.setSize(400, 250);
        this.setVisible(true);
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setModal(true);
        getRootPane().setDefaultButton(btnOK);
    }

    private void Move(int x, int y) {
        this.setLocation(x - PosX, y - PosY);
    }

    public int getAction() {
        return Action;
    }

    public static void main(String[] args) {
        JFrame myFrame = new JFrame();
        dialog test = new dialog("Không kết nối được", dialog.ERROR_DIALOG);

//        myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        myFrame.add(test);
//
//        myFrame.pack();
//        myFrame.setResizable(false);
//        myFrame.setLocationRelativeTo(null);
//        myFrame.setVisible(true);
    }
}
