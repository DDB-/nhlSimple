package Utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class HtmlUtils {

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
	
	public static String getPlayerImage(String html) {
		return null;
	}
}
