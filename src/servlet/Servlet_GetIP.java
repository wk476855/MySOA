package servlet;

import com.demo.IPtoGeo.IPSeeker;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ERA on 2015/6/30.
 */
@WebServlet(name = "Servlet_GetIP")
public class Servlet_GetIP extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String IP;
        //Show IP
        IP=request.getRemoteAddr();
        // IP="202.108.22.5";//Baidu IP in Beijing      IP in SJTU is 202.120.38.22
        System.out.println(IP);
        //Seek IP
        IPSeeker iPSeeker =IPSeeker.getInstance();
        String realPosition=iPSeeker.getAddress(IP);
        System.out.println(realPosition);
        request.setAttribute("Position", realPosition);
        request.getRequestDispatcher("../jsp/baiduMap.jsp").forward(request, response);
    }
}
