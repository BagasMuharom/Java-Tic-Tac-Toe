package Main;

/**
 * Digunakan untuk template dari setiap frame atau panel dari aplikasi ini
 */
public interface MainLayout {

    /**
     * Berfungsi untuk memberikan actionListener pada button atau objek lain
     */
    void actions();

    /**
     * Berfungsi untuk mengatur tampilan obajek
     */
    void init();

}
