package controller;

import model.List;
import model.Task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DataConnector {
    // JDBC driver name and database URL
    private String jdbcDriver;
    private String url;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private Connection connect;
    private Statement statement;

    //  Database credentials
    private String user;
    private String pass;

    public DataConnector(){
        this.jdbcDriver = "org.h2.Driver";
        this.url = "jdbc:h2:./data/test";
        this.user = "sa";
        this.pass = "";
    }
    public List readData() throws SQLException, ClassNotFoundException {
        List list = new List();
        Class.forName(jdbcDriver);
        System.out.println("Connecting to database...");
        connect = DriverManager.getConnection(url,user, pass);
        System.out.println("Connected database successfully...");
        statement = connect.createStatement();
        String sql = "SELECT * FROM TodoList";
        resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            Task task = new Task(resultSet.getString("content"), resultSet.getString("state"));
            list.add(task);
        }
        resultSet.close();
        return list;
    }

    public void writeData(List list) throws SQLException, ClassNotFoundException {
        Class.forName(jdbcDriver);
        System.out.println("Connecting to database...");
        connect = DriverManager.getConnection(url, user, pass);
        System.out.println("Connected database successfully...");
        String sql = "DELETE FROM TodoList";
        preparedStatement = connect.prepareStatement(sql);
        preparedStatement.executeUpdate();
        for (Task task : list) {
            sql = "INSERT INTO TodoList (content, state) " + "VALUES(\'" + task.getContent() + "\', \'" + task.getState() + "\')";
            System.out.println(sql);
            preparedStatement = connect.prepareStatement(sql);
            preparedStatement.executeUpdate();
        }
    }
}
