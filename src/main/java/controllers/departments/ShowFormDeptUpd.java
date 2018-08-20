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

@WebServlet(name = "ShowFormDeptUpd", urlPatterns = "/showFormUpdateDepartment")
public class ShowFormDeptUpd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DepartmentDao departmentDao = new DepartmentDao();
        int id = Integer.parseInt( request.getParameter( "updateId" ) );
        Department department=null;
        try {
            department = departmentDao.getDepartment( id );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher( "UpdateDepartment.jsp" );
        request.setAttribute( "department", department );
        dispatcher.forward( request, response );
    }
}
