package game.serverSide.controllers.weapons;

import java.io.IOException;

import game.Location;
import game.Velocity;
import game.serverSide.gameEngine.TemperatureCoolDown;
import game.serverSide.models.weapons.BulletModel;
import game.serverSide.models.weapons.BulletModel.BulletType;
import media.GamePictures;

public class BulletController {
	BulletModel bulletModel;
	
	public BulletController() {
	}

	public BulletController(Location location, Velocity velocity,BulletType bulletType, int power) {
		bulletModel = new BulletModel(location, velocity, bulletType, power);
		initialize();
	}
	
	private void initialize() {
				
		try {
			bulletModel.setWidth(GamePictures.getInstance().getWidth(bulletModel.getType()));
			bulletModel.setHeight(GamePictures.getInstance().getHeight(bulletModel.getType()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void move() {
		bulletModel.move();
	}
	
	public double getX() {
		return bulletModel.getX();
	}
	
	public double getY() {
		return bulletModel.getY();
	}
	
	public int getWidth() {
		return bulletModel.getWidth();
	}
	
	public int getHeight() {
		return bulletModel.getHeight();
	}
	
	public int getPower() {
		return bulletModel.getPower();
	}
	
	
}
