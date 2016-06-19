import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main implements KeyListener {
	JFrame Frame;
	JFrame StartupFrame;
	JPanel StartupPanel;
	GamePanel object;
	BlockObject entity;
	JButton Player1;
	JButton Player2;

	public static void main(String[] args) {
		Main m = new Main();
	}

	Main() {
		StartupFrame = new JFrame("Block Escape");
		StartupFrame.setVisible(true);
		StartupFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		StartupFrame.setSize(256, 60);
		Player1 = new JButton("Single Player");
		Player2 = new JButton("Two Player");
		StartupPanel = new JPanel();
		StartupFrame.add(StartupPanel);
		StartupPanel.addKeyListener(this);
		StartupPanel.add(Player1);
		StartupPanel.add(Player2);
		Frame = new JFrame("Block Escape");
		//Frame.setVisible(true);
		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		object = new GamePanel();
		Frame.add(object);
		Frame.addKeyListener(this);
		Frame.setSize(256, 502);
	}
	public void actionPerformed(ActionEvent e) {
		 
	}
	@Override
	public void keyTyped(KeyEvent e) {
		object.keyTyped(e);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		object.keyPressed(e);

	}

	@Override
	public void keyReleased(KeyEvent e) {
		object.keyReleased(e);
	}
}