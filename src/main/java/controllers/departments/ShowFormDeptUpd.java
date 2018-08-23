package controllers.departments;

import exception.ServiceException;
import model.Department;
import service.DepartmentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ShowFormDeptUpd", urlPatterns = "/showFormUpdateDepartment")
public class ShowFormDeptUpd extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher( "UpdateDepartment.jsp" );
        dispatcher.forward( request, response );
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DepartmentService departmentService = new DepartmentService();
        try {
            Department department = departmentService.getDepartment( request.getParameter( "updateId" ) );
            request.setAttribute( "department", department );
            doGet( request, response );
        } catch (ServiceException e) {
            request.setAttribute( "serviceException", e );
            response.sendRedirect( "/main" );
        }
    }
}
