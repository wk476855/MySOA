package com.demo.resource;

import com.demo.internet.BaiduPOI;
import com.demo.internet.POIDetails;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by wk on 2015/6/8.
 */
@Path("/theater")
public class TheaterResource {

	@Path("/getTheaterNearby")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Response getTheaterNearby(@DefaultValue("360")@QueryParam("lat")double lat, @DefaultValue("360")@QueryParam("lng")double lng) {
		List<Theater> tlist;
		if(lat > 180 || lng > 180) {
			return Response.serverError().entity("lat and lng is not correct!").build();
		}
		tlist = BaiduPOI.getPOI(lat, lng);
		System.out.println(tlist.size());
		GenericEntity<List<Theater>> entity = new GenericEntity<List<Theater>>(tlist) {};
		Response response = Response.ok(entity).build();
		return response;
	}

	@Path("/getTheaterDetails")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Response getTheaterDetails(@DefaultValue("")@QueryParam("uid")String uid) {
		if(uid.equals("")) {
//			return Response.serverError().entity("need uid!!!").build();
		}
		Theater theater = POIDetails.getTheaterDetails(uid);
		GenericEntity<Theater> entity = new GenericEntity<Theater>(theater) {};
		Response response = Response.ok(entity).build();
		return response;
	}
}
