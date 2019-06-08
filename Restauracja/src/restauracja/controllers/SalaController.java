package restauracja.controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class SalaController
{
	private MainController mainController ;
	
	@FXML
	public void stolikClick()
	{
		FXMLLoader loader = new FXMLLoader (this.getClass().getResource("/restauracja/Stolik.fxml"));
		Pane pane=null;
		try
		{
			pane = loader.load();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		StolikController stolikController = loader.getController();
		StolikController.setMainController(mainController);
		mainController.setCenterPane(pane);
	}

	public void setMainController(MainController mainController)
	{
		this.mainController = mainController;
	}
	
	

}
