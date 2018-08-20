package controllers.emploees;

import dao.DepartmentDao;
import dao.EmploeeDao;
import model.Emploee;
import service.Builder;
import service.Validator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

@WebServlet(name = "AddEmpl", urlPatterns = "/addEmploee")
public class AddEmpl extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher( "AddEmploee.jsp" );
        dispatcher.forward( request, response );
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DepartmentDao departmentDao = new DepartmentDao();
        EmploeeDao emploeeDao = new EmploeeDao();
        Validator validator = new Validator();
        request.setCharacterEncoding( "UTF-8" );
        Map<String, String> result = validator.validateEmploee( request.getParameterMap() );
        if (!result.isEmpty()) {
            request.setAttribute( "errors", result );
            request.setAttribute( "emploee", Builder.getData( request.getParameterMap() ) );
            request.setAttribute( "departmentName", request.getParameter( "departmentName" ) );
            request.setAttribute( "departmentId", request.getParameter( "departmentId" ) );
            doGet( request, response );
        } else {

            Emploee emploee = Builder.buildEmploeeFromRequest( request.getParameterMap(), Integer.parseInt(request.getParameter( "departmentId" )));
            try {
                emploeeDao.addEmploee( emploee );
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                departmentDao.updateDepartmentCount( Integer.parseInt( request.getParameter( "departmentId" ) ), 1 );
            } catch (SQLException e) {
                e.printStackTrace();
            }
            request.setAttribute( "departmentName", request.getParameter( "departmentName" ) );
            request.setAttribute( "departmentId", request.getParameter( "departmentId" ) );
            request.setAttribute( "message", "Emploee added" );
            doGet( request, response );
        }
    }
}
