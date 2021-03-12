import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import net.imyeyu.pixelfx.bean.TipsLevel;
import net.imyeyu.pixelfx.component.PixelButton;

public class TestApp extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		AnchorPane ap = new AnchorPane();
		ImageView iv = new ImageView(TipsLevel.toImg(TipsLevel.SUCCESS));
		iv.setLayoutX(100);
		iv.setLayoutY(100);

		PixelButton pb = new PixelButton("test");
		ap.getChildren().addAll(pb, iv);

		Scene scene = new Scene(ap);
		stage.setScene(scene);
		stage.setWidth(520);
		stage.setHeight(320);
		stage.show();
	}
}
