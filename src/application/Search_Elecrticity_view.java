package application;

import java.time.LocalDate;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Search_Elecrticity_view extends Add_Elecrticity_view {
	private int day = 0;
	private int month = 0;
	private int year = 0;

	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}

	@Override
	public Text getText1() {
		// TODO Auto-generated method stub
		super.getText1().setText("Search_By_Date");
		super.getText1().setFont(Font.font("Arial", FontWeight.BOLD, 20));
		return super.getText1();
	}

	@Override
	public Button getSearch() {

		return super.getSearch();
	}

	public GridPane gpaneSearch() {
		VBox vbox = new VBox(20);
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setVgap(20);
		pane.setHgap(20);
		pane.add(getText1(), 0, 0);
		pane.add(vbox, 0, 1);
		pane.add(getSearch(), 0, 3);
		DatePicker datePicker = new DatePicker();

		vbox.getChildren().add(datePicker);
		Text err = new Text("Fiald Input Is null !!!");
		Text mass = new Text("Search Is Successfully");

		getSearch().setFont(Font.font("Arial", FontWeight.BOLD, 20));
		getSearch().setTextFill(Color.BLUE);

		mass.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		err.setFont(Font.font("Arial", FontWeight.BOLD, 20));

		getSearch().setOnAction(e -> {
			try {

				day = datePicker.getValue().getDayOfMonth();
				month = datePicker.getValue().getMonthValue();
				year = datePicker.getValue().getYear();
				Main.list1.search(new Electricity(0, year));
				Main.list2.search(new Electricity(month, 0));
				Main.list3.search(new Electricity(day, 0, 0, 0, 0, 0, 0, 0));
				System.out.println("MOTAYAM TAYSEER TARADA");
				massegeBox(mass);
			} catch (Exception e1) {
				massegeBox(err);
			}
		});

		return pane;
	}
}
