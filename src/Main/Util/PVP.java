package Main.Util;

public class PVP {

    public void playRundown(byte row, byte col){
        if(Constants.turnPlayer1)
            Constants.arrayBoard[row][col] = 1;
        else
            Constants.arrayBoard[row][col] = 2;
        Constants.turnPlayer1 = !Constants.turnPlayer1;
    }

}
