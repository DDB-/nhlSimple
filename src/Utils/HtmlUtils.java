package Utils;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.imageio.ImageIO;

import org.htmlparser.Parser;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.tags.ImageTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

public class HtmlUtils {
	
	public static final String IMG_REGEX_IN_URL = "/photos/mugs/";
	public static final String IMG_DIR			= "imgs/mugs/";

	/**
	 * Gets the HTML content of the specified URL string
	 * @param address - URL address in String form
	 * @return
	 */
	public static String getHtmlContent(String address) {
		try {
			URL url = new URL(address);
			URLConnection conn = url.openConnection();
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			StringBuffer sb = new StringBuffer();
			String inputLine;
			
			while((inputLine = reader.readLine()) != null){
				sb.append(inputLine);
				sb.append("\n");
			}
			reader.close();
			
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * This function gets the image of the player mugshot from NHL.com
	 * given the html of the of the player's page
	 * 
	 * @param htmlBody - HTML of player's page whose mughshot you want
	 * @return
	 */
	public static String getPlayerImageUrl(String htmlBody) {
		try {
			Parser parser = new Parser();
			parser.setInputHTML(htmlBody);
			NodeList imgList = parser.extractAllNodesThatMatch(new NodeClassFilter(ImageTag.class));
			
			for(int i = 0; i < imgList.size(); i++){
				ImageTag extracted = (ImageTag)imgList.elementAt(i);
				String extractedImgUrl = extracted.getImageURL();
				if(extractedImgUrl.contains(IMG_REGEX_IN_URL)) {
					System.out.println(extractedImgUrl);
					return extractedImgUrl;
				}
			}
		} catch (ParserException e) {
			e.printStackTrace();
			return null;
		}
		
		return null;
	}
	
	/**
	 * Given an image URL it will down
	 * @param imgLink
	 */
	public static void downloadMugshot(String imgLink) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new URL(imgLink));
			File outImg = new File(IMG_DIR, "steven-stamkos.jpg");
			outImg.createNewFile();
			ImageIO.write(img, "jpg", outImg);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}
