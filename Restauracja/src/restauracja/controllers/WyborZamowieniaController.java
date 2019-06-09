package restauracja.controllers;

import java.util.Map;
import java.util.TreeMap;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import struktura.DanieGlowne;
import struktura.Inne;
import struktura.Napoj;
import struktura.Zupa;

public class WyborZamowieniaController
{

	@FXML
	private ComboBox<String> daniaComboBox;

	@FXML
	private ComboBox<String> napojeComboBox;

	@FXML
	private ComboBox<String> zupyComboBox;

	@FXML
	private ComboBox<String> inneComboBox;

	@FXML
	private ComboBox<String> daniaDodatkiComboBox;

	@FXML
	private ComboBox<String> surowkiComboBox;

	@FXML
	private ComboBox<Float> pojemnoscComboBox;

	@FXML
	private ComboBox<String> zupyDodatkiComboBox;

	@FXML
	private Button zamowButton;

	private int miejsce;
	private int stolik;
	private static MainController mainController;
	Map<String, Float> daniaGlowneMap = new TreeMap<>();
	Map<String, Float> daniaDodatkiMap = new TreeMap<>();
	Map<String, Float> surowkiMap = new TreeMap<>();
	Map<String, Float> zupyMap = new TreeMap<>();
	Map<String, Float> zupyDodatkiMap = new TreeMap<>();
	Map<String, Float> napojeMap = new TreeMap<>();
	Map<String, Float> inneMap = new TreeMap<>();

	@FXML
	public void initialize()
	{
		daniaGlowneMap.put("Schabowy", 21.0f);
		daniaGlowneMap.put("Placki Ziemniaczane", 13.0f);
		daniaDodatkiMap.put("Ziemniaki", 2.0f);
		daniaDodatkiMap.put("Frytki", 3.0f);
		zupyMap.put("Pomidorowa", 5.0f);
		zupyMap.put("¯urek", 6.5f);
		zupyDodatkiMap.put("Chleb", 1.0f);
		zupyDodatkiMap.put("Makaron", 1.5f);
		zupyDodatkiMap.put("Ry¿", 1.5f);
		napojeMap.put("Cola 0,5 L", 3.5f);
		napojeMap.put("Woda 0,5 L", 2.2f);
		napojeMap.put("Cola 0,7 L", 7.5f);
		napojeMap.put("Woda 1 L", 5.0f);
		surowkiMap.put("Buraczk", 2.5f);
		surowkiMap.put("Marchewka", 2.0f);
		inneMap.put("Lody", 10.0f);
		inneMap.put("Szarlotka", 6.5f);

		ObservableList<String> daniaLista = FXCollections.observableArrayList(daniaGlowneMap.keySet());
		daniaComboBox.setItems(daniaLista);
		ObservableList<String> surowkiLista = FXCollections.observableArrayList(surowkiMap.keySet());
		surowkiComboBox.setItems(surowkiLista);
		ObservableList<String> daniaDodatkiLista = FXCollections.observableArrayList(daniaDodatkiMap.keySet());
		daniaDodatkiComboBox.setItems(daniaDodatkiLista);

		ObservableList<String> napojeLista = FXCollections.observableArrayList(napojeMap.keySet());
		napojeComboBox.setItems(napojeLista);

		ObservableList<String> zupyLista = FXCollections.observableArrayList(zupyMap.keySet());
		zupyComboBox.setItems(zupyLista);
		ObservableList<String> zupyDodatkiLista = FXCollections.observableArrayList(zupyDodatkiMap.keySet());
		zupyDodatkiComboBox.setItems(zupyDodatkiLista);

		ObservableList<String> inneLista = FXCollections.observableArrayList(inneMap.keySet());
		inneComboBox.setItems(inneLista);
	}

	@FXML
	public void dodajZamowienie()
	{
		if (daniaComboBox.getValue() != null && !daniaComboBox.getValue().toString().isEmpty())
		{
			if (daniaDodatkiComboBox.getValue() != null && !daniaDodatkiComboBox.getValue().toString().isEmpty()
					&& surowkiComboBox.getValue() != null && !surowkiComboBox.getValue().toString().isEmpty())
			{
				DanieGlowne dg = new DanieGlowne(daniaComboBox.getValue(), daniaGlowneMap.get(daniaComboBox.getValue()),
						stolik, miejsce, surowkiComboBox.getValue(), surowkiMap.get(surowkiComboBox.getValue()),
						daniaDodatkiComboBox.getValue(), daniaDodatkiMap.get(daniaDodatkiComboBox.getValue()));
				mainController.addZamowienie(dg);
			} else
			{
				DanieGlowne dg = new DanieGlowne(daniaComboBox.getValue(), daniaGlowneMap.get(daniaComboBox.getValue()),
						stolik, miejsce);
				mainController.addZamowienie(dg);
			}

		}

		if (zupyComboBox.getValue() != null && !zupyComboBox.getValue().toString().isEmpty())
		{
			if (zupyDodatkiComboBox.getValue() != null && !zupyDodatkiComboBox.getValue().toString().isEmpty())
			{
				Zupa zupa = new Zupa(zupyComboBox.getValue(), zupyMap.get(zupyComboBox.getValue()), stolik, miejsce,
						zupyDodatkiComboBox.getValue(), zupyDodatkiMap.get(zupyDodatkiComboBox.getValue()));
				mainController.addZamowienie(zupa);

			} else
			{
				Zupa zupa = new Zupa(zupyComboBox.getValue(), zupyMap.get(zupyComboBox.getValue()), stolik, miejsce);
				mainController.addZamowienie(zupa);
			}

		}

		if (napojeComboBox.getValue() != null && !napojeComboBox.getValue().toString().isEmpty())
		{
			Napoj n = new Napoj(napojeComboBox.getValue(), napojeMap.get(napojeComboBox.getValue()), stolik, miejsce);
			mainController.addZamowienie(n);
		}

		if (inneComboBox.getValue() != null && !inneComboBox.getValue().toString().isEmpty())
		{
			Inne n = new Inne(inneComboBox.getValue(), inneMap.get(inneComboBox.getValue()), stolik, miejsce);
			mainController.addZamowienie(n);

		}

		mainController.loadMainScreen("/fxml/Sala.fxml");
	}

	public void setOsoba(int s, int m)
	{
		miejsce = m;
		stolik = s;
	}

	public static void setMainController(MainController mainController)
	{
		WyborZamowieniaController.mainController = mainController;
	}

}