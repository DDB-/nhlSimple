package htmlUtils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;

public class FileDownloader {
	
	public static final String IMG_DIR			= "imgs/mugs/";
	
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
