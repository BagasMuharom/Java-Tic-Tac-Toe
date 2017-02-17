package Main.Menu;

import Main.Dialog.BackToMenuAlert;
import Main.Dialog.PlayAgain;
import Main.Layout.MainLayout;
import Main.UI.CustomButton;
import Main.UI.Tiles;
import Main.Util.Constants;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

final public class Playboard extends JPanel implements MainLayout {

    private JPanel mainPanel = new JPanel();
    private JPanel mainGrid = new JPanel();
    private JPanel giliranPanel = new JPanel();
    private JPanel player1Panel = new JPanel();
    private JPanel player2Panel = new JPanel();
    private JPanel atas = new JPanel();

    private JLabel player1 = new JLabel();
    private JLabel player2 = new JLabel();
    private JLabel giliran = new JLabel();
    private JLabel turnPlayerName = new JLabel();

    private ImageIcon player1Icon = new ImageIcon();
    private ImageIcon player2Icon = new ImageIcon();

    private JLabel player1IconPanel = new JLabel("",player1Icon,JLabel.LEFT);
    private JLabel player2IconPanel = new JLabel("",player2Icon,JLabel.LEFT);

    private JLabel waktu = new JLabel();
    
    private Color bg = Constants.warna4;

    private ArrayList<Tiles> xo = new ArrayList<>();
    private CustomButton backtomenu = new CustomButton("Kembali ke menu",CustomButton.DANGER);

    private byte gridRow = 4;
    private byte gridCol = 3;
    private byte gap = 10;

    public Playboard(){
        init();
        actions();
    }

    public void actions(){
        backtomenu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(!Constants.PVPGame)
                    Constants.timer.stop();
                BackToMenuAlert back = new BackToMenuAlert();
            }
        });

        for(byte j=0;j<9;j++){
            byte i = j;
            xo.get(j).addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    Constants.Controller.tileClicked(i);
                }
            });
        }

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
        atas.add(backtomenu,BorderLayout.LINE_END);
        mainPanel.add(atas,BorderLayout.NORTH);

        backtomenu.setForeground(Constants.warna2);

        player1.setText(Constants.Player1Name);
        player2.setText(Constants.Player2Name);
        giliran.setText("Giliran");
        giliran.setFont(new Font("Helvetica",Font.PLAIN,20));
        giliran.setForeground(Color.WHITE);

        player1.setFont(new Font("Helvetica",Font.PLAIN,20));
        player2.setFont(new Font("Helvetica",Font.PLAIN,20));
        player1.setForeground(Color.WHITE);
        player2.setForeground(Color.WHITE);

        getGiliran().setText(getGiliran().getText());
        getPlayer1().setHorizontalAlignment(SwingConstants.CENTER);
        getPlayer2().setHorizontalAlignment(SwingConstants.CENTER);
        getGiliran().setHorizontalAlignment(SwingConstants.CENTER);

        player1Panel.setLayout(new BoxLayout(player1Panel,BoxLayout.Y_AXIS));
        player1Panel.setBackground(bg);
        player1Panel.setBorder(new EmptyBorder(10,10,10,10));
        player2Panel.setLayout(new BoxLayout(player2Panel,BoxLayout.Y_AXIS));
        player2Panel.setBackground(bg);
        player2Panel.setBorder(new EmptyBorder(10,10,10,10));
        giliranPanel.setLayout(new BoxLayout(giliranPanel,BoxLayout.Y_AXIS));
        giliranPanel.setBackground(bg);
        giliranPanel.setBorder(new EmptyBorder(10,10,10,10));

        turnPlayerName.setForeground(Color.WHITE);
        turnPlayerName.setFont(new Font("Helvetica", Font.PLAIN,16));

        player1Icon.setImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../../Resources/squaresmall.png")));
        player2Icon.setImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../../Resources/circlesmall.png")));
        player1IconPanel.setIcon(player1Icon);
        player2IconPanel.setIcon(player2Icon);
        player1IconPanel.setBorder(new EmptyBorder(10,0,0,0));
        player2IconPanel.setBorder(new EmptyBorder(10,0,0,0));
        player1Panel.add(player1);
        player1Panel.add(player1IconPanel);
        player2Panel.add(player2);
        player2Panel.add(player2IconPanel);
        giliranPanel.add(giliran);
        giliranPanel.add(turnPlayerName);

        mainGrid.add(player1Panel);
        mainGrid.add(player2Panel);
        mainGrid.add(giliranPanel);

        // Inisialisasi XO Button
        // Gunakan byte agar hemat memori
        for(byte i=0;i<9;i++){
            xo.add(new Tiles());
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

    public JLabel getTurnPlayerName() {
        return turnPlayerName;
    }

    public void renderPlayboard(){
        int adder = 0;
        if(Constants.turnPlayer1)
            turnPlayerName.setText(Constants.Player1Name);
        else
            turnPlayerName.setText(Constants.Player2Name);
        for(byte i=0;i<3;i++){
            for(byte j=0;j<3;j++){
                if(Constants.arrayBoard[i][j]==1){
                    xo.get(i+j+adder).setIcon(Constants.iconPlayer1);
                }
                else if(Constants.arrayBoard[i][j]==2){
                    xo.get(i+j+adder).setIcon(Constants.iconPlayer2);
                }
                else{
                    xo.get(i+j+adder).setIcon("");
                }
            }
            adder+=2;
        }
    }

    public void hapusWaktu(){
        waktu.setVisible(false);
    }

    public void setPVEGame(){
        setCountdown();
        aturWaktu();
        if(!Constants.turnPlayer1)
            Constants.Controller.PVEStart();
    }

    public void aturWaktu(){
        waktu.setVisible(true);
        waktu.setForeground(Color.WHITE);
        ImageIcon sw = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../../Resources/stopwatchsmall.png")));
        waktu.setIcon(sw);
        waktu.setIconTextGap(JLabel.LEFT);
        waktu.setFont(new Font("Helvetica",Font.PLAIN,16));
        waktu.setHorizontalAlignment(SwingConstants.CENTER);
        atas.add(waktu,BorderLayout.CENTER);

        Constants.PVETime = 15;
        int level = Constants.GameLevel;
        switch(level){
            case 1:
                Constants.PVETime = 15;
                break;
            case 2:
                Constants.PVETime = 10;
                break;
            case 3:
                Constants.PVETime = 8;
                break;
        }
    }

    public void setCountdown(){
        Constants.PVETime--;
        Constants.timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Constants.PVETime>9)
                    waktu.setText("     Waktu : " + Constants.PVETime + " detik");
                else
                    waktu.setText("     Waktu : 0" + Constants.PVETime + " detik");
                if(Constants.PVETime>0){
                    Constants.PVETime--;
                }
                else{
                    Constants.timer.stop();
                    if(!Constants.GameEnd) {
                        JOptionPane.showMessageDialog(Constants.TicTacToeParentFrame, "Waktu habis, anda kalah !");
                        PlayAgain playAgain = new PlayAgain();
                    }
                }
            }
        });
        Constants.timer.start();
    }

    public JLabel getWaktu() {
        return waktu;
    }
}
