package Main.Menu;

import Main.Util.Constants;
import Main.UI.CustomButton;
import Main.Layout.MainLayout;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

/**
 * Class untuk menampilkan menu utama pada aplikasi
 */
final public class MainMenu extends JPanel implements MainLayout {

    private JPanel menu = new JPanel();
    private JPanel newGamePanel = new JPanel();
    private JPanel caraMainPanel = new JPanel();
    private JPanel aboutPanel = new JPanel();
    private JPanel exitPanel = new JPanel();

    private JLabel mainTitle = new JLabel();

    private Color bg = Constants.windowBg;

    private CustomButton newGame = new CustomButton("Permainan Baru",CustomButton.PRIMARY);
    private CustomButton caraMain = new CustomButton("Cara Bermain",CustomButton.PRIMARY);
    private CustomButton about = new CustomButton("Tentang Aplikasi",CustomButton.PRIMARY);
    private CustomButton exit = new CustomButton("Keluar",CustomButton.DANGER);

    private ImageIcon logo = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../../Resources/icon.png")));

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
        setBackground(bg);

        newGame.getText().setFont(new Font("Helvetica",1,20));
        caraMain.getText().setFont(new Font("Helvetica",1,20));
        about.getText().setFont(new Font("Helvetica",1,20));
        exit.getText().setFont(new Font("Helvetica",1,20));

        //Mengatur Judul
        mainTitle.setText("TIC TAC TOE");
        mainTitle.setForeground(Color.WHITE);
        mainTitle.setBorder(new EmptyBorder(10, 10, 10, 10));
        mainTitle.setFont(new Font("Source Sans Pro", Font.BOLD, 30));
        mainTitle.setHorizontalAlignment(SwingConstants.CENTER);

        //Tampilan Panel
        newGamePanel.setLayout(new BoxLayout(newGamePanel, BoxLayout.X_AXIS));
        newGamePanel.setBackground(bg);
        caraMainPanel.setLayout(new BoxLayout(caraMainPanel, BoxLayout.X_AXIS));
        caraMainPanel.setBackground(bg);
        aboutPanel.setLayout(new BoxLayout(aboutPanel, BoxLayout.X_AXIS));
        aboutPanel.setBackground(bg);
        exitPanel.setLayout(new BoxLayout(exitPanel, BoxLayout.X_AXIS));
        exitPanel.setBackground(bg);
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
