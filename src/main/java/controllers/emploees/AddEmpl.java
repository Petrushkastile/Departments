package controllers.emploees;

import exception.ErrorComparingException;
import exception.ServiceException;
import service.Builder;
import service.EmploeeService;
import service.Validator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "AddEmpl", urlPatterns = "/addEmploee")

public class AddEmpl extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher( "AddEmploee.jsp" );
        dispatcher.forward( request, response );
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmploeeService emploeeService = new EmploeeService();
        Validator validator = new Validator();
        request.setCharacterEncoding( "UTF-8" );
        try {
            Map<String, String> result = validator.validateEmploee( request.getParameterMap() );
            if (!result.isEmpty()) {
                request.setAttribute( "errors", result );
                request.setAttribute( "emploee", Builder.getData( request.getParameterMap() ) );
                request.setAttribute( "departmentName", request.getParameter( "departmentName" ) );
                request.setAttribute( "departmentId", request.getParameter( "departmentId" ) );
                doGet( request, response );
            } else {
                emploeeService.addEmploee( request.getParameterMap(), Integer.parseInt( request.getParameter( "departmentId" ) ) );
                request.setAttribute( "departmentName", request.getParameter( "departmentName" ) );
                request.setAttribute( "departmentId", request.getParameter( "departmentId" ) );
                request.setAttribute( "message", "Emploee added" );
                doGet( request, response );
            }
        } catch (ServiceException | ErrorComparingException ex) {
            request.setAttribute( "serviceException", ex );
            request.setAttribute( "emploee", Builder.getData( request.getParameterMap() ) );
            request.setAttribute( "departmentName", request.getParameter( "departmentName" ) );
            request.setAttribute( "departmentId", request.getParameter( "departmentId" ) );
            doGet( request, response );
        }
    }
}

