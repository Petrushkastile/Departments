package controllers.emploees;

import exception.ServiceException;
import model.Department;
import model.Emploee;
import service.DepartmentService;
import service.EmploeeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowFormUpdateEmpl", urlPatterns = "/showFormUpdateEmploee")
public class ShowFormUpdateEmpl extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher( "UpdateEmploee.jsp" );
        dispatcher.forward( request, response );
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding( "UTF-8" );
        EmploeeService emploeeService = new EmploeeService();
        DepartmentService departmentService = new DepartmentService();

        try {
            Emploee emploee = emploeeService.getEmploee( Integer.parseInt( request.getParameter( "updateId" ) ) );
            List<Department> departments = departmentService.getDepartments();
            request.setAttribute( "departments", departments );
            request.setAttribute( "departmentName", request.getParameter( "departmentName" ) );
            request.setAttribute( "departmentId", request.getParameter( "departmentId" ) );
            request.setAttribute( "emploee", emploee );
            doGet( request, response );
        } catch (ServiceException e) {
            request.setAttribute( "serviceException", e );
            request.setAttribute( "departmentName", request.getParameter( "departmentName" ) );
            request.setAttribute( "departmentId", request.getParameter( "departmentId" ) );
            doGet( request, response );
        }
    }
}
