package Main;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
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
public class SelectLevel extends JDialog implements MainLayout{

    private JPanel LevelPanel = new JPanel();

    private JPanel EasyPanel = new JPanel();
    private JPanel MediumPanel = new JPanel();
    private JPanel HardPanel = new JPanel();

    private JButton Easy = new JButton("Easy");
    private JButton Medium = new JButton("Medium");
    private JButton Hard = new JButton("Hard");

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
        Easy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Constants.GameLevel = 1;
                Constants.Controller.InputNama(selectLevel,false);
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

        EasyPanel.setLayout(new BorderLayout());
        EasyPanel.add(Easy,BorderLayout.CENTER);
        MediumPanel.setLayout(new BorderLayout());
        MediumPanel.add(Medium,BorderLayout.CENTER);
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
