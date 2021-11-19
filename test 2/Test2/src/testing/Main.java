package testing;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.stage.*;
import javafx.util.Callback;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.Scene;


public class Main extends Application{
	
	public void start(Stage s) {
		List<List<String>> or = Organize.organized();
		
		Label l1 = new Label("Select number of words to display count for: ");
		TextArea ta = new TextArea();		
		Button b1 = new Button("Top 20 Words");
		Button b2 = new Button("Top 50 Words");
		Button b3 = new Button("All words");
		
		ta.setEditable(false);
		
		GridPane ro = new GridPane();
		ro.addRow(0, b1);
		ro.addRow(1, b2);
		ro.addRow(2, b3);
		
		VBox vb = new VBox(ro, ta);
		VBox.setVgrow(ta, Priority.ALWAYS);
		
		Scene sc = new Scene(vb, 750, 750);

		b1.setOnAction(value -> {
			String r = "";
			try {
				r = Organize.topTwenty(or);
			} catch (Exception e) {
				e.printStackTrace();
			}
			ta.setText(r);
		});
		
		b2.setOnAction(value -> {
			String r = "";
			try {
				r = Organize.topFifty(or);
			} catch (Exception e) {
				e.printStackTrace();
			}
			ta.setText(r);
		});
		
		b3.setOnAction(value -> {
			String r = "";
			try {
				r = Organize.all(or);
			} catch (Exception e) {
				e.printStackTrace();
			}
			ta.setText(r);
		});
		
		s.setScene(sc);
		s.setTitle("Poem word occurances");
		s.show();		
		
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Organize.org();
		launch(args);

	}

}
