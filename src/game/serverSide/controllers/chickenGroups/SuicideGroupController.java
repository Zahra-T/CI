package game.serverSide.controllers.chickenGroups;

import game.serverSide.controllers.RocketController;
import game.serverSide.controllers.chickens.SuicideChickenController;
import game.serverSide.models.chickenGroups.SuicideGroupModel;

public class SuicideGroupController {

	SuicideGroupModel groupModel;
	public SuicideGroupController(int num, int chickenLevel, RocketController rocket) {
		groupModel = new SuicideGroupModel(num, chickenLevel, rocket);
	}
	public SuicideChickenController get(int i) {
		// TODO Auto-generated method stub
		return groupModel.get(i);
	}

}
