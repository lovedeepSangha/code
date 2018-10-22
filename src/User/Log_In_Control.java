package User;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.print.attribute.standard.RequestingUserName;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Log_In_Control {
	@FXML
	private TextField PhoneNumber;
	@FXML
	private PasswordField Password;

	public void Log_In_Control() throws Exception {
		System.out.println("Log_In_Control");
		String Contain_PhoneNumber_Passowrd = PhoneNumber.getText().trim() + " " + Password.getText().trim();
		System.out.println(Contain_PhoneNumber_Passowrd);
		Data_Sending_For_Result data_Sending_For_Result = new Data_Sending_For_Result();
		String result = data_Sending_For_Result.Data_Sending_for_Result(Contain_PhoneNumber_Passowrd);

		result = data_Sending_For_Result.Data_Sending_for_Result(Contain_PhoneNumber_Passowrd);

		System.out.println(result);
		/* String[] Check=Contain_PhoneNumber_Passowrd.trim().split("\\s+"); */

	}

}

class Data_Sending_For_Result {
	public static Socket socket;
	public boolean result = false;
	public static DataInputStream dataInputStream;
	public static DataOutputStream dataOutputStream;

	public String Data_Sending_for_Result(String Contain_PhoneNumber_Password) throws Exception, Exception {
		synchronized (this) {

			try {
				System.out.println("checking");
				try {
					socket = new Socket("172.20.10.3", 1);
				} catch (Exception e) {

					return null;

				}
				socket.setKeepAlive(true);
				while (socket.getKeepAlive() == true) {
					dataOutputStream = new DataOutputStream(socket.getOutputStream());
					dataOutputStream.writeUTF(Contain_PhoneNumber_Password);
					socket.shutdownOutput();
					dataInputStream = new DataInputStream(socket.getInputStream());
					result = dataInputStream.readBoolean();
					socket.shutdownInput();
					socket.close();
					if (result) {
						return "TRUE";

					} else {
						return "FALSE";
					}
				}
			} catch (IOException e) {

				e.printStackTrace();
			}

		}
		return null;
	}
}
