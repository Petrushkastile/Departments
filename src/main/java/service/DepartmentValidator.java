package service;

import dao.DepartmentDao;
import exception.DaoException;
import exception.ErrorComparingException;

import java.util.HashMap;
import java.util.Map;

public class DepartmentValidator {
    private DepartmentDao departmentDao=new DepartmentDao();
    private static final String USEDDEPARTMENTNAME = "this department name already used";
    private static final String BADNAME = "enter correct name 3-10 chars,only letters, first char must be in upper case";

    public Map<String, String> validateDepartment(Map<String, String[]> form) throws ErrorComparingException {
        Map<String, String> departmentFieds = new HashMap<>();
        if (!(!form.get( "name" )[0].isEmpty() && name( form.get( "name" )[0] ))) {
            departmentFieds.put( "name", BADNAME );
        }
        if (!nameUsed( form.get( "name" )[0] )) {
            departmentFieds.put( "nameUsed", USEDDEPARTMENTNAME );
        }
        return departmentFieds;
    }


    private boolean name(String value) {
        String regex = "[A-ZА-Я]{1}[a-zа-я]{2}([a-zа-я]{0,10})?";
        return value.matches( regex );
    }

    private boolean nameUsed(String value) throws ErrorComparingException {
        boolean result = true;

        try {
            if (departmentDao.existName( value ) == 1)
                result = false;

        } catch (DaoException e) {
            throw new ErrorComparingException( e.getMessage(), e.getCause() );
        }
        return result;
    }
}