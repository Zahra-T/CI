package game.serverSide.gameEngine;

import game.serverSide.controllers.RocketController;

public class TemperatureCoolDown extends Thread{
	
	RocketController rocket;
	public TemperatureCoolDown(RocketController rocket) throws InterruptedException
	{
		this.rocket = rocket;

	}
	
	@Override
	public void run()
	{
		while(true)
		{
			while(rocket.getDecreaseCoolDown() <= 0)
			{
				rocket.decreaseTemp(1);
				try {
					sleep(40);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			try {
				sleep(40);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	

}
