package com.demo.resource;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlRootElement
public class HotMovie implements Serializable{
	private String city;
	private List<MovieInfo> movies;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}


	public List<MovieInfo> getMovies() {
		return movies;
	}

	public void setMovies(List<MovieInfo> movies) {
		this.movies = movies;
	}
}
