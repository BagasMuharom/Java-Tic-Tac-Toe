package Main.Menu;

import Main.Util.Constants;
import Main.UI.CustomButton;
import Main.Layout.MainLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

final public class HowToPlay extends JPanel implements MainLayout {

    private JLabel Judul = new JLabel("Cara Bermain");

    private JTextPane isi = new JTextPane();

    private CustomButton Kembali = new CustomButton("Kembali",CustomButton.PRIMARY);

    public HowToPlay(){
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
        Judul.setForeground(Color.WHITE);
        Judul.setOpaque(true);
        Judul.setBackground(Constants.windowBg);

        JPanel isiPanel = new JPanel();
        isiPanel.setLayout(new BoxLayout(isiPanel,BoxLayout.X_AXIS));
        isiPanel.setBorder(new EmptyBorder(0,0,10,0));
        isiPanel.setBackground(Constants.windowBg);

        isi.setText("1) Pertama, pilih menu permainan baru dan pilih mode yang diinginkan"+
                "\r\n2) Nama pemain tidak boleh sama"+
                "\r\n3) Pemain 1 akan mendapat bidak kotak merah dan pemain 2 mendapat bidak lingkaran biru"+
                "\r\n4) Giliran awal akan diacak" +
                "\r\n5) Untuk mode Player vs CPU, maka pemain akan dibatasi oleh waktu, jika waktu habis, maka pemain dianggap kalah"+
                "\r\n6) Cara bermainnya adalah dengan menekan/klik salah satu dari 9 kotak yang ada dimana bidak ingin diletakkan"+
                "\r\n7) Jika bidak anda tersusun sebanyak 3 berturut-turut secara horizontal, verikal, atau diagonal, maka akan dinyatakan menang"+
                "\r\n8) Jika seluruh kotak telah terisi namun tidak ada yang menang, maka permainan dianggap seri");
        isi.setOpaque(false);
        isi.setForeground(Constants.warna2);
        isi.setFont(new Font("Helvetica",Font.PLAIN,15));
        isi.setBorder(new EmptyBorder(10,10,10,10));
        isi.setFocusable(false);
        isi.setBackground(new Color(0,0,0,0));

        isiPanel.add(isi);
        add(Judul, BorderLayout.PAGE_START);
        add(isiPanel,BorderLayout.CENTER);
        add(Kembali,BorderLayout.PAGE_END);
        setVisible(true);
    }

}
