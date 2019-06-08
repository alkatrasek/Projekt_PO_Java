package restauracja;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application
{
	public void start(Stage primaryStage)
	{
		FXMLLoader loader = new FXMLLoader (this.getClass().getResource("/fxml/MainScreen.fxml"));
			BorderPane root=null;
			try
			{
				root = loader.load();
			} catch (IOException e)
			{
				System.out.println(e);
			}
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}
}
