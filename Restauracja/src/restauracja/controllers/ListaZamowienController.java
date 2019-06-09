package restauracja.controllers;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import restauracja.Main;
import struktura.Osoba;
import struktura.Zamowienie;

public class ListaZamowienController
{	
	@FXML
    private ListView<String> list;
    
    public void init(List<String> lista)
    {
    	ObservableList<String> items =FXCollections.observableArrayList (lista);
		list.setItems(items);
    }


}
