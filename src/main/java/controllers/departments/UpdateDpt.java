package controllers.departments;

import exception.ErrorComparingException;
import exception.ServiceException;
import service.Builder;
import service.DepartmentService;
import service.DepartmentValidator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "UpdateDpt", urlPatterns = "/updateDepartment")
public class UpdateDpt extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher( "UpdateDepartment.jsp" );
        dispatcher.forward( request, response );
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DepartmentService departmentService = new DepartmentService();
        DepartmentValidator validator = new DepartmentValidator();
        request.setCharacterEncoding( "UTF-8" );
        try {
            Map<String, String> result = validator.validateDepartment( request.getParameterMap() );
            if (!result.isEmpty()) {
                request.setAttribute( "errors", result );
                request.setAttribute( "department", Builder.getData( request.getParameterMap() ) );
                doGet( request, response );
            } else {
                departmentService.updateDepartment( request.getParameterMap() );
                response.sendRedirect( "/main" );
            }
        } catch (ServiceException | ErrorComparingException e) {
            request.setAttribute( "serviceException", e );
            doGet( request, response );
        }
    }
}
