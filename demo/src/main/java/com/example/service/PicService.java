package com.example.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.util.Base64;

import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import com.example.utils.imgUtil;

@Service
public class PicService {
	public String MainPicIO(String picUri,String productId) {
		byte[] cover= Base64.getDecoder().decode(imgUtil.extractBase64FromUri(picUri));
		String fileName="MainPic_"+productId+"."+imgUtil.getImageExtensionFromBase64(picUri);
		// 获取static目录的路径
		 String staticPath = Paths.get("src", "main", "resources","static","frontstage","productPic").toString();

        // 生成完整文件路径
        String filePath = Paths.get(staticPath, fileName).toString();
        String fileSrc = "/"+Paths.get("frontstage","productPic", fileName).toString();
        fileSrc=fileSrc.replace("\\", "/");
        System.out.println(fileSrc);
        FileOutputStream fos;
		try {
			fos = new FileOutputStream(new File(filePath));
			FileCopyUtils.copy(cover, fos);
			fos.flush();
			fos.close();
        
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return fileSrc;
		
		
	}
}
