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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.classes.FrontLoginClasses;
import com.example.entity.Products;
import com.example.service.FrontloginService;
import com.example.service.ProductService;
import com.example.utils.EcpayReturnConverter;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/shop")
public class ShopViewcontroller {
	@Autowired
	ProductService productService;
	@Autowired
	FrontloginService frontloginService;
	
	
	
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
		model.addAttribute("productDiscription", product.getDiscription());
		model.addAttribute("imgSrc",product.getPicJSON());
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
		model.addAttribute("auth",loginInfo);
		return "/shopPage/cart05.html";		//確認訂單等等		
	}
	
	@GetMapping("/{shopId}/regist")
	public String registPage(HttpSession session,Model model,@PathVariable int shopId) {
		FrontLoginClasses loginInfo= (FrontLoginClasses)session.getAttribute("authObject");
		setAllLoginInfo(loginInfo, model, shopId);	
		
		
		return "/shopPage/teaShopRegist.html";		//註冊		
	}
	
	@GetMapping("/{shopId}/login")
	public String loginPage(HttpSession session,Model model,@PathVariable int shopId) {
		FrontLoginClasses loginInfo= (FrontLoginClasses)session.getAttribute("authObject");
		setAllLoginInfo(loginInfo, model, shopId);		
		
		return "/shopPage/teaShopLogin.html";		//登入	
	}
	
	@GetMapping("/{shopId}/login1")
	public String loginPagex(HttpSession session,Model model,@PathVariable int shopId) {
		FrontLoginClasses loginInfo= (FrontLoginClasses)session.getAttribute("authObject");
		setAllLoginInfo(loginInfo, model, shopId);		
		
		return "/shopPage/memberDetail.html";		//登入	
	}
	
	@GetMapping("{shopId}/checkMember")
	public String checkMember(HttpSession session,@PathVariable int shopId) {
		FrontLoginClasses loginInfo= (FrontLoginClasses)session.getAttribute("authObject");
		String userEmail = loginInfo.getEmail();
		String StringshopId = Integer.toString(loginInfo.getShopId());
		if(frontloginService.checkMember(userEmail,StringshopId)) {
			return "shopPage/index.html";
		}else {
			return "/shopPage/memberDetail.html";
		}
		
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
