package net.imyeyu.pixelfx.bean;

import javafx.scene.image.Image;

/**
 * 提示等级
 * 
 * 夜雨 创建于 2021/2/13 13:27
 */
public enum TipsLevel {

	TIPS("TIPS"),       // 一般
	SUCCESS("SUCCESS"), // 成功
	WARNING("WARNING"), // 警告
	ERROR("ERROR");     // 错误

	private final String typeName;
	
	TipsLevel(String typeName) {
        this.typeName = typeName;
    }
	
	public static TipsLevel fromTypeName(String typeName) {
        for (TipsLevel type : TipsLevel.values()) {
            if (type.getTypeName().equals(typeName)) {
                return type;
            }
        }
        return null;
    }
	
	public static String toString(TipsLevel type) {
		return switch (type) {
			case TIPS    -> "提示";
			case SUCCESS -> "成功";
			case WARNING -> "警告";
			case ERROR   -> "错误";
		};
	}
	
	public static Image toImg(TipsLevel type) {
		switch (type) {
			case SUCCESS -> {
				return new Image("success.png");
			}
			case WARNING -> {
				return new Image("warning.png");
			}
			case ERROR   -> {
				return new Image("error.png");
			}
		}
		return null;
	}
	
	public String getTypeName() {
        return this.typeName;
    }
}