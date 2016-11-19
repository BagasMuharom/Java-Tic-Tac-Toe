package Main;

import java.awt.Frame;

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

}
