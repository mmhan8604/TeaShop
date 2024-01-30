package com.example.service;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;

import com.example.classes.shopInfo;
import com.example.interf.SetShopInfoSerivice;
import com.example.repository.SetShopDao;
import com.example.utils.imgUtil;



@Component
public class SetShopInfoSeriviceImpl implements SetShopInfoSerivice {
	
	;
	@Autowired
	SetShopDao ssd;
	com.example.entity.shopInfo siEntity;
	
	@Transactional
	public int updateInfo(shopInfo si,String email) {
		int state = 0;
		
		siEntity= ssd.findByEmail(email).get(0);
		siEntity.setAddress(!si.getAddress().equals("")?si.getAddress():siEntity.getAddress());
		siEntity.setName(!si.getName().equals("")?si.getName():siEntity.getName());
		siEntity.setPhone(!si.getTel().equals("")?si.getTel():siEntity.getPhone());
		siEntity.setShopName(!si.getShopName().equals("")?si.getShopName():siEntity.getShopName());
		siEntity.setShopLogoUrl(!si.getLogo().equals("")?si.getLogo():siEntity.getShopLogoUrl());
		siEntity.setShopIntro(!si.getIntro().equals("")?si.getIntro():siEntity.getShopIntro());
		siEntity.setBankAccount(!si.getBankAccount().equals("")?si.getBankAccount():siEntity.getShopIntro());
		siEntity.setEmail(!si.getEmail().equals("")?si.getEmail():siEntity.getEmail());
		
		if(!si.getCover().equals("")) {
			try {
				String coverUrl= saveCover(si.getCover());
				siEntity.setShopCoverURL(coverUrl);
			} catch (IOException e) {
				
				state=1;
			}
		}
		
		try {
			ssd.save(siEntity);
		} catch (Exception e) {
			state=2;
		}
		
		return state;
		
	}
	
	
	private String saveCover(String coverUri) throws IOException {
		byte[] cover= Base64.getDecoder().decode(imgUtil.extractBase64FromUri(coverUri));
		String fileName="cover_"+siEntity.getId()+"."+imgUtil.getImageExtensionFromBase64(coverUri);
		// 获取static目录的路径
		 String staticPath = Paths.get("src", "main", "resources", "static", "shopCover").toString();

        // 生成完整文件路径
        String filePath = Paths.get(staticPath, fileName).toString();
        
        FileOutputStream fos = new FileOutputStream(new File(filePath));
        FileCopyUtils.copy(cover, fos);
        fos.flush();
        fos.close();
        
        return filePath;
        
	}
	
	   

	

	

}
