package game.serverSide.controllers.chickenGroups;

import game.serverSide.controllers.chickens.RectangularChickenController;
import game.serverSide.models.chickenGroups.RectangularGroupModel;

public class RectangularGroupController {
	RectangularGroupModel groupModel;
	
	public RectangularGroupController(int row, int column, int chickenLevel) {
		groupModel = new RectangularGroupModel(row, column, chickenLevel);
		
	}

	public RectangularChickenController get(int i) {
		// TODO Auto-generated method stub
		return groupModel.get(i);
	}

}
