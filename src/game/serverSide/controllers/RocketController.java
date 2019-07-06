package game.serverSide.controllers;

import java.io.IOException;

import game.Location;
import game.Velocity;
import game.serverSide.controllers.weapons.BulletController;
import game.serverSide.gameEngine.AttackCoolDown;
import game.serverSide.gameEngine.Shelik;
import game.serverSide.gameEngine.TemperatureCoolDown;
import game.serverSide.models.RocketModel;
import game.serverSide.models.weapons.BulletModel.BulletType;
import media.GamePictures;
import media.GameSounds;
import media.SoundPlayer;

public class RocketController {
	private RocketModel rocketModel;

	public RocketController() {
		initialize();
	}

	public RocketController(Location location, BulletType bulletType) {
		rocketModel = new RocketModel();
		rocketModel.setLocation(location);
		rocketModel.setMoving(true);
		rocketModel.setBulletType(bulletType);
		initialize();
	}

	private void initialize() {
		rocketModel.setShelik(new Shelik());
		try {
			rocketModel.setWidth(GamePictures.getInstance().getWidth("rocket"));
			rocketModel.setHeight(GamePictures.getInstance().getHeight("rocket"));
			(new TemperatureCoolDown(this)).start();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public void shelik() {
		
			int r = 100;
			for (int i = 0; i < 5; i++) {
				double degree = (68 + i * 10) / 180.0 * Math.PI;
				rocketModel.addTir(new BulletController(new Location(rocketModel.getX()-30 + r * Math.cos(degree),
						rocketModel.getY()  -r * Math.sin(degree)),
						new Velocity(10 * Math.cos(degree),
						-10 * Math.sin(degree)) , rocketModel.getBulletType(), 1));
			}
			playGunSound();
			(new AttackCoolDown(this)).start();
			increaseTemp(8);
		
	}
	
	private void increaseTemp(int d) {
		rocketModel.increaseTemp(d);
	}
	public void playGunSound()
	{
		SoundPlayer soundPlayer = new SoundPlayer(GameSounds.getInstance().get("gun"));
	}
	

	public int getDecreaseCoolDown() {
		return rocketModel.getDecreaseCoolDown();
	}

	public void decreaseTemp(int i) {
		rocketModel.decreaseTemp(i);
	}

	public void setDecreaseCoolDown(int i) {
		rocketModel.setDecreaseCoolDown(i);
	}
	
	public boolean isShelik() {
		return rocketModel.isShelik();
	}

	public int getGamerID() {
		return rocketModel.getGamerID();
	}

	public boolean getMoving() {
		return rocketModel.getMoving();
	}

	public void setLocation(Location location) {
		rocketModel.setLocation(location);
	}

	public void setMousePresset(boolean b) {
		rocketModel.setMousePressed(b);
	}
	





}
