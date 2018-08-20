package dao;


import dto.JoinDto;
import model.Emploee;
import service.Builder;
import service.DbConnection;
import service.Queries;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmploeeDao {
    private DbConnection dbConnection = new DbConnection();

    public void addEmploee(Emploee emploee) throws SQLException {
        java.sql.Date date = new java.sql.Date( emploee.getBirthDate().getTime() );
        PreparedStatement statement = dbConnection.getConnection().prepareStatement( Queries.ADD_EMPLOEE );
        statement.setString( 1, emploee.getName() );
        statement.setString( 2, emploee.getSurname() );
        statement.setDate( 3, date );
        statement.setInt( 4, emploee.getSalary() );
        statement.setString( 5, emploee.getEmail() );
        statement.setInt( 6, emploee.getDepartmentId() );
        statement.executeUpdate();
        statement.close();
        dbConnection.closeConnection();
    }

    public void deleteEmploee(int id) throws SQLException {
        PreparedStatement statement = dbConnection.getConnection().prepareStatement( Queries.DELETE_EMPLOEE );
        statement.setInt( 1, id );
        statement.executeUpdate();
        statement.close();
        dbConnection.closeConnection();
    }

    public void updateEmploee(Emploee emploee) throws SQLException {
        java.sql.Date date = new java.sql.Date( emploee.getBirthDate().getTime() );
        PreparedStatement statement = dbConnection.getConnection().prepareStatement( Queries.UPDATE_EMPLOEE );
        statement.setString( 1, emploee.getName() );
        statement.setString( 2, emploee.getSurname() );
        statement.setDate( 3, date );
        statement.setInt( 4, emploee.getSalary() );
        statement.setString( 5, emploee.getEmail() );
        statement.setInt( 6, emploee.getDepartmentId() );
        statement.setInt( 7, emploee.getId() );
        statement.executeUpdate();
        statement.close();
        dbConnection.closeConnection();
    }

    public Emploee getEmploee(int id) throws SQLException {
        Emploee emploee = null;
        PreparedStatement statement = dbConnection.getConnection().prepareStatement( Queries.GET_EMPLOEE );
        statement.setInt( 1, id );
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            String name = resultSet.getString( "name" );
            String surname = resultSet.getString( "surname" );
            java.util.Date birth = new java.util.Date( resultSet.getDate( "birth" ).getTime() );
            int salary = resultSet.getInt( "salary" );
            int departmentId = resultSet.getInt( "department_id" );
            String email = resultSet.getString( "email" );
            emploee = Builder.buildEmploee( id, name, surname, birth, salary, departmentId, email );
        }
        resultSet.close();
        statement.close();
        dbConnection.closeConnection();
        return emploee;
    }

    public List<Emploee> getDepartmentEmploees(int deptId) throws SQLException {
        List<Emploee> departmentEmploees = new ArrayList<>();
        PreparedStatement statement = dbConnection.getConnection().prepareStatement( Queries.GET_DEPARTMENT_EMPLOEES );
        statement.setInt( 1, deptId );
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt( "id" );
            String name = resultSet.getString( "name" );
            String surname = resultSet.getString( "surname" );
            Date birth = resultSet.getDate( "birth" );
            int salary = resultSet.getInt( "salary" );
            int departmentId = resultSet.getInt( "department_id" );
            String email = resultSet.getString( "email" );
            Emploee emploee = Builder.buildEmploee( id, name, surname, birth, salary, departmentId, email );
            departmentEmploees.add( emploee );
        }
        resultSet.close();
        statement.close();
        dbConnection.closeConnection();
        return departmentEmploees;
    }

    public List<JoinDto> getAllEmploees() throws SQLException {
        List<JoinDto> allEmploees = new ArrayList<>();
        Statement statement = dbConnection.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery( Queries.GET_ALL_EMPLOEES );
        while (resultSet.next()) {
            JoinDto joinDto = Builder.buildJoinDto( resultSet.getInt( "id" ), resultSet.getString( "name" ), resultSet.getString( "surname" ), resultSet.getDate( "birth" ), resultSet.getInt( "salary" ), resultSet.getString( "email" ), resultSet.getString( "dept_name" ) );
            allEmploees.add( joinDto );
        }
        resultSet.close();
        statement.close();
        dbConnection.closeConnection();
        return allEmploees;
    }

    public int existEmail(String email) throws SQLException {
        PreparedStatement statement = dbConnection.getConnection().prepareStatement( Queries.EMAIL_EXISTS );
        statement.setString( 1, email );
        ResultSet resultSet = statement.executeQuery();
        int result = resultSet.getRow();
        resultSet.close();
        statement.close();
        dbConnection.closeConnection();
        return result;
    }
}
