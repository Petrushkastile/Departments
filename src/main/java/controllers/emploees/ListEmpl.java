package controllers.emploees;

import exception.ServiceException;
import model.Emploee;
import service.EmploeeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListEmpl", urlPatterns = "/listEmploee")
public class ListEmpl extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher( "ListEmploee.jsp" );
        dispatcher.forward( request, response );
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmploeeService emploeeService = new EmploeeService();
        request.setCharacterEncoding( "UTF-8" );
        int departmentId = Integer.parseInt( request.getParameter( "departmentId" ) );
        String departmentName = request.getParameter( "departmentName" );
        try {
            List<Emploee> emploees = emploeeService.getDepartmentEmploees( departmentId );
            if (emploees.isEmpty()) {
                request.setAttribute( "message", "There are no emploees" );
            }
            request.setAttribute( "emploees", emploees );
            request.setAttribute( "departmentId", departmentId );
            request.setAttribute( "departmentName", departmentName );
            doGet( request, response );
        } catch (ServiceException e) {
            request.setAttribute( "serviceException", e );
            request.setAttribute( "departmentId", departmentId );
            request.setAttribute( "departmentName", departmentName );
            doGet( request, response );
        }
    }
}
