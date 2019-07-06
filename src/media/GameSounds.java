package media;

import java.awt.Image;
import java.io.File;
import java.util.HashMap;

public class GameSounds extends Loadable{
	private static GameSounds gameSounds;
	HashMap<String, File> sounds;

	public static GameSounds getInstance() {
		if(gameSounds == null) {
			gameSounds = new GameSounds();
		}

		return gameSounds;
	}

	private GameSounds() {
		initialize();
	}

	private void initialize() {
		sounds = new HashMap<String, File>();

		sounds.put("gunSound", loadWAVFile("gun"));

	}

	public File get(String name) {
		synchronized(sounds) {
			return sounds.get(name);
		}
	}

}
