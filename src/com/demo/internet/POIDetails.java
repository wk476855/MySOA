package com.demo.internet;

import com.demo.resource.MovieInfo;
import com.demo.resource.Theater;
import com.demo.resource.TimeTable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wk on 2015/6/22.
 */
public class POIDetails {

	private static final String POI_DETAILS_HOST = "http://map.baidu.com/detail";

	public static Theater getTheaterDetails(String uid) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(POI_DETAILS_HOST).queryParam("qt", "ninf").queryParam("uid", uid);
		Response response = target.request(MediaType.APPLICATION_JSON).get();
		String result = response.readEntity(String.class);
//		System.out.println("result: " + result);
		Theater theater = new Theater();
		try {
			JSONObject jsonObject = new JSONObject(result);
			JSONObject content, ext, other_info, detail_info;
			JSONArray base, time_table;
			if(jsonObject.has("content")) {
				content = jsonObject.getJSONObject("content");
				if(content.has("ext")) {
					ext = content.getJSONObject("ext");
					if(ext.has("detail_info")) {
						detail_info = ext.getJSONObject("detail_info");
						theater.setTag(detail_info.getString("tag"));
						theater.setAddress(detail_info.getString("poi_address"));
						theater.setName(detail_info.getString("name"));
						theater.setUid(uid);
						theater.setTelephone(detail_info.getString("phone"));
						theater.setImage("http://pcsv0.map.bdimg.com/pr/?qt=poiprv&uid="+uid+"&width=200&height=180&quality=80&fovx=80");
					}
					other_info = ext.getJSONObject("other_info");
					base = other_info.getJSONArray("base");
					time_table = other_info.getJSONArray("time_table");
					Map<String, List<TimeTable>> map = null;
					if(time_table.length() > 0) {
						map = new HashMap<String, List<TimeTable>>();
						for (int i = 0; i < time_table.length(); i++) {
							JSONArray ja = time_table.getJSONArray(i);
							for(int j = 0; j < ja.length(); j++) {
								TimeTable t = new TimeTable();
								JSONObject a = ja.getJSONObject(j);
								String movieId = a.getString("movie_id");
								t.setTime(a.getString("time"));
								t.setDate(a.getString("date"));
								t.setLan(a.getString("lan"));
								t.setTheater(a.getString("theater"));
								t.setPrice(a.getDouble("origin_price"));
								t.setType(a.getString("type"));
								if (map.containsKey(movieId)) {
									map.get(movieId).add(t);
								} else {
									List<TimeTable> timeTables = new ArrayList<TimeTable>();
									timeTables.add(t);
									map.put(movieId, timeTables);
								}
							}
						}
					}
					if (base.length() > 0) {
						List<MovieInfo> movieInfos = new ArrayList<MovieInfo>();
						for (int i = 0; i < base.length(); i++) {
							JSONObject a = base.getJSONObject(i);
							MovieInfo movieInfo = new MovieInfo();
							movieInfo.setActor(a.getString("movie_starring"));
							movieInfo.setBrief(a.getString("movie_description"));
							movieInfo.setDirector(a.getString("movie_director"));
							movieInfo.setName(a.getString("movie_name"));
							movieInfo.setPicture(a.getString("movie_picture"));
							movieInfo.setRelease_date(a.getString("movie_release_date"));
							movieInfo.setScore(a.getString("movie_score"));
							movieInfo.setTag(a.getString("movie_type"));
							movieInfo.setTime(a.getString("movie_length"));
							movieInfo.setType(a.getString("movie_tags"));
							if(a.has("movie_id")) {
								String id = a.getString("movie_id");
								if(map != null && map.containsKey(id)) {
									movieInfo.setTimeTables(map.get(id));
								}
							}
							movieInfos.add(movieInfo);
						}
						theater.setMovieInfos(movieInfos);
					}
				}
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return theater;
	}


}
