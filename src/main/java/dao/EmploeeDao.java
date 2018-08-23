package dao;

import dto.JoinDto;
import exception.DaoException;
import model.Emploee;
import service.Builder;
import service.DbConnection;
import service.Queries;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmploeeDao {

    public void addEmploee(Emploee emploee) throws DaoException {
        try (PreparedStatement statement = DbConnection.getConnection().prepareStatement( Queries.ADD_EMPLOEE )) {
            statement.setString( 1, emploee.getName() );
            statement.setString( 2, emploee.getSurname() );
            statement.setDate( 3, new java.sql.Date( emploee.getBirthDate().getTime() ) );
            statement.setInt( 4, emploee.getSalary() );
            statement.setString( 5, emploee.getEmail() );
            statement.setInt( 6, emploee.getDepartmentId() );
            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new DaoException( e.getMessage() );
        }
    }

    public void deleteEmploee(int id) throws DaoException {
        try (PreparedStatement statement = DbConnection.getConnection().prepareStatement( Queries.DELETE_EMPLOEE )) {
            statement.setInt( 1, id );
            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new DaoException( e.getMessage() );
        }
    }

    public void updateEmploee(Emploee emploee) throws DaoException {
        try (PreparedStatement statement = DbConnection.getConnection().prepareStatement( Queries.UPDATE_EMPLOEE )) {
            statement.setString( 1, emploee.getName() );
            statement.setString( 2, emploee.getSurname() );
            statement.setDate( 3, new java.sql.Date( emploee.getBirthDate().getTime() ) );
            statement.setInt( 4, emploee.getSalary() );
            statement.setString( 5, emploee.getEmail() );
            statement.setInt( 6, emploee.getDepartmentId() );
            statement.setInt( 7, emploee.getId() );
            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new DaoException( e.getMessage() );
        }
    }

    public Emploee getEmploee(int id) throws DaoException {
        Emploee emploee = new Emploee();
        try (PreparedStatement statement = DbConnection.getConnection().prepareStatement( Queries.GET_EMPLOEE )) {
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
            return emploee;
        } catch (SQLException | ClassNotFoundException e) {
            throw new DaoException( e.getMessage() );
        }
    }

    public List<Emploee> getDepartmentEmploees(int deptId) throws DaoException {
        List<Emploee> departmentEmploees = new ArrayList<>();
        try (PreparedStatement statement = DbConnection.getConnection().prepareStatement( Queries.GET_DEPARTMENT_EMPLOEES )) {
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
            return departmentEmploees;
        } catch (SQLException | ClassNotFoundException e) {
            throw new DaoException( e.getMessage() );
        }
    }

    public List<JoinDto> getAllEmploees() throws DaoException {
        List<JoinDto> allEmploees = new ArrayList<>();
        try (Statement statement = DbConnection.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery( Queries.GET_ALL_EMPLOEES );
            while (resultSet.next()) {
                JoinDto joinDto = Builder.buildJoinDto( resultSet.getInt( "id" ), resultSet.getString( "name" ), resultSet.getString( "surname" ), resultSet.getDate( "birth" ), resultSet.getInt( "salary" ), resultSet.getString( "email" ), resultSet.getString( "dept_name" ) );
                allEmploees.add( joinDto );
            }
            return allEmploees;
        } catch (SQLException | ClassNotFoundException e) {
            throw new DaoException( e.getMessage() );
        }
    }

    public int existEmail(String email) throws DaoException {
        try (PreparedStatement statement = DbConnection.getConnection().prepareStatement( Queries.EMAIL_EXISTS )) {
            statement.setString( 1, email );
            ResultSet resultSet = statement.executeQuery();
            return resultSet.getRow();
        } catch (SQLException | ClassNotFoundException e) {
            throw new DaoException( e.getMessage() );
        }
    }
}