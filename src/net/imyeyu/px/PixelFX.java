package net.imyeyu.px;

import javafx.scene.layout.Border;
import javafx.scene.paint.Paint;
import net.imyeyu.px.extend.BorderX;

/**
 * 像素风 FX 依赖库
 * 
 * @author 夜雨
 * @createdAt 2021-01-17 11:30:27
 *
 */
public class PixelFX {

	/** 资源路径 */
	public static final String RES_PATH = "/net/imyeyu/px/res/";
	/** 样式文件 */
	public static final String CSS = RES_PATH + "pixel.css";
	
	/** 白色 */
	public static final Paint WHITE       = Paint.valueOf("#FFF");
	/** 品红 */
	public static final Paint RED         = Paint.valueOf("#F30");
	/** 褐色 */
	public static final Paint BROWN       = Paint.valueOf("#A67D7B");
	/** 黑色 */
	public static final Paint BLACK       = Paint.valueOf("#000");
	/** 橙色 */
	public static final Paint ORANGE      = Paint.valueOf("#F60");
	/** 绿色 */
	public static final Paint GREEN       = Paint.valueOf("#393");
	/** 灰色 */
	public static final Paint GRAY        = Paint.valueOf("#666");
	/** 天蓝 */
	public static final Paint BLUE        = Paint.valueOf("#008DCB");
	/** 亮灰 */
	public static final Paint LIGHT_GRAY  = Paint.valueOf("#CCC");
	/** 深灰 */
	public static final Paint DARK_GRAY   = Paint.valueOf("#333");
	/** 少女粉 */
	public static final Paint PINK        = Paint.valueOf("#FF7A9B");
	/** 透明 */
	public static final Paint TRANSPARENT = Paint.valueOf("#FFFFFF00");
	
	// 边框
	public static final Border BORDER_DEFAULT = new BorderX("#CCC").build();
	public static final Border BORDER_FOCUSED = new BorderX("#A67D7B").build();
}