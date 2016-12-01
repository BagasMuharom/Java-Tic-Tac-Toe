package Main;

/*
 * Ini merupakan permainan TicTacToe versi Java dengan Swing sebagai GUI
 */

import Main.Bootstrap.Controller;
import Main.Bootstrap.View;
import Main.Layout.MainLayout;
import Main.Util.Constants;
import Main.Util.PVE;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.*;

final public class TicTacToe extends JFrame implements MainLayout {

    private Main.Bootstrap.View View = new View();
    private Main.Bootstrap.Controller Controller = new Controller();

    public TicTacToe(){
        // Memberi Judul Window
        super("Tic Tac Toe");

        //Mengatur Konstanta
        Constants.Frame = this;
        Constants.View = this.View;
        Constants.Controller = this.Controller;
        Constants.AI = new PVE();
        Constants.TicTacToeParentFrame = this;

        //Mengatur Icon pada Window
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../Resources/icon.png")));

        //Inisialisasi Komponen
        init();
    }

    public static void main(String[] args) {
        /*
         * Disinilah aplikasi dimulai :)
         */
        setLookAndFeel();
        new TicTacToe();
    }

    private static void setLookAndFeel(){
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
    }

    @Override
    public void actions() {

    }

    public void init(){
        //Frame
        setSize(400, 550);
        setMinimumSize(new Dimension(400,550));
        setResizable(true);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        //Frame
        add(View, BorderLayout.CENTER);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
