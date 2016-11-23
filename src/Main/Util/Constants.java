package Main.Util;

import Main.Dialog.NewGame;
import Main.TicTacToe;

import java.awt.*;

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
public class Constants {

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
    public static boolean PVP;

    /**
     * Apakah permainan sudah dimulai
     */
    public static boolean GameStart;

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
     * Warna
     */
    public static Color warna1 = new Color(255, 86, 86);
    public static Color warna1Dark = new Color(220, 50, 50);
    public static Color warna2 = new Color(237, 242, 246);
    public static Color warna3 = new Color(106, 126, 252);
    public static Color warna4 = new Color(73,73,83);

}
