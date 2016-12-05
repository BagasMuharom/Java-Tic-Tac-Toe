package Main.UI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.PanelUI;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Tiles extends JPanel{

    protected Color bg;

    protected Color hoverBg;

    private String iconSrc = "";

    private JLabel Text = new JLabel();

    private ImageIcon icon = new ImageIcon();

    public Tiles(){
        this.bg = new Color(0,0,0,75);
        this.hoverBg = new Color(0,0,0,120);
        init();
        actions();
    }

    protected void actions(){
        Tiles element = this;
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
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
    }

    public void setIcon(String iconstr){
        this.iconSrc = iconstr;
        icon.setImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(iconSrc)));
        Text.setIcon(icon);
        setStyle();
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

                /**
                 * Memberi icon pada button jika memiliki alamat icon
                 * alamat icon akan diberikan jika user atau CPU memilih button ini untuk diletakkan
                 * gaconya
                 */
                if(!iconSrc.equals("")){
                    try{
                        g.drawImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(iconSrc)), (getWidth() - getHeight() + 30) / 2, 15, getHeight() - 30, getHeight() - 30, null);
                    }
                    catch(NullPointerException err){
                        System.out.println("Alamat Icon salah !");
                    }
                }
            }
        });
    }

    protected void init(){
        setOpaque(false);
        setLayout(new BorderLayout(10,10));
        setBorder(new EmptyBorder(10,10,10,10));
        setBackground(bg);
        setStyle();
        Text.setHorizontalAlignment(SwingConstants.CENTER);
        Text.setForeground(Color.WHITE);
        add(Text);
    }

    public void setForeground(Color color){
        try {
            this.Text.setForeground(color);
        }
        catch (NullPointerException err){

        }
    }

}
