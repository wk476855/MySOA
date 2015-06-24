package com.demo.internet;

import com.demo.resource.HotMovie;
import com.demo.resource.MovieInfo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class HotMovieCrawler
{
	private HotMovie hotMovie;
	
	public HotMovieCrawler()
	{
		hotMovie = new HotMovie();
	}
	
	private String getCityCode(String city)
	{
		HttpURLConnection connection = null;
		URL url = null;
		try 
		{
			url = new URL("http://t.dianping.com/movie/" + city);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
			connection.connect();
			String cityCode = connection.getHeaderFields().get("Set-Cookie").get(1).split(";")[0].split("=")[1];
			return cityCode;
		}catch (IOException e) {
			throw new RuntimeException(e);
		}finally {
			if(connection != null)
				connection.disconnect();
		}
	}
	
	public Document getDocument(String url,String city)
	{
		Document document = null;
		try 
		{
			String code = getCityCode(city);
			document = Jsoup.connect(url).timeout(50000).cookie("cy", code)
					.userAgent("Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)").get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return document;
	}
	
	public HotMovie getHotMovieByCity(String city)
	{
		hotMovie.setCity(city);
		String url = "http://t.dianping.com/movie/" + city + "/playing";
		List<MovieInfo> movies = new ArrayList<MovieInfo>();
		movies.addAll(getHotMovieByURL(url,city));
		Document document = getDocument(url,city);
		Element element = document.select(".list").select(".Pages").get(0);
		Elements elements = element.select(".PageLink");
		for(Element e : elements)
		{
			movies.addAll(getHotMovieByURL(url + e.attr("href"),city));
		}
		hotMovie.setMovies(movies);
		writeToDb(hotMovie);
		return hotMovie;
	}
	
	private List<MovieInfo> getHotMovieByURL(String url,String city)
	{
		List<MovieInfo> movies = new ArrayList<MovieInfo>();
		Document document = getDocument(url,city);
		Elements elements = document.select(".list-item");
		for(Element element : elements)
		{
			MovieInfo movieInfo = new MovieInfo();
			movieInfo.setPicture(element.select("img").attr("src"));
			movieInfo.setName(element.select(".title").select(".text").text());
			movieInfo.setTag(element.select(".tags").select(".threed").text());
			movieInfo.setScore(element.select(".score").text().substring(3));
			movieInfo.setBrief(element.select(".story-tip").select(".bg").text());
			Elements el = element.select(".cat");
			for(Element e : el)
			{
				String str = e.parent().text().substring(e.text().length());
				if(e.text().contains("导演"))
					movieInfo.setDirector(str);
				if(e.text().contains("主演"))
					movieInfo.setActor(str);
				if(e.text().contains("类型"))
					movieInfo.setType(str);
				if(e.text().contains("语言/片长"))
					movieInfo.setTime(str);
				if(e.text().contains("上映时间"))
					movieInfo.setRelease_date(str);
			}
//			movieInfo.setPrice(element.select(".price").select(".pc").text());
			movies.add(movieInfo);
		}
		return movies;
	}
	
	public void writeToDb(HotMovie hotMovie)
	{
		System.out.println(hotMovie.getCity());
		System.out.println(hotMovie.getMovies().size());
		for(MovieInfo movieInfo : hotMovie.getMovies())
		{
			System.out.println(movieInfo.getName());
			System.out.println(movieInfo.getPicture());
			System.out.println(movieInfo.getTag());
			System.out.println(movieInfo.getScore());
			System.out.println(movieInfo.getBrief());
			System.out.println(movieInfo.getDirector());
			System.out.println(movieInfo.getActor());
			System.out.println(movieInfo.getType());
			System.out.println(movieInfo.getTime());
			System.out.println(movieInfo.getRelease_date());
//			System.out.println(movieInfo.getPrice());
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HotMovieCrawler hotMovieCrawler = new HotMovieCrawler();
		hotMovieCrawler.getHotMovieByCity("shanghai");
	}
}
