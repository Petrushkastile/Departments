package controllers.departments;

import dao.DepartmentDao;
import model.Department;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "MainCtrl", urlPatterns = "/main")
public class MainCtrl extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Department> departments = null;
        DepartmentDao departmentDao = new DepartmentDao();
        try {
            departments = departmentDao.getDepartments();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute( "departments", departments );
        RequestDispatcher dispatcher = request.getRequestDispatcher( "Company.jsp" );
        dispatcher.forward( request, response );
    }
}
