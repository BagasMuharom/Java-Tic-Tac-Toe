package Main;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.TextUI;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class About extends JPanel implements MainLayout{

    private JLabel Judul = new JLabel("Tentang");

    private JTextPane isi = new JTextPane();

    private CustomButton Kembali = new CustomButton("Kembali",Constants.warna3,Constants.warna4);

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
        setBackground(Constants.warna2);

        Judul.setHorizontalAlignment(SwingConstants.CENTER);
        Judul.setFont(new Font("Helvetica",20,20));
        Judul.setBorder(new EmptyBorder(0,0,10,0));

        JPanel isiPanel = new JPanel();
        isiPanel.setLayout(new BoxLayout(isiPanel,BoxLayout.X_AXIS));
        isiPanel.setBorder(new EmptyBorder(0,0,10,0));
        isiPanel.setBackground(new Color(0,0,0,0));

        isi.setText("Permainan ini dibuat oleh Bagas Muharom Hanugrah Hidayat. Permainan ini dibuat sebagai tugas akhir mata kuliah Pemrograman Berbasis Objek tahun 2016.");
        isi.setEditable(false);
        isi.setOpaque(true);
        isi.setBorder(new EmptyBorder(10,10,10,10));

        Kembali.setBorder(new EmptyBorder(10,10,10,10));

        isiPanel.add(isi);
        add(Judul, BorderLayout.PAGE_START);
        add(isiPanel,BorderLayout.CENTER);
        add(Kembali,BorderLayout.PAGE_END);
        setVisible(true);
    }

}
