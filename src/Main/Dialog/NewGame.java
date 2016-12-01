package Main.Dialog;

import Main.Util.Constants;
import Main.Layout.MainLayout;
import Main.UI.CustomButton;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Class ini digunakan untuk membuat JDialog ketika user ingin memulai permainan baru
 * Dibuat terpisah dengan Class JFrame agar lebih terstruktur
 */
final public class NewGame extends JDialog implements MainLayout {

    private JPanel pvpPanel = new JPanel();
    private JPanel pvePanel = new JPanel();

    private CustomButton pvp = new CustomButton("Player VS Player",CustomButton.PRIMARY);
    private CustomButton pve = new CustomButton("Player VS CPU",CustomButton.PRIMARY);

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
        setBackground(Constants.windowBg);

        //Main Title
        mainTitle.setHorizontalAlignment(SwingConstants.CENTER);
        mainTitle.setBorder(new EmptyBorder(10,10,10,10));
        mainTitle.setOpaque(false);
        mainTitle.setBackground(Constants.windowBg);
        mainTitle.setForeground(Color.WHITE);
        mainTitle.setFont(new Font("Helvetica",Font.BOLD,20));

        // Parent Panel
        parentPanel.setLayout(new BorderLayout());
        parentPanel.setBackground(Constants.windowBg);

        //Panel
        pvpPanel.setLayout(new BorderLayout());
        pvePanel.setLayout(new BorderLayout());
        pvpPanel.setBackground(Constants.windowBg);
        pvpPanel.setBorder(new EmptyBorder(0,0,10,0));
        pvpPanel.add(pvp,BorderLayout.CENTER);
        pvePanel.add(pve,BorderLayout.CENTER);
        pvePanel.setBackground(Constants.windowBg);

        //Root panel
        rootPanel.setBorder(new EmptyBorder(10,10,10,10));
        rootPanel.setLayout(new BoxLayout(rootPanel,BoxLayout.Y_AXIS));
        rootPanel.setBackground(Constants.windowBg);
        rootPanel.add(pvpPanel);
        rootPanel.add(pvePanel);

        parentPanel.add(mainTitle,BorderLayout.PAGE_START);
        parentPanel.add(rootPanel,BorderLayout.CENTER);

        add(parentPanel,BorderLayout.CENTER);

        setVisible(true);
    }

}
