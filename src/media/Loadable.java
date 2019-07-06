package media;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Loadable {
	String directory = "C:\\Users\\Markazi.co\\workspace\\Chicken Invaders\\src\\game\\resources\\";
	
	
	public Image loadJPGImage(String name) throws IOException
	{
		Image image = ImageIO.read(new File(directory+name+".jpg"));
		return image;
	}
	
	public Image loadPNGImage(String name) throws IOException
	{
		Image image = ImageIO.read(new File(directory+name+".png"));
		return image;
	}
	
	public File loadWAVFile(String name) {
		File sound = new File(directory+name+".wav");
		return sound;
	}
}
