package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Products;
import com.example.service.PicService;
import com.example.service.ProductServiceImpl;
import com.example.utils.Tools;

import jakarta.servlet.http.HttpSession;

@RestController
public class ProductController {
	@Autowired
	ProductServiceImpl productService;
	@Autowired
	PicService picServic;

	@PostMapping("/queryProduct")
	public List<Products> queryProduct(@RequestBody String shopId,HttpSession session) {
		String shopid =Tools.intObjToString( session.getAttribute("backShopId"));
		System.out.println("查詢全部" + shopid);
		return productService.queryProduct(shopid);
	}
	
	@PostMapping("/frontqueryProduct")
	public List<Products> frontqueryProduct(@RequestBody String shopId) {
		
		return productService.queryProduct(shopId);
	}

	@PostMapping("/queryProductByname")
	public List<Products> queryProductByName(@RequestBody String name) {
		System.out.println("查詢部分:" + name);
		return productService.queryProductByName(name);
	}

//	新增商品
	@PostMapping("/addProduct/{id}")
	public ResponseEntity<?> AddProduct(@PathVariable String id, @RequestBody Products products,HttpSession session) {
		String shopid =Tools.intObjToString( session.getAttribute("backShopId"));
		products.setShopId(shopid);
		if(products.getPicjson()!=null) {
			String mianPicUrl = picServic.MainPicIO(products.getPicjson(), products.getId());
			products.setMainPicBlob(picServic.base64ToBlob(products.getPicjson()));
			products.setPictext_0(null);
			products.setPicjson(mianPicUrl);
			}
		Products addProduct = productService.addProduct(id, products);
		if (addProduct != null) {
			return ResponseEntity.ok(addProduct);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

//	刪除刪品
	@PostMapping("/delProduct/{id}")
	public ResponseEntity<?> delProduct(@PathVariable String id) {
		Products deletedProduct = productService.delProduct(id);

		if (deletedProduct != null) {
			// 成功刪除，可以使用deletedProduct
			return ResponseEntity.ok("Product deleted successfully");
		} else {
			// 找不到要刪除的產品，返回相應的錯誤訊息
			return ResponseEntity.notFound().build();
		}
	}

//	編輯商品
	@GetMapping("/products/{id}")
	public ResponseEntity<?> queryProductById(@PathVariable String id) {
		Optional<Products> Products = productService.findById(id);
		if (Products.isPresent()) {
			Map<String, Object> response = new HashMap<>();
			response.put("product", Products.get());
			return ResponseEntity.ok(response);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

//	更新商品
	@PostMapping("/updateProducts/{id}")
	public ResponseEntity<?> updateProduct(@PathVariable String id, @RequestBody Products products) {
		if(products.getPicjson()!=null) {
			String mianPicUrl = picServic.MainPicIO(products.getPicjson(), products.getId());
			products.setPicjson(mianPicUrl);}
		Products updateProducts = productService.updateProduct(id, products);
		if (updateProducts != null) {
			return ResponseEntity.ok(updateProducts);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// 新增用於更新商品狀態的端點
	@PostMapping("/updateDiscontinued/{id}")
	public ResponseEntity<?> updateDiscontinued(@PathVariable String id, @RequestBody Map<String, Boolean> updateData) {
		boolean discontinued = updateData.get("discontinued");

		// 呼叫服務進行商品狀態的更新
		Products updatedProduct = productService.updateDiscontinued(id, discontinued);

		if (updatedProduct != null) {
			return ResponseEntity.ok(updatedProduct);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
