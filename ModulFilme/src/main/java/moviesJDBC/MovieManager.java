package moviesJDBC;

import org.h2.tools.Server;
import java.sql.*;

public class MovieManager {

    public static final String URL = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1";
    public static final String USER = "sa";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        try {
            Server.createWebServer("-webPort", "8082", "-tcpAllowOthers").start();
            System.out.println("Consola H2: http://localhost:8082");

            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {

                createTable(conn);

                addMovie(conn, "The Matrix", "Sci-Fi", 1999);
                addMovie(conn, "Gladiator", "Drama", 2000);
                addMovie(conn, "The Dark Knight", "Action", 2008);
                addMovie(conn, "Inception", "Sci-Fi", 2010);
                addMovie(conn, "Titanic", "Romance", 1997);
                addMovie(conn, "The Godfather", "Crime", 1972);

                System.out.println("\nFILME IN BD");
                showMovies(conn);

                updateGenre(conn, 3, "Action/Drama");

                deleteMovie(conn, 4);

                System.out.println("\nDUPA MODIFICARI");
                showMovies(conn);

                System.out.println("\nDeschide consola H2 in browser");
                System.out.println("JDBC URL: " + URL);
                System.out.println("User: sa (no password)");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createTable(Connection conn) throws SQLException {
        String sql = "CREATE TABLE movies (id INT AUTO_INCREMENT PRIMARY KEY, title VARCHAR(100), genre VARCHAR(50), releaseYear INT)";
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela 'movies' a fost creata.");
        }
    }

    private static void addMovie(Connection conn, String title, String genre, int year) throws SQLException {
        String sql = "INSERT INTO movies (title, genre, releaseYear) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, title);
            ps.setString(2, genre);
            ps.setInt(3, year);
            ps.executeUpdate();
        }
    }

    private static void showMovies(Connection conn) throws SQLException {
        String sql = "SELECT * FROM movies";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " +
                        rs.getString("title") + " | " +
                        rs.getString("genre") + " | " +
                        rs.getInt("releaseYear"));
            }
        }
    }

    private static void updateGenre(Connection conn, int id, String genre) throws SQLException {
        String sql = "UPDATE movies SET genre = ? WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, genre);
            ps.setInt(2, id);
            ps.executeUpdate();
        }
    }

    private static void deleteMovie(Connection conn, int id) throws SQLException {
        String sql = "DELETE FROM movies WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
