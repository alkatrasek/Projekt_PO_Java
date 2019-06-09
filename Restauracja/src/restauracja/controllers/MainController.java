package restauracja.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import struktura.Zamowienie;

public class MainController
{
	@FXML
	private BorderPane mainBorderPane;



	private List<Zamowienie> zamowienia = new ArrayList<Zamowienie>();

	@FXML
	private ListView<String> listaZamowien;

	@FXML
	public void initialize()
	{
		loadMainScreen("/fxml/Sala.fxml");
	}

	public void loadMainScreen(String path)
	{
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource(path));
		Pane sala = null;
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
		this.init();
		mainBorderPane.setCenter(pane);
	}

	public void init()
	{
		List<String> zamowienialist = new ArrayList<String>();
		for (Zamowienie item : zamowienia)
		{
			if (item.getStatus() == 1)
				zamowienialist.add(item.getNazwa() + "\t" + item.getStolik() + "\t" + item.getMiejsce());

				
		}
		ObservableList<String> items = FXCollections.observableArrayList(zamowienialist);
		listaZamowien.getItems().clear();
		listaZamowien.setItems(items);
	}

	public void addZamowienie(Zamowienie z)
	{
		zamowienia.add(z);
	}

	public List<String> getListaZamowien()
	{
		List<String> zamowienialist = new ArrayList<String>();
		for (Zamowienie item : zamowienia)
		{
			if (item.getStatus() == 0)
				zamowienialist.add(item.getNazwa());
		}
		return zamowienialist;
	}

	public void zmienStatus(String z, int i)
	{
		for (Zamowienie item : zamowienia)
		{
			if (item.getNazwa().equals(z))
				item.setStatus(i);
		}
	}

	@FXML
	void dostarcz(ActionEvent e)
	{
		String gotoweZamowienie = listaZamowien.getSelectionModel().getSelectedItem();
		String g[]=gotoweZamowienie.split("\t");
		this.zmienStatus(g[0], 2);
		this.init();
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
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/Kuchnia.fxml"));
		KuchniaController kuchniaController = loader.getController();
		kuchniaController.setMainController(this);
		Pane pane = null;
		try
		{
			pane = loader.load();
		} catch (IOException e)
		{
			System.out.println(e);
			e.printStackTrace();
		}
		setCenterPane(pane);
	}

	@FXML
	public void loadStatystyki()
	{
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/Statystyki.fxml"));
		StatystykiController edycjaController = loader.getController();
		StatystykiController.setMainController(this);
		Pane pane = null;
		try
		{
			pane = loader.load();
		} catch (IOException e)
		{
			System.out.println(e);
			e.printStackTrace();
		}

		setCenterPane(pane);
	}

	@FXML
	public void loadEdycja()
	{
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/Edycja.fxml"));
		EdycjaController edycjaController = loader.getController();
		edycjaController.setMainController(this);
		Pane pane = null;
		try
		{
			pane = loader.load();
		} catch (IOException e)
		{
			System.out.println(e);
			e.printStackTrace();
		}
		setCenterPane(pane);
	}

}
