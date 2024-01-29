package com.example.frontStage.element;

import java.util.List;

public class ProductElementHTML {
	private String headerText1;
	private String headerText2;
	private String childBackroundColor;
	private String childBackroundImg;
	
	private List<String> productAreaBackround;
	private List<String> productTitleColor;
	private List<String> buttonBorder;
	private List<String> buttonColor;
	private List<String> buttonTextColor;
	
	private String productElement;
	
	public ProductElementHTML(int type,String headerText1, String headerText2, String childBackroundColor,
			String childBackroundImg, List<String> productAreaBackround, List<String> productTitleColor,
			List<String> buttonBorder, List<String> buttonColor, List<String> buttonTextColor) {
		super();
		this.headerText1 = headerText1;
		this.headerText2 = headerText2;
		this.childBackroundColor = childBackroundColor;
		this.childBackroundImg = childBackroundImg;
		this.productAreaBackround = productAreaBackround;
		this.productTitleColor = productTitleColor;
		this.buttonBorder = buttonBorder;
		this.buttonColor = buttonColor;
		this.buttonTextColor = buttonTextColor;
		
		if(type==1) {
			createProductElement01();
		}else if (type==2) {
			createProductElement02();
		}
	}
	
	public String createProductElement01() {
		
		productElement=String.format("<div class='child' style='background-color:%s ; background-image:%s ; display: flex;flex-direction: column;justify-content: center;align-items: center;height: 100%%;padding: 3%%;'>\r\n"
				+ "  <h1 class='headerText1'>%s</h1>\r\n"
				+ "  <h2 class='headerText2'>%s</h2>\r\n"
				+ "  <div class='row' >\r\n"
				+ "      <div class='col-xl-3 col-lg-4 col-md-6 col-12' style=' padding: 10px;'>\r\n"
				+ "          <div class='productArea SetProduct-1' style=\"background-color: %s;\">\r\n"
				+ "              <img class='productImg' src='' alt='圖片1'>\r\n"
				+ "              <div class='product-body'>\r\n"
				+ "                  <h5 class='product-title' style='color: %s; margin: 10px 0 10px 0;'>標題</h5>\r\n"
				+ "                  <p class='product-text'>$價格</p>\r\n"
				+ "                  <div class='clearfix'>\r\n"
				+ "                      <button type='submit' class='btn float-end pButton' style=\"color:%s ;background-color:%s ;border: 1px solid %s; \">購買</button>\r\n"
				+ "                  </div>\r\n"
				+ "              </div>\r\n"
				+ "          </div>\r\n"
				+ "      </div>\r\n"
				+ "  \r\n"
				+ "\r\n"
				+ "      <div class='col-xl-3 col-lg-4 col-md-6 col-12'\r\n"
				+ "          style=' padding: 10px;'>\r\n"
				+ "          <div class='productArea SetProduct-2' style=\"background-color: %s;\">\r\n"
				+ "              <img class='productImg' src='' alt='圖片1'>\r\n"
				+ "              <div class='product-body'>\r\n"
				+ "                  <h5 class='product-title' style='color: %s; margin: 10px 0 10px 0;'>標題</h5>\r\n"
				+ "                  <p class='product-text'>$價格</p>\r\n"
				+ "                  <div class='clearfix'>\r\n"
				+ "                      <button type='submit' class='btn float-end pButton' style=\"color:%s ;background-color:%s ;border: 1px solid %s; \">購買</button>\r\n"
				+ "                  </div>\r\n"
				+ "              </div>\r\n"
				+ "          </div>\r\n"
				+ "      </div>\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "      <div class='col-xl-3 col-lg-4 col-md-6 col-12'\r\n"
				+ "          style=' padding: 10px; '>\r\n"
				+ "          <div class='productArea SetProduct-3' style=\"background-color: %s;\">\r\n"
				+ "              <img class='productImg' src='' alt='圖片1'>\r\n"
				+ "              <div class='product-body'>\r\n"
				+ "                  <h5 class='product-title' style='color: %s; margin: 10px 0 10px 0;'>標題</h5>\r\n"
				+ "                  <p class='product-text'>$價格</p>\r\n"
				+ "                  <div class='clearfix'>\r\n"
				+ "                      <button type='submit' class='btn float-end pButton' style=\"color:%s ;background-color:%s ;border: 1px solid %s; \">購買</button>\r\n"
				+ "                  </div>\r\n"
				+ "              </div>\r\n"
				+ "          </div>\r\n"
				+ "      </div>\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "      <div class='col-xl-3 col-lg-4 col-md-6 col-12'\r\n"
				+ "          style=' padding: 10px;'>\r\n"
				+ "          <div class='productArea SetProduct-4' style=\"background-color: %s;\">\r\n"
				+ "              <img class='productImg' src='' alt='圖片1'>\r\n"
				+ "              <div class='product-body'>\r\n"
				+ "                  <h5 class='product-title' style='color: %s; margin: 10px 0 10px 0;'>標題</h5>\r\n"
				+ "                  <p class='product-text'>$價格</p>\r\n"
				+ "                  <div class='clearfix'>\r\n"
				+ "                      <button type='submit' class='btn float-end pButton' style=\"color:%s ;background-color:%s ;border: 1px solid %s; \">購買</button>\r\n"
				+ "                  </div>\r\n"
				+ "              </div>\r\n"
				+ "          </div>\r\n"
				+ "      </div>\r\n"
				+ "\r\n"
				+ "  </div>\r\n"
				+ "</div>\r\n"
				+ "",childBackroundColor,childBackroundImg,headerText1,headerText2,
				productAreaBackround.get(0),productTitleColor.get(0),buttonTextColor.get(0),buttonColor.get(0),buttonBorder.get(0),
				productAreaBackround.get(1),productTitleColor.get(1),buttonTextColor.get(1),buttonColor.get(1),buttonBorder.get(1),
				productAreaBackround.get(2),productTitleColor.get(2),buttonTextColor.get(2),buttonColor.get(2),buttonBorder.get(2),
				productAreaBackround.get(3),productTitleColor.get(3),buttonTextColor.get(3),buttonColor.get(3),buttonBorder.get(3));
		
		return productElement;
	}
	
