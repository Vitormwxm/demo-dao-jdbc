package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DB {

    private static Connection conn = null;

    // iniciando uma conexão
    public static Connection getConnection() {
        if (conn == null) {
            try {
                Properties props = loadProperties();

                String url = props.getProperty("dburl");

                conn = DriverManager.getConnection(url, props);

            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }

        return conn;
    }

    // fechando conexão
    public static void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
                conn = null;
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }
    // carrega nossos arquivos de propriedades
    private static Properties loadProperties() {
        try (FileInputStream fs = new FileInputStream("db.properties")) {

            Properties props = new Properties();
            props.load(fs);

            return props;

        } catch (IOException e) {
            throw new DbException(e.getMessage());
        }
    }

    public static void statementClose(Statement statement)  {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }


    public static void connectionClose(Connection conn)  {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }


    public static void resultSetClose(ResultSet ResultSet)  {
        if (ResultSet != null) {
            try {
                ResultSet.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }
}
