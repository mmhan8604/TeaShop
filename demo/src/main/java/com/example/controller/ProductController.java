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
import com.example.service.ProductServiceImpl;

@RestController
public class ProductController {
	@Autowired
	ProductServiceImpl productService;

	@PostMapping("/addProduct")
	public String AddProduct(@RequestBody Products products) {

		System.out.println("新增" + products.toString());
		// System.out.println(products.getActivity().getID());
		productService.addProduct(products);
		return products.toString();
	}

//	@PostMapping("/delProduct")
//	public String delProduct(@RequestBody Products products) {
//
//		System.out.println("刪除id" + products.getId());
//		productService.delProduct(products);
//		return products.toString();
//	}

//	@PostMapping("/editProduct/{id}")
//	public String editProduct(@RequestBody Products products) {
//
//		System.out.println("修改id" + products.getId());
//		productService.editProduct(products);
//		return products.toString();
//	}

	@PostMapping("/queryProduct")
	public List<Products> queryProduct(@RequestBody String shopId) {
		System.out.println("查詢全部" + shopId);
		return productService.queryProduct(shopId);
	}

	@PostMapping("/queryProductByname")
	public List<Products> queryProductByName(@RequestBody String name) {
		System.out.println("查詢部分:" + name);
		return productService.queryProductByName(name);
	}

//	@PostMapping("/queryProductById")
//	public List<Products> queryProductById(@RequestBody String id) {
//		System.out.println("查詢部分:"+id);
//		List<Products> list= new ArrayList<>();
//		list.add(productService.queryProductById(id));
//		return list;
//	}

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

	@PostMapping("/updateProducts/{id}")
	public ResponseEntity<?> updateProduct(@PathVariable String id, @RequestBody Products products) {
		Products updateProducts = productService.updateProduct(id, products);
		if (updateProducts != null) {
			return ResponseEntity.ok(updateProducts);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
