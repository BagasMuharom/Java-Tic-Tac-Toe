package Main.Dialog;

import Main.Util.Constants;
import Main.Layout.MainLayout;
import Main.UI.CustomButton;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Class ini digunakan untuk membuat JDialog ketika user ingin memulai permainan baru
 * Dibuat terpisah dengan Class JFrame agar lebih terstruktur
 */
final public class SelectLevel extends JDialog implements MainLayout {

    private JPanel LevelPanel = new JPanel();

    private JPanel EasyPanel = new JPanel();
    private JPanel MediumPanel = new JPanel();
    private JPanel HardPanel = new JPanel();

    private CustomButton Easy = new CustomButton("Mudah",CustomButton.PRIMARY);
    private CustomButton Medium = new CustomButton("Sedang",CustomButton.PRIMARY);
    private CustomButton Hard = new CustomButton("Sulit",CustomButton.PRIMARY);

    private ImageIcon sw = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../../Resources/stopwatchsmall.png")));

    private JLabel easyTime = new JLabel("15 detik",sw,JLabel.LEFT);
    private JLabel mediumTime = new JLabel("10 detik",sw,JLabel.LEFT);
    private JLabel hardTime = new JLabel("  8 detik",sw,JLabel.LEFT);

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
        Medium.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Constants.GameLevel = 2;
                Constants.Controller.InputNama(selectLevel,false);
            }
        });
        Hard.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Constants.GameLevel = 3;
                Constants.Controller.InputNama(selectLevel,false);
            }
        });
    }

    /**
     * Inisialisasi JDialog
     */
    public void init(){
        setSize(200,300);
        setResizable(false);
        setBackground(Constants.windowBg);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(Constants.TicTacToeParentFrame);
        setLayout(new BorderLayout());

        //Main Title
        mainTitle.setBackground(Constants.windowBg);
        mainTitle.setOpaque(true);
        mainTitle.setHorizontalAlignment(SwingConstants.CENTER);
        mainTitle.setBorder(new EmptyBorder(10,10,10,10));
        mainTitle.setForeground(Color.WHITE);
        mainTitle.setFont(new Font("Helvetica",Font.BOLD,20));

        easyTime.setForeground(Color.WHITE);
        mediumTime.setForeground(Color.WHITE);
        hardTime.setForeground(Color.WHITE);

        EasyPanel.setLayout(new BorderLayout());
        EasyPanel.add(Easy,BorderLayout.CENTER);
        Easy.add(easyTime,BorderLayout.LINE_END);
        EasyPanel.setBorder(new EmptyBorder(0,0,10,0));
        EasyPanel.setBackground(Constants.windowBg);
        MediumPanel.setLayout(new BorderLayout());
        MediumPanel.add(Medium,BorderLayout.CENTER);
        Medium.add(mediumTime,BorderLayout.LINE_END);
        MediumPanel.setBorder(new EmptyBorder(0,0,10,0));
        MediumPanel.setBackground(Constants.windowBg);
        HardPanel.setLayout(new BorderLayout());
        HardPanel.add(Hard,BorderLayout.CENTER);
        HardPanel.setBackground(Constants.windowBg);
        Hard.add(hardTime,BorderLayout.LINE_END);

        //Panel
        LevelPanel.setLayout(new BoxLayout(LevelPanel,BoxLayout.Y_AXIS));
        LevelPanel.setBackground(Constants.windowBg);
        LevelPanel.add(EasyPanel);
        LevelPanel.add(MediumPanel);
        LevelPanel.add(HardPanel);

        //Root panel
        rootPanel.setBorder(new EmptyBorder(10,10,10,10));
        rootPanel.setLayout(new BoxLayout(rootPanel,BoxLayout.Y_AXIS));
        rootPanel.setBackground(Constants.windowBg);
        rootPanel.add(LevelPanel);

        add(mainTitle, BorderLayout.PAGE_START);
        add(rootPanel,BorderLayout.CENTER);

        setVisible(true);
    }

}
