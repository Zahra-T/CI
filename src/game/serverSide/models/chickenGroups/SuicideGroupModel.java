package game.serverSide.models.chickenGroups;
import java.util.ArrayList;
import java.util.Random;

import game.serverSide.controllers.RocketController;
import game.serverSide.controllers.chickens.SuicideChickenController;
import game.serverSide.models.chickens.SuicideChickenModel;
public class SuicideGroupModel {
	
	ArrayList<RocketController> rockets;
	ArrayList<SuicideChickenController> chickens;
	
	public SuicideGroupModel() {
		initialize();
	}
	public SuicideGroupModel(int num, int chickenLevel) {
		this.num = num;
		this.chickenLevel = chickenLevel;
		initialize();
		
	}
	private void initialize() {
		
	}
	
	private int num;
	private int chickenLevel;
	private long previousTime;
	private long lastAttack;
	private boolean start;
	private transient Random random = new Random();

	public SuicideChickenController get(int i) {
		// TODO Auto-generated method stub
		return chickens.get(i);
	}
	
//	private transient Rocket rocket;
//	private AssetHolder assetHolder;
}
