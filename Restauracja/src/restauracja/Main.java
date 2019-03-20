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
			Scene sceneMain = new Scene(layoutMain,800,400);
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
			MenuItem exitfromapp = new MenuItem("Zakoñcz");
			programMenu.getItems().add(exitfromapp);
			exitfromapp.setOnAction(e -> {
				System.exit(0);
			});
			
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
			layoutSala.setPadding(new Insets(0, 15, 15, 15));
			layoutSala.setVgap(60);
		    layoutSala.setHgap(60);
		    //flowPane.setPrefWrapLength(210);
			Button stolik1=new Button("Stolik 1");
			stolik1.setMinSize(100, 100);
			stolik1.setMaxSize(100, 100);
			GridPane.setConstraints(stolik1, 1, 1);
			Button stolik2=new Button("Stolik 2");
			stolik2.setMinSize(100, 100);
			stolik2.setMaxSize(100, 100);
			GridPane.setConstraints(stolik2, 1, 2);
			Button stolik3=new Button("Stolik 3");
			stolik3.setMinSize(100, 100);
			stolik3.setMaxSize(100, 100);
			GridPane.setConstraints(stolik3, 1, 3);
			Button stolik4=new Button("Stolik 4");
			stolik4.setMinSize(200, 100);
			stolik4.setMaxSize(200, 100);
			GridPane.setConstraints(stolik4, 2, 3);
			Button stolik5=new Button("Stolik 5");
			stolik5.setMinSize(200, 100);
			stolik5.setMaxSize(200, 100);
			GridPane.setConstraints(stolik5, 3, 3);
			Button stolik6=new Button("Stolik 6");
			stolik6.setMinSize(200, 100);
			stolik6.setMaxSize(200, 100);
			GridPane.setConstraints(stolik6, 4, 3);
			Button stolik7=new Button("Stolik 7");
			stolik7.setMinSize(100, 200);
			stolik7.setMaxSize(100, 200);
			GridPane.setConstraints(stolik7, 4, 1);
			layoutSala.getChildren().addAll(stolik1,stolik2,stolik3,stolik4,stolik5,stolik6,stolik7);
			
			
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
