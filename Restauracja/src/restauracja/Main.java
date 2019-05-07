package restauracja;
	
import java.util.Locale;
import java.util.ResourceBundle;

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
import javafx.scene.layout.FlowPane;
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
			//Locale currentLocale = new Locale("de", "DE");
			//messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
			Locale locale = new Locale("de", "DE");
			ResourceBundle exampleBundle = ResourceBundle.getBundle("package.MessageBundle", locale);
			String msg1 = exampleBundle.getString("greetings");
			
			BorderPane layoutMain = new BorderPane();
			Scene sceneMain = new Scene(layoutMain,800,400);
			GridPane layoutSala = new GridPane();
			FlowPane layoutKuchnia = new FlowPane();
			FlowPane layoutEdycjaMenu = new FlowPane();
			FlowPane layoutStatystyki = new FlowPane();
			BorderPane layoutStol = new BorderPane();
			VBox layoutKuchniaInfo = new VBox();
			VBox layoutEdycjaMenuPrzyciski = new VBox();
			sceneMain.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
			
			//Menu narzêdzia
			Menu narzedziaMenu = new Menu(msg1);
			//narzedziaMenu.getItems().add(new MenuItem("Statystyki"));
			//narzedziaMenu.getItems().add(new MenuItem("Kuchnia"));
			//narzedziaMenu.getItems().add(new MenuItem("Edycja menu"));
			MenuItem kuchnia_przycisk = new MenuItem("Kuchnia");
			narzedziaMenu.getItems().add(kuchnia_przycisk);
			kuchnia_przycisk.setOnAction(e -> {
				layoutMain.setCenter(layoutKuchnia);
				layoutMain.setRight(layoutStol);
			});
			MenuItem kelner_przycisk = new MenuItem("Kelner");
			narzedziaMenu.getItems().add(kelner_przycisk);
			kelner_przycisk.setOnAction(e -> {
				layoutMain.setCenter(layoutSala);
				layoutMain.setRight(layoutKuchniaInfo);
			});
			MenuItem edycja_menu_przycisk = new MenuItem("Edycja Menu");
			narzedziaMenu.getItems().add(edycja_menu_przycisk);
			edycja_menu_przycisk.setOnAction(e -> {
				layoutMain.setCenter(layoutEdycjaMenu);
				layoutMain.setRight(layoutEdycjaMenuPrzyciski);
			});
			MenuItem statystyki_przycisk = new MenuItem("Statystyki");
			narzedziaMenu.getItems().add(statystyki_przycisk);
			statystyki_przycisk.setOnAction(e -> {
				layoutMain.setRight(layoutStol);
				layoutMain.setCenter(layoutStatystyki);
			});
			
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
			
			
			//Edycja menu -  przyciski dodaj, usuñ, modyfikuj
			Button modyfikuj_przycisk=new Button("Modyfikuj");
			modyfikuj_przycisk.setMinSize(200, 100);
			modyfikuj_przycisk.setMaxSize(200, 100);
			Button dodaj_przycisk=new Button("Dodaj");
			dodaj_przycisk.setMinSize(200, 100);
			dodaj_przycisk.setMaxSize(200, 100);
			Button usun_przycisk=new Button("Usuñ");
			usun_przycisk.setMinSize(200, 100);
			usun_przycisk.setMaxSize(200, 100);
			layoutEdycjaMenuPrzyciski.getStyleClass().add("layoutEdycjaMenuPrzyciski");
			layoutEdycjaMenuPrzyciski.getChildren().addAll(dodaj_przycisk, usun_przycisk, modyfikuj_przycisk);
			
			//layoutStatystyki
			layoutKuchnia.getStyleClass().add("layoutStatystyki");
			//layoutKuchnia.getChildren().addAll(obrazek1);
			
			//layoutKuchnia
			layoutKuchnia.getStyleClass().add("layoutKuchnia");
			layoutKuchnia.setPadding(new Insets(0, 15, 15, 15));
		    layoutKuchnia.setHgap(30);
		    layoutKuchnia.setVgap(30);
			Button zamowienie1=new Button("Schabowy z ziemniakami i kapust¹");
			zamowienie1.setMinSize(450, 150);
			//GridPane.setConstraints(zamowienie1, 1, 1);
			Button zamowienie2=new Button("Kebab na ostro z wo³owin¹ na cienkim");
			zamowienie2.setMinSize(450, 150);
			Button zamowienie3=new Button("Pomidorówka");
			//GridPane.setConstraints(zamowienie2, 2, 1);
			zamowienie3.setMinSize(450, 150);
			Button zamowienie4=new Button("Ogórkówka");
			//GridPane.setConstraints(zamowienie2, 3, 1);
			zamowienie4.setMinSize(450, 150);
			//GridPane.setConstraints(zamowienie4, 4, 1);
			Button zamowienie5=new Button("Æwieræfunciak z serem");
			zamowienie5.setMinSize(450, 150);
			//GridPane.setConstraints(zamowienie5, 5, 1);
			layoutKuchnia.getChildren().addAll(zamowienie1, zamowienie2, zamowienie3, zamowienie4, zamowienie5);
			
			//layoutEdycjaMenu
			layoutEdycjaMenu.getStyleClass().add("layoutEdycjaMenu");
			layoutEdycjaMenu.setPadding(new Insets(0, 15, 15, 15));
		    layoutEdycjaMenu.setHgap(30);
		    layoutEdycjaMenu.setVgap(30);
			Button pozycja1=new Button("Schabowy z ziemniakami i kapust¹");
			pozycja1.setMinSize(450, 150);
			//GridPane.setConstraints(zamowienie1, 1, 1);
			Button pozycja2=new Button("Kebab na ostro z wo³owin¹ na cienkim");
			pozycja2.setMinSize(450, 150);
			Button pozycja3=new Button("Pomidorówka");
			//GridPane.setConstraints(zamowienie2, 2, 1);
			pozycja3.setMinSize(450, 150);
			Button pozycja4=new Button("Ogórkówka");
			//GridPane.setConstraints(zamowienie2, 3, 1);
			pozycja4.setMinSize(450, 150);
			//GridPane.setConstraints(zamowienie4, 4, 1);
			Button pozycja5=new Button("Æwieræfunciak z serem");
			pozycja5.setMinSize(450, 150);
			//GridPane.setConstraints(zamowienie5, 5, 1);
			layoutEdycjaMenu.getChildren().addAll(pozycja1, pozycja2, pozycja3, pozycja4, pozycja5);
			
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
