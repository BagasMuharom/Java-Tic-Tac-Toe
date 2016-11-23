package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class XOButton extends JButton{

    static int i = 0;

    public XOButton(){
        setBackground(Constants.warna2);
        init();
        actions();
    }

    private void actions(){
        addMouseListener(new MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                setBackground(Constants.warna3);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                setBackground(Constants.warna2);
            }
        });
    }

    private void init(){
        setIcon(new Icon() {
            @Override
            public void paintIcon(Component c, Graphics g, int x, int y) {
                g.drawImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../res/kotak.png")), (getWidth()-getHeight()+20)/2 , 10 , (getHeight()-20), (getHeight()-20),null);
            }
            @Override
            public int getIconWidth() {
                return 0;
            }

            @Override
            public int getIconHeight() {
                return 0;
            }
        });
    }

}