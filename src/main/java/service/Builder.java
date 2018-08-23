package service;

import dto.JoinDto;
import exception.BuilderException;
import model.Department;
import model.Emploee;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Builder {

    public static Department buildDepartment(int id, String name, int countEmploees) {
        Department department = new Department();
        if (id != 0) {
            department.setId( id );
        }
        department.setName( name );
        department.setCountEmploees( countEmploees );
        return department;
    }

    public static Emploee buildEmploee(int id, String name, String surname, Date birth, int salary, int departmentId, String email) {
        Emploee emploee = new Emploee();
        if (id != 0) {
            emploee.setId( id );
        }
        emploee.setName( name );
        emploee.setSurname( surname );
        emploee.setBirthDate( birth );
        emploee.setSalary( salary );
        emploee.setEmail( email );
        emploee.setDepartmentId( departmentId );

        return emploee;
    }

    public static Emploee buildEmploeeFromRequest(Map<String, String[]> parameters,int deptId) throws BuilderException {
        Emploee emploee = new Emploee();
        if(parameters.containsKey("id")){
            emploee.setId( Integer.parseInt( parameters.get( "id" )[0] ) );
        }
        emploee.setName( parameters.get( "name" )[0] );
        emploee.setSurname( parameters.get( "surname" )[0] );
        try{
        emploee.setBirthDate( DateParser.parseDate( parameters.get( "birthDate" )[0] ) );}
        catch (ParseException e){
            throw new BuilderException(e.getMessage());
        }
        emploee.setSalary( Integer.parseInt( parameters.get( "salary" )[0] ) );
        emploee.setEmail( parameters.get( "email" )[0] );
        emploee.setDepartmentId(deptId);
        return emploee;
    }

    public static JoinDto buildJoinDto(int id, String name, String surname, Date birth, int salary, String email, String departmentName) {
        JoinDto joinDto = new JoinDto();
        if (id != 0) {
            joinDto.setEmploeeId( id );
        }
        joinDto.setEmploeeName( name );
        joinDto.setEmploeeSurname( surname );
        joinDto.setEmploeeBirth( birth );
        joinDto.setSalary( salary );
        joinDto.setEmail( email );
        joinDto.setDepartmentName( departmentName );

        return joinDto;
    }

    public static Map<String, String> getData(Map<String, String[]> parameters) {
        Map<String, String> data = new HashMap<>();
        Set<Map.Entry<String, String[]>> fields = parameters.entrySet();
        for (Map.Entry<String, String[]> field : fields) {
            String keyField = field.getKey();
            String valuefield = field.getValue()[0];
            data.put( keyField, valuefield );
        }
        return data;
    }

    public static Department buildDepartmentFromRequest(Map<String, String[]> parameters) {
         Department department=new Department();
        if(parameters.containsKey("id")){
            department.setId( Integer.parseInt( parameters.get( "id" )[0] ) );
        }
        if(!parameters.containsKey("countEmploees")){
            department.setCountEmploees( 0 );
        }
        if(parameters.containsKey("countEmploees")){
            department.setCountEmploees(Integer.parseInt( parameters.get( "countEmploees" )[0] ));
        }
        department.setName(parameters.get( "name" )[0]  );
        return department;
    }
}