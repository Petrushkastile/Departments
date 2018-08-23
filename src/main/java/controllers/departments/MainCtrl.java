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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "MainCtrl", urlPatterns = "/main")
public class MainCtrl extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Department> departments = new ArrayList<>();
        DepartmentService departmentService = new DepartmentService();
        try {
            departments = departmentService.getDepartments();
            request.setAttribute( "departments", departments );
            RequestDispatcher dispatcher = request.getRequestDispatcher( "Company.jsp" );
            dispatcher.forward( request, response );
        } catch (ServiceException e) {
            request.setAttribute( "serviceException", e );
            request.setAttribute( "departments", departments );
            RequestDispatcher dispatcher = request.getRequestDispatcher( "Company.jsp" );
            dispatcher.forward( request, response );
        }
    }
}
