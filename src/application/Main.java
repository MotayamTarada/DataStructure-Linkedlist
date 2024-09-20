package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.*;

import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Main extends Application {
	Button main = new Button("LOGIN");
	Button select = new Button("Load File");
	Text messge3 = new Text("No file selected.");
	Text messge = new Text("Save Is Successfully");
    

	File selectedFile;
	Scanner sca;
	String[] arr;
	// Create the first linked list
	static CircularLinkedList<Electricity> list1 = new CircularLinkedList<>();
	// Create the second linked list
	static CircularLinkedList<Electricity> list2 = new CircularLinkedList<>();
	// Create the thierd linked list
	static CircularLinkedList<Electricity> list3 = new CircularLinkedList<>();

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {

			list1.concatenate(list2);
			list2.concatenate(list3);
			// Tabpane
			TabPane pane = new TabPane(); // Mangement screen
			SplitPane admin = new SplitPane(); // Admin screen

			// Start Main Screen
			BorderPane mainG = new BorderPane();
			Text text = new Text("Welcome To Programe");
			HBox hb = new HBox();
			hb.getChildren().add(text);
			hb.setAlignment(Pos.CENTER);
			text.setFont(Font.font("Arial", FontWeight.BOLD, 30));
			mainG.setPadding(new Insets(40, 30, 30, 70));
			mainG.setTop(hb);
			messge3.setFont(Font.font("Arial", FontWeight.BOLD, 15));
			messge3.setFill(Color.RED);
			messge.setFont(Font.font("Arial", FontWeight.BOLD, 15));
			// vbox contain Button
			VBox vb = new VBox();
			vb.getChildren().addAll(select, main);
			vb.setSpacing(10);
			select.setMaxWidth(150);
			select.setFont(Font.font("Arial", FontWeight.BOLD, 15));

			mainG.setCenter(vb);
			vb.setAlignment(Pos.CENTER);
			main.setMaxWidth(150);
			main.setTextFill(Color.GREEN);

			main.setFont(Font.font("Arial", FontWeight.BOLD, 15));

			// Action button main
			main.setOnAction(e -> {
				Scene scene = new Scene(admin, 600, 400);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.setTitle("Main Page");
				primaryStage.show();

			});

			// File chooser and Button Action
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Select a File");
			select.setOnAction(e -> {
				selectedFile = fileChooser.showOpenDialog(primaryStage);
				if (selectedFile != null) {
					selectedFile.getAbsolutePath();
					try {
				        BufferedReader br = new BufferedReader(new FileReader(selectedFile));

						begin(selectedFile);
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
				} else {
					massegeBox(messge3);
				}
			});

			// End main screen

			// ************************************************************************
			// Start Screen admin

			Button mangement = new Button("Mangement Screen");
			Button statistic = new Button("Statistics Screen");
			Button save = new Button("SaveData");

			Image image1 = new Image("D:/Work-eclips/project_1/src/Gaza.jpg");
			Image image2 = new Image("D:/Work-eclips/project_1/src/Gaza2.jpeg");
			ImageView view = new ImageView();
			ImageView view1 = new ImageView();
			// design button
			mangement.setFont(Font.font("Arial", FontWeight.BOLD, 15));
			statistic.setFont(Font.font("Arial", FontWeight.BOLD, 15));
			save.setFont(Font.font("Arial", FontWeight.BOLD, 15));
			mangement.setMaxHeight(300);
			statistic.setMaxHeight(300);
			save.setMaxHeight(300);
			mangement.setTextFill(Color.BROWN);
			statistic.setTextFill(Color.SADDLEBROWN);
			save.setTextFill(Color.CRIMSON);
			view.setImage(image1);
			view1.setImage(image2);
			VBox left = new VBox(mangement, statistic,save);
			left.setSpacing(10);
			VBox right = new VBox(view, view1);
			left.setAlignment(Pos.CENTER);
			right.setAlignment(Pos.CENTER);
			admin.getItems().addAll(left, right);

			mangement.setOnAction(e -> {
				Stage stage = new Stage();
				Scene scene = new Scene(pane, 700, 600);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				stage.setScene(scene);
				stage.setTitle("Mangement Page");
				stage.show();
			});
			
			statistic.setOnAction(e->{
				Statistics_Elecrticity_view stat = new Statistics_Elecrticity_view();
				Stage stage = new Stage();
				Scene scene = new Scene(stat.gpanSta(),850,600);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				stage.setScene(scene);
				stage.setTitle("Statistic Page");
				stage.show();	
			});

			save.setOnAction(e -> {

				FileChooser fileChooser2 = new FileChooser();
				fileChooser2.setTitle("Select a File");
				selectedFile = fileChooser.showOpenDialog(primaryStage);
				if (selectedFile != null) {
					selectedFile.getAbsolutePath();

					try {
						list1.printFile(list1, list2, list3, selectedFile);
						massegeBox(messge);
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
				} else {
					massegeBox(messge3);
				}
			});
			// ******************************************************************

			// Start Mangement Screen Show:
			// *************************************************************************************
			Add_Elecrticity_view cc = new Add_Elecrticity_view();
			Delete_Elecrticity_view dd = new Delete_Elecrticity_view();
			Update_Elecrticity_view uu = new Update_Elecrticity_view();
			Search_Elecrticity_view ss = new Search_Elecrticity_view();
			Tab tab1 = new Tab("Add");
			tab1.setContent(cc.GridP());
			Tab tab2 = new Tab("Delete");
			tab2.setContent(dd.GridP());
			Tab tab3 = new Tab("Update");
			tab3.setContent(uu.GridP());
			Tab tab4 = new Tab("Search");
			tab4.setContent(ss.gpaneSearch());
			Tab tab5 = new Tab("Statistics");
			pane.getTabs().addAll(tab1, tab2, tab4, tab3);
			// *************************************************************************************
			Scene scene = new Scene(mainG, 600, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("LOGIN SCREEN");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void begin(File file) throws FileNotFoundException {
		try {
			sca = new Scanner(file);

			while (sca.hasNext()) {

				arr = sca.nextLine().trim().split(",");

				String daye = arr[0].substring(8, 10).trim();
				String month = arr[0].substring(5, 7).trim();
				String year = arr[0].substring(0, 4).trim();

				list1.addSorted(new Electricity(0, Integer.parseInt(year)));
				list2.addSorted(new Electricity(Integer.parseInt(month), 0));
				list3.addSorted(new Electricity(Integer.parseInt(daye), Integer.parseInt(arr[1]),
						Integer.parseInt(arr[2]), Integer.parseInt(arr[3]), Integer.parseInt(arr[4]),
						Integer.parseInt(arr[5]), Integer.parseInt(arr[6]), Integer.parseInt(arr[7])));

				list1.printAll(list1, list2, list3);

			}
		} catch (Exception e) {

		}

	}
	




	  

	public static Stage massegeBox(Text text) {
		GridPane pane = new GridPane();
		Button ok = new Button("OK");
		Stage stage = new Stage();
		stage.setScene(new Scene(pane, 280, 130));
		pane.add(text, 0, 0);
		pane.add(ok, 0, 2);
		pane.setAlignment(Pos.CENTER);
		pane.setVgap(20);
		pane.setHgap(20);
		stage.show();
		ok.setOnAction(e -> {
			stage.close();
		});
		stage.setTitle("Message");
		return stage;
	}

	public static void main(String[] args) {
		launch(args);
	}

}
