package game.serverSide.models.chickenGroups;
import java.util.ArrayList;

import game.Location;
import game.serverSide.controllers.chickens.RotationalChickenController;
import game.serverSide.models.chickens.RotationalChickenModel;
public class RotationalGroupModel {
	
	private ArrayList<RotationalChickenController> chickens;
	private Double radius;
	private double newRadius;
	private double angularFrequency;
	private Location center;
	private boolean start;
	private boolean inPosition;
	private int num;
//	private AssetHolder assetHolder;
	
	public RotationalGroupModel() {}
	public RotationalGroupModel(int num, Integer...chickenLevels) {
		this.num = num;
		initialize(chickenLevels);
	}
	private void initialize(Integer[]chickenLevels) {
		
	}
	public RotationalChickenController get(int i) {
		// TODO Auto-generated method stub
		return chickens.get(i);
	}
}
