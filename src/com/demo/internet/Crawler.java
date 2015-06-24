package com.demo.internet;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class Crawler 
{
	public Document getDocument(String url)
	{
		Document document = null;
		try {
			document = Jsoup.connect(url).timeout(50000)
					.userAgent("Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)").get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return document;
	}
}
