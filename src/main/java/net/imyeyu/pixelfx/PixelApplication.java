package net.imyeyu.pixelfx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import net.imyeyu.betterfx.extend.AnchorPaneX;
import net.imyeyu.betterfx.extend.BgImage;
import net.imyeyu.betterfx.extend.BorderX;
import net.imyeyu.betterfx.util.Resizable;

/**
 * 像素风应用
 *
 * 夜雨 创建于 2021/4/9 21:56
 */
public abstract class PixelApplication extends Application {

	private double ox = 0;
	private double oy = 0;
	private boolean isHiddenClose;
	private PixelStageKeyPressed keyPressedEvent;
	private AnchorPane shadowPane;

	protected Stage stage;
	protected Scene scene;
	protected Label title;
	protected Button min, close;
	protected BorderPane root;

	@Override
	public void start(Stage stage) {
		this.stage = stage;

		// 标题
		title = new Label("Pixel Stage");

		StackPane header = new StackPane();
		header.getChildren().add(title);
		header.setPadding(new Insets(4, 8, 6, 8));
		header.setBorder(new BorderX("#CDDEF0").bottom().build());
		StackPane.setAlignment(title, Pos.CENTER);

		if (!isHiddenClose) {
			// 窗体控制
			min = new Button();
			min.getStyleClass().add("translate-click");
			min.setMinSize(16, 16);
			min.setPrefSize(16, 16);
			min.hoverProperty().addListener((tmp, o, isHover) -> min.setOpacity(isHover ? .6 : 1));
			BgImage.setBgTp(min, "/min.png", 16, 0, 0);
			close = new Button();
			close.getStyleClass().add("translate-click");
			close.setMinSize(16, 16);
			close.setPrefSize(16, 16);
			close.hoverProperty().addListener((tmp, o, isHover) -> close.setOpacity(isHover ? .6 : 1));
			BgImage.setBgTp(close, "/close.png", 16, 0, 0);
			HBox ctrl = new HBox();
			ctrl.setSpacing(12);
			ctrl.setAlignment(Pos.BOTTOM_RIGHT);
			ctrl.getChildren().addAll(min, close);

			header.getChildren().add(ctrl);

			min.setOnAction(event -> stage.setIconified(true));
			close.setOnAction(event -> stage.close());
		}

		DropShadow rootShadow = new DropShadow();
		rootShadow.setRadius(0);
		rootShadow.setOffsetX(2);
		rootShadow.setOffsetY(2);
		rootShadow.setSpread(1);
		rootShadow.setColor(Color.valueOf("#000A"));

		root = new BorderPane();
		root.setEffect(rootShadow);
		root.setStyle("-fx-background-color: #F4F4F4;");
		root.setBorder(new BorderX("#CDDEF0").width(2).build());
		root.setTop(header);

		shadowPane = new AnchorPane();
		AnchorPaneX.def(root, 3);
		shadowPane.setBackground(Background.EMPTY);
		shadowPane.getChildren().addAll(root);

		scene = new Scene(shadowPane);
		scene.getStylesheets().add(PixelFX.CSS);
		scene.setFill(null);
		stage.setScene(scene);
		stage.initStyle(StageStyle.TRANSPARENT);

		// 事件
		header.setOnMousePressed(event -> {
			ox = event.getX();
			oy = event.getY();
		});
		header.setOnMouseDragged(event -> {
			stage.setX(event.getScreenX() - ox - 6);
			stage.setY(event.getScreenY() - oy - 6);
		});
		// 关闭事件
		final KeyCombination ctrl_w = new KeyCodeCombination(KeyCode.W, KeyCombination.CONTROL_DOWN);
		scene.addEventFilter(KeyEvent.KEY_PRESSED, (event) -> {
			if (ctrl_w.match(event)) {
				stage.close();
			}
			if (keyPressedEvent != null) keyPressedEvent.handler(event);
		});
		Resizable.add(stage, shadowPane, 0, 0);
	}

	public void appendKeyPressedEvent(PixelStageKeyPressed keyPressedEvent) {
		this.keyPressedEvent = keyPressedEvent;
	}

	public void setHiddenClose(boolean isHiddenClose) {
		this.isHiddenClose = isHiddenClose;
	}

	public void setSyncTitle(String title) {
		this.title.setText(title);
		stage.setTitle(title);
	}

	public void setMinSize(double width, double height) {
		stage.setMinWidth(width);
		stage.setMinHeight(height);

		stage.setWidth(width);
		stage.setHeight(height);

		Resizable.remove(shadowPane);
		Resizable.add(stage, shadowPane, width, height);
	}

	public void setIcon(Image img) {
		stage.getIcons().add(img);
	}
}
