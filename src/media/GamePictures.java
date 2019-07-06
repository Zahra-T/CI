package media;

import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.util.HashMap;

import game.serverSide.models.weapons.BulletModel.BulletType;

public class GamePictures extends Loadable{

	private static GamePictures gamePictures;
	HashMap <String, Image> pictures;                           //enum

	public static GamePictures getInstance() throws IOException
	{
		if(gamePictures == null) {
			gamePictures = new GamePictures();
		}
		return gamePictures;
	}

	private GamePictures() throws IOException
	{
		initialize();
	}

	private void initialize() throws IOException
	{
		pictures = new HashMap();

		pictures.put("background", loadJPGImage("background"));

		pictures.put("startPanel", loadJPGImage("startPanel"));

		pictures.put("egg", loadPNGImage("egg"));

		pictures.put("coin", loadPNGImage("coin"));

		pictures.put("redBullet", loadPNGImage("redBullet"));

		pictures.put("yellowBullet", loadPNGImage("yellowBullet"));

		pictures.put("grayBullet", loadPNGImage("grayBullet"));

		pictures.put("redGift", loadPNGImage("redGift"));

		pictures.put("yellowGift", loadPNGImage("yellowGift"));

		pictures.put("grayGift", loadPNGImage("grayGift"));

		pictures.put("empowerer", loadPNGImage("empowerer"));

		pictures.put("chicken1", loadPNGImage("chicken1"));

		pictures.put("chicken2", loadPNGImage("chicken2"));

		pictures.put("chicken3", loadPNGImage("chicken3"));

		pictures.put("chicken4", loadPNGImage("chicken4"));

		pictures.put("giant1", loadPNGImage("giant1"));

		pictures.put("rocket", loadPNGImage("rocket"));

		pictures.put("redBullet", loadPNGImage("redBullet"));

		pictures.put("bombItem", loadPNGImage("BombItem"));

		pictures.put("leftDown", loadPNGImage("leftDown"));

		pictures.put("leftUp", loadPNGImage("leftUp"));

		pictures.put("userPanel", loadPNGImage("userPanel"));

		pictures.put("menuPanel", loadJPGImage("menuPanel"));



	}

	public Image get(String name)
	{
		return pictures.get(name);
	}
	
	public int getWidth(String name) {
		return pictures.get(name).getWidth(null);
	}

	public int getWidth(BulletType bulletType) {

		return pictures.get(bulletType.toString()).getWidth(null);
	}

	public int getHeight(String name) {
		return pictures.get(name).getHeight(null);
	}

	public int getHeight(BulletType bulletType) {
		return pictures.get(bulletType.toString()).getHeight(null);
	}


}

