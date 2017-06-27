package brickGamePackage;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		Gamepanel panel = new Gamepanel();
		JFrame	 frame = new JFrame();	
		frame.setBounds(10, 10, 700, 600);
		frame.setTitle("Break the brick");
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);

	}

}
