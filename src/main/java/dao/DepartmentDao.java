package dao;


import model.Department;
import service.Builder;
import service.DbConnection;
import service.Queries;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDao {

    private DbConnection dbConnection = new DbConnection();

    public void addDepartment(Department department) throws SQLException {
        PreparedStatement statement = dbConnection.getConnection().prepareStatement( Queries.ADD_DEPARTMENT );
        statement.setString( 1, department.getName() );
        statement.executeUpdate();
        statement.close();
        dbConnection.closeConnection();
    }

    public void deleteDepartment(int id) throws SQLException {
        PreparedStatement statement = dbConnection.getConnection().prepareStatement( Queries.DELETE_DEPARTMENT );
        statement.setInt( 1, id );
        statement.executeUpdate();
        statement.close();
        dbConnection.closeConnection();
    }

    public void updateDepartment(Department department) throws SQLException {
        PreparedStatement statement = dbConnection.getConnection().prepareStatement( Queries.UPDATE_DEPARTMENT );
        statement.setString( 1, department.getName() );
        statement.setInt( 2, department.getId() );
        statement.executeUpdate();
        statement.close();
        dbConnection.closeConnection();
    }

    public Department getDepartment(int id) throws SQLException {
        Department department = null;
        PreparedStatement statement = dbConnection.getConnection().prepareStatement( Queries.GET_DEPARTMENT );
        statement.setInt( 1, id );
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            String name = resultSet.getString( "department_name" );
            int countEmploees = resultSet.getInt( "count_emploees" );
            department = Builder.buildDepartment( id, name, countEmploees );
        }
        resultSet.close();
        statement.close();
        dbConnection.closeConnection();
        return department;
    }

    public List<Department> getDepartments() throws SQLException {
        List<Department> departments = new ArrayList<>();
        Statement statement = dbConnection.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery( Queries.GET_DEPARTMENTS );
        while (resultSet.next()) {
            int id = resultSet.getInt( "dept_id" );
            String name = resultSet.getString( "department_name" );
            int countEmploees = resultSet.getInt( "count_emploees" );
            Department department = Builder.buildDepartment( id, name, countEmploees );
            departments.add( department );
        }
        resultSet.close();
        statement.close();
        dbConnection.closeConnection();
        return departments;
    }

    public void updateDepartmentCount(int id, int operation) throws SQLException {
        PreparedStatement statement;
        if (operation == 1) {
            statement = dbConnection.getConnection().prepareStatement( Queries.INCREMENT_EMPLOEES );
            statement.setInt( 1, id );
            statement.executeUpdate();
        } else {
            statement = dbConnection.getConnection().prepareStatement( Queries.DECREMENT_EMPLOEES );
            statement.setInt( 1, id );
            statement.executeUpdate();
        }

        statement.close();
        dbConnection.closeConnection();
    }

    public int getIdDepartment(String departmentName) throws SQLException {
        int departmentId = 0;
        PreparedStatement statement = dbConnection.getConnection().prepareStatement( Queries.GET_ID_DEPARTMENT );
        statement.setString( 1, departmentName );
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            departmentId = resultSet.getInt( "dept_id" );
        }
        resultSet.close();
        statement.close();
        dbConnection.closeConnection();
        return departmentId;
    }
}
