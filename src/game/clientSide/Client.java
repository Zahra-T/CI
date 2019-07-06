package game.clientSide;

import java.awt.Window.Type;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import game.Location;
import game.MessageHandler.ClientMessage;
import game.MessageHandler.ServerMessage;

public class Client extends Thread{

	String IP;
	int port;
	PrintStream printer;
	Scanner scanner;
	Stack <ClientMessage>clientMessages = new Stack<ClientMessage>();
	Stack <ServerMessage>serverMessages = new Stack<ServerMessage>();
	private transient Gson gson = new Gson();
	boolean moving;

	public Client(String IP, int port) {
		this.IP = IP;
		this.port = port;

	}

	@Override
	public void run() {
		try {
			Socket socket = new Socket(IP, port);

			printer = new PrintStream(socket.getOutputStream());
			scanner = new Scanner(socket.getInputStream());

		} catch (IOException e) {
			e.printStackTrace();
		}
		while(true) {
			synchronized(clientMessages) {
				String message = gson.toJson(clientMessages, new TypeToken<Stack<ClientMessage>>(){}.getType());
				printer.println(message);
				clientMessages.clear();
			}

			synchronized(serverMessages) {
				while(scanner.hasNextLine()) {
					String message = scanner.nextLine();
					Stack<ServerMessage> messages = gson.fromJson(message, new TypeToken<Stack<ServerMessage>>() {}.getType());
					serverMessages.addAll(messages);
				}
			}

			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}


	}

//	public synchronized void sendInfo(String name, Location location) {
//		try {
//			printer.writeObject(name);
//			printer.writeObject(location);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

	public boolean isMoving() {
		return moving;
	}
}
