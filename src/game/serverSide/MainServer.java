package game.serverSide;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Stack;

import game.MessageHandler.ClientMessage;
import game.MessageHandler.ServerMessage;

public class MainServer extends Thread {
	Stack <ServerMessage> serverMessages = new Stack <ServerMessage>();
	ServerSocket serverSocket;
	int port;
	
	ArrayList<Service> services;
	
	public MainServer(int port) throws IOException {
		this.port = port;
	}
	
	public void run() {
		try {
			serverSocket = new ServerSocket(port);
			
			services = new ArrayList<>();
			while(true) {
				Socket socket = serverSocket.accept();
				Service newService = 
						new Service(
								services.size(),
								socket.getInputStream(), 
								socket.getOutputStream());
				
				services.add(newService);
				newService.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void stopService() {
		for (Service thread:services) {
			thread.stop();
		}
	}
	
	
}
