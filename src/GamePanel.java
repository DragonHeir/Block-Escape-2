import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	boolean isFalling;
	int x = 5;
	int blockcounter = 0;
	Timer blocktimer;
	Timer playertimer;
	BlockObject bg;
	ArrayList<BlockObject> blocks;
	PlayerObject player;

	public void paint(Graphics g) {
		bg.paint(g);
		for (BlockObject block : blocks) {
			block.paint(g);
		}
		player.paint(g);
	}

	public GamePanel() {
		bg = new BlockObject(0, 0, 256, 480, "Background.png");
		blocks = new ArrayList<BlockObject>();
		player = new PlayerObject(128, 464, 16, 16, "Player.png");
		blocktimer = new Timer(1000 / 20, this);
		blocktimer.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (BlockObject block : blocks) {
			if (block.isFalling) {
				block.checkCollision(blocks);
				block.refresh();
			}

		}

		player.PlayerCollisionDetection(blocks);
		//checkPlayerCollision(blocks);
		player.refresh(blocks);
		repaint();
		blockLogic();
	}

	int block() {
		Random r = new Random();
		int x = r.nextInt(16);
		x = x * 16;
		return x;
	}

	public void addBlock() {
		blocks.add(new BlockObject(block(), 0, 16, 16, "block.png"));
	}

	public void blockLogic() {
		if (blockcounter == 7) {
			addBlock();
		blockcounter = 0;
		}
		blockcounter++;
	}

	boolean isFalling() {
		return isFalling;
	}

	public void checkCollision() {
		for (int i = 0; i < blocks.size(); i++) {
			for (int j = 0; j < blocks.size(); j++) {
				if (i == j) {
					continue;
				}
				Rectangle r1 = blocks.get(i).getBox();
				Rectangle r2 = blocks.get(j).getBox();
				if (r1.intersects(r2) && blocks.get(i).getisFalling()) {
					BlockObject go = blocks.get(j);
					go.setY(go.getY() - 32);
					go.setIsFalling(false);
				}
			}
		}

	}

	
	
	public void checkPlayerCollision(ArrayList<BlockObject> list) {
		for (BlockObject b : list) {
			if (player.cBox.intersects(b.getBox())) {
				if (player.isJumping) {
					player.isJumping = false;				
			}
		}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		player.keyTyped(e);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		player.keyPressed(e);

	}

	@Override
	public void keyReleased(KeyEvent e) {
		player.keyReleased(e);

	}
}