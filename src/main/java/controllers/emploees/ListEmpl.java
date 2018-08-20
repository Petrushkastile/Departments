package controllers.emploees;


import dao.EmploeeDao;
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

@WebServlet(name = "ListEmpl", urlPatterns ="/listEmploee")
public class ListEmpl extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher( "ListEmploee.jsp" );
        dispatcher.forward( request, response );
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmploeeDao emploeeDao=new EmploeeDao();
        request.setCharacterEncoding("UTF-8");
        int departmentId = Integer.parseInt( request.getParameter( "departmentId" ) );
        String departmentName=request.getParameter( "departmentName" );
        List<Emploee> emploees = new ArrayList<>(  );
        try {
            emploees = emploeeDao.getDepartmentEmploees(departmentId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(emploees.isEmpty()){
            request.setAttribute( "message","There are no emploees" );
        }
        request.setAttribute( "emploees", emploees );
        request.setAttribute( "departmentId", departmentId);
        request.setAttribute( "departmentName", departmentName );
        doGet( request, response );
    }
}
