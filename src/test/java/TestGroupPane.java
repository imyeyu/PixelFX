import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import net.imyeyu.betterfx.extend.BorderX;
import net.imyeyu.pixelfx.PixelFX;
import net.imyeyu.pixelfx.component.GroupPane;

public class TestGroupPane extends Application {

	@Override
	public void start(Stage stage) {
		BorderPane bp = new BorderPane(new Label("测试"));
		bp.setBorder(BorderX.test());

		GroupPane gp = new GroupPane("标题", bp);
		gp.setPrefSize(200, 200);

		Pane p = new Pane(gp);

		BorderPane root = new BorderPane(p);
		root.setPadding(new Insets(20));

		Scene scene = new Scene(root);
		scene.getStylesheets().add(PixelFX.CSS);
		stage.setWidth(500);
		stage.setHeight(460);
		stage.setScene(scene);
		stage.show();
	}
}

class LauncherTestGroupPane {

	public static void main(String[] args) {
		Application.launch(TestGroupPane.class, args);
	}
}
