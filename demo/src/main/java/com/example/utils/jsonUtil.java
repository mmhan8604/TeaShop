package com.example.utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;

public class jsonUtil {
    public static LinkedList<String> toLinkedList(String json) {
        JSONArray ja = new JSONArray(json);
        List<Object> objectList = ja.toList();
        
        // 創建新的 LinkedList<String> 來保存轉換後的值
        LinkedList<String> stringLinkedList = new LinkedList<>();

        // 遍歷 List<Object>
        for (Object obj : objectList) {
            // 檢查元素類型是否為 String
            if (obj instanceof String) {
                // 將 String 元素添加到新的 LinkedList<String> 中
                stringLinkedList.add((String) obj);
            } else {
                // 如果類型不是 String，你可以選擇忽略或者進行其他處理
                // 在這裡我們可以跳過該元素或者拋出異常
                // 例如：throw new IllegalArgumentException("元素不是 String 類型");
            }
        }

        // 返回轉換後的 LinkedList<String>
        return stringLinkedList;
    }
    
    public static LinkedList<String> objtoLinkedList(Object list){
    	ArrayList<Object>alist= (ArrayList<Object>)list;
    	LinkedList<String>llist = new LinkedList<String>();
    	for(int i=0;i<alist.size();i++) {
    		llist.add(alist.get(i).toString());
    	}
    	
    	return(llist);
    }
}