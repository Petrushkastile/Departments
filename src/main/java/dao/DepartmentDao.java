package dao;

import exception.DaoException;
import model.Department;
import service.Builder;
import service.DbConnection;
import service.Queries;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDao {

    public void addDepartment(Department department) throws DaoException {
        try (PreparedStatement statement = DbConnection.getConnection().prepareStatement( Queries.ADD_DEPARTMENT )) {
            statement.setString( 1, department.getName() );
            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new DaoException( e.getMessage() );
        }
    }

    public void deleteDepartment(int id) throws DaoException {
        try (PreparedStatement statement = DbConnection.getConnection().prepareStatement( Queries.DELETE_DEPARTMENT )) {
            statement.setInt( 1, id );
            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new DaoException( e.getMessage() );
        }
    }

    public void updateDepartment(Department department) throws DaoException {
        try (PreparedStatement statement = DbConnection.getConnection().prepareStatement( Queries.UPDATE_DEPARTMENT )) {
            statement.setString( 1, department.getName() );
            statement.setInt( 2, department.getId() );
            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new DaoException( e.getMessage() );
        }
    }

    public Department getDepartment(int id) throws DaoException {
        Department department = new Department();
        try (PreparedStatement statement = DbConnection.getConnection().prepareStatement( Queries.GET_DEPARTMENT )) {
            statement.setInt( 1, id );
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString( "department_name" );
                int countEmploees = resultSet.getInt( "count_emploees" );
                department = Builder.buildDepartment( id, name, countEmploees );
            }
            return department;
        } catch (SQLException | ClassNotFoundException e) {
            throw new DaoException( e.getMessage() );
        }
    }

    public List<Department> getDepartments() throws DaoException {
        List<Department> departments = new ArrayList<>();
        try (Statement statement = DbConnection.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery( Queries.GET_DEPARTMENTS );
            while (resultSet.next()) {
                int id = resultSet.getInt( "dept_id" );
                String name = resultSet.getString( "department_name" );
                int countEmploees = resultSet.getInt( "count_emploees" );
                Department department = Builder.buildDepartment( id, name, countEmploees );
                departments.add( department );
            }
            return departments;
        } catch (SQLException | ClassNotFoundException e) {
            throw new DaoException( e.getMessage() );
        }
    }


    public void inctementEmploeeCount(int id) throws DaoException {
        try (PreparedStatement statementForInc = DbConnection.getConnection().prepareStatement( Queries.INCREMENT_EMPLOEES )) {
            statementForInc.setInt( 1, id );
            statementForInc.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new DaoException( e.getMessage() );
        }
    }

    public void decrementEmploeeCount(int id) throws DaoException {
        try (PreparedStatement statementForInc = DbConnection.getConnection().prepareStatement( Queries.DECREMENT_EMPLOEES )) {
            statementForInc.setInt( 1, id );
            statementForInc.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new DaoException( e.getMessage() );
        }
    }

    public int getIdDepartment(String departmentName) throws DaoException {
        int departmentId = 0;
        try (PreparedStatement statement = DbConnection.getConnection().prepareStatement( Queries.GET_ID_DEPARTMENT )) {
            statement.setString( 1, departmentName );
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                departmentId = resultSet.getInt( "dept_id" );
            }
            return departmentId;
        } catch (SQLException | ClassNotFoundException e) {
            throw new DaoException( e.getMessage() );
        }
    }

    public int existName(String name) throws DaoException {
        try (PreparedStatement statement = DbConnection.getConnection().prepareStatement( Queries.DEPARTMENT_NAME_EXISTS )) {
            statement.setString( 1, name );
            ResultSet resultSet = statement.executeQuery();
            return resultSet.getRow();
        } catch (SQLException | ClassNotFoundException e) {
            throw new DaoException( e.getMessage() );
        }
    }
}
