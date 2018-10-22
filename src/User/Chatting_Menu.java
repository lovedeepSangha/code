package User;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Chatting_Menu{
	static Stage Class_Stage_Chatting_Menu=new Stage();
	
	public void start(Stage primaryStage) throws Exception {
	Parent parent = FXMLLoader.load(getClass().getResource("/User_fxml/Chatting_Menu.fxml"));

	Scene scene = new Scene(parent);

	scene.getStylesheets().add(getClass().getResource("/User_fxml/application.css").toExternalForm());
	Starting_User.Class_Stage_Starting=primaryStage;
	Class_Stage_Chatting_Menu.setScene(scene);
	Class_Stage_Chatting_Menu.show();
}
	}
class Chatting_Menu_Control{
	public void ListView_Click(){
		
	}
}
