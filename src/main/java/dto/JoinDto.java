package dto;

import java.util.Date;

public class JoinDto {
    private int emploeeId;
    private String emploeeName;
    private String emploeeSurname;
    private Date emploeeBirth;
    private int salary;
    private String email;
    private String departmentName;

    public int getEmploeeId() {
        return emploeeId;
    }

    public void setEmploeeId(int emploeeId) {
        this.emploeeId = emploeeId;
    }

    public String getEmploeeName() {
        return emploeeName;
    }

    public void setEmploeeName(String emploeeName) {
        this.emploeeName = emploeeName;
    }

    public String getEmploeeSurname() {
        return emploeeSurname;
    }

    public void setEmploeeSurname(String emploeeSurname) {
        this.emploeeSurname = emploeeSurname;
    }

    public Date getEmploeeBirth() {
        return emploeeBirth;
    }

    public void setEmploeeBirth(Date emploeeBirth) {
        this.emploeeBirth = emploeeBirth;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }


}
