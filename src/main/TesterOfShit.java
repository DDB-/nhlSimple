package main;

import htmlUtils.FileDownloader;
import htmlUtils.HtmlExtractor;

public class TesterOfShit {
	
	public static void main(String[] args) {
		String url = "http://www.nhl.com/ice/player.htm?id=8474564";
		String html = HtmlExtractor.getHtmlContent(url);
		String imgLink = HtmlExtractor.getPlayerImageUrl(html);
		FileDownloader.downloadMugshot(imgLink);
		HtmlExtractor.extractPlayerInfo(html);
	}
}
