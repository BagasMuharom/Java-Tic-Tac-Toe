package Main;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class About extends JPanel implements MainLayout{

    private JLabel Judul = new JLabel("Tentang");

    private JButton Kembali = new JButton("Kembali");

    public About(){
        init();
        actions();
    }

    @Override
    public void actions() {
        Kembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Constants.View.setView("MainMenu");
            }
        });
    }

    @Override
    public void init(){
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        add(Judul);
        add(Kembali);
        setVisible(true);
    }

}
