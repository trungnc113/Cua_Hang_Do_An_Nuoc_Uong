package Main;

import GUI.DangNhapGUI;

public class Main {
    
    public static void main(String[] args) {
        DangNhapGUI dangNhapGUI=new DangNhapGUI();
        dangNhapGUI.setVisible(true);   
    }
            
    public static void changLNF(String nameLNF) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if (nameLNF.equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
        }
    }
}
