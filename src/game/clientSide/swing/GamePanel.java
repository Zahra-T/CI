package game.clientSide.swing;

import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import game.Location;
import game.clientSide.Client;

public class GamePanel extends JPanel{
	Client client;
	
	public GamePanel(Client client) {
		this.client = client;
		initialize();
	}

	private void initialize() {
		setFocusable(true);
		requestFocusInWindow();
		addMouseMotionListener();
		addMouseListener();
	}

	private void addMouseMotionListener() {
		addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseDragged(MouseEvent e) {
				if(client.isMoving()) {
					client.sendInfo("rocket", new Location(e.getX(), e.getY()));
				}

			}

			@Override
			public void mouseMoved(MouseEvent e) {
				if(client.isMoving()) {
					client.sendInfo("rocket", new Location(e.getX(), e.getY()));
				}
			}
		});
	}

	private void addMouseListener() {
		addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//				gamer.shelik();

				if (e.getModifiers() == MouseEvent.BUTTON3_MASK)
				{
					try {
						client.throwBomb();
					} catch (IOException | InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}

	
			@Override
			public void mousePressed(MouseEvent e) {

				int modifiers = e.getModifiers();
				if ((modifiers & InputEvent.BUTTON1_MASK) == InputEvent.BUTTON1_MASK) {
					gamer.getRocket().getShelik().setMousePress(true);

				}


			}

			@Override
			public void mouseReleased(MouseEvent e) {
				gamer.getRocket().getShelik().setMousePress(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}
		});
	}

}
