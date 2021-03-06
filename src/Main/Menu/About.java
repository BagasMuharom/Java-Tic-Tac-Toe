package Main.Menu;

import Main.Util.Constants;
import Main.UI.CustomButton;
import Main.Layout.MainLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.TextUI;
import javax.swing.text.EditorKit;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

final public class About extends JPanel implements MainLayout {

    private JLabel Judul = new JLabel("Tentang");

    private JTextPane isi = new JTextPane();

    private CustomButton Kembali = new CustomButton("Kembali",CustomButton.PRIMARY);

    public About(){
        init();
        actions();
    }

    @Override
    public void actions() {
        Kembali.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                Constants.View.setView("MainMenu");
            }
        });
    }

    @Override
    public void init(){
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(20,20,20,20));
        setBackground(Constants.windowBg);

        Judul.setHorizontalAlignment(SwingConstants.CENTER);
        Judul.setFont(new Font("Helvetica",20,20));
        Judul.setBorder(new EmptyBorder(0,0,10,0));
        Judul.setForeground(Constants.warna2);

        JPanel isiPanel = new JPanel();
        isiPanel.setLayout(new BoxLayout(isiPanel,BoxLayout.X_AXIS));
        isiPanel.setBorder(new EmptyBorder(0,0,10,0));
        isiPanel.setBackground(Constants.windowBg);

        isi.setText("Permainan ini dibuat oleh Bagas Muharom Hanugrah Hidayat. Permainan ini dibuat sebagai tugas akhir mata kuliah Pemrograman Berbasis Objek tahun 2016.");
        isi.setOpaque(false);
        isi.setForeground(Constants.warna2);
        isi.setFont(new Font("Helvetica",Font.PLAIN,15));
        isi.setBorder(new EmptyBorder(10,10,10,10));
        isi.setFocusable(false);
        isi.setBackground(new Color(0,0,0,0));

        Kembali.setBorder(new EmptyBorder(10,10,10,10));

        isiPanel.add(isi);
        add(Judul, BorderLayout.PAGE_START);
        add(isiPanel,BorderLayout.CENTER);
        add(Kembali,BorderLayout.PAGE_END);
        setVisible(true);
    }

}
