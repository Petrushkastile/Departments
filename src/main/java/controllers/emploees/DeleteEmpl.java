package controllers.emploees;

import dao.DepartmentDao;
import dao.EmploeeDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "DeleteEmpl", urlPatterns = "/deleteEmploee")
public class DeleteEmpl extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher( "/listEmploee" );
        dispatcher.forward( request, response );
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DepartmentDao departmentDao=new DepartmentDao();
        EmploeeDao emploeeDao=new EmploeeDao();

        String departmentName = request.getParameter( "departmentName" );
        int departmentId = Integer.parseInt( request.getParameter( "departmentId" ) );
        int emploeeId = Integer.parseInt( request.getParameter( "deleteId" ) );
        try {
            emploeeDao.deleteEmploee( emploeeId );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            departmentDao.updateDepartmentCount( departmentId, 0 );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute( "departmentName", departmentName );
        request.setAttribute( "departmentID", departmentId );
        doGet( request, response );
    }
}
