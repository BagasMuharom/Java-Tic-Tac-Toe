package Main;

import javax.swing.JButton;
import javax.swing.ImageIcon;

public class XOButton extends JButton{

    private boolean x;

    private ImageIcon imageX;

    private ImageIcon imageO;

    public XOButton(){
        actions();
        setBackground(java.awt.Color.white);
    }

    private void actions(){

    }

    public boolean isX(){
        return x;
    }

    public void change(){

    }

}