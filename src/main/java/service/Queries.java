package service;

public final class Queries {

    public static final String ADD_DEPARTMENT = "INSERT INTO departments (department_name, count_emploees) VALUES (?,0)";

    public static final String DELETE_DEPARTMENT = "DELETE FROM departments WHERE dept_id =?";

    public static final String UPDATE_DEPARTMENT = "UPDATE departments SET department_name=? WHERE dept_id=?";

    public static final String GET_DEPARTMENT = "SELECT * FROM departments WHERE dept_id=?";

    public static final String GET_ID_DEPARTMENT = "SELECT * FROM departments WHERE department_name=?";

    public static final String GET_DEPARTMENTS = "SELECT * FROM departments";

    public static final String INCREMENT_EMPLOEES = "UPDATE departments  SET count_emploees = count_emploees + 1 WHERE dept_id=?";

    public static final String DECREMENT_EMPLOEES = "UPDATE departments SET count_emploees = count_emploees - 1 WHERE dept_id=?";

    public static final String ADD_EMPLOEE = "INSERT INTO emploees (name, surname, birth, salary,email, department_id) VALUES (?,?,?,?,?,?)";

    public static final String DELETE_EMPLOEE = "DELETE FROM emploees WHERE id =?";

    public static final String UPDATE_EMPLOEE = "UPDATE emploees SET name=?, surname=?, birth=?, salary=?, email=?, department_id=? WHERE id=?";

    public static final String GET_EMPLOEE = "SELECT * FROM emploees WHERE id=?";

    public static final String GET_DEPARTMENT_EMPLOEES = "SELECT * FROM emploees WHERE department_id=?";

    public static final String GET_ALL_EMPLOEES = "SELECT id, name, surname, birth, salary, email, department_name AS dept_name FROM emploees LEFT OUTER JOIN departments ON  department_id=dept_id ORDER BY name";

    public static final String EMAIL_EXISTS = "SELECT EXISTS (SELECT * FROM emploees WHERE email=?)";

    public static final String DEPARTMENT_NAME_EXISTS = "SELECT EXISTS (SELECT * FROM departments WHERE department_name=?)";
}


