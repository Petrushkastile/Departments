package controllers.emploees;

import exception.ServiceException;
import service.EmploeeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteEmpl", urlPatterns = "/deleteEmploee")
public class DeleteEmpl extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher( "/listEmploee" );
        dispatcher.forward( request, response );
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmploeeService emploeeService = new EmploeeService();
        String departmentName = request.getParameter( "departmentName" );
        String departmentId = request.getParameter( "departmentId" );
        try {
            emploeeService.deleteEmploee( request.getParameter( "deleteId" ), departmentId );
            request.setAttribute( "departmentName", departmentName );
            request.setAttribute( "departmentID", departmentId );
            doGet( request, response );
        } catch (ServiceException e) {
            request.setAttribute( "serviceException", e );
            request.setAttribute( "departmentName", departmentName );
            request.setAttribute( "departmentID", departmentId );
            doGet( request, response );
        }
    }
}
