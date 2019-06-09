package restauracja.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import restauracja.Main;
import struktura.Osoba;

public class ListaZamowienController
{
	@FXML
    private TableView<Osoba> listaZamowienTabela;
    @FXML
    private TableColumn<Osoba, String> potrawaZamowieniaKolumna;
    @FXML
    private TableColumn<Osoba, Integer> stolikZamowieniaKolumna;
    @FXML
    private TableColumn<Osoba, Integer> miejsceZamowieniaKolumna;
    @FXML
    private TableColumn<Osoba, Osoba> dostarczZamowieniaKolumna;
    
    @FXML
    void initialize()
    {
    	//this.listaZamowienTabela.setItems(Main.getOsobaObsevableList());
    	//this.potrawaZamowieniaKolumna.setCellValueFactory(cellData -> cellData.getValue().zamowienia.get(0).getNazwa());
    }

}
