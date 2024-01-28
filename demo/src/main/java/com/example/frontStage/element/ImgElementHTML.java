package com.example.frontStage.element;

import java.util.List;

public class ImgElementHTML {
	private String headerText1;
	private String headerText2;
	private String childBackroundColor;
	private String childBackroundImg;
	private List<String> img;
	
	private String imgElement;

	public ImgElementHTML(int type, String headerText1, String headerText2,String childBackroundColor,String childBackroundImg, List<String> img) {
		
		this.headerText1 = headerText1;
		this.headerText2 = headerText2;
		this.childBackroundColor=childBackroundColor;
		this.childBackroundImg=childBackroundImg;
		this.img = img;
		
		if(type==1) {
			createImgElement01();
		}else if (type==2) {
			createImgElement02();
		}else {
			createImgElement03();
		}
	}
	
	public String createImgElement01() {
		imgElement=String.format("<div  class='child' style='background-color:%s ;background-image: %s;display: flex;flex-direction: column;justify-content: center;align-items: center;height: 100%%;padding: 3%%;'>\r\n"
				+ "  <h1 class='headerText1' >%s</h1>\r\n"
				+ "  <h2 class='headerText2' >%s</h2>\r\n"
				+ "\r\n"
				+ "  <div class='row ' >\r\n"
				+ "\r\n"
				+ "      <div  class='col-lg-4 col-12  Image-1 img'>\r\n"
				+ "          <!-- 加入圖片1 -->\r\n"
				+ "          <div class='row-item p-1 border bg-light' style='margin: 10px;'>\r\n"
				+ "              <img src='%s' class='img-fluid imgElement02' alt='圖片1'>\r\n"
				+ "          </div>\r\n"
				+ "      </div>\r\n"
				+ "\r\n"
				+ "      <div  class='col-lg-4 col-12 Image-2 img'>\r\n"
				+ "          <!-- 加入圖片2 -->\r\n"
				+ "          <div class='row-item p-1 border bg-light' style='margin: 10px;'>\r\n"
				+ "              <img src='%s' class='img-fluid imgElement02' alt='圖片2'>\r\n"
				+ "          </div>\r\n"
				+ "      </div>\r\n"
				+ "\r\n"
				+ "      <div  class='col-lg-4 col-12 Image-3 img'>\r\n"
				+ "          <!-- 加入圖片3 -->\r\n"
				+ "          <div class='row-item p-1 border bg-light' style='margin: 10px;'>\r\n"
				+ "              <img src='%s' class='img-fluid imgElement02' alt='圖片3'>\r\n"
				+ "          </div>\r\n"
				+ "      </div>\r\n"
				+ "\r\n"
				+ "      <div  class='col-lg-4 col-12 Image-4 img'>\r\n"
				+ "          <!-- 加入圖片4 -->\r\n"
				+ "          <div class='row-item p-1 border bg-light' style='margin: 10px;'>\r\n"
				+ "              <img src='%s' class='img-fluid imgElement02' alt='圖片4'>\r\n"
				+ "          </div>\r\n"
				+ "      </div>\r\n"
				+ "\r\n"
				+ "      <div  class='col-lg-4  col-12 Image-5 img'>\r\n"
				+ "          <!-- 加入圖片5 -->\r\n"
				+ "          <div class='row-item p-1 border bg-light' style='margin: 10px;'>\r\n"
				+ "              <img src='%s' class='img-fluid imgElement02' alt='圖片5'>\r\n"
				+ "          </div>\r\n"
				+ "      </div>\r\n"
				+ "\r\n"
				+ "      <div  class='col-lg-4 col-12 Image-6 img'>\r\n"
				+ "          <!-- 加入圖片6 -->\r\n"
				+ "          <div class='row-item p-1 border bg-light' style='margin: 10px;'>\r\n"
				+ "              <img src='%s' class='img-fluid imgElement02' alt='圖片6'>\r\n"
				+ "          </div>\r\n"
				+ "      </div>\r\n"
				+ "\r\n"
				+ "  </div>\r\n"
				+ "</div>",childBackroundColor,childBackroundImg,headerText1,headerText2,img.get(0),img.get(1),img.get(2),img.get(3),img.get(4),img.get(5) );
		return imgElement;
	}
	
