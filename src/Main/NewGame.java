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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Class ini digunakan untuk membuat JDialog ketika user ingin memulai permainan baru
 * Dibuat terpisah dengan Class JFrame agar lebih terstruktur
 */
public class NewGame extends JDialog implements MainLayout{

    private JPanel pvpPanel = new JPanel();
    private JPanel pvePanel = new JPanel();

    private CustomButton pvp = new CustomButton("Player VS Player",Constants.warna3,Constants.warna4);
    private CustomButton pve = new CustomButton("Player VS CPU",Constants.warna3,Constants.warna4);

    private JPanel parentPanel = new JPanel();
    private JPanel rootPanel = new JPanel();

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
        Constants.NewGameFrame = this;
        setTitle("Permainan Baru");
        actions();
        init();
    }

    public void actions(){
        NewGame newGame = this;
        pvp.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Constants.Controller.InputNama(newGame,true);
            }
        });
        pve.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Constants.Controller.SelectLevel();
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
        setBackground(Constants.warna2);

        //Main Title
        mainTitle.setHorizontalAlignment(SwingConstants.CENTER);
        mainTitle.setBorder(new EmptyBorder(10,10,10,10));
        mainTitle.setOpaque(false);
        mainTitle.setBackground(Constants.warna2);

        // Parent Panel
        parentPanel.setLayout(new BorderLayout());
        parentPanel.setBackground(Constants.warna2);

        //Panel
        pvpPanel.setLayout(new BorderLayout());
        pvePanel.setLayout(new BorderLayout());
        pvpPanel.setBackground(Constants.warna2);
        pvpPanel.setBorder(new EmptyBorder(0,0,10,0));
        pvpPanel.add(pvp,BorderLayout.CENTER);
        pvePanel.add(pve,BorderLayout.CENTER);
        pvePanel.setBackground(Constants.warna2);

        //Root panel
        rootPanel.setBorder(new EmptyBorder(10,10,10,10));
        rootPanel.setLayout(new BoxLayout(rootPanel,BoxLayout.Y_AXIS));
        rootPanel.setBackground(Constants.warna2);
        rootPanel.add(pvpPanel);
        rootPanel.add(pvePanel);

        parentPanel.add(mainTitle,BorderLayout.PAGE_START);
        parentPanel.add(rootPanel,BorderLayout.CENTER);

        add(parentPanel,BorderLayout.CENTER);

        setVisible(true);
    }

}
