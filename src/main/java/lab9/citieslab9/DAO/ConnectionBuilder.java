package lab9.citieslab9.DAO;

import java.sql.Connection;
import java.sql.SQLException;


public interface ConnectionBuilder {
    Connection getConnection() throws SQLException;
}