package com.example.interf;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public interface ShopIndexService {

	public HashMap<String, Object> getStyle(Integer shopid);
	public HashMap<String, List> createBigDivHTML(Integer shopid);
}
