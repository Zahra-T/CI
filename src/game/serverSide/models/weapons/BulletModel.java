package game.serverSide.models.weapons;

import game.Location;
import game.Velocity;

public class BulletModel {
	private int gamerID;
	private BulletType bulletType;
	private Location location;
	private Velocity velocity;
	private int power;
	private int width;
	private int height;
	//enum type;
	
	public enum BulletType{
		redBullet, yellowBullet, grayBullet;
	}
	
    public BulletModel(Location location, Velocity velocity, BulletType bulletType,int power) {
       this.location = location;
       this.velocity = velocity;
       this.bulletType = bulletType; 
       this.power = power;
    }

    public void move() {
    	location.x += velocity.getVx();
    	location.y += velocity.getVy();
    }
    
	public BulletType getType() {
		return bulletType;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}

	public double getX() {
		return location.getX();
	}
	
	public double getY() {
		return location.getY();
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getPower() {
		return power;
	}
}
