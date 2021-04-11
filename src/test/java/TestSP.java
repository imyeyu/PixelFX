import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import net.imyeyu.betterfx.BetterFX;
import net.imyeyu.betterfx.extend.BgFill;
import net.imyeyu.betterfx.extend.BorderX;
import net.imyeyu.pixelfx.PixelFX;

public class TestSP extends Application {

	@Override
	public void start(Stage stage) {
		ScrollPane sp = new ScrollPane();
		sp.setPrefSize(100, 100);
		sp.setBorder(new BorderX(BetterFX.RED).build());

		AnchorPane root = new AnchorPane(sp);
		root.setBackground(BgFill.test());

		Scene scene = new Scene(root);
		scene.getStylesheets().add(PixelFX.CSS);
		stage.setScene(scene);
		stage.show();
	}
}

class LauncherTestSP {

	public static void main(String[] args) {
		Application.launch(TestSP.class, args);
	}
}
