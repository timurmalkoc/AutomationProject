package DBFramework;

import java.time.ZoneId;
import java.sql.*;
import java.text.ParseException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Actor extends Connect{
    ResultSet resultSet;
    Statement statement;
    public void connect() throws SQLException {
        statement = setUp();
    }

    public String addActor(String firstName, String lastName) throws SQLException, ParseException {

        Timestamp ts=new Timestamp(System.currentTimeMillis());
        Date date=new Date(ts.getTime());

        try {
            statement.executeUpdate("INSERT INTO Actor(first_name,last_name,last_update)"+
                    "VALUES(\'" + firstName + "\',\'" + lastName + "\',\'" + date + "\')");
        }catch (SQLException e){
            e.printStackTrace();
        }
        return getId(date);
    }

    public boolean search(String id) throws SQLException {

        resultSet = statement.executeQuery("SELECT * FROM actor WHERE actor_id=\'"+id+"\'");
        id = null;
        while (resultSet.next()){
            System.out.println( resultSet.getString("actor_id")+
                        " | " + resultSet.getString("first_name")+
                        " | " + resultSet.getString("last_name")+
                        " | " + resultSet.getString("last_update"));
            id = resultSet.getString("actor_id");
        }

        if (id==null)
            return false;
        return true;
    }

    public void update(String id, String name) throws SQLException {
        statement.executeUpdate("UPDATE actor SET first_name=\'"+name+"\' WHERE actor_id=\'"+id+"\'");
    }

    public void delete(String id) throws SQLException {
        statement.executeUpdate("DELETE FROM actor WHERE actor_id=\'"+id+"\'");
    }

    public void disconnect() throws SQLException {
        tearDown();
    }

    private String getId(Date date) throws SQLException {

        String id = null;
        resultSet = statement.executeQuery("SELECT * FROM actor WHERE last_update=\'"+date+"\'");
        while (resultSet.next()){
            id = resultSet.getString("actor_id");
        }
        return id;
    }
}
