package game.serverSide.models;
import Logger.Logger;
import game.serverSide.controllers.RocketController;
public class GamerModel {
	private int gamerID;
	private String userName;
	private int level = 1;
	private int health = 5;
	private int bomb = 3;
	private int coin = 0;
	private int score = 0;
	private transient Logger logger = Logger.getLogger();

	public GamerModel() {}
	public GamerModel(String userName) {
		this.userName = userName;
	}
	public int getID() {
		return gamerID;
	}
	public int getBombNum() {
		return bomb;
	}
	public void decreaseBomb() {
		bomb--;
	}


	

}
