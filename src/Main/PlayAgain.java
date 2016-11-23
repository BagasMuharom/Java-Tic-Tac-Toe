package Main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Bagas Angga on 20/11/2016.
 */
public class PlayAgain extends JDialog implements MainLayout{
    private JPanel YesNoPanel = new JPanel();

    private JPanel YesPanel = new JPanel();
    private JPanel NoPanel = new JPanel();

    private JButton Yes = new JButton("Ya");
    private JButton No = new JButton("Tidak");

    private JPanel rootPanel = new JPanel();

    /**
     * Judul Utama
     */
    private JLabel mainTitle = new JLabel("Apa anda ingin mengulang ?");

    /**
     * Konstruktor override untuk JDialog
     * Digunakan untuk melakukan inisialisasi JDialog
     */
    public PlayAgain(){
        super(Constants.TicTacToeParentFrame,true);
        setTitle("Permainan Baru");
        actions();
        init();
    }

    public void actions(){
        Yes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Constants.View.setView("Playboard");
                setVisible(false);
            }
        });
        No.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Constants.View.setView("MainMenu");
                Constants.GameStart = false;
                setVisible(false);
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

        YesPanel.setLayout(new BorderLayout());
        YesPanel.add(Yes,BorderLayout.CENTER);
        NoPanel.setLayout(new BorderLayout());
        NoPanel.add(No,BorderLayout.CENTER);

        //Panel
        YesNoPanel.setLayout(new BoxLayout(YesNoPanel,BoxLayout.Y_AXIS));
        YesNoPanel.add(YesPanel);
        YesNoPanel.add(NoPanel);

        //Root panel
        rootPanel.setBorder(new EmptyBorder(10,10,10,10));
        rootPanel.setLayout(new BoxLayout(rootPanel,BoxLayout.Y_AXIS));
        rootPanel.add(YesNoPanel);

        add(mainTitle, BorderLayout.PAGE_START);
        add(new JPanel(),BorderLayout.LINE_START);
        add(new JPanel(),BorderLayout.LINE_END);
        add(rootPanel,BorderLayout.CENTER);

        setVisible(true);
    }
}
