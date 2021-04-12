package net.imyeyu.pixelfx.component;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.paint.Color;
import net.imyeyu.betterfx.BetterFX;
import net.imyeyu.betterfx.extend.BgFill;

/**
 * <br>像素风按钮
 * <br>默认内边距 [3, 14, 5, 18]
 * 
 * 夜雨 创建于 2021/2/13 13:32
 */
public class PixelButton extends Button {
	
	private final DropShadow shadow = new DropShadow();
	
	private final Background bgDedault = new BgFill("#EEE", "#DADADA").toBottom().build();
	private final Background bgHover = new BgFill("#F8F8F8", "#E5E5E5").toBottom().build();
	private final Background bgPressed = new BgFill("#EEE").build();

	private Border borderFocused = BetterFX.BORDER_FOCUSED;
	private Border borderDefault = BetterFX.BORDER_DEFAULT;

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
		setBorder(BetterFX.BORDER_DEFAULT);
		setPadding(new Insets(3, 14, 5, 18));
		
		// 指向
		hoverProperty().addListener((obs, o, isHover) -> setBackground(isHover ? bgHover : bgDedault));
		// 聚焦
		focusedProperty().addListener((obs, o, isFocused) -> setBorder(isFocused ? borderFocused : borderDefault));
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

	public void setBorderDefault(Border borderDefault) {
		setBorder(borderDefault);
		this.borderDefault = borderDefault;
	}

	public void setBorderFocused(Border borderFocused) {
		this.borderFocused = borderFocused;
	}

	public void clearClickEffect() {
		setEffect(null);
		setOnMousePressed(null);
		setOnMouseReleased(null);
	}
}