package Main;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class ini digunakan untuk membuat JDialog ketika user ingin memulai permainan baru
 * Dibuat terpisah dengan Class JFrame agar lebih terstruktur
 */
public class NewGame extends JDialog implements MainLayout{

    private JPanel pvpPanel = new JPanel();
    private JPanel pvePanel = new JPanel();

    private JButton pvp = new JButton("Player VS Player");
    private JButton pve = new JButton("Player VS CPU");

    private JPanel rootPanel = new JPanel();

    private String player1 = "";
    private String player2 = "";

    private boolean gameStart = false;
    private boolean gamePVP = false;

    /**
     * Judul Utama
     */
    private JLabel mainTitle = new JLabel("Pilih Mode");

    /**
     * Konstruktor override untuk JDialog
     * Digunakan untuk melakukan inisialisasi JDialog
     */
    public NewGame(){
        super(Constants.TicTacToeParentFrame,true);
        setTitle("Permainan Baru");
        actions();
        init();
    }

    public void actions(){
        pvp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player1 = JOptionPane.showInputDialog("Nama Player 1");
                //Jika klik OK
                if(getPlayer1() != null){
                    //Jika ada isiya
                    if(getPlayer1().length()>0){
                        player2 = JOptionPane.showInputDialog("Nama Player 2");
                        //Jika klik OK
                        if(getPlayer2() != null){
                            //Jika tidak ada isiya
                            if(getPlayer2().length()>1){
                                gameStart = true;
                                setVisible(false);
                            }
                            else {
                                while (getPlayer2().length() <= 0  || getPlayer2() == null){
                                    player2 = JOptionPane.showInputDialog("Nama Player 2");
                                }
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"Tidak ada isinya");
                        }
                    }
                    else {
                        while (getPlayer1().length() <=0 || getPlayer1() == null){
                            player1 = JOptionPane.showInputDialog("Nama Player 1");
                        }
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,"Tidak ada isinya");
                }
            }
        });
    }

    /**
     * Inisialisasi JDialog
     */
    public void init(){
        setSize(200,200);
        setResizable(false);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(Constants.TicTacToeParentFrame);
        setLayout(new BorderLayout());

        //Main Title
        mainTitle.setHorizontalAlignment(SwingConstants.CENTER);
        mainTitle.setBorder(new EmptyBorder(10,10,10,10));

        //Panel
        pvpPanel.setLayout(new BoxLayout(pvpPanel,BoxLayout.X_AXIS));
        pvePanel.setLayout(new BoxLayout(pvePanel,BoxLayout.X_AXIS));
        pvpPanel.add(pvp);
        pvePanel.add(pve);

        //Root panel
        rootPanel.setBorder(new EmptyBorder(10,10,10,10));
        rootPanel.setLayout(new BoxLayout(rootPanel,BoxLayout.Y_AXIS));
        rootPanel.add(pvpPanel);
        rootPanel.add(pvePanel);

        add(mainTitle,BorderLayout.PAGE_START);
        add(new JPanel(),BorderLayout.LINE_START);
        add(new JPanel(),BorderLayout.LINE_END);
        add(rootPanel,BorderLayout.CENTER);

        setVisible(true);
    }

    public String getPlayer1() {
        return player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public boolean isGameStart() {
        return gameStart;
    }

    public boolean isGamePVP() {
        return gamePVP;
    }
}
