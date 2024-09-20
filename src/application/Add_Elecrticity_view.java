package application ;

import java.time.LocalDate;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Add_Elecrticity_view {

	private TextField ILM = new TextField(); // Israeli_Lines_MWs
	private TextField GPPM = new TextField(); // Gaza_Power_Plant_MWs
	private TextField ELM = new TextField(); // Egyptian_Lines_MWs
	private TextField TdSAM = new TextField(); // Total_daily_Supply_available_in_MWs
	private TextField ODM = new TextField(); // Overall_demand_in_MWs
	private TextField PCHD = new TextField();// Power_Cuts_hours_day_400mg
	private TextField temp = new TextField();
	private Button add = new Button("Add");
	private Button delete = new Button("Delete");
	private Button update = new Button("Update");
	private Button search = new Button("Search");

	private Text text1 = new Text("date");
	private Text text2 = new Text("Israeli_Lines_MWs");
	private Text text3 = new Text("Gaza_Power_Plant_MWs");
	private Text text4 = new Text("Egyptian_Lines_MWs");
	private Text text5 = new Text("Total_daily_Supply_available_in_MWs ");
	private Text text6 = new Text("Overall_demand_in_MWs");
	private Text text7 = new Text("Power_Cuts_hours_day_400mg");
	private Text text8 = new Text("Temp ");

	public TextField getILM() {
		return ILM;
	}

	public TextField getGPPM() {
		return GPPM;
	}

	public TextField getELM() {
		return ELM;
	}

	public TextField getTdSAM() {
		return TdSAM;
	}

	public TextField getODM() {
		return ODM;
	}

	public TextField getPCHD() {
		return PCHD;
	}

	public TextField getTemp() {
		return temp;
	}

	public Button getAdd() {
		return add;
	}

	public Button getDelete() {
		return delete;
	}

	public Button getUpdate() {
		return update;
	}

	public Button getSearch() {
		return search;
	}

	public Text getText1() {
		return text1;
	}

	public Text getText2() {
		return text2;
	}

	public Text getText3() {
		return text3;
	}

	public Text getText4() {
		return text4;
	}

	public Text getText5() {
		return text5;
	}

	public Text getText6() {
		return text6;
	}

	public Text getText7() {
		return text7;
	}

	public Text getText8() {
		return text8;
	}

	public GridPane GridP() {
		GridPane pane = new GridPane();
		VBox vbox = new VBox(20);
		DatePicker datePicker = new DatePicker();
		pane.setAlignment(Pos.CENTER);
		pane.setVgap(20);
		pane.setHgap(20);
		pane.add(getText1(), 0, 0);
		pane.add(vbox, 0, 1);
		pane.add(getText2(), 0, 2);
		pane.add(getGPPM(), 0, 3);
		pane.add(getText3(), 0, 4);
		pane.add(getELM(), 0, 5);
		pane.add(getText4(), 0, 6);
		pane.add(getILM(), 0, 7);
		pane.add(getText5(), 1, 0);
		pane.add(getTdSAM(), 1, 1);
		pane.add(getText6(), 1, 2);
		pane.add(getODM(), 1, 3);
		pane.add(getText7(), 1, 4);
		pane.add(getPCHD(), 1, 5);
		pane.add(getText8(), 1, 6);
		pane.add(getTemp(), 1, 7);
		pane.add(getAdd(), 0, 9);
		vbox.getChildren().add(datePicker);
		
		Text err =new Text("Fiald Input Is null !!!");
		Text mass = new Text("Add Is Successfully");
		// Design text font
		getText1().setFont(Font.font("Arial", FontWeight.BOLD, 20));
		getText2().setFont(Font.font("Arial", FontWeight.BOLD, 20));
		getText3().setFont(Font.font("Arial", FontWeight.BOLD, 20));
		getText4().setFont(Font.font("Arial", FontWeight.BOLD, 20));
		getText5().setFont(Font.font("Arial", FontWeight.BOLD, 20));
		getText6().setFont(Font.font("Arial", FontWeight.BOLD, 20));
		getText7().setFont(Font.font("Arial", FontWeight.BOLD, 20));
		getText8().setFont(Font.font("Arial", FontWeight.BOLD, 20));
		err.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		mass.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		getAdd().setFont(Font.font("Arial", FontWeight.BOLD, 20));
		getAdd().setTextFill(Color.BLUE);

			getAdd().setOnAction(e -> {
				try {
					int day = datePicker.getValue().getDayOfMonth();
					int month = datePicker.getValue().getMonthValue();
					int year = datePicker.getValue().getYear();
					Main.list1.addSorted(new Electricity(0, year));
					Main.list2.addSorted(new Electricity(month, 0));
					Main.list3.addSorted(new Electricity(day, Integer.parseInt(getELM().getText()),
							Integer.parseInt(getGPPM().getText()), Integer.parseInt(getELM().getText()),
							Integer.parseInt(getTdSAM().getText()), Integer.parseInt(getODM().getText()),
							Integer.parseInt(getPCHD().getText()), Integer.parseInt(getTemp().getText())));
					massegeBox(mass);
				} catch (Exception e1) {
					massegeBox(err);
				}
			});

		return pane;
	}

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
