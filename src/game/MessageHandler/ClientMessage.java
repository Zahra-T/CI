package game.MessageHandler;

import game.Location;

public class ClientMessage{
	ClientMessageType messageType;
	Object info;
	
	ClientMessage(ClientMessageType messageType, Object info){
		this.messageType = messageType;
		this.info = info;
	}
	
	public ClientMessageType getType() {
		return messageType;
	}

	public Location getLocation() {
		if(info instanceof Location) {
			return (Location)info;
		}
		return null;
	}
}
