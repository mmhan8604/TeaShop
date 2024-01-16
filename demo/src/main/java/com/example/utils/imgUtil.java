package com.example.utils;

public class imgUtil {
	
	public static String  getImageExtensionFromBase64(String base64Data) {
        if (base64Data != null && base64Data.startsWith("data:image/")) {
            int commaIndex = base64Data.indexOf(",");
            if (commaIndex != -1) {
                String mimeType = base64Data.substring("data:image/".length(), commaIndex);
                return mimeType.split(";")[0];
            }
        }
        return null; // 如果无法解析，返回null或者你定义的默认值
    }
	
	public static String extractBase64FromUri(String base64Uri) {
        // 找到逗號後的部分，這部分就是Base64編碼的字串
        int commaIndex = base64Uri.indexOf(',');
        if (commaIndex != -1) {
            return base64Uri.substring(commaIndex + 1);
        } else {
            // 如果找不到逗號，表示格式可能不正確
            throw new IllegalArgumentException("Invalid Base64 URI format");
        }
    }

}
