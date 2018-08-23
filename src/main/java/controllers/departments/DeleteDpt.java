package controllers.departments;

import dao.DepartmentDao;
import exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteDpt", urlPatterns = "/deleteDepartment")
public class DeleteDpt extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DepartmentDao departmentDao = new DepartmentDao();
        request.setCharacterEncoding( "UTF-8" );
        int departmentId = Integer.parseInt( request.getParameter( "deleteId" ) );
        try {
            departmentDao.deleteDepartment( departmentId );
            response.sendRedirect( "/main" );
        } catch (ServiceException e) {
            request.setAttribute( "serviceException", e );
            response.sendRedirect( "/main" );
        }
    }
}
