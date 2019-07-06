package game.MessageHandler;

import game.Location;

public class ServerMessage {
	ObjectType objectType;
	Location location;
	
	public ServerMessage(ObjectType objectType, Location location) {
		this.objectType = objectType;
		this.location = location;
	}

}
