package DBFramework;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Examples extends Connect{
    Statement statement;
    ResultSet resultSet;
    @BeforeClass
    public void connect() throws SQLException {
        statement = setUp();
    }

    public void listMovies(String title, String length) throws SQLException {
        // alignment
        String leftAlignFormat = "| %-25s | %-6s | %-5s | %-5s |\n";

    resultSet = statement.executeQuery("SELECT * FROM film WHERE description LIKE '%"+title+"%' " +
            "AND length>'"+length+"' AND rating='PG'");

            System.out.format("|----------------- List Movies Results ------------------|%n");
            System.out.format("|--------------------------------------------------------|%n");
        while (resultSet.next()){
            System.out.print("\033[31m");   // Red
            System.out.printf(leftAlignFormat,  resultSet.getString("title"),
                                                resultSet.getString("release_year"),
                                                resultSet.getString("length"),
                                                resultSet.getString("rental_rate"));
            System.out.print("\033[0m");    // Red
        }
        System.out.format("|--------------------------------------------------------|%n");
    }


    public void getActorMovies(String id) throws SQLException {
        String leftAlignFormat = "| %-25s | %-6s | %-6s |\n";

        resultSet = statement.executeQuery("SELECT title, rating, release_year FROM film " +
                "INNER JOIN film_actor ON film.film_id=film_actor.film_id " +
                "WHERE actor_id=\'"+id+"\'");

        while (resultSet.next()){
            System.out.print("\033[31m");   // Red
            System.out.printf(leftAlignFormat,  resultSet.getString("title"),
                    resultSet.getString("rating"),
                    resultSet.getString("release_year"));
            System.out.print("\033[0m");    // Red
        }
    }


    @AfterClass
    public void disconnect() throws SQLException {
        tearDown();
    }
}
