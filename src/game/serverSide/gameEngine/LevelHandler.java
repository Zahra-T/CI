package game.serverSide.gameEngine;

import Logger.Logger;
import game.serverSide.controllers.GiantController;
import game.serverSide.controllers.chickenGroups.CircularGroupController;
import game.serverSide.controllers.chickenGroups.RectangularGroupController;
import game.serverSide.controllers.chickenGroups.RotationalGroupController;
import game.serverSide.controllers.chickenGroups.SuicideGroupController;

public class LevelHandler extends Thread{
	private int level;
	private Game game;
	private transient Logger logger = Logger.getLogger();
	public LevelHandler(Game game) {
		this.level = 1;
		this.game = game;
		addRectangularGroup(new RectangularGroupController(1, 5, 1));
	}

	@Override 
	public void run() {

		while(level != 20) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if(game.checkNextLevelTime()) {
				game.nextLevel();
			}
		}
	}

	public void nextLevel() {
		this.level++;
		if(level == 2) {
			logger.debug(2+"");
			RectangularGroupController c = new RectangularGroupController(3, 5, 1);
			addRectangularGroup(c);
		}
		else if(level == 3) {
			logger.debug(3+"");
			CircularGroupController c = new CircularGroupController(20, 1);
			addCircularGroup(c);
		}
		else if(level == 4) {
			logger.debug(4+"");
			RotationalGroupController c = new RotationalGroupController(15, 1, 1, 1);
			addRotationalGroup(c);
		}
		else if(level == 5) {
			logger.debug(5+"");
			GiantController g = new GiantController(1);
			addGiant(g);
		}
		else if(level == 6) {
			logger.debug(6+"");
			RectangularGroupController c = new RectangularGroupController(4, 6, 1);
			addRectangularGroup(c);
		}
		else if(level == 7) {
			CircularGroupController c = new CircularGroupController(25, 2);
			addCircularGroup(c);
		}
		else if(level == 8) {
			SuicideGroupController c = new SuicideGroupController(30, 2, game.getRocket());
			addSuicideGroup(c);
		}
		else if(level == 9) {
			RotationalGroupController c = new RotationalGroupController(15, 2, 1, 2);
			addRotationalGroup(c);
		}
		else if(level == 10) {
			GiantController g = new GiantController(2);
			addGiant(g);
		}
		else if(level == 11) {
			RectangularGroupController c = new RectangularGroupController(5, 7, 3);
			addRectangularGroup(c);
		}
		else if(level == 12) {
			SuicideGroupController c = new SuicideGroupController(40, 3, game.getRocket());
			addSuicideGroup(c);
		}
		else if(level == 13) {
			RotationalGroupController c = new RotationalGroupController(15, 2, 3, 1);
			addRotationalGroup(c);
		}
		else if(level == 14) {
			CircularGroupController c1 = new CircularGroupController(25, 3);
			addCircularGroup(c1);
			CircularGroupController c2 = new CircularGroupController(20, 2);
			addCircularGroup(c2);
		}
		else if(level == 15)
		{
			GiantController g = new GiantController(3);
			addGiant(g);
		}
		else if(level == 16) {
			RectangularGroupController c = new RectangularGroupController(5, 8, 4);
			addRectangularGroup(c);
		}
		else if(level == 17) {
			RectangularGroupController c1 = new RectangularGroupController(5, 8, 4);
			addRectangularGroup(c1);
			SuicideGroupController c2 = new SuicideGroupController(30, 30, game.getRocket());
			addSuicideGroup(c2);
		}
		else if(level == 18) {
			RotationalGroupController c = new RotationalGroupController(15,3,4,2);
			addRotationalGroup(c);
		}
		else if(level == 19) {
			SuicideGroupController c = new SuicideGroupController(50, 4, game.getRocket());
			addSuicideGroup(c);
		}
		else if(level == 20) {
			GiantController g = new GiantController(4);
			addGiant(g);
		}
		logger.debug("game.start called");
		game.start();

	}
	public void addRectangularGroup(RectangularGroupController c){
		synchronized(game.getRectangularGroups()) {
			game.addRectangularGroup(c);
		}
	}
	
	public void addCircularGroup(CircularGroupController c) {
		synchronized(game.getCircularGroups()) {
			game.addCircularGroup(c);
		}
	}
	
	public void addRotationalGroup(RotationalGroupController c) {
		synchronized(game.getRotationalGroups()) {
			game.addRotationalGroup(c);
		}
	}
	
	public void addSuicideGroup(SuicideGroupController c) {
		synchronized(game.getSuicideGroups()) {
			game.addSuicideGroup(c);
		}
	}


	public void addGiant(GiantController g) {
		
			game.addGiant(g);
			logger.debug("giant added");
	}


}
