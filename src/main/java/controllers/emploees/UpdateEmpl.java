package controllers.emploees;

import exception.ErrorComparingException;
import exception.ServiceException;
import model.Department;
import service.Builder;
import service.DepartmentService;
import service.EmploeeService;
import service.Validator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "UpdateEmpl", urlPatterns = "/updateEmploee")
public class UpdateEmpl extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher( "/UpdateEmploee.jsp" );
        dispatcher.forward( request, response );
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmploeeService emploeeService = new EmploeeService();
        DepartmentService departmentService = new DepartmentService();
        Validator validator = new Validator();
        request.setCharacterEncoding( "UTF-8" );
        List<Department> departments = null;
        try {
            Map<String, String> result = validator.validateEmploee( request.getParameterMap() );
            departments = departmentService.getDepartments();
            if (!result.isEmpty()) {
                request.setAttribute( "errors", result );
                request.setAttribute( "emploee", Builder.getData( request.getParameterMap() ) );
                request.setAttribute( "departmentName", request.getParameter( "departmentName" ) );
                request.setAttribute( "departmentId", request.getParameter( "departmentId" ) );
                request.setAttribute( "departments", departments );
                doGet( request, response );
            } else {
                emploeeService.updateEmploee( request.getParameterMap(), request.getParameter( "departmentName" ), request.getParameter( "olddepartmentId" ) );
                request.setAttribute( "departmentName", request.getParameter( "departmentName" ) );
                request.setAttribute( "departmentID", request.getParameter( "departmentId" ) );
                RequestDispatcher dispatcher = request.getRequestDispatcher( "/listEmploee" );
                dispatcher.forward( request, response );
            }

        } catch (ServiceException | ErrorComparingException e) {
            request.setAttribute( "serviceException", e );
            request.setAttribute( "emploee", Builder.getData( request.getParameterMap() ) );
            request.setAttribute( "departmentName", request.getParameter( "departmentName" ) );
            request.setAttribute( "departmentId", request.getParameter( "departmentId" ) );
            request.setAttribute( "departments", departments );
            doGet( request, response );
        }
    }
}
