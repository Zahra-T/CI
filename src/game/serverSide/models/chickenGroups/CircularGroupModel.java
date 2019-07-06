package game.serverSide.models.chickenGroups;
import java.util.ArrayList;

import game.Location;
import game.Velocity;
import game.serverSide.controllers.chickens.CircularChickenController;
import game.serverSide.models.chickens.CircularChickenModel;
import Logger.Logger;
public class CircularGroupModel {
	private ArrayList<CircularChickenController> chickens;
	private Double angularFrequency;
	private Double radius;
	private Location center;
	private Velocity centerVelocity;
	private int remainingCenterStep;
	private int num;
	private int chickenLevel;
	private boolean start;
//	private AssetHolder assetHHolder;
	private transient Logger logger = Logger.getLogger();
	
	public CircularGroupModel(int num, int chickenLevel) {
		this.num = num;
		this.chickenLevel = chickenLevel;
	}

	public CircularChickenController get(int i) {
		// TODO Auto-generated method stub
		return chickens.get(i);
	}
	
}
