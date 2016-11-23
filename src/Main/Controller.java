package Main;

import javax.swing.*;

public class Controller {

    public void newGameDialog(){
        /*
         * Menampilkan JDialog agar user dapat memilih mode antara Player VS Player
         * atau Player VS CPU
         */
        NewGame newGame = new NewGame();

        /*
         * Jika User memulai permainan
         */
        if(Constants.GameStart){
            Constants.View.setView("Playboard");
            Constants.View.getPlayboard().getPlayer1().setText(Constants.Player1Name);
            Constants.View.getPlayboard().getPlayer2().setText(Constants.Player2Name);
        }
    }
    
    public void InputNama(JDialog parent, boolean PVP){
        Constants.Player1Name = JOptionPane.showInputDialog("Nama Player 1");
        //Jika klik OK
        if(Constants.Player1Name != null){
            //Jika ada isiya
            if(Constants.Player1Name.length()>0){
                if(PVP) {
                    Constants.Player2Name = JOptionPane.showInputDialog("Nama Player 2");
                    //Jika klik OK
                    if (Constants.Player2Name != null) {
                        //Jika tidak ada isiya
                        if (Constants.Player2Name.length() > 1) {
                            Constants.GameStart = true;
                            Constants.PVP = true;
                            parent.setVisible(false);
                        } else {
                            while (Constants.Player2Name.length() <= 0 || Constants.Player2Name == null) {
                                Constants.Player2Name = JOptionPane.showInputDialog("Nama Player 2");
                            }
                        }
                    }
                }
                else{
                    Constants.GameStart = true;
                    Constants.PVP = false;
                    Constants.Player2Name = "CPU";
                    parent.setVisible(false);
                    Constants.NewGameFrame.setVisible(false);
                }
            }
            else {
                while (Constants.Player1Name.length() <=0 || Constants.Player1Name == null){
                    Constants.Player1Name = JOptionPane.showInputDialog("Nama Player 1");
                }
            }
        }
    }

    public void SelectLevel() {
        SelectLevel pilihLevel = new SelectLevel();
    }

    public void destroyGame() {
        Constants.GameStart = false;
        Constants.View.setView("MainMenu");
    }

}
