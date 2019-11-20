package gui;

import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class GUITest {

	private JFrame frame;

	public void createandShowGUI() {
		frame = new JFrame();
		frame.setTitle("Projeto ES1");
		frame.setLayout(new GridBagLayout());
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		GUITest gui = new GUITest();
		gui.createandShowGUI();
	}

}
