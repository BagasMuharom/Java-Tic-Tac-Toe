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
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Class ini digunakan untuk membuat JDialog ketika user ingin memulai permainan baru
 * Dibuat terpisah dengan Class JFrame agar lebih terstruktur
 */
public class SelectLevel extends JDialog implements MainLayout {

    private JPanel LevelPanel = new JPanel();

    private JPanel EasyPanel = new JPanel();
    private JPanel MediumPanel = new JPanel();
    private JPanel HardPanel = new JPanel();

    private CustomButton Easy = new CustomButton("Easy", Constants.warna3,Constants.warna4);
    private CustomButton Medium = new CustomButton("Medium",Constants.warna3,Constants.warna4);
    private CustomButton Hard = new CustomButton("Hard",Constants.warna3,Constants.warna4);

    private JPanel rootPanel = new JPanel();

    /**
     * Judul Utama
     */
    private JLabel mainTitle = new JLabel("Pilih Mode");

    /**
     * Konstruktor override untuk JDialog
     * Digunakan untuk melakukan inisialisasi JDialog
     */
    public SelectLevel(){
        super(Constants.TicTacToeParentFrame,true);
        setTitle("Permainan Baru");
        actions();
        init();
    }

    public void actions(){
        SelectLevel selectLevel = this;
        Easy.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Constants.GameLevel = 1;
                Constants.Controller.InputNama(selectLevel,false);
            }
        });
    }

    /**
     * Inisialisasi JDialog
     */
    public void init(){
        setSize(200,250);
        setResizable(false);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(Constants.TicTacToeParentFrame);
        setLayout(new BorderLayout());

        //Main Title
        mainTitle.setHorizontalAlignment(SwingConstants.CENTER);
        mainTitle.setBorder(new EmptyBorder(10,10,10,10));

        EasyPanel.setLayout(new BorderLayout());
        EasyPanel.add(Easy,BorderLayout.CENTER);
        EasyPanel.setBorder(new EmptyBorder(0,0,10,0));
        MediumPanel.setLayout(new BorderLayout());
        MediumPanel.add(Medium,BorderLayout.CENTER);
        MediumPanel.setBorder(new EmptyBorder(0,0,10,0));
        HardPanel.setLayout(new BorderLayout());
        HardPanel.add(Hard,BorderLayout.CENTER);

        //Panel
        LevelPanel.setLayout(new BoxLayout(LevelPanel,BoxLayout.Y_AXIS));
        LevelPanel.add(EasyPanel);
        LevelPanel.add(MediumPanel);
        LevelPanel.add(HardPanel);

        //Root panel
        rootPanel.setBorder(new EmptyBorder(10,10,10,10));
        rootPanel.setLayout(new BoxLayout(rootPanel,BoxLayout.Y_AXIS));
        rootPanel.add(LevelPanel);

        add(mainTitle, BorderLayout.PAGE_START);
        add(new JPanel(),BorderLayout.LINE_START);
        add(new JPanel(),BorderLayout.LINE_END);
        add(rootPanel,BorderLayout.CENTER);

        setVisible(true);
    }

}
