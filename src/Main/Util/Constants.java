package Main.Util;

import Main.Dialog.NewGame;
import Main.TicTacToe;
import java.awt.*;
import javax.swing.Timer;


/**
 * Class ini berfungsi untuk menyimpan alamat dari sebuah Objek
 * yang akan digunakan bersama-sama dalam aplikasi
 *
 * Kenapa harus seperti itu ?
 * Hal ini agar kita tidak perlu mengoper alamat Objek ke setiap Class
 * yang kita buat
 *
 * Kenapa Static ?
 * Agar kita tidak perlu menggunakan notasi "new"
 */
final public class Constants {

    /**
     * Alamat Frame utama dari TicTacToe.java
     */
    public static TicTacToe Frame;

    /**
     * Alamat Frame utama dari TicTacToe.java namun digunakan
     * sebagai parent Window dari sebuah JDialog
     */
    public static Frame TicTacToeParentFrame;

    /**
     * Alamat dari Class View
     */
    public static Main.Bootstrap.View View;

    /**
     * Alamat dari Class Controller
     */
    public static Main.Bootstrap.Controller Controller;

    /**
     *
     */
    public static NewGame NewGameFrame;

    /**
     * Jenis atau Tipe Permainan
     */
    public static boolean PVPGame;

    /**
     * Class PVP dan PVE
     */
    public final static PVP PVP = new PVP();
    public final static PVE PVE = new PVE();

    /**
     * Apakah permainan sudah dimulai
     */
    public static boolean GameStart;

    /**
     * Untuk menyimpan array dari playboard
     */
    public static byte arrayBoard[][] = new byte[3][3];

    /**
     * Last tile clicked
     */
    public static byte lastTileCol;
    public static byte lastTileRow;

    /**
     * Untuk mengatur apakah saat ini giliran player 1
     */

    /**
     * Countdown
     */
    public static Timer timer;

    public static boolean turnPlayer1;

    /**
     * Game Selesai
     */
    public static boolean GameEnd = false;

    /**
     * AI
     */
    public static PVE AI;

    /**
     * Game Time
     */
    public static int PVETime;

    /**
     * Nama Player
     */
    public static String Player1Name;
    public static String Player2Name;

    /**
     * Jenis level permainan yang dipilih
     */
    public static byte GameLevel;

    /**
     * Icon
     */
    public static String iconPlayer1 = "../../Resources/squaremd.png";
    public static String iconPlayer2 = "../../Resources/circlemd.png";

    /**
     * Warna
     */
    public final static Color warna1 = new Color(255, 86, 86);
    public final static Color warna2 = new Color(237, 242, 246);
    public final static Color warna3 = new Color(106, 126, 252);
    public final static Color warna4 = new Color(73,73,83);

    /**
     * Custom Button UI
     */
    public static final Color buttonBgPrimary = warna3;
    public static final Color buttonBgPrimaryHover = new Color(warna3.getRed()-20,warna3.getGreen()-20,warna3.getBlue()-20);
    public static final Color buttonBgDanger = warna1;
    public static final Color buttonBgDangerHover = new Color(warna1.getRed()-20,warna1.getGreen()-20,warna1.getBlue()-20);

    /**
     * Background
     */
    public static final Color windowBg = warna4;


    /**
     * Jika ada pemain yang menang
     */
    public static String winner;

}
