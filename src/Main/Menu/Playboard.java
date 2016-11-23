package Main.Menu;

import Main.Dialog.PlayAgain;
import Main.Layout.MainLayout;
import Main.UI.CustomButton;
import Main.UI.XOButton;
import Main.Util.Constants;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Playboard extends JPanel implements MainLayout {

    private JPanel mainPanel = new JPanel();
    private JPanel mainGrid = new JPanel();
    private JPanel giliranPanel = new JPanel();
    private JPanel player1Panel = new JPanel();
    private JPanel player2Panel = new JPanel();
    private JPanel atas = new JPanel();

    private JLabel player1 = new JLabel();
    private JLabel player2 = new JLabel();
    private JLabel giliran = new JLabel();

    private JLabel waktu = new JLabel();
    
    private Color bg = Constants.warna3;

    private ArrayList<XOButton> xo = new ArrayList<>();
    private CustomButton backtomenu = new CustomButton("Kembali ke menu",Constants.warna2,Constants.warna4);

    private byte gridRow = 4;
    private byte gridCol = 3;
    private byte gap = 10;

    public Playboard(){
        init();
        actions();
    }

    public void actions(){
        for(byte i=0;i<9;i++){
            xo.get(i).addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    JOptionPane.showMessageDialog(Constants.TicTacToeParentFrame,"Selamat, anda menang !");
                    PlayAgain playAgain = new PlayAgain();
                }
            });
        }
        backtomenu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Constants.Controller.destroyGame();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                backtomenu.setForeground(Constants.warna2);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                backtomenu.setForeground(Constants.warna3);
            }
        });
    }

    public void init(){
        //Main Panel
        setLayout(new BorderLayout());

        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(gap,gap,gap,gap));
        mainPanel.setBackground(bg);
        mainGrid.setLayout(new GridLayout(gridRow,gridCol,gap,gap));
        mainGrid.setBackground(bg);

        atas.setLayout(new BorderLayout());
        atas.setBackground(bg);

        waktu.setText("Waktu");
        waktu.setHorizontalAlignment(SwingConstants.CENTER);

        atas.add(waktu,BorderLayout.CENTER);
        atas.add(backtomenu,BorderLayout.LINE_END);
        mainPanel.add(atas,BorderLayout.NORTH);

        backtomenu.setForeground(Constants.warna3);

        player1.setText(Constants.Player1Name);
        player2.setText(Constants.Player2Name);

        player1.setFont(new Font("Helvetica",Font.PLAIN,20));
        player1.setIcon(new Icon() {
            @Override
            public void paintIcon(Component c, Graphics g, int x, int y) {
                g.drawImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../res/icon.png")), (getWidth()-getHeight()+20)/2 , 10 , (getHeight()-20), (getHeight()-20),null);
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
        player2.setFont(new Font("Helvetica",Font.PLAIN,20));

        getGiliran().setText(getGiliran().getText());
        getPlayer1().setHorizontalAlignment(SwingConstants.CENTER);
        getPlayer2().setHorizontalAlignment(SwingConstants.CENTER);
        getGiliran().setHorizontalAlignment(SwingConstants.CENTER);

        player1Panel.setLayout(new BoxLayout(player1Panel,BoxLayout.X_AXIS));
        player1Panel.setBackground(bg);
        player2Panel.setLayout(new BoxLayout(player2Panel,BoxLayout.X_AXIS));
        player2Panel.setBackground(bg);
        giliranPanel.setLayout(new BoxLayout(giliranPanel,BoxLayout.X_AXIS));
        giliranPanel.setBackground(bg);

        player1Panel.add(player1);
        player2Panel.add(player2);
        giliranPanel.add(giliran);

        mainGrid.add(player1Panel);
        mainGrid.add(player2Panel);
        mainGrid.add(giliranPanel);

        // Inisialisasi XO Button
        // Gunakan byte agar hemat memori
        for(int i=0;i<9;i++){
            xo.add(new XOButton());
            mainGrid.add(xo.get(i));
        }

        mainPanel.add(mainGrid,BorderLayout.CENTER);
        add(mainPanel);
    }

    public JLabel getPlayer1() {
        return player1;
    }

    public JLabel getPlayer2() {
        return player2;
    }

    public JLabel getGiliran() {
        return giliran;
    }

    public void setGiliran(JLabel giliran) {
        this.giliran = giliran;
    }

}
