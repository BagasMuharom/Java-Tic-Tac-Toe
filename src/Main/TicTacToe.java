package Main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe extends JFrame {

    private JPanel rootPanel = new JPanel();
    private JPanel menu = new JPanel();
    private JPanel newGamePanel = new JPanel();
    private JPanel caraMainPanel = new JPanel();
    private JPanel aboutPanel = new JPanel();
    private JPanel exitPanel = new JPanel();

    private JLabel mainTitle = new JLabel();

    private JButton newGame = new JButton();
    private JButton caraMain = new JButton();
    private JButton about = new JButton();
    private JButton exit = new JButton();

    public TicTacToe() {
        super("Tic Tac Toe");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../res/icon.png")));
        initComponents();
        actions();
    }

    private void actions(){
        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newGameDialog();
            }
        });
    }

    private void newGameDialog(){
        JDialog dialog = new JDialog(this,true);
        dialog.setSize(200,100);
        dialog.setTitle("Permainan Baru");
        dialog.setLocationRelativeTo(this);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);
    }

    public static void main(String[] args) {
        /**
         * Set Look and Feel
         **/
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TicTacToe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TicTacToe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TicTacToe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TicTacToe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        new TicTacToe();
    }

    private void initComponents() {
        //Frame
        setSize(400, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        //Button
        newGame.setText("Permainan Baru");
        newGame.setBackground(Color.blue);
        newGame.setMargin(new Insets(10,10,10,10));
        newGame.setFont(new Font(Font.SANS_SERIF,10,18));
        newGame.setForeground(Color.WHITE);
        caraMain.setText("Cara Bermain");
        about.setText("Tentang");

        //Label
        mainTitle.setText("TIC TAC TOE");
        mainTitle.setBorder(new EmptyBorder(10, 10, 10, 10));
        mainTitle.setFont(new Font("Source Sans Pro", 20, 20));
        mainTitle.setHorizontalAlignment(SwingConstants.CENTER);

        //Panel
        rootPanel.setLayout(new BorderLayout());
        rootPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        newGamePanel.setLayout(new BoxLayout(newGamePanel, BoxLayout.X_AXIS));
        caraMainPanel.setLayout(new BoxLayout(caraMainPanel, BoxLayout.X_AXIS));
        aboutPanel.setLayout(new BoxLayout(aboutPanel, BoxLayout.X_AXIS));
        newGamePanel.add(newGame);
        newGamePanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        caraMainPanel.add(caraMain);
        caraMainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        aboutPanel.add(about);
        aboutPanel.setBorder(new EmptyBorder(10,10,10,10));

        //Menu
        menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));
        menu.add(newGamePanel);
        menu.add(caraMainPanel);
        menu.add(aboutPanel);

        rootPanel.add(mainTitle, BorderLayout.PAGE_START);
        rootPanel.add(new JPanel(), BorderLayout.LINE_START);
        rootPanel.add(menu, BorderLayout.CENTER);

        //Adding component
        add(rootPanel, BorderLayout.CENTER);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
