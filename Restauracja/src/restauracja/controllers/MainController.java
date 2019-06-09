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
		loadMainScreen("/fxml/Sala.fxml");
	}

	public void loadMainScreen(String path)
	{
		FXMLLoader loader = new FXMLLoader (this.getClass().getResource(path));
		Pane sala=null;
		try
		{
			sala = loader.load();
		} catch (IOException e)
		{
			System.out.println(e);
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
		System.exit(0);
	}
	
	@FXML
	public void loadSala()
	{
		loadMainScreen("/fxml/Sala.fxml");
	}
	
	@FXML
	public void loadKuchnia()
	{
		FXMLLoader loader = new FXMLLoader (this.getClass().getResource("/fxml/Kuchnia.fxml"));
		Pane pane=null;
		try
		{
			pane = loader.load();
		} catch (IOException e)
		{
			System.out.println(e);
			e.printStackTrace();
		}
		KuchniaController edycjaController = loader.getController();
		edycjaController.setMainController(this);
		setCenterPane(pane);
	}
	
	@FXML
	public void loadStatystyki()
	{
		FXMLLoader loader = new FXMLLoader (this.getClass().getResource("/fxml/Statystyki.fxml"));
		Pane pane=null;
		try
		{
			pane = loader.load();
		} catch (IOException e)
		{
			System.out.println(e);
			e.printStackTrace();
		}
		StatystykiController edycjaController = loader.getController();
		edycjaController.setMainController(this);
		setCenterPane(pane);
	}
	
	@FXML
	public void loadEdycja()
	{
		FXMLLoader loader = new FXMLLoader (this.getClass().getResource("/fxml/Edycja.fxml"));
		Pane pane=null;
		try
		{
			pane = loader.load();
		} catch (IOException e)
		{
			System.out.println(e);
			e.printStackTrace();
		}
		EdycjaController edycjaController = loader.getController();
		edycjaController.setMainController(this);
		setCenterPane(pane);
	}
	

}
