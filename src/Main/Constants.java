package Main;

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
    static TicTacToe Frame;

    /**
     * Alamat Frame utama dari TicTacToe.java namun digunakan
     * sebagai parent Window dari sebuah JDialog
     */
    static Frame TicTacToeParentFrame;

    /**
     * Alamat dari Class View
     */
    static View View;

    /**
     * Alamat dari Class Controller
     */
    static Controller Controller;

    /**
     *
     */
    static NewGame NewGameFrame;

    /**
     * Jenis atau Tipe Permainan
     */
    static boolean PVP;

    /**
     * Apakah permainan sudah dimulai
     */
    static boolean GameStart;

    /**
     * Nama Player
     */
    static String Player1Name;
    static String Player2Name;

    /**
     * Jenis level permainan yang dipilih
     */
    static byte GameLevel;

    /**
     * Warna
     */
    static Color warna1 = new Color(255, 86, 86);
    static Color warna2 = new Color(237, 242, 246);
    static Color warna3 = new Color(106, 126, 252);
    static Color warna4 = new Color(73,73,83);

}
