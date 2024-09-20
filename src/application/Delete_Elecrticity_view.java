package application;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Delete_Elecrticity_view extends Add_Elecrticity_view {

	@Override
	public Button getDelete() {
		// TODO Auto-generated method stub
		return super.getDelete();
	}

	@Override
	public TextField getELM() {
		// TODO Auto-generated method stub
		return super.getELM();
	}

	@Override
	public TextField getGPPM() {
		// TODO Auto-generated method stub
		return super.getGPPM();
	}

	@Override
	public TextField getODM() {
		// TODO Auto-generated method stub
		return super.getODM();
	}

	@Override
	public TextField getTdSAM() {
		// TODO Auto-generated method stub
		return super.getTdSAM();
	}

	@Override
	public TextField getTemp() {
		// TODO Auto-generated method stub
		return super.getTemp();
	}

	@Override
	public TextField getILM() {
		// TODO Auto-generated method stub
		return super.getILM();
	}

	@Override
	public TextField getPCHD() {
		// TODO Auto-generated method stub
		return super.getPCHD();
	}

	@Override
	public Text getText1() {
		// TODO Auto-generated method stub
		return super.getText1();
	}

	@Override
	public Text getText2() {
		// TODO Auto-generated method stub
		return super.getText2();
	}

	@Override
	public Text getText3() {
		// TODO Auto-generated method stub
		return super.getText3();
	}

	@Override
	public Text getText4() {
		// TODO Auto-generated method stub
		return super.getText4();
	}

	@Override
	public Text getText5() {
		// TODO Auto-generated method stub
		return super.getText5();
	}

	@Override
	public Text getText6() {
		// TODO Auto-generated method stub
		return super.getText6();
	}

	@Override
	public Text getText7() {
		// TODO Auto-generated method stub
		return super.getText7();
	}

	@Override
	public Text getText8() {
		// TODO Auto-generated method stub
		return super.getText8();
	}

	@Override
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
		pane.add(getILM(), 0, 3);
		pane.add(getText3(), 0, 4);
		pane.add(getGPPM(), 0, 5);
		pane.add(getText4(), 0, 6);
		pane.add(getELM(), 0, 7);
		pane.add(getText5(), 1, 0);
		pane.add(getTdSAM(), 1, 1);
		pane.add(getText6(), 1, 2);
		pane.add(getODM(), 1, 3);
		pane.add(getText7(), 1, 4);
		pane.add(getPCHD(), 1, 5);
		pane.add(getText8(), 1, 6);
		pane.add(getTemp(), 1, 7);
		pane.add(getDelete(), 0, 9);
		vbox.getChildren().add(datePicker);
		Text err = new Text("Fiald Input Is null !!!");
		Text mass = new Text("Delete Is Successfully");

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

		getDelete().setFont(Font.font("Arial", FontWeight.BOLD, 20));
		getDelete().setTextFill(Color.RED);

		mass.setFill(Color.RED);
		getDelete().setOnAction(e -> {
			try {
				int day = datePicker.getValue().getDayOfMonth();
				int month = datePicker.getValue().getMonthValue();
				int year = datePicker.getValue().getYear();
				Main.list1.delete(new Electricity(0, year));
				Main.list2.delete(new Electricity(month, 0));
				Main.list3.delete(new Electricity(day, Integer.parseInt(getELM().getText()),
						Integer.parseInt(getGPPM().getText()), Integer.parseInt(getELM().getText()),
						Integer.parseInt(getTdSAM().getText()), Integer.parseInt(getODM().getText()),
						Integer.parseInt(getPCHD().getText()), Integer.parseInt(getTemp().getText())));

				Main.list1.printAll(Main.list1, Main.list2, Main.list3);

				massegeBox(mass);
			} catch (Exception e1) {
				massegeBox(err);
			}
		});

		return pane;
	}

	@Override
	public Stage massegeBox(Text text) {

		return super.massegeBox(text);
	}

}
