package net.imyeyu.px.component;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import net.imyeyu.px.PixelFX;

/**
 * <br>表单组，简化标签和字段组合的组件
 * 
 * @author 夜雨
 *
 * @param <T> 字段
 */
public class InputGroup<T extends Control> extends HBox {
	
	private Label before, after;
	private T control;
	
	public InputGroup(T control) {
		this.control = control;
		init();
	}
	
	public InputGroup(String before, T control) {
		this.before = new Label(before);
		this.before.setTextFill(PixelFX.GRAY);
		this.control = control;
		init();
	}
	
	public InputGroup(T control, String after) {
		this.control = control;
		this.after = new Label(after);
		this.after.setTextFill(PixelFX.GRAY);
		init();
	}

	public InputGroup(String before, T control, String after) {
		this.before = new Label(before);
		this.before.setTextFill(PixelFX.GRAY);
		this.control = control;
		this.after = new Label(after);
		this.after.setTextFill(PixelFX.GRAY);
		init();
	}
	
	private void init() {
		setAlignment(Pos.CENTER_LEFT);
		HBox.setMargin(control, new Insets(0, 4, 0, 4));

		if (before != null) getChildren().add(before);
		getChildren().add(control);
		if (after != null) getChildren().add(after);
	}
	
	public Label getBefore() {
		return before;
	}
	
	public T getInput() {
		return control;
	}
	
	public Label getAfter() {
		return after;
	}
}