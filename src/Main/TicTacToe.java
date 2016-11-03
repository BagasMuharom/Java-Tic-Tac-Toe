package Main;

import javax.swing.*;
import java.awt.*;

public class TicTacToe extends JFrame {

    private CardLayout cl = new CardLayout();
    private JPanel rootPanel = new JPanel();
    private MenuUtama container1 = new MenuUtama(this);
    private Playboard container2 = new Playboard();

    public TicTacToe(){
        super("Tic Tac Toe");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../res/icon.png")));
        initComponents();
    }

    public static void main(String[] args) {
        /*
         * Mengatur Look and Feel
         */
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

        /*
         * Disinilah aplikasi dimulai :)
         */
        new TicTacToe();
    }

    private void initComponents() {
        //Frame
        setSize(400, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        //Mengatur tampilan semua JPanel
        getRootPanel().setLayout(getCl());

        //Root Panel
        getRootPanel().add(container1,"1");
        getRootPanel().add(container2,"2");
        container1.frame = this;

        //Menampilkan menu utama
        getCl().show(getRootPanel(),"1");

        //Frame
        add(getRootPanel(), BorderLayout.CENTER);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public CardLayout getCl() {
        return cl;
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }
}
