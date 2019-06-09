package restauracja.controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

public class StolikController
{
	private static MainController mainController ;
	
	private int stolik;
	private int miejsce;
	
	@FXML
	private Circle m3;

	@FXML
	private Circle m1;

	@FXML
	private Circle m2;

	@FXML
	private Circle m4;

	
	@FXML
	public void powrot()
	{
		mainController.loadMainScreen("/fxml/Sala.fxml");
	}
	
	@FXML
	public void wyborMiejsca(MouseEvent e)
	{
		if (e.getPickResult().getIntersectedNode().getId().endsWith("m1")) miejsce=1;
		else if (e.getPickResult().getIntersectedNode().getId().endsWith("m2")) miejsce=2;
		else if (e.getPickResult().getIntersectedNode().getId().endsWith("m3")) miejsce=3;
		else if (e.getPickResult().getIntersectedNode().getId().endsWith("m4")) miejsce=4;
		FXMLLoader loader = new FXMLLoader (this.getClass().getResource("/fxml/WyborZamowienia.fxml"));
		Pane pane=null;
		try
		{
			pane = loader.load();
		} catch (IOException a)
		{
			a.printStackTrace();
		}
		WyborZamowieniaController wyborZamowieniaController = loader.getController();
		WyborZamowieniaController.setMainController(mainController);
		wyborZamowieniaController.setOsoba (stolik, miejsce);
		
		mainController.setCenterPane(pane);
	}

	public static void setMainController(MainController mainController)
	{
		StolikController.mainController = mainController;
	}
	
	public void setStolik(int s)
	{
		stolik=s;
	}
	
	
	
	
	
	

}
