package Main.Util;

public class GameHandler {

    /**
     * Mengecek apakah setelah selesai turn dari salah satu pemain terdapat
     * pemain yang memenangkan permainan
     * @return
     */
    public static boolean winCheck(){
        for(byte i=0;i<3;i++){
            if(Constants.arrayBoard[i][0]==Constants.arrayBoard[i][1]  &&  Constants.arrayBoard[i][0]==Constants.arrayBoard[i][2] && (Constants.arrayBoard[i][0]==1 || Constants.arrayBoard[i][0]==2)){
                Constants.winner = Constants.arrayBoard[i][0]==1 ? Constants.Player1Name : Constants.Player2Name;
                return true;
            }
        }
        for(byte i=0;i<3;i++){
            if(Constants.arrayBoard[0][i]==Constants.arrayBoard[1][i] &&  Constants.arrayBoard[0][i]==Constants.arrayBoard[2][i] && (Constants.arrayBoard[0][i]==1 || Constants.arrayBoard[0][i]==2)){
                Constants.winner = Constants.arrayBoard[0][i]==1 ? Constants.Player1Name : Constants.Player2Name;
                return true;
            }
        }
        // Pengecekan diagonal
        if(Constants.arrayBoard[0][0]==Constants.arrayBoard[1][1] && Constants.arrayBoard[0][0]==Constants.arrayBoard[2][2] && (Constants.arrayBoard[0][0]==1 || Constants.arrayBoard[0][0]==2)){
            Constants.winner = Constants.arrayBoard[0][0]==1 ? Constants.Player1Name : Constants.Player2Name;
            return true;
        }
        if(Constants.arrayBoard[0][2]==Constants.arrayBoard[1][1] && Constants.arrayBoard[0][2]==Constants.arrayBoard[2][0] && (Constants.arrayBoard[0][2]==1 || Constants.arrayBoard[0][2]==2)){
            Constants.winner = Constants.arrayBoard[0][2]==1 ? Constants.Player1Name : Constants.Player2Name;
            return true;
        }
        return false;
    }

    /**
     * Mengecek apakah permainan berakhir dengan seimbang
     */
    public static boolean drawCheck(){
        for(byte i=0;i<3;i++){
            for(byte j=0;j<3;j++){
                if(Constants.arrayBoard[i][j]==0){
                    return false;
                }
            }
        }
        return true;
    }

}
