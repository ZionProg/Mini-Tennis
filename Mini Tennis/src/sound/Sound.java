package sound;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

public class Sound {

	private static Sound instance = new Sound();
	private  URL bgUrl;
	private  URL coUrl;
	private  URL goUrl;
	private  URL fiveUrl;
	private  URL tenUrl;
	private  URL rgUrl;
	private  AudioClip backgroundMusic;
	private  AudioClip collision;
	private  AudioClip gameOver;
	private  AudioClip fiveInc;
	private  AudioClip tenInc;
	private  AudioClip readyGo;

	private Sound() {
		bgUrl = Sound.class.getResource("BG_M.wav");
		backgroundMusic = Applet.newAudioClip(bgUrl);
		coUrl = Sound.class.getResource("CO_S.wav");
		collision = Applet.newAudioClip(coUrl);
		goUrl = Sound.class.getResource("GO_S.wav");
		gameOver = Applet.newAudioClip(goUrl);
		fiveUrl = Sound.class.getResource("5LU_S.wav");
		fiveInc = Applet.newAudioClip(fiveUrl);
		tenUrl = Sound.class.getResource("10LU_S.wav");
		tenInc = Applet.newAudioClip(tenUrl);
		rgUrl = Sound.class.getResource("RG_S.wav");
		readyGo = Applet.newAudioClip(rgUrl);
	}

	public static Sound getInstance() {
		return instance;
	}
	
	public  AudioClip getBackgroundMusic() {
		return backgroundMusic;
	}

	public  AudioClip getCollision() {
		return collision;
	}

	public  AudioClip getGameOver() {
		return gameOver;
	}

	public  AudioClip getTenLU() {
		return tenInc;
	}

	public  AudioClip getFiveLU() {
		return fiveInc;
	}

	public  AudioClip getReadyGo() {
		return readyGo;
	}
}
