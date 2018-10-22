package User;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Starting_User extends Application {

		public static Stage Class_Stage_Starting = new Stage();

	
	
	public static void main(String[] args) {
	launch(args);
}

@Override
public void start(Stage primaryStage) throws Exception {
	Parent parent = FXMLLoader.load(getClass().getResource("/User_fxml/Starting_fxml.fxml"));

	Scene scene = new Scene(parent);

	scene.getStylesheets().add(getClass().getResource("/User_fxml/application.css").toExternalForm());
	Starting_User.Class_Stage_Starting=primaryStage;
	Class_Stage_Starting.setScene(scene);
	Class_Stage_Starting.show();
}
}
