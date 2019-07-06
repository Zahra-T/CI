package game.MessageHandler;

import java.util.Stack;

import game.serverSide.gameEngine.Game;

public class ClientMessageHandler extends Thread{
	Game game;
	Stack<ClientMessage> clientMessages;
	
	public ClientMessageHandler(Game game, Stack<ClientMessage> clientMessages) {
		this.clientMessages = clientMessages;
		this.game = game;
	}
	
	@Override 
	public void run() {
		while(true) {
			synchronized(clientMessages) {
				while(clientMessages.isEmpty()) {
					ClientMessage message = clientMessages.pop();
					handleMessage(message);
				}
			}
			
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	private synchronized void handleMessage(ClientMessage message) {
		switch(message.getType()) {
	
		case rightClick:{
			game.throwBomb();
			break;
		}
		case mousePressed:{
			game.setMousePressed(true);
			break;
		}
		case mouseReleased:{
			game.setMousePressed(false);
			break;
		}
		case mouseDragged:{
			if(game.rocketMoving()) {
				game.getRocket().setLocation(message.getLocation());
			}
			break;
		}
		case mouseMoved:{
			if(game.rocketMoving()) {
				game.getRocket().setLocation(message.getLocation());
			}
			break;
		}
		case ESCAPE:{
			game.pause();
			break;
		}

		}
		
	}

		

}
