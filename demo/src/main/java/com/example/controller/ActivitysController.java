package com.example.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.classes.ActivitysDTO;
import com.example.entity.Activitydetails;
import com.example.entity.Activitys;
import com.example.entity.Products;
import com.example.service.ActivityService;
import com.example.utils.Tools;

import jakarta.servlet.http.HttpSession;

@RestController
public class ActivitysController {
	@Autowired
	private ActivityService activityService;


	//查全部活動
	@PostMapping("/queryActivitys")
	public List<Activitys> queryActivitys(@RequestBody String shopId,HttpSession session) {
		String shopid =Tools.intObjToString( session.getAttribute("backShopId"));
		System.out.println("查詢全部" + shopid);
		return activityService.queryActivitys(shopid);
	}

	//增加活動
	@PostMapping("/addActivity")
	public String addActivityWithDetails(@RequestBody ActivitysDTO activitysDTO,HttpSession session) {
		String shopid =Tools.intObjToString( session.getAttribute("backShopId"));
		Activitys activitys = activitysDTO.getActivitys();
		activitys.setShopId(shopid);
		List<Activitydetails> activitydetailsList = activitysDTO.getActivitydetailsList();

		return activityService.addActivityWithDetails(activitys, activitydetailsList);
	}

	//刪除活動
	@PostMapping("/delActivity/{activityId}")
	public ResponseEntity<String> deleteActivitys(@PathVariable String activityId) {
		try {
			activityService.deleteActivitys(activityId);
			return new ResponseEntity<>("Activity and related Activitydetails deleted successfully", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Error deleting activity and activitydetails1",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	//查一筆活動
	@GetMapping("/queryActivitys/{id}")
	public ResponseEntity<ActivitysDTO> getActivityWithDetails(@PathVariable String id) {
		try {
			ActivitysDTO activitysDTO = activityService.getActivityWithDetails(id);
			return new ResponseEntity<>(activitysDTO, HttpStatus.OK);
		} catch (NotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	//編輯活動
	@PostMapping("/updateActivity/{id}")
	public String updateActivityWithDetails(@PathVariable String id, @RequestBody ActivitysDTO activitysDTO) {
		Activitys activitys = activitysDTO.getActivitys();
		List<Activitydetails> activitydetailsList = activitysDTO.getActivitydetailsList();

		return activityService.updateActivityWithDetails(activitys, activitydetailsList);
	}
	
	//查全部產品
	@PostMapping("/findProducts")
	public List<Products> findProducts(@RequestBody String shopId,HttpSession session) {
		String shopid =Tools.intObjToString( session.getAttribute("backShopId"));
		return activityService.queryProducts(shopid);
	}
	
	//依產品id查折扣
	@GetMapping("/queryDiscount/{productId}")
	public Map<String, Double> queryActivitys(@PathVariable String productId) {
		System.out.println("查產品" + productId);
		return activityService.queryDiscount(productId);

	}
	
	//查產品折扣
	@PostMapping("/queryProductdiscount")
	public List<Object[]> queryProductdiscount(@RequestBody String shopId) {
		//String shopid =Tools.intObjToString( session.getAttribute("backShopId"));
		//System.out.println("查詢全部" + shopid);
		return activityService.findProductsAndMinDiscountsByShopId(shopId);
	}


}