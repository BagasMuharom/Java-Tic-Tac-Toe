package Main.UI;

import Main.Dialog.PlayAgain;
import Main.Util.Constants;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.PanelUI;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CustomButton extends JPanel{

    protected Color bg;

    protected Color hoverBg;

    private JLabel Text = new JLabel();

    int type;

    public static final int PRIMARY = 1;

    public static final int DANGER = 2;

    public CustomButton(String Text,int type){
        this.Text.setText(Text);
        this.type = type;
        init();
        actions();
    }

    protected void actions(){
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                setBackground(hoverBg);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                setBackground(bg);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                setBackground(new Color(getBackground().getRed()-20,getBackground().getGreen()-20,getBackground().getBlue()-20));
            }
        });
    }

    protected void setStyle(){
        setUI(new PanelUI() {
            @Override
            public void paint(Graphics g, JComponent c) {
                super.paint(g, c);
                Dimension arcs = new Dimension(10, 10);
                Color shadowColor = Color.BLUE;
                int width = getWidth();
                int height = getHeight();
                int shadowGap = 0;
                int shadowOffset = 0;
                int strokeSize = 0;
                Color shadowColorA = new Color(shadowColor.getRed(), shadowColor.getGreen(), shadowColor.getBlue());
                Graphics2D graphics = (Graphics2D) g;

                //Sets antialiasing if HQ.
                graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                //Draws shadow borders if any.
                graphics.setColor(new Color(0,0,0,0));
                graphics.fillRoundRect(
                        0,// X position
                        0,// Y position
                        width, // width
                        height, // height
                        arcs.width, arcs.height);// arc Dimension

                //Draws the rounded opaque panel with borders.
                graphics.setColor(getBackground());
                graphics.fillRoundRect(0, 0, width - shadowGap, height - shadowGap, arcs.width, arcs.height);
                graphics.setColor(new Color(0,0,0,0));
                graphics.drawRoundRect(0, 0, width - shadowGap, height - shadowGap, arcs.width, arcs.height);
            }
        });
    }

    protected void init(){
        if(type==1){
            this.bg = Constants.buttonBgPrimary;
            this.hoverBg = Constants.buttonBgPrimaryHover;
        }
        else if(type==2){
            this.bg = Constants.buttonBgDanger;
            this.hoverBg = Constants.buttonBgDangerHover;
        }
        setOpaque(false);
        setLayout(new BorderLayout(10,10));
        setBorder(new EmptyBorder(10,10,10,10));
        setBackground(bg);
        setStyle();
        Text.setHorizontalAlignment(SwingConstants.CENTER);
        Text.setForeground(Color.WHITE);
        add(Text);
    }

    public JLabel getText(){
        return this.Text;
    }

    public void setForeground(Color color){
        try {
            this.Text.setForeground(color);
        }
        catch (NullPointerException err){

        }
    }

}
