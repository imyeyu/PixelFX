package net.imyeyu.pixelfx.component;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import net.imyeyu.betterfx.BetterFX;

/**
 * <br>表单组，简化标签和字段组合的组件
 * 
 * @param <T> 字段
 *
 * 夜雨 创建于 2021/2/13 13:31
 */
public class InputGroup<T extends Control> extends HBox {
	
	private Label before, after;
	private final T control;
	
	public InputGroup(T control) {
		this.control = control;
		init();
	}
	
	public InputGroup(String before, T control) {
		this.before = new Label(before);
		this.before.setTextFill(BetterFX.GRAY);
		this.control = control;
		init();
	}
	
	public InputGroup(T control, String after) {
		this.control = control;
		this.after = new Label(after);
		this.after.setTextFill(BetterFX.GRAY);
		init();
	}

	public InputGroup(String before, T control, String after) {
		this.before = new Label(before);
		this.before.setTextFill(BetterFX.GRAY);
		this.control = control;
		this.after = new Label(after);
		this.after.setTextFill(BetterFX.GRAY);
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