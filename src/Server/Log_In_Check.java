package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;

import com.sun.javafx.stage.EmbeddedWindow;

public class Log_In_Check {
	public static void main(String[] args) throws Exception {
		Work work = new Work();
		work.Running();
	}
}

class Work {
	public static ServerSocket serverSocket;

	public static Socket socket;

	public void Running() throws Exception {

		try {
			serverSocket = new ServerSocket(1);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {

			while (true) {

				socket = serverSocket.accept();
				System.out.println("helloS");
				// socket.setKeepAlive(true);
				// connecitons.add(socket);
				System.out.println("hellokkllS");
				BackEnd backEnd = new BackEnd(socket);
				Thread thread = new Thread(backEnd);
				thread.start();

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

class BackEnd extends Thread {
	Socket s;

	public BackEnd(Socket socket) {
		this.s = socket;
	}

	public void run() {

		DataInputStream dataInputStream;
		DataOutputStream dataOutputStream;
		String Log_Info;
		boolean Result = false;
		System.out.println("hello");
		try {
			dataInputStream = new DataInputStream(s.getInputStream());
			dataOutputStream = new DataOutputStream(s.getOutputStream());

			Log_Info = dataInputStream.readUTF();
			s.shutdownInput();
			System.out.println(Log_Info);
			String[] User_data = Log_Info.trim().split("\\s+");
			System.out.println(User_data[0] + User_data[1]);
			DataBase_Checking_UserName_Password base_Checking_UserName_Password = new DataBase_Checking_UserName_Password();
			Result = base_Checking_UserName_Password.Checking_UserName_Password(Long.parseLong(User_data[0]),
					User_data[1]);
			System.out.println(Result);
			dataOutputStream.writeBoolean(Result);
			s.shutdownOutput();

			dataInputStream.close();
			dataOutputStream.close();
			Log_Info = "";

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}