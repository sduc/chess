package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2740437090361841747L;
	private static final String TITLE = "ChessTempest";
	
	private static final int MIN_H_SZ = 600;
	private static final int MIN_V_SZ = 500;
	
	private static final int SMALL_SZ = 400;
	private static final int MEDIUM_SZ = 600;
	private static final int LARGE_SZ = 800;
	
	public MainWindow(ChessBoardComponent view) {
		this.setLayout(new BorderLayout());

		setCenterPanel(view);
		// Have a left menu and right menu for the previous move and player informations
		// maybe have changeable menus
		JPanel leftPanel = new JPanel();
		this.add(leftPanel, BorderLayout.WEST);
		JPanel rightPanel = new JPanel();
		this.add(rightPanel, BorderLayout.EAST);
		JPanel upPanel = new JPanel();
		this.add(upPanel, BorderLayout.NORTH);
		JPanel downPanel = new JPanel();
		this.add(downPanel, BorderLayout.SOUTH);
		init();
	}
	
	private void setCenterPanel(JComponent view) {
		view.setPreferredSize(new Dimension(MEDIUM_SZ, MEDIUM_SZ));
		view.setMinimumSize(new Dimension(SMALL_SZ, SMALL_SZ));
		JPanel centrePanel = new JPanel();
		centrePanel.setLayout(new GridBagLayout());
		centrePanel.add(view);
		
		this.add(centrePanel, BorderLayout.CENTER);
	}
	

	private void init() {
		this.setTitle(MainWindow.TITLE);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setMinimumSize(new Dimension(MIN_H_SZ,MIN_V_SZ));
		
		this.setVisible(true);
	}
	

}
