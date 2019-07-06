package game.serverSide;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.Stack;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import game.MessageHandler.ClientMessage;
import game.MessageHandler.ClientMessageHandler;
import game.MessageHandler.ServerMessage;
import game.serverSide.gameEngine.Game;

public class Service extends Thread{
	int ID;
	PrintStream printer;
	Scanner scanner;
	Stack<ClientMessage> clientMessages = new Stack<ClientMessage>();
	Game game;
	ClientMessageHandler messageHandler;
	
	private transient Gson gson = new Gson();

	public Service(int ID, InputStream inputStream, OutputStream outputStream) {
		this.ID = ID;
		printer = new PrintStream(outputStream);
		scanner = new Scanner(inputStream);

	}
	
	@Override
	public void run() {
		while(true) {
			synchronized(clientMessages) {
				while(scanner.hasNextLine()) {
					String message = scanner.nextLine();
					Stack<ClientMessage> messages = gson.fromJson(message, new TypeToken<Stack<ServerMessage>>() {}.getType());
					clientMessages.addAll(messages);
				}
			}

			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void sendMessages(String serverMessage) {
		printer.println(serverMessage);
	}
}
