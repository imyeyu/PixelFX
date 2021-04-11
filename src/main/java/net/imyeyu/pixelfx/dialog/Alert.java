package net.imyeyu.pixelfx.dialog;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import net.imyeyu.pixelfx.PixelStage;
import net.imyeyu.pixelfx.component.PixelButton;

public class Alert extends PixelStage {

	public Alert(String text) {
		super(240, 140, true);
		Label label = new Label(text);
		label.setWrapText(true);

		PixelButton ok = new PixelButton("好");

		BorderPane.setAlignment(ok, Pos.CENTER);
		BorderPane.setMargin(ok, new Insets(4, 0, 4, 0));
		root.setCenter(label);
		root.setBottom(ok);

		setSyncTitle("错误");
		initModality(Modality.APPLICATION_MODAL);
		show();

		ok.setOnAction(e -> close());
	}
}