package service;

import dao.EmploeeDao;
import exception.DaoException;
import exception.ErrorComparingException;

import java.util.HashMap;
import java.util.Map;

public class Validator {

    private EmploeeDao emploeeDao = new EmploeeDao();

    private static final String BADNAME = "enter correct name 3-10 chars,only letters, first char must be in upper case";
    private static final String BADSURNAME = "enter correct surname 3-12 chars,only letters, first char must be in upper case";
    private static final String BADSALARY = "enter correct salary: only numbers 1-9 chars,integer";
    private static final String BADDATE = "enter correct date in format DD.MM.YYYY";
    private static final String BADEMAIL = "incorrect email";
    private static final String USEDEMAIL = "this email already used";

    public Map<String, String> validateEmploee(Map<String, String[]> form) throws ErrorComparingException {
        Map<String, String> emploeeFields = new HashMap<>();
        if (!(!form.get( "name" )[0].isEmpty() && name( form.get( "name" )[0] ))) {
            emploeeFields.put( "name", BADNAME );
        }
        if (!(!form.get( "surname" )[0].isEmpty() && surname( form.get( "surname" )[0] ))) {
            emploeeFields.put( "surname", BADSURNAME );
        }
        if (!(!form.get( "birthDate" )[0].isEmpty() && date( form.get( "birthDate" )[0] ))) {
            emploeeFields.put( "birthDate", BADDATE );
        }
        if (!(!form.get( "salary" )[0].isEmpty() && salary( form.get( "salary" )[0] ))) {
            emploeeFields.put( "salary", BADSALARY );
        }
        if (!(!form.get( "email" )[0].isEmpty() && email( form.get( "email" )[0] ))) {
            emploeeFields.put( "email", BADEMAIL );
        }
        if (!emailUsed( form.get( "email" )[0] )) {
            emploeeFields.put( "emailUsed", USEDEMAIL );
        }
        return emploeeFields;
    }

    private boolean name(String value) {
        String regex = "[A-ZА-Я]{1}[a-zа-я]{2}([a-zа-я]{0,10})?";
        return value.matches( regex );
    }

    private boolean surname(String value) {
        String regex = "[A-ZА-Я]{1}[a-zа-я]{2}([a-zа-я]{0,10})?";
        return value.matches( regex );
    }

    private boolean date(String value) {
        String regex = "(0[1-9]|1[0-9]|2[0-9]|3[01]).(0[1-9]|1[012]).[0-9]{4}";
        return value.matches( regex );
    }

    private boolean salary(String value) {
        String regex = "[0-9]{1,9}";
        return value.matches( regex );
    }

    private boolean email(String value) {
        String regex = "(?!.*@.*@.*$)(?!.*@.*\\-\\-.*\\..*$)(?!.*@.*\\-\\..*$)(?!.*@.*\\-$)(.*@.+(\\..{1,11})?)";
        return value.matches( regex );
    }

    private boolean emailUsed(String value) throws ErrorComparingException {
        boolean result = true;

        try {
            if (emploeeDao.existEmail( value ) == 1)
                result = false;

        } catch (DaoException e) {
            throw new ErrorComparingException( e.getMessage(), e.getCause() );
        }
        return result;
    }
}
