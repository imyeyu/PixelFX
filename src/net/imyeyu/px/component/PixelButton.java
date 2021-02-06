package net.imyeyu.px.component;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import net.imyeyu.px.PixelFX;
import net.imyeyu.px.extend.BgFill;

/**
 * <br>像素风按钮
 * <br>默认内边距 [3, 14, 5, 18]
 * 
 * @author 夜雨
 * @createdAt 2021-01-02 15:03:07
 *
 */
public class PixelButton extends Button {
	
	private DropShadow shadow = new DropShadow();
	
	private Background bgDedault = new BgFill("#EEE", "#DADADA").toBottom().build();
	private Background bgHover = new BgFill("#F8F8F8", "#E5E5E5").toBottom().build();
	private Background bgPressed = new BgFill("#EEE").build();
	
	public PixelButton() {
		this("");
	}
	
	public PixelButton(String text) {
		super(text);
		
		getStyleClass().clear();
		
		shadow.setRadius(0);
		shadow.setOffsetX(1);
		shadow.setOffsetY(1);
		shadow.setSpread(1);
		shadow.setColor(Color.valueOf("#000A"));
		
		setEffect(shadow);
		setBackground(bgDedault);
		setBorder(PixelFX.BORDER_DEFAULT);
		setPadding(new Insets(3, 14, 5, 18));
		
		// 指向
		hoverProperty().addListener((obs, o, isHover) -> setBackground(isHover ? bgHover : bgDedault));
		// 聚焦
		focusedProperty().addListener((obs, o, isFocused) -> {
			setBorder(isFocused ? PixelFX.BORDER_FOCUSED : PixelFX.BORDER_DEFAULT);	
		});
		// 禁用
		disabledProperty().addListener((obs, o, isDisabled) -> setOpacity(isDisabled ? .5 : 1));
		
		// 移出
		setOnMouseExited(event -> setBackground(bgDedault));
		// 点击
		setOnMouseClicked(event -> setBackground(bgPressed));
		// 按下
		setOnMousePressed(event -> {
			setEffect(null);
			setTranslateX(1);
			setTranslateY(1);
		});
		// 松开
		setOnMouseReleased(event -> {
			setTranslateX(0);
			setTranslateY(0);
			setEffect(shadow);
		});
	}
}