
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundObject implements Runnable {
private String file;
public SoundObject (String f){
	file = f;
}
	public void run() {
		try{
			File f = new File(file);
			Clip c = AudioSystem.getClip();
			c.open(AudioSystem.getAudioInputStream(f));
			c.start();
			Thread.sleep(c.getMicrosecondLength()/1000);		
		}catch(Exception e) {
			System.out.println("Error Loading Sound");
		}
		
	}

}