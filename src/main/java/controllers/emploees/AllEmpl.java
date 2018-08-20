package controllers.emploees;

import dao.EmploeeDao;
import dto.JoinDto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AllEmpl", urlPatterns ="/allEmploees")
public class AllEmpl extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmploeeDao emploeeDao=new EmploeeDao();
        List<JoinDto> allEmploees = null;
        try {
            allEmploees = emploeeDao.getAllEmploees();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute( "emploees", allEmploees );

        RequestDispatcher dispatcher = request.getRequestDispatcher( "AllEmploee.jsp" );
        dispatcher.forward( request, response );
    }
}
