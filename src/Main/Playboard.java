package Main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class Playboard extends JPanel implements MainLayout{

    private JPanel mainPanel = new JPanel();
    private JPanel mainGrid = new JPanel();

    private String namaPlayer1;
    private String namaPlayer2;
    private String giliranSekarang;

    private JLabel player1 = new JLabel();
    private JLabel player2 = new JLabel();
    private JLabel giliran = new JLabel();

    private ArrayList<XOButton> xo = new ArrayList<>();

    public Playboard(){
        actions();
        init();
    }

    public void actions(){

    }

    public void init(){
        //Main Panel
        setLayout(new BorderLayout());
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(10,10,10,10));
        mainGrid.setLayout(new GridLayout(4,3,10,10));

        player1.setText(getNamaPlayer1());
        player2.setText(getNamaPlayer2());
        giliran.setText(getGiliranSekarang());
        player1.setHorizontalAlignment(SwingConstants.CENTER);
        player2.setHorizontalAlignment(SwingConstants.CENTER);
        giliran.setHorizontalAlignment(SwingConstants.CENTER);

        mainGrid.add(player1);
        mainGrid.add(player2);
        mainGrid.add(giliran);

        //Inisialisasi XO Button
        for(int i=0;i<9;i++){
            xo.add(new XOButton());
            xo.get(i).setBackground(Color.BLUE);
            mainGrid.add(xo.get(i));
        }

        mainPanel.add(mainGrid,BorderLayout.CENTER);
        add(mainPanel);
    }

    public String getNamaPlayer1() {
        return namaPlayer1;
    }

    public void setNamaPlayer1(String namaPlayer1) {
        this.namaPlayer1 = namaPlayer1;
    }

    public String getNamaPlayer2() {
        return namaPlayer2;
    }

    public void setNamaPlayer2(String namaPlayer2) {
        this.namaPlayer2 = namaPlayer2;
    }

    public String getGiliranSekarang() {
        return giliranSekarang;
    }

    public void setGiliranSekarang(String giliranSekarang) {
        this.giliranSekarang = giliranSekarang;
    }
}
