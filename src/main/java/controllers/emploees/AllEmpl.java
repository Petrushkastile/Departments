package controllers.emploees;

import dto.JoinDto;
import exception.ServiceException;
import service.EmploeeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AllEmpl", urlPatterns = "/allEmploees")
public class AllEmpl extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmploeeService emploeeService = new EmploeeService();
        try {
            List<JoinDto> allEmploees = emploeeService.getAllEmploee();
            request.setAttribute( "emploees", allEmploees );
            RequestDispatcher dispatcher = request.getRequestDispatcher( "AllEmploee.jsp" );
            dispatcher.forward( request, response );
        } catch (ServiceException e) {
            request.setAttribute( "serviceException", e );
            RequestDispatcher dispatcher = request.getRequestDispatcher( "AllEmploee.jsp" );
            dispatcher.forward( request, response );
        }
    }
}
