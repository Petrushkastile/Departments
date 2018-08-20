package controllers.emploees;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ShowFormAddEmpl", urlPatterns = "/showFormAddEmploee")
public class ShowFormAddEmpl extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher( "AddEmploee.jsp" );
        dispatcher.forward( request, response );
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dptName = request.getParameter( "departmentName" );
        String dpt = request.getParameter( "departmentId" );

        request.setAttribute( "departmentName", dptName );
        request.setAttribute( "departmentId", dpt );
        doGet( request, response );
    }
}
