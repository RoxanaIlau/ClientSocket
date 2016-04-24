package pack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {

	private static Socket socket;
	private static PrintStream ps;
	private static BufferedReader br;

	public static void main(String[] args) {

		String message = null;
		Scanner scanner = new Scanner(System.in);

		try {
			//System.out.println("f");
			//socket = new Socket("10.45.176.115", 1025);
			//socket = new Socket("192.168.1.192", 1025);
			socket = new Socket("127.0.0.1", 1025);
			ps = new PrintStream(socket.getOutputStream());
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			System.out.println("Write anything to send to server...");
			System.out.println("Write 'quit' to close connection and terminate.");

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (socket != null && ps != null && br != null) {
			do {
				message = scanner.nextLine();
				ps.println(message);
				if ("quit".equals(message)){
					System.out.println("bye");
					break;
				}
				try {
					System.out.println(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}

			} while (true);
		}
		

	}
}
