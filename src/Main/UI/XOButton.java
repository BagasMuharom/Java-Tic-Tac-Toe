package Main.UI;

import Main.UI.CustomButton;
import Main.Util.Constants;

public class XOButton extends CustomButton {

    public XOButton(){
        super("Tes", Constants.warna2,Constants.warna4);
        initButton();
    }

    private void initButton(){
        /*
        setUI(new PanelUI() {
            @Override
            public void paint(Graphics g, JComponent c) {
                super.paint(g, c);
                g.drawImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../Resources/icon.png")), (getWidth()-getHeight()+20)/2 , 10 , (getHeight()-20), (getHeight()-20),null);
            }
        });
        */
    }

}