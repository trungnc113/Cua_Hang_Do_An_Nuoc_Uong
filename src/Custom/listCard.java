package Custom;

import DTO.SanPham;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class listCard extends JPanel {

    private int w = 1000;
    private int h = 350;
    JPanel productList = new JPanel();

    // khởi tạo khi không có danh sách
    public listCard() {
        productList.setLayout(null);
        JScrollPane scrollPane = new JScrollPane(productList);
        scrollPane.setPreferredSize(new Dimension(w, h));
        this.setPreferredSize(new Dimension(w, 500));
        this.add(scrollPane);
    }

    //khởi tạo khi có danh sách
    public listCard(ArrayList<SanPham> listSP) {
        productList.setLayout(new GridLayout(0, 5, 5, 5));
        JScrollPane scrollPane = new JScrollPane(productList);
        scrollPane.setPreferredSize(new Dimension(w, h));
        this.setPreferredSize(new Dimension(w, 500));
        this.add(scrollPane);
        addCards(listSP);
    }

    // thêm khi có danh sách
    public void addCards(ArrayList<SanPham> listSP) {
        for (int i = 0; i < listSP.size(); i++) {
            productList.add(new ProductCard(listSP.get(i)));
        }

    }

    //thêm khi chỉ có 1 sản phẩm
    public void addCard(SanPham sp) {
        productList.add(new ProductCard(sp));
    }

    //clear
    public void removeAll() {
        productList.removeAll();
    }
}