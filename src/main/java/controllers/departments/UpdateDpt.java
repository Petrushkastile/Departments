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

@WebServlet(name = "UpdateDpt", urlPatterns = "/updateDepartment")
public class UpdateDpt extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DepartmentDao departmentDao = new DepartmentDao();
        request.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt( request.getParameter( "id" ) );
        String name = request.getParameter( "name" );
        int countEmploees = Integer.parseInt( request.getParameter( "countEmploees" ) );
        Department department = Builder.buildDepartment( id, name, countEmploees );
        try {
            departmentDao.updateDepartment( department );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect( "/main" );
    }
}
