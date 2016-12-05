package Main.Bootstrap;

import Main.Dialog.PlayAgain;
import Main.Util.Constants;
import Main.Dialog.NewGame;
import Main.Dialog.SelectLevel;
import Main.Util.GameHandler;

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
            Constants.View.getPlayboard().renderPlayboard();
            Constants.View.getPlayboard().getTurnPlayerName().setText(Constants.Player1Name);
            if(!Constants.PVPGame)
                Constants.View.getPlayboard().setPVEGame();
            else
                Constants.View.getPlayboard().hapusWaktu();
            Constants.turnPlayer1 = true;
            Constants.View.getPlayboard().getPlayer1().setText(Constants.Player1Name);
            Constants.View.getPlayboard().getPlayer2().setText(Constants.Player2Name);
        }
    }
    
    public void InputNama(JDialog parent, boolean PVP){
        Constants.Player1Name = JOptionPane.showInputDialog(Constants.TicTacToeParentFrame,"Nama Player 1");
        //Jika klik OK
        if(Constants.Player1Name != null){
            //Jika ada isinya
            if(Constants.Player1Name.length()>0){
                if(PVP) {
                    Constants.Player2Name = JOptionPane.showInputDialog(Constants.TicTacToeParentFrame,"Nama Player 2");
                    //Jika klik OK
                    if (Constants.Player2Name != null) {
                        //Jika tidak ada isinya
                        if (Constants.Player2Name.length() > 1) {
                            Constants.GameStart = true;
                            Constants.PVPGame = true;
                            parent.setVisible(false);
                        } else {
                            while (Constants.Player2Name.length() <= 0 || Constants.Player2Name == null) {
                                Constants.Player2Name = JOptionPane.showInputDialog(Constants.TicTacToeParentFrame,"Nama Player 2");
                            }
                                Constants.GameStart = true;
                                Constants.PVPGame = true;
                                parent.setVisible(false);
                        }
                    }
                }
                else{
                    Constants.GameStart = true;
                    Constants.PVPGame = false;
                    Constants.Player2Name = "CPU";
                    parent.setVisible(false);
                    Constants.NewGameFrame.setVisible(false);
                }
            }
            else {
                while (Constants.Player1Name.length() <=0 || Constants.Player1Name == null){
                    Constants.Player1Name = JOptionPane.showInputDialog(Constants.TicTacToeParentFrame,"Nama Player 1");
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

    public void tileClicked(int target){
        int row,col;
        //Mengonversi posisi indeks
        if(target<=8 && target>=6){
            target = target - 4;
            row = 2;
        }
        else if(target<=5 && target>=3){
            target = target - 2;
            row = 1;
        }
        else{
            row = 0;
        }
        col = target - row;

        Constants.lastTileCol = (byte) col;
        Constants.lastTileRow = (byte) row;

        // Mengecek apakah baris dan kolom sudah ada isi sebelumnya
        if(Constants.arrayBoard[row][col]==0){
            /**
             * Jika permainan adalah player vs player
             * maka akan meletakkan bidak sesuai giliran
             */
            if(Constants.PVPGame){
                PVPStart((byte) row,(byte) col);
            }
            else{
                PVEStart((byte) row,(byte) col);
            }
            Constants.View.getPlayboard().renderPlayboard();
        }
    }

    private void PVPStart(byte row, byte col){
        Constants.PVP.playRundown(row,col);
        Constants.View.getPlayboard().renderPlayboard();
        if(GameHandler.winCheck()){
            Constants.GameEnd = true;
            JOptionPane.showMessageDialog(Constants.TicTacToeParentFrame,Constants.winner+" Menang");
            PlayAgain playAgain = new PlayAgain();
        }
        else{
            if(GameHandler.drawCheck()){
                Constants.GameEnd = true;
                JOptionPane.showMessageDialog(Constants.TicTacToeParentFrame,"Permainan seri !");
                PlayAgain playAgain = new PlayAgain();
            }
        }
    }

    private void PVEStart(byte row, byte col) {
        Constants.arrayBoard[row][col] = 1;
        Constants.View.getPlayboard().renderPlayboard();
        if(!GameHandler.drawCheck()){
            Constants.PVE.start();
            Constants.View.getPlayboard().renderPlayboard();
            if(GameHandler.winCheck()){
                Constants.timer.stop();
                Constants.GameEnd = true;
                JOptionPane.showMessageDialog(Constants.TicTacToeParentFrame,Constants.winner + " Menang !");
                PlayAgain playAgain = new PlayAgain();
            }
        }
        else {
            Constants.timer.stop();
            JOptionPane.showMessageDialog(Constants.TicTacToeParentFrame, "Permainan seri !");
            PlayAgain playAgain = new PlayAgain();
        }
    }

    public void clearPlayboard(){
        for(byte i=0;i<3;i++){
            for(byte j=0;j<3;j++){
                Constants.arrayBoard[i][j] = 0;
            }
        }
        Constants.View.getPlayboard().renderPlayboard();
    }

}
