package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.classes.FrontLoginClasses;
import com.example.entity.Products;
import com.example.service.ProductService;
import com.example.utils.EcpayReturnConverter;

import jakarta.servlet.http.HttpSession;

@Controller
public class Viewcontroller {
	@Autowired
	ProductService productService;
	
	
	@GetMapping(value = "/model")
	// 將Model 作為Controller 的引數，由Spring 框架自動創建並作為參數傳入
	public String model(Model model) {
		// 設定傳遞資料
	  model.addAttribute("message", "Hello thymeleaf. (using Model)");

		// 返回值指定頁面路徑a
	  return "model";
	}
	@PostMapping("/clientReturn")									//付款後client端接綠界跳轉		//由表單直接跳轉post所以可以收到
	public String clientReturn(@RequestBody String returnMsg,Model model) {
		String MSgJSON = EcpayReturnConverter.convertToJSON(returnMsg);
		System.out.println("clientReturn:"+MSgJSON);
		model.addAttribute("jsonData", MSgJSON);

		return "/payresult";
	}
	
	@GetMapping("/backstage")				//後台畫面
	public String backstageView(HttpSession session) {
		
		return "/mainIndex";
	}
	
	@GetMapping("/shopindex")
	public String shopindex(HttpSession session,Model model) {
		FrontLoginClasses loginInfo= (FrontLoginClasses)session.getAttribute("authObject");
		
		setLoginInfo(loginInfo, model);
		
		return "/shopPage/index.html";		//前台畫面
		
	}
	
	@GetMapping("/aboutUs")
	public String shopAbout() {
		return "/shopPage/about.html";		//前台畫面
		
	}
	
	@GetMapping("/shoppingPage")
	public String shoppingPage() {
		return "/shopPage/shoppingPage.html";		//前台畫面
		
	}
	
	@GetMapping("/contactUs")
	public String contactUs() {
		return "/shopPage/connection.html";		//前台畫面
		
	}
	
	@GetMapping("/shoppingCart")
	public String shoppingCart() {
		return "/shopPage/cart01.html";		//購物車		
	}
	
	@GetMapping("/productPage")
	public String productPage(@RequestParam String productId,Model model) {
		System.out.println(productId);
		Products product = productService.queryProductById(productId);
		model.addAttribute("productId", product.getId());
		model.addAttribute("productName", product.getName());
		model.addAttribute("productPrice", product.getPrice());
//		model.addAttribute("productDiscription", product.getDiscription());
		model.addAttribute("productDiscription", "資料庫尚無打上敘述，僅測試用");
		return "/shopPage/product";		//商品頁	
	}
	
	@GetMapping("/orderPayment")
	public String orderPayment() {
		return "/shopPage/cart03.html";		//付款、運送方式等等		
	}
	
	@GetMapping("/orderInfo")
	public String orderInfo() {
		return "/shopPage/cart04.html";		//訂購人等等		
	}
	
	@GetMapping("/confirmOrder")
	public String confirmOrder() {
		return "/shopPage/cart05.html";		//確認訂單等等		
	}
	
	@GetMapping("/regist")
	public String registPage() {
		return "/shopPage/teaShopRegist.html";		//確認訂單等等		
	}
	
	@GetMapping("/{shopId}/login")
	public String loginPage(@PathVariable int shopId) {
		return "/shopPage/teaShopLogin.html";		//確認訂單等等		
	}
	
	
	
	
	
	//內部方法 用於給動態網頁用戶資訊
	private void setLoginInfo(FrontLoginClasses loginInfo, Model model) {
		if(loginInfo!=null) {
			String user = loginInfo.getDisplayName();
			String email = loginInfo.getEmail();
			
			if (loginInfo.getEmailVerified()&&email!=null) {
				if(user!=null) {
					model.addAttribute("userName", user);
				}else {
					model.addAttribute("userName", email);
				}
			} else {
				model.addAttribute("userName", null);
			}
		}
	}
	
	
}
