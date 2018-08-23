package service;

import dao.DepartmentDao;
import dao.EmploeeDao;
import exception.DaoException;
import exception.ServiceException;
import model.Department;

import java.util.List;
import java.util.Map;


public class DepartmentService {
    private EmploeeDao emploeeDao = new EmploeeDao();
    private DepartmentDao departmentDao = new DepartmentDao();

    public List<Department> getDepartments() throws ServiceException {
        List<Department> departments;
        try {
            departments = departmentDao.getDepartments();
            return departments;
        } catch (DaoException e) {
            throw new ServiceException( e.getMessage(), e.getCause() );
        }
    }

    public void addDepartment(Map<String, String[]> requestParams) throws ServiceException {
        try {
            departmentDao.addDepartment(Builder.buildDepartmentFromRequest(requestParams) );
        } catch (DaoException e) {
            throw new ServiceException( e.getMessage(), e.getCause() );
        }
    }

    public void updateDepartment(Map<String,String[]> requestParams) throws ServiceException {
        try {
            departmentDao.updateDepartment( Builder.buildDepartmentFromRequest( requestParams ) );
        } catch (DaoException e) {
            throw new ServiceException( e.getMessage(), e.getCause() );
        }
    }

    public Department getDepartment(String id) throws ServiceException {
        try {
           return departmentDao.getDepartment( Integer.parseInt( id ) );
        } catch (DaoException e) {
            throw new ServiceException( e.getMessage(), e.getCause() );
        }
    }
}
