package restauracja.controllers;

import java.util.Map;
import java.util.TreeMap;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class WyborZamowieniaController {

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
    private static MainController mainController ;
    Map<String, Float> daniaGlowneMap = new TreeMap<>();
    Map<String, Float> daniaDodatkiMap = new TreeMap<>();
    Map<String, Float> surowkiMap = new TreeMap<>();
    Map<String, Float> zupyMap = new TreeMap<>();
    Map<String, Float> zupyDodatkiMap = new TreeMap<>();
    Map<String, Float> napojeMap = new TreeMap<>();
    Map<Float, Float> pojemnoscMap = new TreeMap<>();
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
        zupyDodatkiMap.put("Chleb", 5.0f);
        zupyDodatkiMap.put("Makaron", 6.5f);
        napojeMap.put("Cola", 3.5f);
        napojeMap.put("Woda", 2.2f);
        pojemnoscMap.put(0.5f, 3.5f);
        pojemnoscMap.put(0.7f, 2.2f);
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
        ObservableList<Float> pojemnoscLista = FXCollections.observableArrayList(pojemnoscMap.keySet());
        pojemnoscComboBox.setItems(pojemnoscLista);
        
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
    	
    	
    	mainController.loadMainScreen("/fxml/Sala.fxml");
    }
    
    public void setOsoba (int s, int m)
    {
    	miejsce=m;
    	stolik=s;
    }
    
    public static void setMainController(MainController mainController)
	{
		WyborZamowieniaController.mainController = mainController;
	}

}