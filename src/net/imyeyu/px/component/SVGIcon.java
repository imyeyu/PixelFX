package net.imyeyu.px.component;

import javafx.scene.shape.SVGPath;

/**
 * SVG 图标，主要简化 SVGPath 构造函数
 * 
 * @author 夜雨
 *
 */
public class SVGIcon extends SVGPath {

	public SVGIcon(String path) {
		setContent(path);
	}
}