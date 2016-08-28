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
	Timer scrolltimer;
	BlockObject bg;
	BlockObject fog;
	ImageObject controls;
	ArrayList<BlockObject> blocks;
	PlayerObject player;
	boolean isScrolling = false;
	int h = 0;
	long startTime;


	public GamePanel() {
		bg = new BlockObject(0, 0, 256, 480, "Background.png");
		controls = new ImageObject(82, 60, 92, 27, "Controls.png");
		blocks = new ArrayList<BlockObject>();
			player = new PlayerObject(128, 464, 16, 16, "Player.png");
			fog = new BlockObject(0, 0, 256, 300, "Fog.png");
		blocktimer = new Timer((int) 50, this);
		blocktimer.start();
	}
	public void paint(Graphics g) {
		bg.paint(g);
		for (BlockObject block : blocks) {
			block.paint(g);
		}
		player.paint(g);
		fog.paint(g);
		controls.paint(g);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (BlockObject block : blocks) {
			if (block.isFalling) {
				block.checkCollision(blocks);
				block.refresh();
			}

		}
		
		if (startTime == -1){
			startTime = System.currentTimeMillis();
		}
		if (player.y <= 320){
			
			if (System.currentTimeMillis() - startTime >= 3000){
				for (BlockObject block : blocks) {
					block.setY(block.getY() + 16);
				}
				startTime = System.currentTimeMillis();
			}
		}
			
			player.PlayerCollisionDetection(blocks);
			// checkPlayerCollision(blocks);
			player.refresh(blocks);		
			repaint();
			blockLogic();
//			scroll();
		}

//	public void scroll() {
//	if (player.y <= 460)
//	{
//		isScrolling = true;
////		System.out.println("scroll");
//	}
//	if (isScrolling) {		
//		for(BlockObject block : blocks){
////			block.scroll();
//		}
//	}
		
//	}

	int block() {
		Random r = new Random();
		int x = r.nextInt(16);
		x = x * 16;
		return x;
	}

	public void addBlock() {
		blocks.add(new BlockObject(block(), h, 16, 16, "block.png"));
	}
	public void blockLogic() {
		if (blockcounter == 77) {
			addBlock();
			blockcounter = 70;
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