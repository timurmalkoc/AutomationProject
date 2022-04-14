package DBTest;

import DBFramework.Examples;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class DBTest extends Examples {

    // Basics -----
    @Test
    public void listingMovies() throws SQLException {
        listMovies("Drama","180");
    }

    @Test
    public void getActorMovies() throws SQLException {
        getActorMovies("100");
    }

    @Test
    public void wildCart() throws SQLException {
        customer();
    }

    @Test
    public void subQuery() throws SQLException {
        actorNumberOfMovie(35);
    }

    @Test
    public void grouping() throws SQLException {
        groupByRating();
    }
}
