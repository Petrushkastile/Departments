package controllers.departments;

import dao.DepartmentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "DeleteDpt", urlPatterns = "/deleteDepartment")
public class DeleteDpt extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DepartmentDao departmentDao = new DepartmentDao();
        request.setCharacterEncoding("UTF-8");
        int departmentId = Integer.parseInt( request.getParameter( "deleteId" ) );
        try {
            departmentDao.deleteDepartment( departmentId );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect( "/main" );
    }
}
