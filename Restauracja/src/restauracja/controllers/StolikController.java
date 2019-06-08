package restauracja.controllers;

import javafx.fxml.FXML;

public class StolikController
{
	private static MainController mainController ;
	
	@FXML
	public void powrot()
	{
		mainController.loadMainScreen();
	}

	public static void setMainController(MainController mainController)
	{
		StolikController.mainController = mainController;
	}
	
	

}
