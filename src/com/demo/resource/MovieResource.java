package com.demo.resource;

import com.demo.internet.HotMovieCrawler;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by wk on 2015/6/1.
 */
@Path("/movies")
public class MovieResource {

	@Path("/getHotMovie")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Response getHotMovie( @DefaultValue("shanghai")@QueryParam("city")String city) {
		HotMovieCrawler hotMovieCrawler = new HotMovieCrawler();
		HotMovie hotMovie = hotMovieCrawler.getHotMovieByCity(city);
		List<MovieInfo> movieInfos = hotMovie.getMovies();
		GenericEntity<List<MovieInfo>> entity = new GenericEntity<List<MovieInfo>>(movieInfos) {};
		Response response = Response.ok(entity).build();
		return response;
	}
}
