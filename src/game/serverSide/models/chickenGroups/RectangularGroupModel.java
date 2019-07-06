package game.serverSide.models.chickenGroups;
import java.util.ArrayList;

import game.serverSide.controllers.chickens.RectangularChickenController;
import game.serverSide.models.assets.AssetHolder;
import game.serverSide.models.chickens.RectangularChickenModel;

public class RectangularGroupModel {
	private ArrayList<RectangularChickenController> chickens;
	private int chickenLevel;
	private int row, column;
	private int step;
	private transient Thread comeInThread;
	private transient Thread velocityHandler;
	private AssetHolder assetHolder;
//	private AssetHolder assetHolder;
	public RectangularGroupModel() {
	}
	public RectangularGroupModel(int row, int column, int chickenLevel) {
		this.chickenLevel = chickenLevel;
		this.row = row;
		this.column = column;
		initialize();
	}
	private void initialize() {
		this.step = 10;
		chickens = new ArrayList();
		assetHolder = new AssetHolder();
	}
	public RectangularChickenController get(int i) {
		// TODO Auto-generated method stub
		return chickens.get(i);
	}
	

}
