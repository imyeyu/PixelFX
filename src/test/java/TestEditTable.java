import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


class TestEditTableLauncher {

	public static void main(String[] args) {
		Application.launch(TestEditTable.class, args);
	}
}

public class TestEditTable extends Application {

	@Override
	public void start(Stage stage) {
		TableView<Bean> tv = new TableView<>();
		tv.setEditable(true);
		TableColumn<Bean, String> col1 = new TableColumn<>("t1");
		TableColumn<Bean, String> col2 = new TableColumn<>("t2");

		col1.setCellValueFactory(new PropertyValueFactory<>("text1"));
		col2.setCellValueFactory(new PropertyValueFactory<>("text2"));

		col1.setCellFactory(TextFieldTableCell.forTableColumn());
		col2.setCellFactory(TextFieldTableCell.forTableColumn());

		tv.getColumns().add(col1);
		tv.getColumns().add(col2);

		BorderPane root = new BorderPane(tv);
		Scene scene = new Scene(root);
		scene.getStylesheets().add("pixel.css");
		stage.setScene(scene);
		stage.show();

		Bean b = new Bean();
		b.setText1("t1");
		b.setText2("t2");
		tv.getItems().add(b);
	}
}