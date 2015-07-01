package servlet;


import com.demo.internet.HotMovieCrawler;
import com.demo.resource.HotMovie;
import com.demo.resource.MovieInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by HSS on 15/6/24.
 */
@WebServlet(name = "Servlet_HotMovies")
public class Servlet_HotMovies extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //  response.sendRedirect("../web/jsp/showMovies.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String lng=request.getParameter("lng");
        String lat=request.getParameter("lat");
        System.out.println(lat);
        System.out.println(lng);
        request.setAttribute("lng", lng);
        request.setAttribute("lat",lat);

        double Dlng=Double.valueOf(lng);
        double Dlat=Double.valueOf(lat);
        HotMovieCrawler hotMovieCrawler = new HotMovieCrawler();
        HotMovie hotMovie = hotMovieCrawler.getHotMovieByCity("shanghai");
        List<MovieInfo> movieInfos = hotMovie.getMovies();
        request.setAttribute("movies",movieInfos);
        request.getRequestDispatcher("../jsp/showMovies.jsp").forward(request,response);

    }
}
