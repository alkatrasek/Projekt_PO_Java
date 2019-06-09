package restauracja.controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class SalaController
{
	private MainController mainController ;
	
	@FXML
	public void stolikClick(MouseEvent a)
	{
		FXMLLoader loader = new FXMLLoader (this.getClass().getResource("/fxml/Stolik.fxml"));
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
		if (a.getPickResult().getIntersectedNode().getId().endsWith("s1"))stolikController.setStolik(1);
		else if (a.getPickResult().getIntersectedNode().getId().endsWith("s2")) stolikController.setStolik(2);
		else if (a.getPickResult().getIntersectedNode().getId().endsWith("s3")) stolikController.setStolik(3);
		
		mainController.setCenterPane(pane);
	}
	
	public void stolikClick2(MouseEvent a)
	{
		FXMLLoader loader = new FXMLLoader (this.getClass().getResource("/fxml/Stolik2.fxml"));
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
		if (a.getPickResult().getIntersectedNode().getId().endsWith("s4")) stolikController.setStolik(4);
		else if (a.getPickResult().getIntersectedNode().getId().endsWith("s5")) stolikController.setStolik(5);
		else if (a.getPickResult().getIntersectedNode().getId().endsWith("s6")) stolikController.setStolik(6);
		else if (a.getPickResult().getIntersectedNode().getId().endsWith("s7")) stolikController.setStolik(7);
		else if (a.getPickResult().getIntersectedNode().getId().endsWith("s8")) stolikController.setStolik(8);
		
		mainController.setCenterPane(pane);
	}

	public void setMainController(MainController mainController)
	{
		this.mainController = mainController;
	}
	
	

}
