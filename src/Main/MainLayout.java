package Main;

/**
 * Digunakan untuk template dari setiap frame atau panel dari aplikasi ini
 */
public interface MainLayout {

    /**
     * Berfungsi untuk memberikan ActionListener pada objek Swing
     */
    void actions();

    /**
     * Berfungsi untuk mengatur tampilan objek Swing
     */
    void init();

}
