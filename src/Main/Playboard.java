package Main;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Playboard extends JPanel implements MainLayout{

    private JPanel mainPanel = new JPanel();
    private JPanel mainGrid = new JPanel();
    private JPanel giliranPanel = new JPanel();
    private JPanel player1Panel = new JPanel();
    private JPanel player2Panel = new JPanel();

    private JLabel player1 = new JLabel();
    private JLabel player2 = new JLabel();
    private JLabel giliran = new JLabel();

    private ArrayList<XOButton> xo = new ArrayList<>();

    private byte gridRow = 4;
    private byte gridCol = 3;
    private byte gap = 10;

    public Playboard(){
        init();
        actions();
    }

    public void actions(){
        for(byte i=0;i<9;i++){
            xo.get(i).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null,"Selamat, anda menang !");
                    Constants.View.setView("MainMenu");
                }
            });
        }
    }

    public void init(){
        //Main Panel
        setLayout(new BorderLayout());
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(gap,gap,gap,gap));
        mainGrid.setLayout(new GridLayout(gridRow,gridCol,gap,gap));

        player1.setFont(new Font("Algerian",Font.PLAIN,20));
        player2.setFont(new Font("Algerian",Font.PLAIN,20));

        getGiliran().setText(getGiliran().getText());
        getPlayer1().setHorizontalAlignment(SwingConstants.CENTER);
        getPlayer2().setHorizontalAlignment(SwingConstants.CENTER);
        getGiliran().setHorizontalAlignment(SwingConstants.CENTER);

        player1Panel.setLayout(new BoxLayout(player1Panel,BoxLayout.X_AXIS));
        player2Panel.setLayout(new BoxLayout(player2Panel,BoxLayout.X_AXIS));
        giliranPanel.setLayout(new BoxLayout(giliranPanel,BoxLayout.X_AXIS));

        player1Panel.add(player1);
        player2Panel.add(player2);
        giliranPanel.add(giliran);

        mainGrid.add(player1Panel);
        mainGrid.add(player2Panel);
        mainGrid.add(giliranPanel);

        // Inisialisasi XO Button
        // Gunakan byte agar hemat memori
        for(byte i=0;i<9;i++){
            xo.add(new XOButton());
            mainGrid.add(xo.get(i));
        }

        mainPanel.add(mainGrid,BorderLayout.CENTER);
        add(mainPanel);
    }

    public JLabel getPlayer1() {
        return player1;
    }

    public void setPlayer1(JLabel player1) {
        this.player1 = player1;
    }

    public JLabel getPlayer2() {
        return player2;
    }

    public void setPlayer2(JLabel player2) {
        this.player2 = player2;
    }

    public JLabel getGiliran() {
        return giliran;
    }

    public void setGiliran(JLabel giliran) {
        this.giliran = giliran;
    }

}