	public String createImgElement02() {
		imgElement=String.format("<div class='child' style='background-color:%s ;background-image: %s;display: flex;flex-direction: column;justify-content: center;align-items: center;height: 100%%;padding: 3%%;' >\r\n"
				+ "  <h1 class='headerText1' >%s</h1>\r\n"
				+ "  <h2 class='headerText2' >%s</h2>\r\n"
				+ "\r\n"
				+ "  <div class='row ' >\r\n"
				+ "\r\n"
				+ "      <div class='col-lg-6 col-12 Image-1 img'>\r\n"
				+ "          <!-- 加入圖片1 -->\r\n"
				+ "          <div class='row-item p-1 border bg-light' style='width: 90%%; margin:1%% auto;'>\r\n"
				+ "              <img src='%s' class='img-fluid imgElement01' alt='圖片1'>\r\n"
				+ "          </div>\r\n"
				+ "      </div>\r\n"
				+ "\r\n"
				+ "      <div class='col-lg-6 col-12 Image-2 img'>\r\n"
				+ "          <!-- 加入圖片2 -->\r\n"
				+ "          <div class='row-item p-1 border bg-light' style='width: 90%%; margin:1%% auto;'>\r\n"
				+ "              <img src='%s' class='img-fluid imgElement01' alt='圖片2'>\r\n"
				+ "          </div>\r\n"
				+ "      </div>\r\n"
				+ "\r\n"
				+ "      <div class='col-lg-6 col-12 Image-3 img'>\r\n"
				+ "          <!-- 加入圖片3 -->\r\n"
				+ "          <div class='row-item p-1 border bg-light' style='width: 90%%; margin:1%% auto;'>\r\n"
				+ "              <img src='%s' class='img-fluid imgElement01' alt='圖片3'>\r\n"
				+ "          </div>\r\n"
				+ "      </div>\r\n"
				+ "\r\n"
				+ "      <div class='col-lg-6 col-12 Image-4 img'>\r\n"
				+ "          <!-- 加入圖片4 -->\r\n"
				+ "          <div class='row-item p-1 border bg-light' style='width: 90%%; margin:1%% auto;'>\r\n"
				+ "              <img src='%s' class='img-fluid imgElement01' alt='圖片4'>\r\n"
				+ "          </div>\r\n"
				+ "      </div>\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "  </div>\r\n"
				+ "</div>",childBackroundColor,childBackroundImg,headerText1,headerText2,img.get(0),img.get(1),img.get(2),img.get(3) );
		return imgElement;
	}

	public String createImgElement03() {
		imgElement=String.format("<div class='child' style='background-color:%s ;background-image: %s;display: flex;flex-direction: column;justify-content: center;align-items: center;height: 100%%;padding: 3%%;'>\r\n"
				+ "  <h1 class='headerText1'>%s</h1>\r\n"
				+ "  <h2 class='headerText2'>%s</h2>\r\n"
				+ "\r\n"
				+ "  <div class='row ' >\r\n"
				+ "      <div class='col-lg-4 col-12 Image-1 img' >\r\n"
				+ "          <!-- 加入圖片 -->\r\n"
				+ "          <div class='p-1 border bg-light' style='margin: 10px;'>\r\n"
				+ "              <img src='%s' class='img-fluid imgElement03' alt='茶葉1'>\r\n"
				+ "          </div>\r\n"
				+ "      </div>\r\n"
				+ "\r\n"
				+ "      <div class='col-lg-4 col-12 Image-2 img' >\r\n"
				+ "\r\n"
				+ "          <div class='p-1 border bg-light' style='margin: 10px;'>\r\n"
				+ "              <img src='%s' class='img-fluid imgElement03' alt='茶葉2'>\r\n"
				+ "          </div>\r\n"
				+ "      </div>\r\n"
				+ "      <div class='col-lg-4 col-12 Image-3 img'>\r\n"
				+ "          <div class='p-1 border bg-light' style='margin: 10px;'>\r\n"
				+ "              <img src='%s' class='img-fluid imgElement03' alt='茶葉1'>\r\n"
				+ "          </div>\r\n"
				+ "      </div>\r\n"
				+ "\r\n"
				+ "  </div>\r\n"
				+ "</div>",childBackroundColor,childBackroundImg, headerText1,headerText2,img.get(0),img.get(1),img.get(2));
		return imgElement;
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

	public List<String> getImg() {
		return img;
	}

	public void setImg(List<String> img) {
		this.img = img;
	}

	public String getImgElement() {
		return imgElement;
	}
	

}
