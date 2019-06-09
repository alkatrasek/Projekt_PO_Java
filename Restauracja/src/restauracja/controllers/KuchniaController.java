package restauracja.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;

public class KuchniaController
{
	private static MainController mainController;

	@FXML
	private ListView<String> list;
	
    @FXML
    private MenuItem gotoweItem;

	@FXML
	void initialize()
	{
		ObservableList<String> items = FXCollections.observableArrayList(mainController.getListaZamowien());
		list.setItems(items);
	}

	@FXML
	void realizacja(ActionEvent e)
	{
		String gotoweZamowienie = list.getSelectionModel().getSelectedItem();
		mainController.zmienStatus(gotoweZamowienie, 1);
		mainController.init();
		initialize();
	}

	public static void setMainController(MainController mainController)
	{
		KuchniaController.mainController = mainController;
	}

}
