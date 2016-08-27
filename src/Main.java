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
	JPanel object;
	BlockObject entity;

	public static void main(String[] args) {
		Main m = new Main();
	}

	Main() {
		object = new GamePanel();
		Frame = new JFrame("Block Escape");
		Frame.setVisible(true);
		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Frame.add(object);
		Frame.addKeyListener(this);
		Frame.setSize(256, 502);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}