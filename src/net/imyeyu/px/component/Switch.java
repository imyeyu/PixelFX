package net.imyeyu.px.component;

import javafx.scene.control.CheckBox;

/**
 * 滑动开关，需要 CSS 支持
 * 
 * @author 夜雨
 * @createdAt 2020-12-31 23:08:18
 *
 */
public class Switch extends CheckBox {
	
	public Switch() {
		this("");
	}
	
	public Switch(String text) {
		super(text);
		getStyleClass().add("switch-box");
	}
}