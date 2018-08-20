package controllers.departments;

import dao.DepartmentDao;
import model.Department;
import service.Builder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AddDpt", urlPatterns = "/addDepartment")
public class AddDpt extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DepartmentDao departmentDao = new DepartmentDao();
        request.setCharacterEncoding("UTF-8");
        String departmentName = request.getParameter( "name" );
        Department department = Builder.buildDepartment(0,departmentName.trim(),0);
        try {
            departmentDao.addDepartment( department );
        } catch (SQLException e) {
            throw new ServletException( e );
        }
        response.sendRedirect( "/main" );
    }
}
