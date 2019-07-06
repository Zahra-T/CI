package game.clientSide;

import game.clientSide.swing.MainFrame;
import game.clientSide.swing.GamePanel;

public class ClientMain {
	public static void main(String [] args) {
		Client simpleClient = new Client(
				"127.0.0.1",
				9090);
		simpleClient.start();
		MainFrame frame = new MainFrame();
		GamePanel panel = new GamePanel(simpleClient);
		panel.setVisible(true);
	}

}
