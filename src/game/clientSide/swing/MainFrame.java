package game.clientSide.swing;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

	public MainFrame(){
		initialize();
	}
	
	private void initialize() {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setResizable(false);
		pack();
		setVisible(true);
	}
}
