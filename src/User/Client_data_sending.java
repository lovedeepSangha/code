package User;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class Client_data_sending {
	public static void main(String[] args) throws Exception {
		Running running = new Running();
		running.Running();
	}
}

class Running {
	
	public static Socket socket;
	public static DataInputStream dataInputStream;
	public static DataOutputStream dataOutputStream;
	public static String string;
	private Scanner scanner;
	public static boolean result = false;
	
	void Running() throws Exception {
	try {
		socket=new Socket("192.168.1.5", 1);
	} catch (Exception e) {
		Running();
		return;
	}	
					System.out.println("Write String :-");
					scanner = new Scanner(System.in);
					string = scanner.nextLine();
					dataInputStream = new DataInputStream(socket.getInputStream());
					dataOutputStream = new DataOutputStream(socket.getOutputStream());
					dataOutputStream.writeUTF(string);
					socket.shutdownOutput();
					result = dataInputStream.readBoolean();
					socket.shutdownInput();
					System.out.println("done");
					socket.close();
					if (result == true) {
						System.out.println("all");
					} else {
						System.out.println("not");
					}

	}
public void Running2() throws Exception {
//	Running();
	
}
}