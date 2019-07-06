package game.serverSide.controllers.chickenGroups;

import game.serverSide.controllers.chickens.CircularChickenController;
import game.serverSide.models.chickenGroups.CircularGroupModel;

public class CircularGroupController {
	CircularGroupModel groupModel;
	public CircularGroupController(int num, int chickenLevel) {
		groupModel = new CircularGroupModel(num, chickenLevel);
	}
	public CircularChickenController get(int i) {
		// TODO Auto-generated method stub
		return groupModel.get(i);
	}
}
