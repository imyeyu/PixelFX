package net.imyeyu.pixelfx.component;

import javafx.scene.control.CheckBox;

/**
 * 滑动开关，需要 CSS 支持
 * 
 * 夜雨 创建于 2021/2/13 13:35
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