package Repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.SQLException;

public class DatabaseQuery {
    public static final String CONNECTIONURL = "jdbc:sqlserver://localhost:1433;databaseName=project;user=sa;password=1234567890";
    
    public static ResultSet executeSelect(String selectSQL) throws SQLException{
        try ( Connection connection = DriverManager.getConnection(CONNECTIONURL);  PreparedStatement prepsSelectProduct = connection.prepareStatement(selectSQL);) {
            CachedRowSet cachedResultSet = RowSetProvider.newFactory().createCachedRowSet();
            cachedResultSet.populate(prepsSelectProduct.executeQuery());
            return cachedResultSet;
        } catch (SQLException exception) {
            throw exception;
        }
    }
    
    public static void executeInsert(String insertSQL) throws SQLException{
        try ( Connection connection = DriverManager.getConnection(CONNECTIONURL);  PreparedStatement prepsInsertStatement = connection.prepareStatement(insertSQL);) {
            prepsInsertStatement.execute();
        } catch (SQLException exception) {
            throw exception;
        }
    }
    
    public static void executeUpdate(String updateSQL) throws SQLException{
        try ( Connection connection = DriverManager.getConnection(CONNECTIONURL);  PreparedStatement prepsUpdateStatement = connection.prepareStatement(updateSQL);) {
            prepsUpdateStatement.executeUpdate();
        } catch (SQLException exception) {
            throw exception;
        }
    }
    
    public static void executeDelete(String deleteSQL) throws SQLException{
        try ( Connection connection = DriverManager.getConnection(CONNECTIONURL);  PreparedStatement prepsDeleteStatement = connection.prepareStatement(deleteSQL);) {
            prepsDeleteStatement.execute();
        } catch (SQLException exception) {
            throw exception;
        }
    }
}
