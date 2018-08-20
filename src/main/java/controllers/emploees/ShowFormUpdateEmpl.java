package controllers.emploees;

import dao.DepartmentDao;
import dao.EmploeeDao;
import model.Department;
import model.Emploee;

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

@WebServlet(name = "ShowFormUpdateEmpl", urlPatterns = "/showFormUpdateEmploee")
public class ShowFormUpdateEmpl extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher( "UpdateEmploee.jsp" );
        dispatcher.forward( request, response );
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmploeeDao emploeeDao = new EmploeeDao();
        DepartmentDao departmentDao = new DepartmentDao();
        List<Department> departments = new ArrayList<>();

        int id = Integer.parseInt( request.getParameter( "updateId" ) );
        String dptName = request.getParameter( "departmentName" );
        String dpt = request.getParameter( "departmentId" );
        Emploee emploee = null;
        try {
            emploee = emploeeDao.getEmploee( id );
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            departments = departmentDao.getDepartments();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute( "departments", departments );
        request.setAttribute( "departmentName", dptName );
        request.setAttribute( "departmentId", dpt );
        request.setAttribute( "emploee", emploee );
        doGet( request, response );
    }
}
