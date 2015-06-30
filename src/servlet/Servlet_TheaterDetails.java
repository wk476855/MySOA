package servlet;

import com.demo.internet.POIDetails;
import com.demo.resource.Theater;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ERA on 2015/6/30.
 */
@WebServlet(name = "Servlet_TheaterDetails")
public class Servlet_TheaterDetails extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uid = request.getParameter("uid");
        Theater theater = POIDetails.getTheaterDetails(uid);
        request.setAttribute("theater",theater);
        request.getRequestDispatcher("../jsp/showTheaterDetails.jsp").forward(request, response);

        System.out.println(uid);

    }
}
