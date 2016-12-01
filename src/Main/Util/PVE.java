package Main.Util;


import java.util.Random;

/**
 * Ini merupakan class untuk PVE alias Artificial Intelligence
 * Algoritma yang digunakan masih cukup panjang
 */
public class PVE {

    public void start(){
        Constants.turnPlayer1 = false;
        computerWillWin();
        Constants.turnPlayer1 = true;
    }

    public void computerWillWin(){
        boolean selesai = false;
        for(int i=0;i<3;i++){
            int jumO = 0;
            int jumX = 0;
            int emptyPos = 0;
            // Cek Baris
            for(int j=0;j<3;j++){
                // Jika menemukan 2 dalam kasus ini 2, maka jumO akan ditambah
                if(Constants.arrayBoard[i][j]==2)
                    jumO++;
                    // Jika menemukan 1, maka jumX akan ditambah
                else if(Constants.arrayBoard[i][j]==1)
                    jumX++;
                    // Jika menemukan Constants.arrayBoard kosong, maka simpan posisinya ke emptyPos
                else
                    emptyPos = j;
            }
            if(jumO==2 && jumX==0){
                // Jika komputer akan menang, maka letakkan 2 sesuai posisi
                Constants.arrayBoard[i][emptyPos] = 2;
                // Giliran ditandai selesai
                selesai = true;
                break;
            }
        }
        //Jika belum selesai, cek per kolom
        if(!selesai){
            for(int i=0;i<3;i++){
                int jumO = 0;
                int jumX = 0;
                int emptyPos = 0;
                // Cek Baris
                for(int j=0;j<3;j++){
                    // Jika menemukan 2, maka jumO akan ditambah
                    if(Constants.arrayBoard[j][i]==2)
                        jumO++;
                        // Jika menemukan 1, maka jumX akan ditambah
                    else if(Constants.arrayBoard[j][i]==1)
                        jumX++;
                        // Jika menemukan Constants.arrayBoard kosong, maka simpan posisinya ke emptyPos
                    else
                        emptyPos = j;
                }
                if(jumO==2 && jumX==0){
                    // Jika komputer akan menang, maka letakkan 2 sesuai posisi
                    Constants.arrayBoard[emptyPos][i] = 2;
                    // Giliran ditandai selesai
                    selesai = true;
                    break;
                }

            }
            if(!selesai){
                //Jika belum selesai, cek diagonal
                // Pemeriksaan Diagonal kiri atas ke kanan bawah
                int jumO = 0;
                int jumX = 0;
                int emptyPos = 0;
                for(int i=0;i<3;i++){
                    if(Constants.arrayBoard[i][i]==2)
                        jumO++;
                    else if(Constants.arrayBoard[i][i]==1)
                        jumX++;
                    else
                        emptyPos = i;
                }
                if(jumO==2 && jumX==0){
                    selesai = true;
                    Constants.arrayBoard[emptyPos][emptyPos] = 2;
                }
                if(!selesai){
                    //Jika belum selesai, cek diagonal
                    // Pemeriksaan Diagonal kiri atas ke kanan bawah
                    jumO = 0;
                    jumX = 0;
                    int emptyCol = 0;
                    int emptyRow = 0;
                    int column = 0;
                    for(int i=2;i>=0;i--){
                        if(Constants.arrayBoard[i][column]==2)
                            jumO++;
                        else if(Constants.arrayBoard[i][column]==1)
                            jumX++;
                        else{
                            emptyRow = i;
                            emptyCol = column;
                        }
                        column++;
                    }
                    if(jumO==2 && jumX==0){
                        selesai = true;
                        Constants.arrayBoard[emptyRow][emptyCol] = 2;
                    }
                }
            }
        }
        // Jika giliran selesai
        if(!selesai){
            playerWillWin();
        }
    }

    public void playerWillWin(){
        boolean selesai = false;
        for(int i=0;i<3;i++){
            int jumO = 0;
            int jumX = 0;
            int emptyPos = 0;
            // Cek Baris
            for(int j=0;j<3;j++){
                // Jika menemukan 2, maka jumO akan ditambah
                if(Constants.arrayBoard[i][j]==2)
                    jumO++;
                    // Jika menemukan 1, maka jumX akan ditambah
                else if(Constants.arrayBoard[i][j]==1)
                    jumX++;
                    // Jika menemukan Constants.arrayBoard kosong, maka simpan posisinya ke emptyPos
                else
                    emptyPos = j;
            }
            if(jumX==2 && jumO==0){
                Constants.arrayBoard[i][emptyPos] = 2;
                selesai = true;
                break;
            }
        }
        //Jika belum selesai, cek per kolom
        if(!selesai){
            for(int i=0;i<3;i++){
                int jumO = 0;
                int jumX = 0;
                int emptyPos = 0;
                // Cek Baris
                for(int j=0;j<3;j++){
                    // Jika menemukan 2, maka jumO akan ditambah
                    if(Constants.arrayBoard[j][i]==2)
                        jumO++;
                        // Jika menemukan 1, maka jumX akan ditambah
                    else if(Constants.arrayBoard[j][i]==1)
                        jumX++;
                        // Jika menemukan Constants.arrayBoard kosong, maka simpan posisinya ke emptyPos
                    else
                        emptyPos = j;
                }
                if(jumX==2 && jumO==0){
                    Constants.arrayBoard[emptyPos][i] = 2;
                    selesai = true;
                    break;
                }

            }
            if(!selesai){
                //Jika belum selesai, cek diagonal
                // Pemeriksaan Diagonal kiri atas ke kanan bawah
                int jumO = 0;
                int jumX = 0;
                int emptyPos = 0;
                for(int i=0;i<3;i++){
                    if(Constants.arrayBoard[i][i]==2)
                        jumO++;
                    else if(Constants.arrayBoard[i][i]==1)
                        jumX++;
                    else
                        emptyPos = i;
                }
                if(jumO==0 && jumX==2){
                    selesai = true;
                    Constants.arrayBoard[emptyPos][emptyPos] = 2;
                }
                if(!selesai){
                    //Jika belum selesai, cek diagonal
                    // Pemeriksaan Diagonal kiri atas ke kanan bawah
                    jumO = 0;
                    jumX = 0;
                    int emptyCol = 0;
                    int emptyRow = 0;
                    int column = 0;
                    for(int i=2;i>=0;i--){
                        if(Constants.arrayBoard[i][column]==2)
                            jumO++;
                        else if(Constants.arrayBoard[i][column]==1)
                            jumX++;
                        else{
                            emptyRow = i;
                            emptyCol = column;
                        }
                        column++;
                    }
                    if(jumO==0 && jumX==2){
                        selesai = true;
                        Constants.arrayBoard[emptyRow][emptyCol] = 2;
                    }
                }
            }
        }
        // Jika giliran selesai
        if(!selesai){
            basicStrategy();
        }
    }

