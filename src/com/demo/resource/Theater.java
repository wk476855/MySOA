package com.demo.resource;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

/**
 * Created by wk on 2015/6/8.
 */
@XmlRootElement
public class Theater implements Serializable{
	private String name;
	private Location location;
	private String image;
	private String address;
	private String telephone;
	private String tag;
	private String uid;
	private String detail_url;
	private List<MovieInfo> movieInfos;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}


	public void setUid(String uid) {
		this.uid = uid;
	}

	public void setDetail_url(String detail_url) {
		this.detail_url = detail_url;
	}

	public String getUid() {
		return uid;
	}

	public List<MovieInfo> getMovieInfos() {
		return movieInfos;
	}

	public void setMovieInfos(List<MovieInfo> movieInfos) {
		this.movieInfos = movieInfos;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	static class Location {
		private double lat;
		private double lng;

		public double getLat() {
			return lat;
		}

		public void setLat(double lat) {
			this.lat = lat;
		}

		public double getLng() {
			return lng;
		}

		public void setLng(double lng) {
			this.lng = lng;
		}
	}
}
