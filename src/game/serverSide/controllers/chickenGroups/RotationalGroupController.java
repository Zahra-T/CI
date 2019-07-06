package game.serverSide.controllers.chickenGroups;

import game.serverSide.controllers.chickens.RotationalChickenController;
import game.serverSide.models.chickenGroups.RotationalGroupModel;

public class RotationalGroupController {
	RotationalGroupModel groupModel;
	public RotationalGroupController(int num, Integer...chickenLevels) {
		groupModel = new RotationalGroupModel(num, chickenLevels);
	}
	public RotationalChickenController get(int i) {
		// TODO Auto-generated method stub
		return groupModel.get(i);
	}

}
