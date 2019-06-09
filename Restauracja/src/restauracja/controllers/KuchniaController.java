package restauracja.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class KuchniaController
{
	private static MainController mainController ;
	
    @FXML
    private ListView<String> list;


	
	@FXML
    void initialize()
    {
		ObservableList<String> items =FXCollections.observableArrayList (mainController.getListaZamowien());
		list.setItems(items);
    }

	public static void setMainController(MainController mainController)
	{
		KuchniaController.mainController = mainController;
	}
	
	

}
