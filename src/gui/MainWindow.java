package gui;

import javax.swing.JFrame;

public class MainWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2740437090361841747L;
	private static final String TITLE = "ChessTempest";
	
	public MainWindow(ChessBoardComponent view) {
		this.add(view);
		init();
	}
	

	private void init() {
		this.setTitle(MainWindow.TITLE);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		this.setVisible(true);
	}
	

}
