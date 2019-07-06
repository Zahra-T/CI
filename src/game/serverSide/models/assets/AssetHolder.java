package game.serverSide.models.assets;

import java.awt.Graphics2D;
import java.util.ArrayList;

import Logger.Logger;

public class AssetHolder {
	
	private ArrayList<EggModel> eggs;
	private ArrayList<EmpowererModel> empowerers;
	private ArrayList<TypeEmpowererModel> typeEmpowerers;
	private ArrayList<CoinModel> coins;
	private transient Logger logger = Logger.getLogger();
	
	public AssetHolder() {
		eggs = new ArrayList<EggModel>();
		empowerers = new ArrayList<EmpowererModel>();
		typeEmpowerers = new ArrayList<TypeEmpowererModel>();
		coins = new ArrayList<CoinModel>();
	}
	

	
}