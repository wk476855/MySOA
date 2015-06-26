package servlet;

import com.demo.IPtoGeo.BaiduGeo;
import com.demo.IPtoGeo.IPSeeker;
import com.demo.internet.BaiduPOI;
import com.demo.resource.Theater;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;

/**
 * Created by ERA on 2015/6/26.
 */
@WebServlet(name = "Servlet_Theaters")
public class Servlet_Theaters extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String IP;
        //Show IP
        //IP=request.getRemoteAddr();
        IP="202.108.22.5";//Baidu IP in Beijing      IP in SJTU is 202.120.38.22
        System.out.println(IP);
        //Seek IP
        IPSeeker iPSeeker =IPSeeker.getInstance();
        String realPosition=iPSeeker.getAddress(IP);
        System.out.println(realPosition);
        //BaiduGeo
        BaiduGeo baiduGeo=new BaiduGeo();
        Object[] o = baiduGeo.getCoordinate(realPosition);
        double lat=Double.valueOf(o[0].toString());
        double lng=Double.valueOf(o[1].toString());
        System.out.println(o[0]);//����
        System.out.println(o[1]);//γ��
        //
        List<Theater> tlist;
//        if(lat > 180 || lng > 180) {
//            return Response.serverError().entity("lat and lng is not correct!").build();
//        }
        tlist = BaiduPOI.getPOI(lat, lng);
        System.out.println(tlist.size());
       // GenericEntity<List<Theater>> entity = new GenericEntity<List<Theater>>(tlist) {};

        //
        request.setAttribute("Geo", realPosition);
        request.setAttribute("Theaters", tlist);
        request.getRequestDispatcher("../jsp/showTheaters.jsp").forward(request, response);


    }
}