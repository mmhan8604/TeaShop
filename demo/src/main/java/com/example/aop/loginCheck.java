package com.example.aop;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Aspect
@Component
//針對登入相關功能以外的所有controller檢查user是否有登入，若否拋出loginException
public class loginCheck {
	@Pointcut("within(com.example.controller..*) && !within(com.example.controller.view.backstageLogin) && !within(com.example.controller.loginController)") // 可以根据实际情况修改切点表达式
    private void requestMappingMethods() {}
	
	@Before("requestMappingMethods()")
	public void checkLoginStatus()  {
		 ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		 
		 if (attributes != null) {
			    HttpServletRequest request = attributes.getRequest();
			    HttpSession session = request.getSession();
			    
			    if (session == null ||session.getAttribute("email") == null) {
		            throw new loginException();
		            // 或者根据实际需求进行重定向等操作
		        }
		 }else {
			 throw new RuntimeException("http error");
		}
		
		
	}
	
	

}
