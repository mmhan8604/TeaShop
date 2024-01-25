package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.classes.ActivitysDTO;
import com.example.entity.Activitydetails;
import com.example.entity.Activitys;
import com.example.entity.Products;
import com.example.repository.ActivityDetailsRepository;
import com.example.repository.ActivityRepository;
import com.example.repository.ProductsResposity;

import jakarta.transaction.Transactional;
import net.sf.jsqlparser.util.validation.ValidationException;

@Service
public class ActivityService {
	@Autowired
	private ActivityRepository activityRepository;
	
	@Autowired
	private ActivityDetailsRepository activityDetailsRepository;
	
	@Autowired
	private ProductsResposity productsResposity;
	
	
	//查全部
	public List<Activitys> queryActivitys(String shopId) {
		return activityRepository.findByShopId(shopId);	
	}

	//增
	public String addActivityWithDetails(Activitys activitys, List<Activitydetails> activitydetailsList) {
		activityRepository.save(activitys);
		
        for (Activitydetails activitydetails : activitydetailsList) {

            Products existingProduct = productsResposity.findById(activitydetails.getProducts().getId())
                    .orElseThrow();

        	activitydetails.setActivitys(activitys);
            activitydetails.setProducts(existingProduct);
         
            activityDetailsRepository.save(activitydetails);
        }

        return "Activity and Activitydetails added successfully!";
    }


	//刪
    public void deleteActivitys(String activityId) {
		try {
			List<Activitydetails> activitydetaillist= activityDetailsRepository.findByActivitysId(activityId);
			activityDetailsRepository.deleteAll(activitydetaillist);
			activityRepository.deleteById(activityId);
		
		}catch(Exception e) {
			throw new RuntimeException("Error deleting activity and details2", e);
		}
		
    }

	
	//查一筆
	public ActivitysDTO getActivityWithDetails(String activityId) throws NotFoundException {
        Optional<Activitys> activitysOptional = activityRepository.findById(activityId);
        if (activitysOptional.isPresent()) {
            Activitys activitys = activitysOptional.get();
            
            List<Activitydetails> activitydetailsList = activityDetailsRepository.findByActivitysId(activityId);

            ActivitysDTO activitysDTO = new ActivitysDTO();
            activitysDTO.setActivitys(activitys);
            activitysDTO.setActivitydetailsList(activitydetailsList);

            return activitysDTO;
        } else {
            throw new NotFoundException();
        }
    }

	//修
	public String updateActivityWithDetails(Activitys activitys, List<Activitydetails> activitydetailsList) {
		List<Activitydetails> activitydetail= activityDetailsRepository.findByActivitysId(activitys.getId());
		activityDetailsRepository.deleteAll(activitydetail);
		
		activityRepository.save(activitys);

        for (Activitydetails activitydetails : activitydetailsList) {
        	Products existingProduct = productsResposity.findById(activitydetails.getProducts().getId())
                    .orElseThrow();

        	activitydetails.setActivitys(activitys);
            activitydetails.setProducts(existingProduct);
            
            activityDetailsRepository.save(activitydetails);
        }

        return "Activity and Activitydetails edited successfully!";
    }
	
	
	//撈產品
	public List<Products> queryProducts(String shopId) {
		return productsResposity.findByShopIdOrderByNameAsc(shopId);	
	}

	
}

	

