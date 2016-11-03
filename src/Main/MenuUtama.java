package Main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuUtama extends JPanel implements MainLayout {

    private JPanel menu = new JPanel();
    private JPanel newGamePanel = new JPanel();
    private JPanel caraMainPanel = new JPanel();
    private JPanel aboutPanel = new JPanel();
    private JPanel exitPanel = new JPanel();

    private JLabel mainTitle = new JLabel();

    private JButton newGame = new JButton("Permainan Baru");
    private JButton caraMain = new JButton("Cara Bermain");
    private JButton about = new JButton("Tentang");
    private JButton exit = new JButton("Keluar");

    public TicTacToe frame;

    private Frame owner;

    public MenuUtama(Frame owner){
        this.owner = owner;
        actions();
        init();
    }

    public void actions(){
        /*
         * Memulai permainan baru
         */
        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newGameDialog();
            }
        });

        /*
         * Keluar dari aplikasi
         */
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void newGameDialog(){
        PermainanBaru newGame = new PermainanBaru(owner,true);
        /**
         * Jika User memilih antara PVP atau PVE
         */
        if(newGame.isGameStart()){
            frame.getCl().show(frame.getRootPanel(),"2");
        }
    }

    public void init(){
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(20, 20, 20, 20));

        //Button
        newGame.setBackground(Color.blue);
        newGame.setMargin(new Insets(10,10,10,10));
        newGame.setFont(new Font(Font.SANS_SERIF,10,18));
        newGame.setForeground(Color.WHITE);

        //Mengatur Judul
        mainTitle.setText("TIC TAC TOE");
        mainTitle.setBorder(new EmptyBorder(10, 10, 10, 10));
        mainTitle.setFont(new Font("Source Sans Pro", 20, 20));
        mainTitle.setHorizontalAlignment(SwingConstants.CENTER);

        //Tampilan Panel
        newGamePanel.setLayout(new BoxLayout(newGamePanel, BoxLayout.X_AXIS));
        caraMainPanel.setLayout(new BoxLayout(caraMainPanel, BoxLayout.X_AXIS));
        aboutPanel.setLayout(new BoxLayout(aboutPanel, BoxLayout.X_AXIS));
        exitPanel.setLayout(new BoxLayout(exitPanel, BoxLayout.X_AXIS));
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
        menu.add(newGamePanel);
        menu.add(caraMainPanel);
        menu.add(aboutPanel);
        menu.add(exitPanel);

        //Container 1
        add(mainTitle, BorderLayout.PAGE_START);
        add(new JPanel(), BorderLayout.LINE_START);
        add(menu, BorderLayout.CENTER);
    }

}
