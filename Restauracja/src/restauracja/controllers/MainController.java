package restauracja.controllers;

import java.io.IOException;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class MainController
{
	@FXML
	private BorderPane mainBorderPane;
	
	@FXML
	public void initialize()
	{
		loadMainScreen();
	}

	public void loadMainScreen()
	{
		FXMLLoader loader = new FXMLLoader (this.getClass().getResource("/restauracja/Sala.fxml"));
		Pane sala=null;
		try
		{
			sala = loader.load();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		SalaController salaController = loader.getController();
		salaController.setMainController(this);
		setCenterPane(sala);
	}

	public void setCenterPane(Pane pane)
	{
		mainBorderPane.setCenter(pane);
	}
	
	@FXML
	public void exit()
	{
		Platform.exit();
	}

}
