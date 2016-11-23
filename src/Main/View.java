package Main;

import javax.swing.JPanel;
import java.awt.*;

public class View extends JPanel{

    private static CardLayout cardLayout = new CardLayout();

    private MainMenu container1 = new MainMenu();
    private Playboard container2 = new Playboard();
    private About container3 = new About();
    private HowToPlay container4 = new HowToPlay();

    public View(){
        setLayout(cardLayout);
        add(container1,"MainMenu");
        add(container2,"Playboard");
        add(container3,"About");
        add(container4,"HowToPlay");
        cardLayout.show(this,"MainMenu");
    }

    public void setView(String id){
        cardLayout.show(this,id);
    }

    public MainMenu getMainMenu(){
        return container1;
    }

    public Playboard getPlayboard(){
        return container2;
    }

}
