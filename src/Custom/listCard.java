package Custom;

import DTO.SanPham;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class listCard extends JPanel {

    int w = 700;
    int h = 318 ; // chỉ chỉnh lại chổ này

    public listCard(ArrayList<SanPham> listSP) {

        JPanel productList = new JPanel();

        productList.setLayout(new GridLayout(0, 3, 5, 5));

        for (int i = 0; i < listSP.size(); i++) {
            productList.add(new ProductCard(listSP.get(i)));
        }

        JScrollPane scrollPane = new JScrollPane(productList);

        scrollPane.setPreferredSize(new Dimension(w, h));

        this.add(scrollPane);
    }
}
