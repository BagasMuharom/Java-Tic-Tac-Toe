package Main;
import javax.swing.*;

public class PermainanBaru extends JDialog{
    
    private JLabel mainTitle = new JLabel();
    
    public PermainanBaru(){
        setTitle("Permainan Baru");
        init();
    }

    private void init(){
        setSize(200,200);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        mainTitle.setText("Permainan Baru");
        add(mainTitle);
        setVisible(true);
    }
    
}
