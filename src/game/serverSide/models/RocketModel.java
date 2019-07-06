package game.serverSide.models;
import game.Location;
import game.serverSide.controllers.weapons.BulletController;
import game.serverSide.gameEngine.LockShelik;
import game.serverSide.gameEngine.Shelik;
import game.serverSide.models.weapons.BulletModel.BulletType;

import java.util.ArrayList;

import Logger.Logger;

public class RocketModel {
	
	private int gamerID;
	private Location location;
	private boolean moving;
	private Integer decreaseCoolDown;
	private Integer temperature;
	private int maxTemp;
	private transient Shelik shelik;
	private int width;
	private int height;
	private BulletType bulletType;
	private ArrayList<BulletController> tirs;
	private transient Logger logger = Logger.getLogger();

	public void setLocation(Location location) {
		this.location = location;
	}

	public void setShelikLock(boolean b) {
		shelik.setLock(b);
	}

	public void setMoving(boolean b) {
		this.moving = b;
	}

	public void setShelik(Shelik shelik) {
		this.shelik = shelik;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void decreaseTemp(int i) {
		synchronized(temperature)
		{
			if(temperature > 0)
			{
				if(temperature - i < 0)
				{
					temperature = 0;
				}
				else
				{
					temperature -= i;
				}
			}
		}
	}

	public ArrayList<BulletController> getTirs() {
		return tirs;
	}

	public void addTir(BulletController bullet) {
		synchronized(tirs) {
			tirs.add(bullet);
		}
	}

	public double getX() {
		return location.getX();
	}
	
	public double getY() {
		return location.getY();
	}

	public BulletType getBulletType() {
		return bulletType;
	}
	
	public void setBulletType(BulletType bulletType) {
		this.bulletType = bulletType;
	}

	public void setDecreaseCoolDown(int i) {
		synchronized(decreaseCoolDown)
		{
			decreaseCoolDown = i;
		}
	}

	public int getDecreaseCoolDown() {
		return decreaseCoolDown;
	}

	public void increaseTemp(int d) {
		synchronized(temperature)
		{
			if(temperature < maxTemp)
			{
				if(temperature + d > maxTemp)
				{
					temperature = maxTemp;
					//Over Heat
					(new LockShelik(this)).start();

				}
				else
				{
					temperature += d;
				}
			}
		}

	}

	public boolean isShelik() {
		return shelik.isMousePress() && !shelik.isLock();
	}

	public int getGamerID() {
		return gamerID;
	}

	public boolean getMoving() {
		return moving;
	}

	public void setMousePressed(boolean b) {
		shelik.setMousePress(b);
	}
	
}
