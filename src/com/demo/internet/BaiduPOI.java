package com.demo.internet;

import com.demo.resource.Theater;
import com.demo.resource.Theaters;
import com.google.gson.Gson;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wk on 2015/6/8.
 */
public class BaiduPOI {

	private static final String BAIDU_MAP_POI = "http://api.map.baidu.com";
	private static final int RADIUS = 10000;
	private static final String KEY_WORD = "电影院";

	public static List<Theater> getPOI(double lat, double lng) {
		String location = lat + "," + lng;
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(BAIDU_MAP_POI).path("place").path("search").queryParam("query", KEY_WORD).queryParam("location", "31.023722,121.437416")
				.queryParam("radius", RADIUS).queryParam("output", "json");
		Response response = target.request(MediaType.APPLICATION_JSON).get();
		String result = response.readEntity(String.class);
		Theaters theaters = new Gson().fromJson(result, Theaters.class);
		if(theaters.getStatus().equals("OK")) {
			return theaters.getResults();
		}
		return new ArrayList<Theater>();
	}
}
