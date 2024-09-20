package application;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Statistics_Elecrticity_view {

	public GridPane gpanSta() {

		CircularLinkedList<Electricity> list = new CircularLinkedList<>();

		Button Max = new Button("Max");
		Button Min = new Button("Min");
		Button Sum = new Button("Sum");
		Button Avg = new Button("Avg");

		TextField sum = new TextField("");
		TextField avg = new TextField("");
		TextField min = new TextField("");
		TextField max = new TextField("");
		TextField sum1 = new TextField("");
		TextField avg1 = new TextField("");
		TextField min1 = new TextField("");
		TextField max1 = new TextField("");
		TextField sum2 = new TextField("");
		TextField avg2 = new TextField("");
		TextField min2 = new TextField("");
		TextField max2 = new TextField("");

		Text text6 = new Text("DayAAllMonths");
		Text text7 = new Text("MonthAAllDay");
		Text text8 = new Text("yearAADay");
		Text text1 = new Text("Max");
		Text text2 = new Text("Sum");
		Text text3 = new Text("Avg");
		Text text4 = new Text("Min");
		Text text11 = new Text("Max");
		Text text21 = new Text("Sum");
		Text text31 = new Text("Avg");
		Text text41 = new Text("Min");
		Text text12 = new Text("Max");
		Text text22 = new Text("Sum");
		Text text32 = new Text("Avg");
		Text text42 = new Text("Min");
		Text text5 = new Text("Date");

		text1.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		text2.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		text3.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		text4.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		text11.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		text21.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		text31.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		text41.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		text12.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		text22.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		text32.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		text42.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		text5.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		text6.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		text7.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		text8.setFont(Font.font("Arial", FontWeight.BOLD, 20));

		Min.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		Max.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		Sum.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		Avg.setFont(Font.font("Arial", FontWeight.BOLD, 20));

		HBox box = new HBox(10);
		VBox vbox = new VBox(20);
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setVgap(20);
		pane.setHgap(20);

		pane.add(text5, 0, 0);
		pane.add(vbox, 0, 1);
		pane.add(text6, 1, 0);
		pane.add(text7, 2, 0);
		pane.add(text8, 3, 0);
		pane.add(text1, 1, 1);
		pane.add(max, 1, 2);
		pane.add(text2, 1, 3);
		pane.add(sum, 1, 4);
		pane.add(text3, 1, 5);
		pane.add(avg, 1, 6);
		pane.add(text4, 1, 7);
		pane.add(min, 1, 8);

		pane.add(text11, 2, 1);
		pane.add(max1, 2, 2);
		pane.add(text21, 2, 3);
		pane.add(sum1, 2, 4);
		pane.add(text31, 2, 5);
		pane.add(avg1, 2, 6);
		pane.add(text41, 2, 7);
		pane.add(min1, 2, 8);

		pane.add(text12, 3, 1);
		pane.add(max2, 3, 2);
		pane.add(text22, 3, 3);
		pane.add(sum2, 3, 4);
		pane.add(text32, 3, 5);
		pane.add(avg2, 3, 6);
		pane.add(text42, 3, 7);
		pane.add(min2, 3, 8);
		pane.add(box, 1, 10);

		box.getChildren().addAll(Max, Min, Sum, Avg);

		box.setAlignment(Pos.CENTER);
		DatePicker datePicker = new DatePicker();

		vbox.getChildren().add(datePicker);
		Text err = new Text("Fiald Input Is null !!!");
		err.setFont(Font.font("Arial", FontWeight.BOLD, 20));

		Sum.setOnAction(e -> {
			try {
				int day = datePicker.getValue().getDayOfMonth();
				int month = datePicker.getValue().getMonthValue();
				int year = datePicker.getValue().getYear();

				double a = list.curr_Sum_Day(Main.list3, Main.list3, day);
				double b = list.curr_Sum_Month(Main.list2, Main.list3, month);
				double c = list.curr_Sum_Year(Main.list1, Main.list3, year);

				sum.setText(a + "MWs");
				sum1.setText(b + "MWs");
				sum2.setText(c + "MWs");

			} catch (Exception e1) {
				massegeBox(err);
			}
		});
		Max.setOnAction(e -> {
			try {
				int day = datePicker.getValue().getDayOfMonth();
				int month = datePicker.getValue().getMonthValue();
				int year = datePicker.getValue().getYear();
				double a = list.curr_Max_Day(Main.list3, Main.list3, day);
				double b = list.curr_Max_Month(Main.list2, Main.list3, month);
				double c = list.curr_Max_Year(Main.list1, Main.list3, year);

				max.setText(a + "MWs");
				max1.setText(b + "MWs");
				max2.setText(c + "MWs");

			} catch (Exception e1) {
				massegeBox(err);
			}
		});
		Min.setOnAction(e -> {
			try {
				int day = datePicker.getValue().getDayOfMonth();
				int month = datePicker.getValue().getMonthValue();
				int year = datePicker.getValue().getYear();
				
				double a = list.curr_Min_Day(Main.list3, Main.list3, day);
				double b = list.curr_Min_Month(Main.list2, Main.list3, month);
				double c = list.curr_Min_Year(Main.list1, Main.list3, year);

				min.setText(a + "MWs");
				min1.setText(b + "MWs");
				min2.setText(c + "MWs");

			} catch (Exception e1) {
				massegeBox(err);
			}
		});

		Avg.setOnAction(e -> {
			try {
				int day = datePicker.getValue().getDayOfMonth();
				int month = datePicker.getValue().getMonthValue();
				int year = datePicker.getValue().getYear();
				
				double a = list.curr_Avg_Day(Main.list3, Main.list3, day);
				double b = list.curr_Avg_Month(Main.list2, Main.list3, month);
				double c = list.curr_Avg_Year(Main.list1, Main.list3, year);

				avg.setText(a + "MWs");
				avg1.setText(b + "MWs");
				avg2.setText(c + "MWs");

			} catch (Exception e1) {
				massegeBox(err);
			}
		});

		return pane;
	}

	// Statistics Manger

	public Stage massegeBox(Text text) {
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

}
