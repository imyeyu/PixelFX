package net.imyeyu.pixelfx;

import javafx.scene.Node;
import javafx.scene.text.Font;

/**
 * 最象素字体，默认 24px，小号 12px
 * 
 * @author 夜雨
 */
public class Zpix {
	
	public static int S = 12, M = 24, L = 48;
	
	private static Font s, m, l;
	
	/**
	 * 通过 CSS 修改字号，请置于组件样式修改的最后
	 * 
	 * @param node 组件
	 * @param size 字号，单位：像素
	 */
	public static void css(Node node, int size) {
		node.setStyle(node.getStyle() + "; -fx-font-size: " + size);
	}

	public static Font getS() {
		return s == null ? buildS() : s;
	}
	
	public static Font get() {
		return m == null ? buildM() : m;
	}
	
	public static Font getL() {
		return l == null ? buildL() : l;
	}
	
	private static Font buildS() {
		s = Font.loadFont(Zpix.class.getResourceAsStream("zpix.ttf"), S);
		return s;
	}
	
	private static Font buildM() {
		m = Font.loadFont(Zpix.class.getResourceAsStream("zpix.ttf"), M);
		return m;
	}
	
	private static Font buildL() {
		l = Font.loadFont(Zpix.class.getResourceAsStream("zpix.ttf"), L);
		return l;
	}
}