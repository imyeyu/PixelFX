package net.imyeyu.pixelfx;


import javafx.scene.input.KeyEvent;

/**
 * PixelStage - 像素窗体的键盘事件追加，因为该窗体本身占有默认事件
 * 夜雨 创建于 2021/3/13 13:26
 */
public interface PixelStageKeyPressed {

	void handler(KeyEvent event);
}