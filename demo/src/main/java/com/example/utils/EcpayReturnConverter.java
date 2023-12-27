package com.example.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public class EcpayReturnConverter {
	public static void main (String[] args) {	//測試用
		convertToJSON("CustomField1=&CustomField2=&CustomField3=&CustomField4=&MerchantID=2000132\r\n"
				+ "&MerchantTradeNo=Test1510056539&PaymentDate=2017/11/02 16:22:18\r\n"
				+ "&PaymentType=Credit_CreditCard&PaymentTypeChargeFee=1&RtnCode=1&RtnMsg=交易成功&SimulatePaid=0&StoreID=&TradeAmt=100&TradeDate=2017/11/07 20:08:59&TradeNo=17110720085960236789\r\n"
				+ "&CheckMacValue=9139AF2AC5D0F9EBC5F3CD44064F666AAA62F0B202B95B341CC25E080EA4FC6E");
	}
	
	
    public static String convertToJSON (String returnInfo) {	//轉換回傳的東西
        // 提供的URL編碼字串
        String urlEncodedString = returnInfo;

        try {
            // 步驟1: 解碼URL編碼的字串
            String decodedString = URLDecoder.decode(urlEncodedString, "UTF-8");

            // 步驟2: 將解碼後的字串解析為鍵值對
            Map<String, String> formDataMap = parseFormData(decodedString);

            // 將Map轉換為JSON字串
            String jsonString = mapToJson(formDataMap);

            // 印出結果
            
//            System.out.println(decodedString);
//            System.out.println(formDataMap);
//            System.out.println(jsonString);
            return jsonString;
        } catch (UnsupportedEncodingException e) {
            
            return e.toString();
        }
        
    }

    private static Map<String, String> parseFormData(String formData) {
        Map<String, String> formDataMap = new HashMap<>();
        String[] pairs = formData.split("&");

        for (String pair : pairs) {
            String[] keyValue = pair.split("=");
            if (keyValue.length == 2) {
                formDataMap.put(keyValue[0], keyValue[1]);
            } else {
                formDataMap.put(keyValue[0], ""); // 處理沒有值的情況
            }
        }

        return formDataMap;
    }

    private static String mapToJson(Map<String, String> formDataMap) {
        // 使用Jackson庫或其他JSON庫將Map轉換為JSON字串
        // 這裡只是個例子，你需要根據你的實際情況選擇和配置相應的庫
        // 可以使用ObjectMapper類來實現
        // ObjectMapper objectMapper = new ObjectMapper();
        // String jsonString = objectMapper.writeValueAsString(formDataMap);

        // 由於此處沒有Jackson庫的依賴，簡單地將Map輸出為JSON格式的字串
        StringBuilder jsonBuilder = new StringBuilder("{");
        for (Map.Entry<String, String> entry : formDataMap.entrySet()) {
            jsonBuilder.append("\"").append(entry.getKey()).append("\":\"").append(entry.getValue()).append("\",");
        }
        jsonBuilder.deleteCharAt(jsonBuilder.length() - 1); // 移除最後一個逗號
        jsonBuilder.append("}");

        return jsonBuilder.toString();
    }
}
