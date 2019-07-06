package game.serverSide.controllers;

import game.serverSide.models.GamerModel;

public class GamerController {
	GamerModel gamerModel;
	public GamerController(String userName) {
		gamerModel = new GamerModel(userName);
		initialize();
	}
	
	private void initialize() {
		
	}

	public int getID() {
		return gamerModel.getID();
	}

	public int getBombNum() {
		return gamerModel.getBombNum();
	}

	public void decreaseBomb() {
		gamerModel.decreaseBomb();
	}


}
