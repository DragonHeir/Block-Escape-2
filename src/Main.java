import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Main implements KeyListener {
	JFrame Frame;
	GamePanel object;
	BlockObject entity;

	public static void main(String[] args) {
		Main m = new Main();
	}

	Main() {
		Frame = new JFrame("Block Escape");
		Frame.setVisible(true);
		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		object = new GamePanel();
		Frame.add(object);
		Frame.addKeyListener(this);
		Frame.setSize(256, 502);
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