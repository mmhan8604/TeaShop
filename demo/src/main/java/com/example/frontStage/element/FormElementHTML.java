package com.example.frontStage.element;

public class FormElementHTML {
	private String headerText1;
	private String headerText2;
	private String childBackroundColor;
	private String childBackroundImg;
	private String formImg;
	
	private String formElement;
	


	public FormElementHTML(int type,String headerText1, String headerText2, String childBackroundColor, String childBackroundImg,
			String formImg) {
		super();
		this.headerText1 = headerText1;
		this.headerText2 = headerText2;
		this.childBackroundColor = childBackroundColor;
		this.childBackroundImg = childBackroundImg;
		this.formImg = formImg;
		
		if(type==1) {
			createFormElement01();
		}else {
			createFormElement02();
		}
	}
	
	public String createFormElement01() {
		formElement=String.format("<div class='child ' style='background-image:%s ; background-color:%s ; display: flex;flex-direction: column;justify-content: center;align-items: center;height: 100%%;padding: 3%%;'>\r\n"
				+ "  <h1 class='headerText1 '>%s</h1>\r\n"
				+ "  <h4 class='headerText2' >%s</h4>\r\n"
				+ "  <div class='rounded' style='padding-right: 15px; padding-left: 15px; margin-right: auto;'>\r\n"
				+ "      <div class='row '>\r\n"
				+ "\r\n"
				+ "          <!--左側圖片區-->\r\n"
				+ "          <div class='col-md-5' id='image-area01' style='padding: 0; '>\r\n"
				+ "              <div class='imageArea02' id='IE-image-element'>\r\n"
				+ "                  <!-- 插入圖片 -->\r\n"
				+ "                  <img src='%s' class='img-fluid' alt='圖片1'>\r\n"
				+ "              </div>\r\n"
				+ "          </div>\r\n"
				+ "\r\n"
				+ "          <!--右側表單區-->\r\n"
				+ "\r\n"
				+ "          <div class='formArea col-md-7'>\r\n"
				+ "\r\n"
				+ "              <form>\r\n"
				+ "                  <div class='row'>\r\n"
				+ "                      <div class='col-md-6'>\r\n"
				+ "                          <div class='mb-3'>\r\n"
				+ "                              <label for='username' class='form-label'></label>\r\n"
				+ "                              <input type='text' class='form-control mt-2' id='userName' placeholder='姓名'>\r\n"
				+ "                          </div>\r\n"
				+ "                      </div>\r\n"
				+ "\r\n"
				+ "                      <div class='col-md-6'>\r\n"
				+ "                          <div class='mb-3'>\r\n"
				+ "                              <label for='userphone' class='form-label'></label>\r\n"
				+ "                              <input type='text' class='form-control mt-2' id='userPhone' placeholder='手機號碼'>\r\n"
				+ "                          </div>\r\n"
				+ "                      </div>\r\n"
				+ "                  </div>\r\n"
				+ "\r\n"
				+ "                  <div class='row'>\r\n"
				+ "                      <div class='col-md-6'>\r\n"
				+ "                          <div class='mb-3'>\r\n"
				+ "                              <label for='useremail' class='form-label'></label>\r\n"
				+ "                              <input type='text' class='form-control mt-2' id='userEmail' placeholder='電子郵件'>\r\n"
				+ "                          </div>\r\n"
				+ "                      </div>\r\n"
				+ "\r\n"
				+ "                      <div class='col-md-6'>\r\n"
				+ "                          <div class='mb-3'>\r\n"
				+ "                              <label for='usersubject' class='form-label'></label>\r\n"
				+ "                              <input type='text' class='form-control mt-2' id='userSubject' placeholder='主旨'>\r\n"
				+ "                          </div>\r\n"
				+ "                      </div>\r\n"
				+ "                  </div>\r\n"
				+ "\r\n"
				+ "                  <div class='row'>\r\n"
				+ "                      <div class='col-md-12'>\r\n"
				+ "                          <div class='mb-3'>\r\n"
				+ "                              <label for='usercontent' class='form-label'></label>\r\n"
				+ "                              <input type='text' class='form-control mt-2' id='userContent' placeholder=' 建議內容'>\r\n"
				+ "                          </div>\r\n"
				+ "                      </div>\r\n"
				+ "                  </div>\r\n"
				+ "\r\n"
				+ "                  <!-- 送出 -->\r\n"
				+ "                  <button type='submit' class='btn btn-primary mt-3' id='send'>送出</button>\r\n"
				+ "\r\n"
				+ "              </form>\r\n"
				+ "          </div>\r\n"
				+ "      </div>\r\n"
				+ "  </div>\r\n"
				+ "</div>\r\n"
				+ "",childBackroundImg,childBackroundColor,headerText1,headerText2,formImg );
		
		return formElement;
	}
	
