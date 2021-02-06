package net.imyeyu.px.bean;

import javafx.scene.image.Image;
import net.imyeyu.px.PixelFX;

/**
 * 提示等级
 * 
 * @author 夜雨
 * @createdAt 2021-01-10 14:34:57
 *
 */
public enum TipsLevel {

	TIPS("TIPS"),       // 一般
	SUCCESS("SUCCESS"), // 成功
	WARNING("WARNING"), // 警告
	ERROR("ERROR");     // 错误

	private String typeName;
	
	private TipsLevel(String typeName) {
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
		switch (type) {
			case TIPS:    return "提示";
			case SUCCESS: return "成功";
			case WARNING: return "警告";
			case ERROR:   return "错误";
			default:      return "";
		}
	}
	
	public static Image toImg(TipsLevel type) {
		String fileName;
		switch (type) {
			case SUCCESS: fileName = "success.png"; break;
			case WARNING: fileName = "warning.png"; break;
			case ERROR:   fileName = "error.png";   break;
			default:      return null;
		}
		return new Image(PixelFX.RES_PATH + fileName);
	}
	
	public String getTypeName() {
        return this.typeName;
    }
}