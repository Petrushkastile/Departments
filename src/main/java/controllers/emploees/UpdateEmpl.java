package controllers.emploees;

import dao.DepartmentDao;
import dao.EmploeeDao;
import model.Department;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet(name = "UpdateEmpl", urlPatterns = "/updateEmploee")
public class UpdateEmpl extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher( "/UpdateEmploee.jsp" );
        dispatcher.forward( request, response );
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmploeeDao emploeeDao = new EmploeeDao();
        DepartmentDao departmentDao = new DepartmentDao();
        Validator validator = new Validator();
        request.setCharacterEncoding( "UTF-8" );
        Map<String, String> result = validator.validateEmploee( request.getParameterMap() );
        if (!result.isEmpty()) {
            List<Department> departments = new ArrayList<>();
            try {
                departments = departmentDao.getDepartments();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            request.setAttribute( "errors", result );
            request.setAttribute( "emploee", Builder.getData( request.getParameterMap() ) );
            request.setAttribute( "departmentName", request.getParameter( "departmentName" ) );
            request.setAttribute( "departmentId", request.getParameter( "departmentId" ) );
            request.setAttribute( "departments", departments );

            doGet( request, response );

        } else {
            try {

                int deptId = departmentDao.getIdDepartment( request.getParameter( "departmentName" ) );
                int oldDept =Integer.parseInt( request.getParameter( "olddepartmentId" ) );
                departmentDao.updateDepartmentCount( deptId,1 );
                departmentDao.updateDepartmentCount( oldDept,0 );
                Emploee emploee = Builder.buildEmploeeFromRequest( request.getParameterMap(), deptId );
                emploeeDao.updateEmploee( emploee );
            } catch (SQLException e) {
                throw new ServletException( e );
            }
            request.setAttribute( "departmentName", request.getParameter( "departmentName" ) );
            request.setAttribute( "departmentID", request.getParameter( "departmentId" ) );
            RequestDispatcher dispatcher = request.getRequestDispatcher( "/listEmploee" );
            dispatcher.forward( request, response );
        }
    }
}
