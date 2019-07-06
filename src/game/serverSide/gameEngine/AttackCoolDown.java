package game.serverSide.gameEngine;

import game.serverSide.controllers.RocketController;

public class AttackCoolDown extends Thread{
	
	RocketController rocket;
	public AttackCoolDown(RocketController rocket)
	{
		this.rocket = rocket;

	}
	
	@Override public void run()
	{
		if(rocket.getDecreaseCoolDown() <= 0) {
			rocket.setDecreaseCoolDown(100);
			while(rocket.getDecreaseCoolDown() > 0) {
				rocket.setDecreaseCoolDown(rocket.getDecreaseCoolDown()-1);
//				attackCoolDown --;
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		else {
			rocket.setDecreaseCoolDown(100);
		}	
	}
	


}
