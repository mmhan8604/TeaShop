package com.example.interf;

import java.util.HashMap;
import java.util.LinkedList;

public interface ShopIndexService {

	public HashMap<String, Object> getStyle(Integer shopid);
	public LinkedList<String> createBigDivHTML(Integer shopid);
}
