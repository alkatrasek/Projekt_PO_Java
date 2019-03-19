package restauracja;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;


public class Main extends Application
{
	public void start(Stage primaryStage)
	{
		primaryStage.setTitle("Restauracja");
		primaryStage.setFullScreen(true);
		try
		{
			BorderPane layoutMain = new BorderPane();
			Scene sceneMain = new Scene(layoutMain,800,350);
			GridPane layoutSala = new GridPane();
			BorderPane layoutStol = new BorderPane();
			VBox layoutKuchniaInfo = new VBox();
			sceneMain.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
			
			//Menu narzêdzia
			Menu narzedziaMenu = new Menu("Narzêdzia");
			narzedziaMenu.getItems().add(new MenuItem("Statystyki"));
			narzedziaMenu.getItems().add(new MenuItem("Kuchnia"));
			narzedziaMenu.getItems().add(new MenuItem("Edycja menu"));
			
			//Menu jêzyk
			Menu jezykMenu = new Menu("Jêzyk");
			ToggleGroup jezykToggle = new ToggleGroup();
			RadioMenuItem pl = new RadioMenuItem("Polski");
			RadioMenuItem en = new RadioMenuItem("Angielski");
			RadioMenuItem de = new RadioMenuItem("Niemiecki");
			pl.setToggleGroup(jezykToggle);
			en.setToggleGroup(jezykToggle);
			de.setToggleGroup(jezykToggle);
			pl.setSelected(true);
			jezykMenu.getItems().addAll(pl, en, de);
			
			//Menu program
			Menu programMenu = new Menu("Program");
			programMenu.getItems().add(new MenuItem("Zakoñcz"));
			
			//Menu bar
			MenuBar menuBar = new MenuBar();
			menuBar.getMenus().addAll(narzedziaMenu,jezykMenu,programMenu);
			
			//Przyciski - potrawy w KuchniaInfo
			Button potrawa1=new Button("Placki 6");
			Button potrawa2=new Button("Kurczak 6");
			Button potrawa3=new Button("Rosó³ 3");
			layoutKuchniaInfo.getStyleClass().add("layoutKuchniaInfo");
			layoutKuchniaInfo.getChildren().addAll(potrawa1, potrawa2, potrawa3);
			
			//layoutSala
			layoutSala.getStyleClass().add("layoutSala");
			
			//Ustawienia layotMain
			layoutMain.setTop(menuBar);
			layoutMain.setCenter(layoutSala);
			layoutMain.setRight(layoutKuchniaInfo);
			layoutMain.getStyleClass().add("layoutMain");
			
			primaryStage.setScene(sceneMain);
			primaryStage.show();
		} catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}
}
