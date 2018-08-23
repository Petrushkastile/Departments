package service;

import dao.DepartmentDao;
import dao.EmploeeDao;
import dto.JoinDto;
import exception.BuilderException;
import exception.DaoException;
import exception.ServiceException;
import model.Emploee;

import java.util.List;
import java.util.Map;

public class EmploeeService {

    private EmploeeDao emploeeDao = new EmploeeDao();
    private DepartmentDao departmentDao = new DepartmentDao();

    public void addEmploee(Map<String, String[]> requestParams, int departmentId) throws ServiceException {
        try {
            Emploee emploee = Builder.buildEmploeeFromRequest( requestParams, departmentId );
            emploeeDao.addEmploee( emploee );
            departmentDao.inctementEmploeeCount( departmentId );
        } catch (DaoException e) {
            throw new ServiceException( e.getMessage(), e.getCause() );
        }
    }

    public void updateEmploee(Map<String, String[]> requestParams, String deptName, String oldDeptId) throws ServiceException {
        try {
            int oldId = Integer.parseInt( oldDeptId );
            int deptId = departmentDao.getIdDepartment( deptName );
            Emploee emploee = Builder.buildEmploeeFromRequest( requestParams, deptId );
            emploeeDao.updateEmploee( emploee );
            departmentDao.inctementEmploeeCount( deptId );
            departmentDao.decrementEmploeeCount( oldId );
        } catch (DaoException | BuilderException e) {
            throw new ServiceException( e.getMessage(), e.getCause() );
        }
    }

    public Emploee getEmploee(int emplId) throws ServiceException {
        Emploee emploee;
        try {
            emploee = emploeeDao.getEmploee( emplId );
            return emploee;
        } catch (DaoException e) {
            throw new ServiceException( e.getMessage(), e.getCause() );
        }
    }

    public void deleteEmploee(String emploeeId, String departmentId) throws ServiceException {
        try {
            emploeeDao.deleteEmploee( Integer.parseInt( emploeeId ) );
            departmentDao.decrementEmploeeCount( Integer.parseInt( departmentId ) );
        } catch (DaoException e) {
            throw new ServiceException( e.getMessage(), e.getCause() );
        }
    }

    public List<JoinDto> getAllEmploee() throws ServiceException {
        try {
            return emploeeDao.getAllEmploees();
        } catch (DaoException e) {
            throw new ServiceException( e.getMessage(), e.getCause() );
        }
    }

    public List<Emploee> getDepartmentEmploees(int deptId) throws ServiceException {
        try {
            return emploeeDao.getDepartmentEmploees( deptId );
        } catch (DaoException e) {
            throw new ServiceException( e.getMessage(), e.getCause() );
        }
    }
}
