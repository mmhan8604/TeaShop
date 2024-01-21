package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.classes.FrontLoginClasses;
import com.example.entity.Products;
import com.example.service.ProductService;
import com.example.utils.EcpayReturnConverter;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/shop")
public class Viewcontroller {
	@Autowired
	ProductService productService;
	
	
	
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
	
	@GetMapping("/{shopId}/shopindex")
	public String shopindex(HttpSession session,Model model,@PathVariable int shopId) {
		FrontLoginClasses loginInfo= (FrontLoginClasses)session.getAttribute("authObject");
		setAllLoginInfo(loginInfo, model, shopId);		
				
		return "shopPage/index.html";		//前台畫面
		
	}
	
	@GetMapping("/{shopId}/aboutUs")
	public String shopAbout(HttpSession session,Model model,@PathVariable int shopId) {
		FrontLoginClasses loginInfo= (FrontLoginClasses)session.getAttribute("authObject");
		setAllLoginInfo(loginInfo, model, shopId);		
		
		return "/shopPage/about.html";		//前台畫面
		
	}
	
	@GetMapping("/{shopId}/shoppingPage")
	public String shoppingPage(HttpSession session,Model model,@PathVariable int shopId) {
		FrontLoginClasses loginInfo= (FrontLoginClasses)session.getAttribute("authObject");
		setAllLoginInfo(loginInfo, model, shopId);		
		
		return "/shopPage/shoppingPage.html";		//前台畫面
		
	}
	
	@GetMapping("/{shopId}/contactUs")
	public String contactUs(HttpSession session,Model model,@PathVariable int shopId) {
		FrontLoginClasses loginInfo= (FrontLoginClasses)session.getAttribute("authObject");
		setAllLoginInfo(loginInfo, model, shopId);		
		
		return "/shopPage/connection.html";		//前台畫面
		
	}
	
	@GetMapping("/{shopId}/shoppingCart")
	public String shoppingCart(HttpSession session,Model model,@PathVariable int shopId) {
		FrontLoginClasses loginInfo= (FrontLoginClasses)session.getAttribute("authObject");
		setAllLoginInfo(loginInfo, model, shopId);		
		
		return "/shopPage/cart01.html";		//購物車		
	}
	
	@GetMapping("/{shopId}/productPage")
	public String productPage(HttpSession session,@RequestParam String productId,Model model,@PathVariable int shopId) {
		FrontLoginClasses loginInfo= (FrontLoginClasses)session.getAttribute("authObject");
		setAllLoginInfo(loginInfo, model, shopId);		
		
		
		Products product = productService.queryProductById(productId);
		model.addAttribute("productId", product.getId());
		model.addAttribute("productName", product.getName());
		model.addAttribute("productPrice", product.getPrice());
//		model.addAttribute("productDiscription", product.getDiscription());
		model.addAttribute("productDiscription", "資料庫尚無打上敘述，僅測試用");
		return "/shopPage/product";		//商品頁	
	}
	
	@GetMapping("/{shopId}/orderPayment")
	public String orderPayment(HttpSession session,Model model,@PathVariable int shopId) {
		FrontLoginClasses loginInfo= (FrontLoginClasses)session.getAttribute("authObject");
		setAllLoginInfo(loginInfo, model, shopId);		
		
		return "/shopPage/cart03.html";		//付款、運送方式等等		
	}
	
	@GetMapping("/{shopId}/orderInfo")
	public String orderInfo(HttpSession session,Model model,@PathVariable int shopId) {
		FrontLoginClasses loginInfo= (FrontLoginClasses)session.getAttribute("authObject");
		setAllLoginInfo(loginInfo, model, shopId);		
		
		return "/shopPage/cart04.html";		//訂購人等等		
	}
	
	@GetMapping("/{shopId}/confirmOrder")
	public String confirmOrder(HttpSession session,Model model,@PathVariable int shopId) {
		FrontLoginClasses loginInfo= (FrontLoginClasses)session.getAttribute("authObject");
		setAllLoginInfo(loginInfo, model, shopId);		
		
		return "/shopPage/cart05.html";		//確認訂單等等		
	}
	
	@GetMapping("/{shopId}/regist")
	public String registPage(HttpSession session,Model model,@PathVariable int shopId) {
		FrontLoginClasses loginInfo= (FrontLoginClasses)session.getAttribute("authObject");
		setAllLoginInfo(loginInfo, model, shopId);		
		
		return "/shopPage/teaShopRegist.html";		//確認訂單等等		
	}
	
	@GetMapping("/{shopId}/login")
	public String loginPage(HttpSession session,Model model,@PathVariable int shopId) {
		FrontLoginClasses loginInfo= (FrontLoginClasses)session.getAttribute("authObject");
		setAllLoginInfo(loginInfo, model, shopId);		
		
		return "/shopPage/teaShopLogin.html";		//確認訂單等等		
	}
	
	
	
	
	
	//內部方法，用於給動態網頁用戶及商店資訊
	private void setAllLoginInfo(FrontLoginClasses loginInfo, Model model,int shopId) {
		
		if(loginInfo!=null&&loginInfo.getShopId()==shopId) {
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
		model.addAttribute("shopId", shopId);
		
	}
	
	
	
	
}