	public String createFormElement02() {
		
		formElement=String.format("<div class='child'\r\n"
				+ "style='background-color:%s;  background-image:%s ; display: flex; flex-direction: column; justify-content: center; align-items: center; height: 100%%; padding: 3%%;'>\r\n"
				+ "\r\n"
				+ "<h1 class='headerText1'>聯絡我們</h1>\r\n"
				+ "\r\n"
				+ "<form id='contactForm'>\r\n"
				+ "    <div class='row' style='margin: 50px 10px 15px 10px; justify-content: center;'>\r\n"
				+ "        <div class='col-md-5' style='margin-bottom: 15px;'><input type='text' style='height: 80px;'\r\n"
				+ "                class='form-control' placeholder='姓名'>\r\n"
				+ "        </div>\r\n"
				+ "        <div class='col-md-5' style='margin-bottom: 15px;'><input type='text' style='height: 80px;'\r\n"
				+ "                class='form-control' placeholder='手機號碼'>\r\n"
				+ "        </div>\r\n"
				+ "    </div>\r\n"
				+ "    <div class='row' style='margin: 15px 10px 15px 10px; justify-content: center;'>\r\n"
				+ "        <div class='col-md-5' style='margin-bottom: 15px;'><input type='text' style='height: 80px;'\r\n"
				+ "                class='form-control' placeholder='電子郵件'>\r\n"
				+ "        </div>\r\n"
				+ "        <div class='col-md-5' style='margin-bottom: 15px;'><input type='text' style='height: 80px;'\r\n"
				+ "                class='form-control' placeholder='聯絡主旨'>\r\n"
				+ "        </div>\r\n"
				+ "    </div>\r\n"
				+ "    <div class='row' style='margin: 15px 10px 15px 10px; justify-content: center;'>\r\n"
				+ "        <div class='col-md-10' style='margin-bottom: 15px;'><input type='text' style='height: 200px;'\r\n"
				+ "                class='form-control' placeholder='聯絡內容'></div>\r\n"
				+ "    </div>\r\n"
				+ "    <div class='row'>\r\n"
				+ "        <div class='col'>\r\n"
				+ "            <button class='btn btn-lg' type='submit'\r\n"
				+ "                style='background-color: #829465; color:white; margin-bottom: 5%%; margin-right: 10%%; float:right;'>送出</button>\r\n"
				+ "        </div>\r\n"
				+ "    </div>\r\n"
				+ "</form>\r\n"
				+ "</div>", childBackroundColor,childBackroundImg);
		
		return formElement;
	}

	public String getHeaderText1() {
		return headerText1;
	}

	public void setHeaderText1(String headerText1) {
		this.headerText1 = headerText1;
	}

	public String getHeaderText2() {
		return headerText2;
	}

	public void setHeaderText2(String headerText2) {
		this.headerText2 = headerText2;
	}

	public String getChildBackroundColor() {
		return childBackroundColor;
	}

	public void setChildBackroundColor(String childBackroundColor) {
		this.childBackroundColor = childBackroundColor;
	}

	public String getChildBackroundImg() {
		return childBackroundImg;
	}

	public void setChildBackroundImg(String childBackroundImg) {
		this.childBackroundImg = childBackroundImg;
	}

	public String getFormImg() {
		return formImg;
	}

	public void setFormImg(String formImg) {
		this.formImg = formImg;
	}

	public String getFormElement() {
		return formElement;
	}
	

}
