package main;

import Utils.HtmlUtils;

public class TesterOfShit {
	
	public static void main(String[] args) {
		String url = "http://www.nhl.com/ice/player.htm?id=8474564";
		String html = HtmlUtils.getHtmlContent(url);
		String imgLink = HtmlUtils.getPlayerImageUrl(html);
		HtmlUtils.downloadMugshot(imgLink);
	}
}
