package game.serverSide.gameEngine;

public class GameLoop extends Thread{
	Game game;

	public GameLoop(Game game) {
		this.game = game;
	}

	
	@Override
	public void run() {
		while(true) {
			if(game.isRunning()) {
				game.move();
				game.kill();
				game.removeOutTirs();
				
				

			}
			try {
				Thread.sleep(40);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
		}
		
	}

}
