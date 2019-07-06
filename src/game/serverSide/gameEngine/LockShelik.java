package game.serverSide.gameEngine;

import game.serverSide.controllers.RocketController;
import game.serverSide.models.RocketModel;

public class LockShelik extends Thread{
	private transient RocketModel rocket;
	
	public LockShelik(RocketModel rocket) {
		this.rocket = rocket;
	}
	
	@Override
	public void run() {
		setShelikLock(true);
		try {
			sleep(4000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		setShelikLock(false);
	}
	
	private void setShelikLock(boolean b) {
		rocket.setShelikLock(b);
	}
	
	

}
