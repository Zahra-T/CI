package game.serverSide.gameEngine;

import java.util.ArrayList;

import Logger.Logger;
import game.Location;
import game.serverSide.controllers.GamerController;
import game.serverSide.controllers.GiantController;
import game.serverSide.controllers.RocketController;
import game.serverSide.controllers.chickenGroups.CircularGroupController;
import game.serverSide.controllers.chickenGroups.RectangularGroupController;
import game.serverSide.controllers.chickenGroups.RotationalGroupController;
import game.serverSide.controllers.chickenGroups.SuicideGroupController;
import game.serverSide.controllers.chickens.RectangularChickenController;
import game.serverSide.controllers.chickens.CircularChickenController;
import game.serverSide.controllers.chickens.RotationalChickenController;
import game.serverSide.controllers.chickens.SuicideChickenController;

import game.serverSide.controllers.weapons.BombController;
import game.serverSide.controllers.weapons.BulletController;
import game.serverSide.models.GiantModel;


public class Game {

	static ArrayList<GamerController> gamers = new ArrayList<GamerController>();
	static ArrayList<RocketController> rockets = new ArrayList<RocketController>();
	static ArrayList<RectangularGroupController> rectangularGroups = new ArrayList<RectangularGroupController> ();
	static ArrayList<CircularGroupController> circularGroups = new ArrayList<CircularGroupController>();
	static ArrayList<RotationalGroupController> rotationalGroups = new ArrayList<RotationalGroupController>();
	static ArrayList<SuicideGroupController> suicideGroups = new ArrayList<SuicideGroupController>();
	static GiantController giant;
	static transient LevelHandler levelHandler;
	static int level;
	static transient boolean running = true;

	GamerController gamer;
	RocketController rocket;
	ArrayList<BulletController> rocketTirs;
	ArrayList<BombController> bombs;


	public Game() {}

	public Game(GamerController gamer) {
		this.gamer = gamer;
	}

	private transient Logger logger = Logger.getLogger();

	public boolean rocketMoving() {
		return rocket.getMoving();
	}

	public RocketController getRocket() {
		return rocket;
	}

	public void throwBomb() {
		if(gamer.getBombNum()>0) {
			gamer.decreaseBomb();
			synchronized(bombs) {
				bombs.add(new BombController());
			}
		}
	}

	public void killEnemy() {
		synchronized(rocketTirs) {

			for(int i = 0; i<rocketTirs.size(); i++) {
				BulletController tir = rocketTirs.get(i);
				synchronized(tir) {
					synchronized(rectangularGroups) {
						for(int k = 0; k<rectangularGroups.size(); k++) {
							RectangularGroupController c = rectangularGroups.get(k);
							synchronized(c) {
								for(int j = 0; j<c.size(); j++) {
									RectangularChickenController chicken = c.get(j);
									synchronized(chicken) {
										if(isStriked(tir, chicken))
										{
											chicken.decreaseHealth(tir.getPower());
											if(chicken.getHealth()<=0)
											{
												c.addAssets(chicken.getChickenLevel(),new Location(chicken.getX(), chicken.getY()));
												c.remove(chicken);
												
											}
											//											synchronized(rocket.getTirs()) {
											rocket.getTirs().remove(tir);
											//											}
										}
									}
								}
							}

						}
					}
					synchronized(circularGroups) {
						for(int k = 0; k<circularGroups.size(); k++) {
							CircularGroupController c = circularGroups.get(k);
							synchronized(c) {
								for(int j = 0; j<c.size(); j++) {
									CircularChickenController chicken= c.get(j);
									synchronized(chicken) {
										if(doesStrike(tir, chicken))
										{
											chicken.decreaseHealth(tir.getPower());
											if(chicken.getHealth()<=0)
											{
												c.addAssets(chicken.getChickenLevel(),new Location(chicken.getX(), chicken.getY()));
												c.remove(chicken);
												
											}
											//											synchronized(rocket.getTirs()) {
											rocket.getTirs().remove(tir);
											//											}
										}
									}
								}

							}

						}

					}
					synchronized(rotationalGroups) {
						for(int k = 0; k<rotationalGroups.size(); k++) {
							RotationalGroupController c = rotationalGroups.get(k);
							synchronized(c) {
								for(int j = 0; j<c.size(); j++) {
									RotationalChickenController chicken= c.get(j);
									synchronized(chicken) {
										if(doesStrike(tir, chicken))
										{
											chicken.decreaseHealth(tir.getPower());
											if(chicken.getHealth()<=0)
											{
												c.addAssets(chicken.getChickenLevel(),new Location(chicken.getX(), chicken.getY()));
												c.remove(chicken);
												
											}
											//											synchronized(rocket.getTirs()) {
											rocket.getTirs().remove(tir);
											//											}
										}
									}
								}
							}
						}

					}
					synchronized(suicideGroups) {
						for(int k = 0; k<suicideGroups.size(); k++) {
							SuicideGroupController c = suicideGroups.get(k);
							synchronized(c) {
								for(int j = 0; j<c.size(); j++) {
									SuicideChickenController chicken= c.get(j);
									synchronized(chicken) {
										if(doesStrike(tir, chicken))
										{
											chicken.decreaseHealth(tir.getPower());
											if(chicken.getHealth()<=0)
											{
												c.addAssets(chicken.getChickenLevel(),new Location(chicken.getX(), chicken.getY()));
												c.remove(chicken);
												
											}
											//											synchronized(rocket.getTirs()) {
											rocket.getTirs().remove(tir);
											//											}
										}
									}
								}
							}

						}
					}
					if(giant != null && isStrikedGiant(tir, giant)) {
						giant.decreaseHealth(tir, tir.getPower());
					}
				}
			}
		}
	}




	public void setMousePressed(boolean b) {
		rocket.setMousePresset(b);
	}

	public ArrayList<RectangularGroupController> getRectangularGroups() {
		return rectangularGroups;
	}

	public ArrayList<CircularGroupController> getCircularGroups() {
		return circularGroups;
	}

	public ArrayList<RotationalGroupController> getRotationalGroups(){
		return rotationalGroups;
	}

	public ArrayList<SuicideGroupController> getSuicideGroups(){
		return suicideGroups;
	}

	public void addRectangularGroup(RectangularGroupController c) {
		rectangularGroups.add(c);
	}

	public void addCircularGroup(CircularGroupController c) {
		circularGroups.add(c);
	}

	public void addRotationalGroup(RotationalGroupController c) {
		rotationalGroups.add(c);
	}

	public void addSuicideGroup(SuicideGroupController c) {
		suicideGroups.add(c);
	}


	public void addGiant(GiantController g) {
		this.giant = g;
	}

	public static boolean isRunning() {
		return running;
	}

	public static void setRunning(boolean b) {
		running = b;
	}




}
