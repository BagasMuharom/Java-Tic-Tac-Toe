package Main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

/**
 * Class untuk menampilkan menu utama pada aplikasi
 */
public class MainMenu extends JPanel implements MainLayout {

    private JPanel menu = new JPanel();
    private JPanel newGamePanel = new JPanel();
    private JPanel caraMainPanel = new JPanel();
    private JPanel aboutPanel = new JPanel();
    private JPanel exitPanel = new JPanel();

    private JLabel mainTitle = new JLabel();

    private CustomButton newGame = new CustomButton("Permainan Baru",Constants.warna3,Constants.warna4);
    private CustomButton caraMain = new CustomButton("Cara Bermain",Constants.warna3,Constants.warna4);
    private CustomButton about = new CustomButton("Tentang Aplikasi",Constants.warna3,Constants.warna4);
    private CustomButton exit = new CustomButton("Keluar",Constants.warna3,Constants.warna4);

    private ImageIcon logo = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../res/icon.png")));

    public MainMenu(){
        actions();
        init();
    }

    public void actions(){
        /*
         * Memulai permainan baru
         */
        newGame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Constants.Controller.newGameDialog();
            }
        });
        caraMain.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Constants.View.setView("HowToPlay");
            }
        });
        about.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Constants.View.setView("About");
            }
        });
        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.exit(0);
            }
        });
        
    }

    public void init(){
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(20, 20, 20, 20));
        setBackground(Constants.warna2);

        newGame.getText().setFont(new Font("Helvetica",1,20));


        //Mengatur Judul
        mainTitle.setText("TIC TAC TOE");
        mainTitle.setBorder(new EmptyBorder(10, 10, 10, 10));
        mainTitle.setFont(new Font("Source Sans Pro", 20, 20));
        mainTitle.setHorizontalAlignment(SwingConstants.CENTER);

        //Tampilan Panel
        newGamePanel.setLayout(new BoxLayout(newGamePanel, BoxLayout.X_AXIS));
        newGamePanel.setBackground(Constants.warna2);
        caraMainPanel.setLayout(new BoxLayout(caraMainPanel, BoxLayout.X_AXIS));
        caraMainPanel.setBackground(Constants.warna2);
        aboutPanel.setLayout(new BoxLayout(aboutPanel, BoxLayout.X_AXIS));
        aboutPanel.setBackground(Constants.warna2);
        exitPanel.setLayout(new BoxLayout(exitPanel, BoxLayout.X_AXIS));
        exitPanel.setBackground(Constants.warna2);
        newGamePanel.add(newGame);
        newGamePanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        caraMainPanel.add(caraMain);
        caraMainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        aboutPanel.add(about);
        aboutPanel.setBorder(new EmptyBorder(10,10,10,10));
        exitPanel.add(exit);
        exitPanel.setBorder(new EmptyBorder(10,10,10,10));

        //Menu Utama
        menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));
        menu.setBackground(new Color(0,0,0,0));
        menu.add(newGamePanel);
        menu.add(caraMainPanel);
        menu.add(aboutPanel);
        menu.add(exitPanel);

        //Container 1
        add(mainTitle, BorderLayout.PAGE_START);
        add(menu, BorderLayout.CENTER);
    }

}