    public void basicStrategy(){
        Random randomGenerator = new Random();
        boolean selesai = false;
        // Cek baris
        for(int i=0;i<3;i++){
            int jumO = 0;
            int jumX = 0;
            int j = 0;
            int posO = 0;
            while(j<3){
                if(Constants.arrayBoard[i][j]==2){
                    jumO++;
                    posO = j;
                }
                else if(Constants.arrayBoard[i][j]==1)
                    jumX++;
                j++;
            }
            if(jumO==1 && jumX==0){
                if(posO==1){
                    int random = randomGenerator.nextInt(2);
                    if(random==0)
                        Constants.arrayBoard[i][posO-1] = 2;
                    else
                        Constants.arrayBoard[i][posO+1] = 2;
                }
                else{
                    int counter = (randomGenerator.nextInt(2))+1;
                    if(posO==0)
                        Constants.arrayBoard[i][posO+counter] = 2;
                    else if(posO==2)
                        Constants.arrayBoard[i][posO-counter] = 2;
                }
                selesai = true;
                break;
            }
        }
        // Cek kolom
        if(!selesai){
            for(int i=0;i<3;i++){
                int jumO = 0;
                int jumX = 0;
                int j = 0;
                int posO=0;
                while(j<3){
                    if(Constants.arrayBoard[j][i]==2){
                        jumO++;
                        posO = j;
                    }
                    else if(Constants.arrayBoard[j][i]==1)
                        jumX++;
                    j++;
                }
                if(jumO==1 && jumX==0){
                    if(posO==1){
                        int random = randomGenerator.nextInt(2);
                        if(random==0)
                            Constants.arrayBoard[posO-1][i] = 2;
                        else
                            Constants.arrayBoard[posO+1][i] = 2;
                    }
                    else{
                        int counter = (randomGenerator.nextInt(2))+1;
                        if(posO==0)
                            Constants.arrayBoard[posO+counter][i] = 2;
                        else if(posO==2)
                            Constants.arrayBoard[posO-counter][i] = 2;
                    }
                    selesai = true;
                    break;
                }
            }
            if(!selesai){
                int rbaris = randomGenerator.nextInt(3);
                int rkolom = randomGenerator.nextInt(3);
                int baris = (int) Constants.lastTileRow;
                int kolom = (int) Constants.lastTileCol;
                int mencoba = 0;
                boolean isi = false;
                while(!isi){
                    mencoba++;
                    if(Constants.arrayBoard[1][1]!=1 && Constants.arrayBoard[1][1]!=2){
                        Constants.arrayBoard[1][1]=2;
                        selesai = true;
                        break;
                    }
                    if( ((rbaris==(baris-1) || rbaris==(baris+1)) && (rkolom!=(kolom-2) || rkolom!=(kolom+2))) ||
                            ((rbaris!=(baris-2) || rbaris==(baris+2)) && (rkolom==(kolom-1) || rkolom==(kolom+1)))
                            ){
                        if(Constants.arrayBoard[rbaris][rkolom]!=1 && Constants.arrayBoard[rbaris][rkolom]!=2){
                            Constants.arrayBoard[rbaris][rkolom] = 2;
                            selesai = true;
                            break;
                        }
                        else{
                            if(mencoba==8){
                                searchEmpty();
                                break;
                            }
                            rbaris = randomGenerator.nextInt(3);
                            rkolom = randomGenerator.nextInt(3);
                        }
                    }
                    else{
                        if(mencoba==8){
                            searchEmpty();
                            break;
                        }
                        rbaris = randomGenerator.nextInt(3);
                        rkolom = randomGenerator.nextInt(3);
                    }
                }
            }
        }
    }

    public void searchEmpty(){
        Random random = new Random();
        int rbaris = random.nextInt(3);
        int rkolom = random.nextInt(3);
        boolean isi = false;
        while(!isi){
            if(Constants.arrayBoard[rbaris][rkolom]!=1 && Constants.arrayBoard[rbaris][rkolom]!=2){
                Constants.arrayBoard[rbaris][rkolom] = 2;
                isi = true;
                break;
            }
            else{
                rbaris = random.nextInt(3);
                rkolom = random.nextInt(3);
            }
        }
    }

}