	public String createProductElement02() {
		
		productElement=String.format("<div class='child' style='background-color:%s ; background-image:%s display: flex;flex-direction: column;justify-content: center;align-items: center;height: 100%%;padding: 3%%;'>\r\n"
				+ "  <h1 class='headerText1'>%s</h1>\r\n"
				+ "  <h2 class='headerText2'>%s</h2>\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "  <div class='row'>\r\n"
				+ "      <div class='col-lg-4 col-md-6 col-12' style=' padding: 15px;'>\r\n"
				+ "          <div class='productArea SetProduct-1 ' style='background-color: %s;'>\r\n"
				+ "              <img class='productImg' src=''  alt='圖片1'>\r\n"
				+ "              <div class='product-body'>\r\n"
				+ "                  <h5 class='product-title' style='color: %s; margin: 10px 0 10px 0;'>標題</h5>\r\n"
				+ "                  <p class='product-text'>$價格</p>\r\n"
				+ "                  <div class='clearfix'>\r\n"
				+ "                      <button type='submit' class='btn float-end pButton'  style='color:%s ;background-color:%s ;border: 1px solid %s; '>購買</button>\r\n"
				+ "                  </div>\r\n"
				+ "              </div>\r\n"
				+ "          </div>\r\n"
				+ "      </div>\r\n"
				+ "\r\n"
				+ "      <div class='col-lg-4 col-md-6 col-12' style=' padding: 15px;'>\r\n"
				+ "          <div class='productArea SetProduct-2' style='background-color: %s;'>\r\n"
				+ "              <img class='productImg' src=''  alt='圖片1'>\r\n"
				+ "              <div class='product-body'>\r\n"
				+ "                  <h5 class='product-title' style= 'color: %s; margin: 10px 0 10px 0;'>標題</h5>\r\n"
				+ "                  <p class='product-text'>$價格</p>\r\n"
				+ "                  <div class='clearfix'>\r\n"
				+ "                      <button type='submit' class='btn float-end pButton'  style='color:%s ;background-color:%s ;border: 1px solid %s; '>購買</button>\r\n"
				+ "                  </div>\r\n"
				+ "              </div>\r\n"
				+ "          </div>\r\n"
				+ "      </div>\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "      <div class='col-lg-4 col-md-6 col-12' style=' padding: 15px;'>\r\n"
				+ "          <div class='productArea SetProduct-3' style='background-color: %s;'>\r\n"
				+ "              <img class='productImg' src=''  alt='圖片1'>\r\n"
				+ "              <div class='product-body'>\r\n"
				+ "                  <h5 class='product-title' style='color: %s; margin: 10px 0 10px 0;'>標題</h5>\r\n"
				+ "                  <p class='product-text'>$價格</p>\r\n"
				+ "                  <div class='clearfix'>\r\n"
				+ "                      <button type='submit' class='btn float-end pButton'  style='color:%s ;background-color:%s ;border: 1px solid %s; '>購買</button>\r\n"
				+ "                  </div>\r\n"
				+ "              </div>\r\n"
				+ "          </div>\r\n"
				+ "      </div>\r\n"
				+ "\r\n"
				+ "  </div>\r\n"
				+ "</div>",childBackroundColor,childBackroundImg,headerText1,headerText2,
				productAreaBackround.get(0),productTitleColor.get(0),buttonTextColor.get(0),buttonColor.get(0),buttonBorder.get(0),
				productAreaBackround.get(1),productTitleColor.get(1),buttonTextColor.get(1),buttonColor.get(1),buttonBorder.get(1),
				productAreaBackround.get(2),productTitleColor.get(2),buttonTextColor.get(2),buttonColor.get(2),buttonBorder.get(2) );
		
		
		return productElement;
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

	public List<String> getProductAreaBackround() {
		return productAreaBackround;
	}

	public void setProductAreaBackround(List<String> productAreaBackround) {
		this.productAreaBackround = productAreaBackround;
	}

	public List<String> getProductTitleColor() {
		return productTitleColor;
	}

	public void setProductTitleColor(List<String> productTitleColor) {
		this.productTitleColor = productTitleColor;
	}

	public List<String> getButtonBorder() {
		return buttonBorder;
	}

	public void setButtonBorder(List<String> buttonBorder) {
		this.buttonBorder = buttonBorder;
	}

	public List<String> getButtonColor() {
		return buttonColor;
	}

	public void setButtonColor(List<String> buttonColor) {
		this.buttonColor = buttonColor;
	}

	public List<String> getButtonTextColor() {
		return buttonTextColor;
	}

	public void setButtonTextColor(List<String> buttonTextColor) {
		this.buttonTextColor = buttonTextColor;
	}

	public String getProductElement() {
		return productElement;
	}
	
	
	
}