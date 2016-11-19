package Main;

public class Controller {

    public void newGameDialog(){
        /*
         * Menampilkan JDialog agar user dapat memilih mode antara Player VS Player
         * atau Player VS CPU
         */
        NewGame newGame = new NewGame();
        /*
         * Jika User memilih antara PVP atau PVE
         */
        if(newGame.isGameStart()){
            setNewGame(newGame.getPlayer1(),newGame.getPlayer2());
        }
    }

    public void setNewGame(String player1, String player2){
        Constants.View.getPlayboard().getPlayer1().setText(player1);
        Constants.View.getPlayboard().getPlayer2().setText(player2);
        Constants.View.getPlayboard().getGiliran().setText("Giliran");
        Constants.View.setView("Playboard");
    }

}
