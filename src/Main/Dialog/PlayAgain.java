package Main.Dialog;

import Main.UI.CustomButton;
import Main.Util.Constants;
import Main.Layout.MainLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

final public class PlayAgain extends JDialog implements MainLayout {
    private JPanel YesNoPanel = new JPanel();

    private JPanel YesPanel = new JPanel();
    private JPanel NoPanel = new JPanel();

    private CustomButton Yes = new CustomButton("Ya",CustomButton.PRIMARY);
    private CustomButton No = new CustomButton("Tidak",CustomButton.DANGER);

    private JPanel rootPanel = new JPanel();

    /**
     * Judul Utama
     */
    private JLabel mainTitle = new JLabel("Ingin mengulang ?");

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
        Yes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Constants.Controller.clearPlayboard();
                Constants.View.setView("Playboard");
                Constants.View.getPlayboard().setCountdown();
                setVisible(false);
            }
        });
        No.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Constants.View.setView("MainMenu");
                Constants.Controller.clearPlayboard();
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
        setBackground(Constants.windowBg);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(Constants.TicTacToeParentFrame);
        setLayout(new BorderLayout());

        //Main Title
        mainTitle.setHorizontalAlignment(SwingConstants.CENTER);
        mainTitle.setBorder(new EmptyBorder(10,10,10,10));
        mainTitle.setOpaque(true);
        mainTitle.setBackground(Constants.windowBg);
        mainTitle.setFont(new Font("Helvetica",Font.BOLD
        ,16));
        mainTitle.setForeground(Color.WHITE);

        YesPanel.setLayout(new BorderLayout());
        YesPanel.add(Yes,BorderLayout.CENTER);
        YesPanel.setBorder(new EmptyBorder(0,0,10,0));
        YesPanel.setBackground(Constants.windowBg);
        NoPanel.setLayout(new BorderLayout());
        NoPanel.add(No,BorderLayout.CENTER);
        NoPanel.setBackground(Constants.windowBg);

        //Panel
        YesNoPanel.setLayout(new BoxLayout(YesNoPanel,BoxLayout.Y_AXIS));
        YesNoPanel.setBackground(Constants.windowBg);
        YesNoPanel.add(YesPanel);
        YesNoPanel.add(NoPanel);

        //Root panel
        rootPanel.setBorder(new EmptyBorder(10,10,10,10));
        rootPanel.setLayout(new BoxLayout(rootPanel,BoxLayout.Y_AXIS));
        rootPanel.setBackground(Constants.windowBg);
        rootPanel.add(YesNoPanel);

        add(mainTitle, BorderLayout.PAGE_START);
        add(rootPanel,BorderLayout.CENTER);

        setVisible(true);
    }
}
