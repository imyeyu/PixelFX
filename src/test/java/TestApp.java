import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import net.imyeyu.betterfx.BetterFX;
import net.imyeyu.betterfx.extend.BorderX;
import net.imyeyu.pixelfx.PixelFX;
import net.imyeyu.pixelfx.Zpix;
import net.imyeyu.pixelfx.component.PixelButton;
import net.imyeyu.pixelfx.component.Switch;

public class TestApp extends Application {

	@Override
	public void start(Stage stage) {
		// 按钮
		PixelButton pxBtn = new PixelButton("按钮");
		pxBtn.setFont(Zpix.getS());
		PixelButton pxBtn2x = new PixelButton("按钮 2x");
		pxBtn2x.setFont(Zpix.getM());
		// 开关
		Switch sw = new Switch("开关");
		sw.setFont(Zpix.getS());
		Switch sw2x = new Switch("开关 2x", true);
		sw2x.setFont(Zpix.getM());

		FlowPane root = new FlowPane(pxBtn, pxBtn2x, sw, sw2x);
		root.setBorder(new BorderX(BetterFX.LIGHT_GRAY).top().build());
		root.setPadding(new Insets(8));
		root.setVgap(6);
		root.setHgap(8);

		Scene scene = new Scene(root);
		scene.getStylesheets().add(PixelFX.CSS);
		stage.setTitle("PixelFX 测试");
		stage.setScene(scene);
		stage.setWidth(520);
		stage.setHeight(320);
		stage.show();
	}
}

class Launcher {

	public static void main(String[] args) {
		Application.launch(TestApp.class, args);
	}
}