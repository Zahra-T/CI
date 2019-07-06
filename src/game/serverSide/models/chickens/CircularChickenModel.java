package game.serverSide.models.chickens;

import game.Location;

import java.util.Random;

import Logger.Logger;

public class CircularChickenModel {
	private Location location;
	private Double angle;
	private int health;
	
	private transient Logger logger = Logger.getLogger();
}
