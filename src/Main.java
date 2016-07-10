import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main implements KeyListener, ActionListener {
	JFrame Frame;
	JFrame StartupFrame;
	JPanel StartupPanel;
	JPanel object;
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
		Player1.addActionListener(this);
		Player2.addActionListener(this);
		StartupPanel.add(Player1);
		StartupPanel.add(Player2);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Player1) {
			object = new GamePanel();
			Frame = new JFrame("Block Escape");
			Frame.setVisible(true);
			Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Frame.add(object);
			Frame.addKeyListener(this);
			Frame.setSize(256, 502);
			StartupFrame.setVisible(false);
		}
		if (e.getSource() == Player2) {
			object = new GamePanel2();
			Frame = new JFrame("Block Escape");
			Frame.setVisible(true);
			Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Frame.add(object);
			Frame.addKeyListener(this);
			Frame.setSize(256, 502);
			StartupFrame.setVisible(false);
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		((KeyListener) object).keyTyped(e);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		((KeyListener) object).keyPressed(e);

	}

	@Override
	public void keyReleased(KeyEvent e) {
		((KeyListener) object).keyReleased(e);
	}
}